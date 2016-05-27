package me.code41.basic.io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by liushiyao on 2016/5/27.
 */
public class NIODemo {
    public static void main(String[] args) {
        try {
            RandomAccessFile file = new RandomAccessFile("src/me/code41/basic/io/file-1.tmp", "rw");
            FileChannel fileChannel = file.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            int flag = fileChannel.read(byteBuffer);
            while (flag != -1) {
                byteBuffer.flip();
                while (byteBuffer.hasRemaining()) {
                    System.out.print((char) byteBuffer.get());
                }
                byteBuffer.compact();
                flag = fileChannel.read(byteBuffer);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
