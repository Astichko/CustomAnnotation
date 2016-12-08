package com.example.boss.customannotation;

import android.util.Log;

import java.lang.reflect.Field;
import java.lang.reflect.Type;

/**
 * Support float(Float),String and int(Integer) only.
 */

public class Dagger {
    final public static String DEFAULT_STRING = "Default text";
    final public static Float DEFAULT_FLOAT = 0.5f;
    final public static Integer DEFAULT_INTEGER = 1;

    public static void inject(Object obj){
            try {
                for (Field field : obj.getClass().getDeclaredFields()) {
                    field.setAccessible(true); // if you want to modify private fields
                    if (field.isAnnotationPresent(Default.class)) {
                        Type t = field.getType();
                        if (t.equals(String.class)) {
                            field.set(obj, DEFAULT_STRING);
                        } else if (t.equals(Float.class)) {
                            field.set(obj, DEFAULT_FLOAT);
                        } else if (t.equals(Integer.class)) {
                            field.set(obj, DEFAULT_INTEGER);
                        } else if (t.equals(float.class)) {
                            field.set(obj, DEFAULT_FLOAT);
                        } else if (t.equals(int.class)) {
                            field.set(obj, DEFAULT_INTEGER);
                        }
                        Log.v("myLogs", field.getName()
                                + " - " + field.getType());
                    }
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        }

}
