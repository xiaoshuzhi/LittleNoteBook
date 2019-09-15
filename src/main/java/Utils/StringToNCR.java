package Utils;

import java.io.*;

public class StringToNCR {
    public static String stringToNCR(String str){
            StringBuffer unicode = new StringBuffer();
            for (int i = 0; i < str.length(); i++) {
                // 取出每一个字符
                char c = str.charAt(i);
                if(c>127) {
                    // 转换为unicode
                    unicode.append("&#x" + Integer.toHexString(c)+";");
                }else{
                    unicode.append(c);
                }
            }
            return unicode.toString();
    }

    public static String fileToNCR(String path){
        File file=new File(path);
        StringBuffer rs=new StringBuffer("");
        try {
            BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String r="";
            while((r=reader.readLine())!=null){
                rs.append(stringToNCR(r));
            }

            reader.close();
           /* System.out.println(rs.toString());
            BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
            writer.write(rs.toString());
            writer.close();*/

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(rs.toString());
        return rs.toString();
    }

    /*读取文件内容*/
    public static String readFile(String path){
        File file=new File(path);
        StringBuffer rs=new StringBuffer("");
        try {
            BufferedReader reader=new BufferedReader(new InputStreamReader(new FileInputStream(path)));
            String r="";
            while((r=reader.readLine())!=null){
                rs.append(r);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(rs.toString());
        return rs.toString();
    }

    public static void writeFile(String path,String content){
        File file=new File(path);
        try {
            System.out.println(content);
            BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
            writer.write(content);
            writer.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
