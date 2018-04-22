package creator.prototype;

import creator.builder.ConcreteBuilder;

/**
 * Created by single on 17/4/5.
 */
public class Prototype implements Cloneable {
    private String name;
    private int age;
    private ConcreteBuilder concreteBuilder;

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

    @Override
    public Object clone() {
        try {
            Prototype pro = (Prototype) super.clone();
            pro.setConcreteBuilder((ConcreteBuilder) pro.getConcreteBuilder().clone());
            return pro;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        Prototype prototype = new Prototype();
        prototype.setConcreteBuilder(new ConcreteBuilder());
        prototype.setName("limingming");
        Prototype prototype1 = (Prototype) prototype.clone();
        System.out.println(prototype == prototype1);
        System.out.println(prototype.getClass().getClassLoader() == prototype1.getClass().getClassLoader());
        System.out.println(prototype.getName() == prototype1.getName());
        System.out.println(prototype.getConcreteBuilder() == prototype1.getConcreteBuilder());
    }

    public ConcreteBuilder getConcreteBuilder() {
        return concreteBuilder;
    }

    public void setConcreteBuilder(ConcreteBuilder concreteBuilder) {
        this.concreteBuilder = concreteBuilder;
    }
}
