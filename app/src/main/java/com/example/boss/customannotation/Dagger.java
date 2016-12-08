package com.example.boss.customannotation;

import android.util.Log;

import java.lang.reflect.Field;
import java.lang.reflect.Type;

/**
 * Support float(Float),String and int(Integer) only.
 */

public class Dagger {
    public static void inject(Object obj) {
        try {
            for (Field field : obj.getClass().getDeclaredFields()) {
                field.setAccessible(true); // if you want to modify private fields
                if (field.isAnnotationPresent(Default.class)) {
                    Type t = field.getType();
                    if (t.equals(String.class)) {
                        field.set(obj, field.getAnnotation(Default.class).value());
                    } else if (t.equals(Float.class)) {
                        field.set(obj, parseFloat(field.getAnnotation(Default.class).value()));
                    } else if (t.equals(float.class)) {
                        field.set(obj, parseFloat(field.getAnnotation(Default.class).value()));
                    } else if (t.equals(Integer.class)) {
                        field.set(obj, parseInt(field.getAnnotation(Default.class).value()));
                    } else if (t.equals(int.class)) {
                        field.set(obj, parseInt(field.getAnnotation(Default.class).value()));
                    } else if (t.equals(long.class)) {
                        field.set(obj, parseInt(field.getAnnotation(Default.class).value()));
                    } else if (t.equals(Double.class)) {
                        field.set(obj, parseDouble(field.getAnnotation(Default.class).value()));
                    } else if (t.equals(double.class)) {
                        field.set(obj, parseDouble(field.getAnnotation(Default.class).value()));
                    }
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    private static Double parseDouble(String s) {
        try {
            return Double.parseDouble(s);
        } catch (NumberFormatException e) {
            Log.v("myLogs", "NumberFormatException  - " + e);
        }
        return 0.0d;
    }

    private static Float parseFloat(String s) {
        try {
            return Float.parseFloat(s);
        } catch (NumberFormatException e) {
            Log.v("myLogs", "NumberFormatException  - " + e);
        }
        return 0.0f;
    }

    private static Integer parseInt(String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            Log.v("myLogs", "NumberFormatException  - " + e);
        }
        return 0;
    }

}
