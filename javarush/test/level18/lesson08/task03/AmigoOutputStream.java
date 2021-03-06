package com.javarush.test.level18.lesson08.task03;

import java.io.*;
import java.nio.channels.FileChannel;

/* AmigoOutputStream
1 Измените класс AmigoOutputStream так, чтобы он стал Wrapper-ом для класса FileOutputStream. Используйте наследование.
2 При вызове метода close() должны выполняться следующая последовательность действий:
2.1 вызвать метод flush()
2.2 дописать следующий текст [JavaRush © 2012-2013 All rights reserved.], используйте метод getBytes()
2.3 закрыть поток методом close()
*/

public class AmigoOutputStream extends FileOutputStream{
    public static String fileName = "C:/tmp/result.txt";

    private FileOutputStream fileOutputStream;

    @Override
    public void write(int b) throws IOException {
        fileOutputStream.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        fileOutputStream.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        fileOutputStream.write(b, off, len);
    }

    @Override
    public FileChannel getChannel() {
        return fileOutputStream.getChannel();
    }

    @Override
    public void flush() throws IOException {
        fileOutputStream.flush();
    }

    public AmigoOutputStream(String name, FileOutputStream fileOutputStream) throws FileNotFoundException {
        super(name);
        this.fileOutputStream = fileOutputStream;
    }

    public AmigoOutputStream(String name, boolean append, FileOutputStream fileOutputStream) throws FileNotFoundException {
        super(name, append);
        this.fileOutputStream = fileOutputStream;
    }

    public AmigoOutputStream(File file, FileOutputStream fileOutputStream) throws FileNotFoundException {
        super(file);
        this.fileOutputStream = fileOutputStream;
    }

    public AmigoOutputStream(File file, boolean append, FileOutputStream fileOutputStream) throws FileNotFoundException {
        super(file, append);
        this.fileOutputStream = fileOutputStream;
    }

    public AmigoOutputStream(FileDescriptor fdObj, FileOutputStream fileOutputStream) {
        super(fdObj);
        this.fileOutputStream = fileOutputStream;
    }

    public AmigoOutputStream(FileOutputStream name) throws FileNotFoundException {
        super(fileName);
        this.fileOutputStream = name;
    }

    @Override
    public void close() throws IOException {
        fileOutputStream.flush();

        fileOutputStream.write("JavaRush © 2012-2013 All rights reserved.".getBytes());
        fileOutputStream.close();
    }


    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

}

