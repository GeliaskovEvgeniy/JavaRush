package com.javarush.test.level31.lesson02.home02;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/* Находим все файлы
Реализовать логику метода getFileTree, который должен в директории root найти список всех файлов включая вложенные.
Используйте очередь, рекурсию не используйте.
Верните список всех путей к найденным файлам, путь к директориям возвращать не надо.
Путь должен быть абсолютный.
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        File dir = new File(root);
        List<String> fileList = new ArrayList<>();
        for (File file : dir.listFiles())
        {
            if (file.isDirectory())
            {
                getFileTree(file.getAbsolutePath());
            }else {
                fileList.add(file.getAbsolutePath());
            }
        }
        return fileList;

    }
}
