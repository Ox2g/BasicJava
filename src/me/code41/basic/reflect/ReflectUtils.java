package me.code41.basic.reflect;

import me.code41.basic.reflect.vo.User;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;

/**
 * Created by liushiyao on 2016/5/27.
 */
public class ReflectUtils {
    private static Map<String, Object> OBJECT_POOL = new HashMap<>();

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Map<String, String> initParam;
        List<Map<String, String>> initParams = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            initParam = new HashMap<>();
            if (i == 0) {
                initParam.put("id", "user1");
                initParam.put("class", "me.code41.basic.reflect.vo.User");
                initParam.put("name", "code41");
            } else {
                initParam.put("id", "user2");
                initParam.put("class", "me.code41.basic.reflect.vo.User");
                initParam.put("name", "0x29");
            }
            initParams.add(initParam);
        }


        initPool(initParams);
        Object o = getObject("user1");
        if (o instanceof User) {
            System.out.println(((User) o).getName());
        }
    }

    public static void initPool(List<Map<String, String>> initParams) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        if (initParams == null || initParams.size() == 0) return;
        for (Map<String, String> item : initParams) {
            String id = item.get("id");
            String className = item.get("class");
            Class clazz = getInstanceByClassLoader(className);
            // new instance
            Object object = clazz.newInstance();
            // set values
            Field[] fields = clazz.getDeclaredFields();
            Iterator<Map.Entry<String, String>> iterator = item.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, String> entry = iterator.next();
                if ("id".equals(entry.getKey()) || "class".equals(entry.getKey())) {
                    continue;
                }
                for (Field field : fields) {
                    if (field.getName().equals(entry.getKey())) {
                        field.setAccessible(true);
                        field.set(object, entry.getValue());
                    }
                }
            }

            OBJECT_POOL.put(id, object);

            // class方法调用
            Method helloMethod = clazz.getMethod("hello", null);
            String result = (String) helloMethod.invoke(object, null);
            System.out.println("result=>" + result + "...method type=>" + Modifier.isStatic(helloMethod.getModifiers()));

            // class静态方法调用
            Method[] methods = clazz.getMethods();
            for (Method method : methods) {
                if (Modifier.isStatic(method.getModifiers())) {
                    String staticResult = (String) method.invoke(object, "LSY");
                    System.out.println("static method result=>" + staticResult + "...method type=>" + Modifier.isStatic(method.getModifiers()));
                }
            }
        }
    }

    public static Class getInstance(String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        return Class.forName(className);
    }

    public static Class getInstanceByClassLoader(String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        System.out.println(classLoader);
        System.out.println(classLoader.getParent());
        System.out.println(classLoader.getParent().getParent());
        return classLoader.loadClass(className);
    }

    public static Object getObject(String id) {
        return OBJECT_POOL.get(id);
    }
}
