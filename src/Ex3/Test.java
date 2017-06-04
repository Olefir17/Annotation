package Ex3;

import Ex2.*;

/**
 * Created by Anastasia on 17.01.2017.
 */
public class Test {
    @Save
    public String name;
    @Save
    private int age;
    @Save
    String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
