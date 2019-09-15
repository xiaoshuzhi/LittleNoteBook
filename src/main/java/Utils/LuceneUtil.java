package Utils;

import com.Entity.Note;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.*;
import org.apache.lucene.index.*;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.search.*;
import org.apache.lucene.search.highlight.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.QueryBuilder;
import org.aspectj.util.FileUtil;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LuceneUtil {

    /* 创建索引,在新建时创建，一般content是空，*/
    public static boolean createLuceneIndex(Note note,String content,String luceneDB)  {
        /*
        * 1.创建IndeWriter对象。
        *       在初始化IndexWriter的过程中，指定存放索引库的Directory 对象
        *       指定一个对文档内容进行分析的分析器。
        * 2.创建document对象。
        * 3.创建filed对象，将filed对象存入document对象中
        * 4.使用IndexWriter将document对象写入索引库，并将syin和document对象写入索引库。
        * 第五步关闭IndexWriter对象。
        * */
        /* "D:\\dir\\indexBase"*/
        /*File path= new File("D:\\dir\\indexBase");*/
        Directory directory= null;
        IndexWriter indexWriter=null;
        try {
            directory = FSDirectory.open(Paths.get(luceneDB));
            Analyzer analyzer=new IKAnalyzer();
            IndexWriterConfig indexWriterConfig=new IndexWriterConfig(analyzer);
            indexWriter = new IndexWriter(directory,indexWriterConfig);

            Document document=new Document();
            //获取文件id
            FieldType type = new FieldType();
            type.setIndexOptions(IndexOptions.DOCS_AND_FREQS_AND_POSITIONS);
            type.setTokenized(false);
            type.setStored(true);
            Field idField=new Field("noteid", String.valueOf(note.getNoteid()), type);
            document.add(idField);
            document.add(new StringField("direcotryid",note.getDirectoryid(), Field.Store.YES));
            //获取文件名
            document.add(new TextField("filename",note.getFilename(), Field.Store.YES));
            //文件内容
            /*新建内容为空时，不对内容建索引*/
            if(content!=null){
                 document.add(new TextField("content",content, Field.Store.YES));
            }
            indexWriter.addDocument(document);
            indexWriter.close();
            return true;
        } catch (IOException e) {
            System.out.println("创建索引时io流出错！");
            e.printStackTrace();
            return false;
        }
    }

    /*
    修改被打开的文件*/
    public static boolean updateLuceneIndex(Note note,String content,String luceneDB){
        try {
            Directory directory=FSDirectory.open(Paths.get(luceneDB));
            IndexWriterConfig indexWriterConfig=new IndexWriterConfig(new IKAnalyzer());
            IndexWriter indexWriter=new IndexWriter(directory,indexWriterConfig);
            Document document=new Document();
            FieldType type = new FieldType();
            type.setIndexOptions(IndexOptions.DOCS_AND_FREQS_AND_POSITIONS);
            type.setTokenized(false);
            type.setStored(true);
            Field idField=new Field("noteid", String.valueOf(note.getNoteid()), type);
            document.add(idField);
            document.add(new StringField("direcotryid",note.getDirectoryid(), Field.Store.YES));
            //获取文件名
            document.add(new TextField("filename",note.getFilename(), Field.Store.YES));
            //文件内容
            if(content!=null) {
                document.add(new TextField("content", content, Field.Store.NO));
            }
            indexWriter.updateDocument(new Term("noteid",note.getNoteid()+""),document);
            indexWriter.close();
            return true;
        } catch (IOException e) {
            System.out.println("修改文件索引出错");

            e.printStackTrace();
            return false;
        }
    }

    /*luceneDB:索引库路径
    fileds:需要搜索字段数组
    queryText:目标字符
    num:返回符合条件的前几个
    返回所有符合查询条件的文件id*/
    public static List<Integer> queryh(String luceneDB, String[] fields,String directoryid, String queryText,int num){
        IndexReader reader=null;
        List<Integer> list=new ArrayList<>();
        //1.创建Directory 确定索引库的位置
        try {
            Directory indexdb= FSDirectory.open(Paths.get(luceneDB));
            //2.创建IndexReader 用来读取所有索引
            reader= DirectoryReader.open(indexdb);
            //3.根据IndexReader创建IndexSearch对象
            IndexSearcher searcher=new IndexSearcher(reader);
            //4.创建搜索的query

            Analyzer analyzer=new IKAnalyzer();
            MultiFieldQueryParser queryParser = new MultiFieldQueryParser(fields, analyzer);
            Query query= queryParser.parse(queryText);
            //5.通过IndexSearch查询得到TopDocs
            TopDocs topDocs= searcher.search(query,num);
            //6.获取结果集scoreDoc对象
            ScoreDoc[] scoreDocss=topDocs.scoreDocs;
            for (ScoreDoc scoreDocs : scoreDocss) {
                if(directoryid!=null) {
                    if (searcher.doc(scoreDocs.doc).get("direcotryid").equals(directoryid)) {
                        list.add(Integer.parseInt(searcher.doc(scoreDocs.doc).get("noteid")));
                        System.out.println(searcher.doc(scoreDocs.doc).get("noteid"));
                        System.out.println(searcher.doc(scoreDocs.doc).get("direcotryid"));
                        System.out.println(searcher.doc(scoreDocs.doc).get("filename"));
                    }
                }else {
                    list.add(Integer.parseInt(searcher.doc(scoreDocs.doc).get("noteid")));
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return list;
    }


    /*返回索引库中指定id的和指定数量的，符合条件文本结果，并高亮显示*/
    public static String search(String queryText,String luceneDB,int much,int noteid) {
        String highLight="";
        Analyzer analyzer = new IKAnalyzer();
        try {
            IndexReader reader = DirectoryReader.open(FSDirectory.open(Paths.get(luceneDB)));
            IndexSearcher indexSearcher = new IndexSearcher(reader);
            // 这里只能接受fileName这一个域，所以下面highLight2()之后，content是null
            // QueryParser queryParser = new QueryParser(Version.LUCENE_35, "fileName", analyzer);
            // 使用MultiFieldQueryParser可以接受多个域，表示既查询fileName，又查询content，这时候，经过highLight2()之后，content就有值了
            MultiFieldQueryParser queryParser = new MultiFieldQueryParser(new String[]{"fileName", "content"}, analyzer);
            Query query = queryParser.parse(queryText);
            TopDocs topDocs = indexSearcher.search(query, much);
            for (ScoreDoc scoreDoc : topDocs.scoreDocs) {
                Document document = indexSearcher.doc(scoreDoc.doc);
                if(document.get("noteid").equals(""+noteid)) {
                    String content = document.get("content");
                    System.out.println("*******" + content);
               /* String content = new Tika().parseToString(new File(document.get("path")));*/
                    content = highLight2(analyzer, query, content, "content");
                    System.out.println(content);
                    highLight=content;
                }
            }
            reader.close();
            //indexSearcher.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (InvalidTokenOffsetsException e) {
            e.printStackTrace();
        }

        return highLight;
    }

    /*queryText:查询字段
    * content：原文本*/
    /*给特定字符添加高亮*/
    public static String contentToHighLight(String queryText,String content){
        Analyzer ika=new IKAnalyzer();
        MultiFieldQueryParser queryParser = new MultiFieldQueryParser(new String[]{"fileName", "content"}, ika);
        String highLightContent="";
        try {
            Query query = queryParser.parse(queryText);
            highLightContent=highLight2(ika,query,content,"fileName");
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (InvalidTokenOffsetsException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
       return highLightContent;
    }


    public static String highLight2(Analyzer analyzer, Query query, String querytext, String field) throws IOException, InvalidTokenOffsetsException {
        QueryScorer queryScorer = new QueryScorer(query);
        Fragmenter fragmenter = new SimpleFragmenter(querytext.length());
        /*设置高亮标枪*/
        org.apache.lucene.search.highlight.Formatter formatter = new SimpleHTMLFormatter("<span style=\"background-color:red;\">","</span>");
        /*Highlighter highlighter = new Highlighter(formatter, queryScorer);*/
        org.apache.lucene.search.highlight.Highlighter highlighter=new org.apache.lucene.search.highlight.Highlighter(formatter,queryScorer);
        highlighter.setTextFragmenter(fragmenter);
        String highlightString = highlighter.getBestFragment(analyzer, field, querytext);
        // 如果查询的highlightString为null，表示在field中没有查到，就返回原来的内容
        return highlightString == null ? querytext : highlightString;
    }

    /*noteid:笔记id
    indexDB：索引库路径
    根据id，删除相应的索引*/
    public static boolean testDeleteIndex(int noteid,String indexDB){
        try {
            Directory directory=FSDirectory.open(Paths.get(indexDB));
            IndexWriter writer =new IndexWriter(directory,new IndexWriterConfig(new StandardAnalyzer()));
           /* QueryBuilder builder=new QueryBuilder(new IKAnalyzer());
            Query query=builder.createPhraseQuery("noteid","早年经历 - 副本.txt");
            writer.deleteDocuments(query);*/
            writer.deleteDocuments(new Term("noteid",noteid+""));
            writer.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void number() throws IOException {
        IndexReader indexReader=DirectoryReader.open(FSDirectory.open(Paths.get("D:\\Idea_project\\MyNoteBook\\out\\artifacts\\MyNoteBook_war_exploded\\uploadDirectory\\305674b0918a44dd9d87f880454363dc\\indexDB")));
        System.out.println("最大的索引数："+indexReader.maxDoc());
        System.out.println("当前索引数："+indexReader.numDocs());
        System.out.println("删除索引数："+indexReader.numDeletedDocs());
        indexReader.close();
    }

    /*@Test
    public  void  testhighlight() {
        HighLightTest highLightTest = new HighLightTest();
        highLightTest.search("海尔希");
    }*/
}
