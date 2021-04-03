package com.jchen.community;

import java.io.IOException;

/**
 * @Auther: jchen
 * @Date: 2021/04/03/19:02
 */
public class WkTests {

    public static void main(String[] args) {
        String cmd = "D:/development/wkhtmltopdf/bin/wkhtmltoimage --quality 75  https://www.baidu.com e:/community/data/wk-images/3.png";
        try {
            Runtime.getRuntime().exec(cmd);
            System.out.println("ok.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
