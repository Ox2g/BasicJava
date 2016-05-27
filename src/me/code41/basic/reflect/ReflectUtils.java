package me.code41.basic.reflect;

import me.code41.basic.reflect.vo.User;

import java.lang.reflect.Field;
import java.util.*;

/**
 * Created by liushiyao on 2016/5/27.
 */
public class ReflectUtils {
    private static Map<String, Object> OBJECT_POOL = new HashMap<>();

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
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

    public static void initPool(List<Map<String, String>> initParams) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        if (initParams == null || initParams.size() == 0) return;
        for (Map<String, String> item : initParams) {
            String id = item.get("id");
            String className = item.get("class");
            Class clazz = getInstance(className);
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
        }
    }

    public static Class getInstance(String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        return Class.forName(className);
    }

    public static Object getObject(String id) {
        return OBJECT_POOL.get(id);
    }
}
