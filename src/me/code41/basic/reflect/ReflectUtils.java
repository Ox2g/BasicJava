package me.code41.basic.reflect;

import me.code41.basic.reflect.vo.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liushiyao on 2016/5/27.
 */
public class ReflectUtils {
    private static Map<String, Object> OBJECT_POOL = new HashMap<>();

    public static void main(String[] args) throws ClassNotFoundException {
        Map<String, String> initParam;
        List<Map<String, String>> initParams = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            initParam = new HashMap<>();
            if (i == 0) {
                initParam.put("id", "user1");
                initParam.put("class", "me.code41.basic.reflect.vo.User");
            } else {
                initParam.put("id", "user2");
                initParam.put("class", "me.code41.basic.reflect.vo.User");
            }
            initParams.add(initParam);
        }


        initPool(initParams);
        Object o = getObject("user1");
        if (o instanceof User) {
            ((User) o).setName("123");
            System.out.println(((User) o).getName());
        }
    }

    public static void initPool(List<Map<String, String>> initParams) throws ClassNotFoundException {
        if (initParams == null || initParams.size() == 0) return;
        for (Map<String, String> item : initParams) {
            String id = item.get("id");
            String className = item.get("class");
            OBJECT_POOL.put(id, getInstance(className));
        }
    }

    public static Object getInstance(String className) throws ClassNotFoundException {
        return Class.forName(className);
    }

    public static Object getObject(String id) {
        return OBJECT_POOL.get(id);
    }
}
