package Ex2;

import Ex1.Test;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Anastasia on 15.01.2017.
 */
public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        TextContainer t = new TextContainer();
        Class<?> cls = t.getClass();



        if(! cls.isAnnotationPresent(SaveTo.class)){
            System.out.println("erroooooooooor");
        }

        SaveTo sv = cls.getAnnotation(SaveTo.class);
        String path = sv.path();
        Method[]  methods = cls.getDeclaredMethods();
        for (Method m : methods){
            if(m.isAnnotationPresent(Save.class)){
                m.invoke(t,path);
                break;

            }
        }
        System.out.println("Ok");
    }
}
