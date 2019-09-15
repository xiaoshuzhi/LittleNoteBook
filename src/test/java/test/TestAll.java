package test;

import org.junit.Test;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public class TestAll {

    @Test
    public void toMD5(){
        String str="xiaoshuzzhi";
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] strByteArray = new byte[0];
        try {
            strByteArray = str.getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        byte[] mdByteArray = md.digest(strByteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < mdByteArray.length; i++) {
            int val = ((int) mdByteArray[i]) & 0xff;
            if (val < 16) {
                System.out.println("");
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }
        System.out.println(hexValue.toString()+" "+hexValue.toString().length());
    }

    @Test
    public void testUUId(){
        String uuid=UUID.randomUUID().toString().replace("-","");
        System.out.println(uuid+" "+uuid.length());
    }
}


