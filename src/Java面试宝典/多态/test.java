package Java面试宝典.多态;

public class test {

    public static void main(String[] args) {
        Father father = new Father();
        Child child = new Child();
        System.out.println(father.getName());
        System.out.println(child.getName());
    }
}

class Father{
    public static String getName() {
        return "father";
    }
}

class Child extends Father{
    public static String getName() {
        return "child";
    }
}

