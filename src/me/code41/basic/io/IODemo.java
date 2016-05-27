package me.code41.basic.io;

import java.io.*;

/**
 * Created by liushiyao on 2016/5/27.
 */
public class IODemo {
    public static void main(String[] args) {
        File file = new File("src/me/code41/basic/io/file-1.tmp");
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            byte[] byteArray = new byte[1024];
            while (bufferedInputStream.available() > 0) {
                bufferedInputStream.read(byteArray, 0, 1024);
                System.out.println(new String(byteArray));
            }
            bufferedInputStream.close();
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
