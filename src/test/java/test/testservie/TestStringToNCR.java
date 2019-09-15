package test.testservie;

import Utils.ImgUrl;
import Utils.StringToNCR;
import com.Entity.Img;
import org.junit.Test;

import java.io.*;

public class TestStringToNCR {
    @Test
    public void test(){
        String s = "你好啊，我是小李";
        String stringToNCR = StringToNCR.stringToNCR(s);
        System.out.println(stringToNCR);
    }

    @Test
    public void testFile(){
        String path = "D:\\Idea_project\\MyNoteBook\\web\\kindecitor\\zh-CN.js";
        StringToNCR.fileToNCR(path);
    }

    @Test
    public void testImgUrl(){
        try {
            BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream("D:\\dir\\test\\a.html")));
            StringBuffer sb=new StringBuffer();
            String line="";
            while((line=br.readLine())!=null){
                sb.append(line);
            }
            System.out.println(sb.toString());
            ImgUrl.getHtmlImgUrl(sb.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
