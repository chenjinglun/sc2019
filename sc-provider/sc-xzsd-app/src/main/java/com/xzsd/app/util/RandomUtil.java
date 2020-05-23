package com.xzsd.app.util;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 生成一串随机数
 * @author 戴顺
 * @date 2015-08-14
 */

public class RandomUtil {

    /*
     * @param count :需要产生随机数的个数
     */
    public static String radmonkey(int count){
        StringBuffer sbf=new StringBuffer();
        for (int i = 0; i <count; i++) {
            int num=(int)(Math.random()*10);
            sbf.append(num);
        }

        return sbf.toString();
    }

    public static void main(String[] args) {
        System.err.println(radmonkey(32));
    }
    /**
     * 随机编号
     * @return
     */
    public static String radmonkey(){
        //6
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        StringBuffer sbf=new StringBuffer();
        sbf.append(sdf.format(new Date()));
        for (int i = 0; i <4; i++) {
            int num=(int)(Math.random()*10);
            sbf.append(num);
        }
        return sbf.toString();
    }

}
