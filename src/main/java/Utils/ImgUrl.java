package Utils;

import java.util.ArrayList;
import java.util.List;

public class ImgUrl {
    /*1.先将所有的非普通字符去掉*，2.每次遇到<就往后取3位，
    如果等于img，遇到s或者S往后取3位，如果整体等于src=，寻找”和“之间的值。
     */

    public  static List<String> getHtmlImgUrl(String htmlStr){
        StringBuffer sb=new StringBuffer();
        for (int i = 0; i < htmlStr.length(); i++) {
            int v=htmlStr.charAt(i);
            if(v<127){
                sb.append((char)v);
            }
        }
        System.out.println(sb.toString().trim());

        List<String> urls=new ArrayList<>();
        StringBuffer img=new StringBuffer();
        for (int i = 0; i < sb.toString().length(); i++) {
            char c=sb.charAt(i);
            if(c=='<'){

                img.append(sb.substring(i,i+4));

                if(img.toString().equals("<img")) {

                   int firstss= sb.substring(i,sb.length()-1).indexOf("\"");
                   int lastss=sb.substring(i+firstss+1,sb.length()-1).indexOf("\"");
                    System.out.println(lastss);
                   urls.add(sb.substring(i+firstss+1,i+firstss+lastss+1));
                   i=i+10;
                }
                img=new StringBuffer("");
            }
        }
        return urls;
    }
}
