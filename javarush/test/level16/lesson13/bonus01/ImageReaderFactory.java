package com.javarush.test.level16.lesson13.bonus01;

import com.javarush.test.level16.lesson13.bonus01.common.*;

/**
 * Created by 1 on 31.01.2016.
 */
public class ImageReaderFactory
{
    public static ImageReader getReader(ImageTypes reader) {

        if (reader == ImageTypes.BMP) {
            return new BmpReader();
        } else if (reader == ImageTypes.JPG) {
            return new JpgReader();
        } else if (reader == ImageTypes.PNG) {
            return new PngReader();
        }else {
            throw  new IllegalArgumentException("Неизвестный тип картинки");
        }
    }
}
