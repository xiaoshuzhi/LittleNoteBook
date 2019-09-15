package Utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
    /* MD5加密算法*/
    public static String strToMd5(String str){
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
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }
}
