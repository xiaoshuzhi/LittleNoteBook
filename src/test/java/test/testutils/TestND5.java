package test.testutils;

import Utils.LuceneUtil;
import Utils.MD5;
import com.Entity.Note;
import com.Entity.NoteUser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.lucene.util.QueryBuilder;
import org.junit.Test;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.IOException;
import java.util.*;

public class TestND5 {
    @Test
    public void testMD5(){
       /* String md5= MD5.strToMd5("xiaoshuzhi");*//*2376cd3f5cdfe62f52050e38bed16682*//*
        String md51= MD5.strToMd5("xiao123");*//*e2f5e798186344470f784f353a80ef7f*//*
        System.out.println(md51);*/
       /* ObjectMapper objectMapper=new ObjectMapper();
        Map<String ,Object> map=new HashMap<>();
        map.put("haha","nihao");
        NoteUser user=new NoteUser();
        user.setUserid(UUID.randomUUID().toString().replace("-",""));
        user.setUsername("小李");
        user.setPassword("xiao123");
        user.setGender(1);
        user.setAddress("江西萍乡");
        user.setUse(0);
        user.setTotal(3);
        user.setLock("no");
        user.setDatalocation("D:\\mynotebook\\data");
        user.setEmail("xiaoshuzhi@163.com");
        user.setType(1);
        map.put("note",user);
        try {
            System.out.println(objectMapper.writeValueAsString(map));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }*/
       /*String content="只向一个无状态的类中加入唯一一个状态元素，只要保证这个状态元素是线程安全的，那么这个类就是线程安全。但是，入股我们向一个 无状态类中加入多个状态元素，就算这些状态元都是状态安全的，也不能保证这个类是线程安全的，因为多个状态元素如果彼此有一丝的关联，就会使得整体存在竞争条件，导致线程不安全。";
        System.out.println(LuceneUtil.contentToHighLight("但是",content));*/

      /*  List<String> list=new ArrayList<>();
        list.add("ha");
        System.out.println(list.get(0));*/



           /* LuceneUtil.testDeleteIndex(102,"D:\\Idea_project\\MyNoteBook\\out\\artifacts\\MyNoteBook_war_exploded\\uploadDirectory\\305674b0918a44dd9d87f880454363dc\\indexDB");
            LuceneUtil.number();*/
          /* Note note=new Note();
           note.setFilename("xiugaisuoyin");
           note.setNoteid(103);
           note.setDirectoryid("wusuowei");
           String content="cehsi xiugaisuoying";
           LuceneUtil.updateLuceneIndex(note,content,"D:\\Idea_project\\MyNoteBook\\out\\artifacts\\MyNoteBook_war_exploded\\uploadDirectory\\305674b0918a44dd9d87f880454363dc\\indexDB");
           LuceneUtil.queryh("D:\\Idea_project\\MyNoteBook\\out\\artifacts\\MyNoteBook_war_exploded\\uploadDirectory\\305674b0918a44dd9d87f880454363dc\\indexDB",new String[]{"noteid"},"wusuowei","103",5);
        */try {
            LuceneUtil.testDeleteIndex(103,"D:\\Idea_project\\MyNoteBook\\out\\artifacts\\MyNoteBook_war_exploded\\uploadDirectory\\305674b0918a44dd9d87f880454363dc\\indexDB");
            LuceneUtil.number();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
