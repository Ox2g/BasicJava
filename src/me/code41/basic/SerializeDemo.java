package me.code41.basic;

import me.code41.basic.serialize.User;

import java.io.*;

/**
 * Created by liushiyao on 2016/5/18.
 */
public class SerializeDemo {
    public static void main(String[] args) {
        User user = new User();
        user.setFirstName("Shaw");
        user.setLastName("Liu");

        byte[] temp = serializableTest(user);
        User userTransfer = deSerializableTest(temp);
        System.out.println(userTransfer.getFirstName() + "." + userTransfer.getLastName());
    }

    public static byte[] serializableTest(User user) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(user);
            objectOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static User deSerializableTest(byte[] bytes) {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            Object object = objectInputStream.readObject();
            return (User) object;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
