package me.code41.basic.annotation;

import me.code41.basic.annotation.vo.Student;
import me.code41.basic.annotation.vo.Teacher;

import java.lang.reflect.Method;

/**
 * Created by code41 on 2016/5/29.
 */
public class AnnotationDemo {
    public static void main(String[] args) {
        Class teacherClass = Teacher.class;
        Method[] teacherClassDeclaredMethods = teacherClass.getDeclaredMethods();
        for (Method method : teacherClassDeclaredMethods) {
            NeedTest needTest = method.getAnnotation(NeedTest.class);
            if (needTest == null) {
                continue;
            }
            if (needTest.value()) {
                System.out.println(method.getName() + " need test...");
            } else {
                System.out.println(method.getName() + " needn't test...");
            }
        }

        Class studentClass = Student.class;
        Method[] studentClassDeclaredMethods = studentClass.getDeclaredMethods();
        for (Method method : studentClassDeclaredMethods) {
            NeedTest needTest = method.getAnnotation(NeedTest.class);
            if (needTest == null) {
                continue;
            }
            if (needTest.value()) {
                System.out.println("class " + studentClass.getName() + " " + method.getName() + " need test...");
            } else {
                System.out.println("class " + studentClass.getName() + " " + method.getName() + " needn't test...");
            }
        }
    }
}
