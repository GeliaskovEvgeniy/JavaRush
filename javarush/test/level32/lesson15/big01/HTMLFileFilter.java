package com.javarush.test.level32.lesson15.big01;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class HTMLFileFilter extends FileFilter
{
    @Override
    public boolean accept(File f)
    {
        if (f.isDirectory()) {
            return true;
        }else if (!f.isDirectory()) {
            String s = f.getName().toLowerCase();
            return s.endsWith(".html") || s.endsWith(".htm");
        }
        return false;
    }

    @Override
    public String getDescription()
    {
        return "HTML и HTM файлы";
    }
}
