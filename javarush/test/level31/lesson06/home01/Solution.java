package com.javarush.test.level31.lesson06.home01;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* Добавление файла в архив
В метод main приходит список аргументов.
Первый аргумент - полный путь к файлу fileName.
Второй аргумент - путь к zip-архиву.
Добавить файл (fileName) внутрь архива в директорию 'new'.
Если в архиве есть файл с таким именем, то заменить его.

Пример входных данных:
C:/result.mp3
C:/pathToTest/test.zip

Файлы внутри test.zip:
a.txt
b.txt

После запуска Solution.main архив test.zip должен иметь такое содержимое:
new/result.mp3
a.txt
b.txt

Подсказка: нужно сначала куда-то сохранить содержимое всех энтри,
а потом записать в архив все энтри вместе с добавленным файлом.
Пользоваться файловой системой нельзя.
*/
public class Solution {
    /*private static Map<ZipEntry, byte[]> zipEntryMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        File fileName = new File(args[0]);
        File pathZip = new File(args[1]);

        inMap(pathZip, fileName);
        inZip(pathZip);
    }

    public static void inMap(File file, File newFile){
        try (ZipInputStream in = new ZipInputStream(new FileInputStream(file));
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream(newFile))) {
            ZipEntry zipEntry;
            while (in.available() > 0) {
                zipEntry = in.getNextEntry();
                byte[] bytes = new byte[1024];
                in.read(bytes);
                zipEntryMap.put(zipEntry, bytes);
            }

            ZipEntry newZipEntry = new ZipEntry("newDir\\" + newFile.getName());
            byte[] bytesNewZip = new byte[bis.available()];
            bis.read(bytesNewZip);

            for (ZipEntry zip : zipEntryMap.keySet()) {
                if (zip.getName().equals(newFile.getName().substring(0, newFile.getName().length()-3))){
                    zipEntryMap.remove(zip);
                }
            }

            zipEntryMap.put(newZipEntry, bytesNewZip);

            in.close();
            bis.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void inZip(File file) {
        try(ZipOutputStream out = new ZipOutputStream(new FileOutputStream(file))) {
            for (Map.Entry<ZipEntry, byte[]> map : zipEntryMap.entrySet()){
                out.putNextEntry(map.getKey());
                out.write(map.getValue());
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }*/

    public static Map<ZipEntry, byte[]> entryMap = new HashMap<>();

    public static void main(String[] args) throws IOException
    {

        File zipArchive = new File(args[1]);
        File addedFile = new File(args[0]);

        fromZipToMap(zipArchive);
        newFileToZip(addedFile, zipArchive);
    }

    public static void fromZipToMap(File file)
    {
        try (ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(file)))
        {
            ZipEntry zipEntry;
            while ((zipEntry = zipInputStream.getNextEntry()) != null)
            {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int count;

                while ((count = zipInputStream.read(buffer)) != -1)
                {
                    byteArrayOutputStream.write(buffer, 0, count);
                }
                byte[] bytes = byteArrayOutputStream.toByteArray();
                entryMap.put(zipEntry, bytes);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    public static void newFileToZip(File addedFile, File zipArchive)
    {

        try (ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(zipArchive));
             FileInputStream fileInputStream = new FileInputStream(addedFile))
        {
            boolean isExist = false;

            ZipEntry fileNameComparator = new ZipEntry(addedFile.getName());

            for (Map.Entry<ZipEntry, byte[]> zipEntry : entryMap.entrySet())
            {
                Path path = Paths.get(zipEntry.getKey().getName());
                if (!(path.getFileName().toString().equals(fileNameComparator.getName())))
                {
                    zipOutputStream.putNextEntry(new ZipEntry(zipEntry.getKey().getName()));
                    zipOutputStream.write(zipEntry.getValue());
                } else
                {
                    isExist = true;
                }
            }
            if (isExist)
            {
                ZipEntry addingFileEntry = new ZipEntry("new/" + addedFile.getName());
                zipOutputStream.putNextEntry(addingFileEntry);
                byte[] buffer = new byte[fileInputStream.available()];
                fileInputStream.read(buffer);
                zipOutputStream.write(buffer);
                zipOutputStream.closeEntry();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
