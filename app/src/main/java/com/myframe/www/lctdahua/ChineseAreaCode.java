package com.myframe.www.lctdahua;

import java.io.UnsupportedEncodingException;

/**
 * Created by wuhai on 2017/11/30 18:09.
 * 描述：区位码
 */

public class ChineseAreaCode {

    public static String toAreaCode(String word){
        byte[] bs = null;
        try {
            bs = word.getBytes("GB2312");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String areaCode="";
        for(byte b:bs){
            int code=Integer.parseInt(Integer.toHexString(b & 0xff),16);
            areaCode += (code-0x80-0x20);       /*transfer the machine code to area code*/
        }
        return areaCode;
    }


    //------------------

    /**
     * 区位码
     * @param word
     * @return
     */
    public static String toAreaCode2(String word){
        byte[] bs = null;
        try {
            bs = word.getBytes("GB2312");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String s = "";
        for (int i = 0; i < bs.length; i++) {
            int a = Integer.parseInt(bytes2HexString(bs), 16);
            s += (a - 0x80 - 0x20) + "";
        }
        return s;
    }
    public static String bytes2HexString(byte[] b) {
        String ret = "";
        for (int i = 0; i < b.length; i++) {
            String hex = Integer.toHexString(b[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            ret += hex.toUpperCase();
        }
        return ret;
    }
}
