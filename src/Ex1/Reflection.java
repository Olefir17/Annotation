package Ex1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Anastasia on 15.01.2017.
 */
public class Reflection {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        SomeClass sm = new SomeClass();
        Class<?> cls = SomeClass.class;

        Method[]  methods = cls.getDeclaredMethods();
        for (Method m : methods){
            if(m.isAnnotationPresent(Test.class)){
                Test test = m.getAnnotation(Test.class);
                int res = (int) m.invoke(sm,test.a(), test.b());
                System.out.println(res);
            }
        }
    }
}
