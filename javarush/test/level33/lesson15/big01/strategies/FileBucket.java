package com.javarush.test.level33.lesson15.big01.strategies;

import com.javarush.test.level33.lesson15.big01.ExceptionHandler;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileBucket {

    Path path;

    public FileBucket() {
        try {
            this.path = Files.createTempFile("tmp", null);
        } catch (IOException e) {
            ExceptionHandler.log(e);
        }
        path.toFile().deleteOnExit();
    }

    public long getFileSize(){
        return path.toFile().length();
    }

    public void putEntry(Entry entry) {
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path.toFile()));
             ObjectOutputStream oos = new ObjectOutputStream(bos))
        {
            oos.writeObject(entry);
        }  catch (IOException e) {
            ExceptionHandler.log(e);
        }
    }

    public Entry getEntry() {
        Entry entry = null;
        if(getFileSize() > 0) {
            try (FileInputStream fis = new FileInputStream(path.toFile());
                 ObjectInputStream inputStream = new ObjectInputStream(fis))
            {
                Object object = inputStream.readObject();
                entry = (Entry)object;
            }
            catch (Exception e) {
                ExceptionHandler.log(e);
            }
        }
        return entry;
    }

    public void remove(){
        try {
            Files.delete(path);
        } catch (IOException e) {
            ExceptionHandler.log(e);
        }
    }

}
