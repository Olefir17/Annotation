package Ex3;

import Ex1.*;

/**
 * Created by Anastasia on 17.01.2017.
 */
public class Main {
    public static void main(String[] args) throws IllegalAccessException, NoSuchFieldException, InstantiationException {
        Test test = new Test();

        test.setName("Alex");
        test.setAge(24);
        //test.setSex("W");

        String res = Serializbe.serializbe(test);
        System.out.println(res);

        test = Serializbe.deserializbe(res,Test.class);
        System.out.println("Desiarilizbe " + test.getName() + " " + test.getSex() + " "+ test.getSex());

    }
}
