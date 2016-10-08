package com.javarush.test.level22.lesson13.task02;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* Смена кодировки
В метод main первым параметром приходит имя файла, тело которого в кодировке Windows-1251.
В метод main вторым параметром приходит имя файла, в который необходимо записать содержимое первого файла в кодировке UTF-8.
*/
public class Solution {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(args[0]));
        byte[] bytes = new byte[bis.available()];
        bis.read(bytes);
        bis.close();
        Charset utf_8 = Charset.forName("UTF-8");
        Charset windows_1251 = Charset.forName("Windows-1251");
        String s = new String(bytes, utf_8);
        System.out.println(s);
        bytes = s.getBytes(windows_1251);
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(args[1]));
        bos.write(bytes);
        bos.close();

    }
}
