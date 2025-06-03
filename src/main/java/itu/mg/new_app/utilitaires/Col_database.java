package itu.mg.new_app.utilitaires;

import java.lang.reflect.Field;
import java.util.*;

public class Col_database {

    public static List <String> colDatabase(Class<?> clazz, List<String> excepts) {
    List<String> fields = new ArrayList<>();

    for (Field f : clazz.getDeclaredFields()) {
        fields.add(f.getName());
    }
    fields.removeAll(excepts);
    return fields;
}

}
