package Ex3;

import java.io.ObjectInputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * Created by Anastasia on 17.01.2017.
 */
public class Serializbe {
    public static String serializbe(Object o) throws IllegalAccessException {
        Class<?> cls = o.getClass();
        StringBuilder stringBuilder = new StringBuilder();

        Field[] fields = cls.getDeclaredFields();
        for (Field f : fields) {
                if (!cls.isAnnotationPresent(Save.class)) {
                continue;
            }
                if (Modifier.isPrivate(f.getModifiers())) f.setAccessible(true);

                stringBuilder.append(f.getName() + "=");

                if (f.getType() == int.class)
                    stringBuilder.append(f.getInt(o));
                if (f.getType() == String.class)
                stringBuilder.append(f.get(o));

            stringBuilder.append(";");
    }
    return stringBuilder.toString();
}

public static <T> T deserializbe(String s,Class<T> cls) throws IllegalAccessException, InstantiationException, NoSuchFieldException {
        T res = (T)cls.newInstance();
        String[] pairs = s.split(";");

    for (String p :pairs
         ) {
        String[] nv = p.split("=");

        String name = nv[0];
        String value = nv[1];
        Field f = cls.getDeclaredField(name);
        if (Modifier.isPrivate(f.getModifiers())) f.setAccessible(true);

        if (f.isAnnotationPresent(Save.class)) {
            if (f.getType() == int.class) {
                f.setInt(res, Integer.parseInt(value));
            } else if (f.getType() == String.class) {
                f.set(res, value);
            }
        }


    }
    return res;



}

}
