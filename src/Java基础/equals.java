package Java基础;

import java.util.ArrayList;
import java.util.List;

public class equals {
}

class Person {
    private String name;

    public Person(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Person) {
            Person person= (Person) obj;
            return name.equalsIgnoreCase(person.getName().trim());
        }
        return false;
    }
    public static void main(String[] args){
        Person p1=new Person("张三");
        Person p2=new Person("张三    ");
        List<Person> list = new ArrayList<Person>();
        list.add(p1);
        list.add(p2);
        System.out.println("是否包含张三："+list.contains(p1));//调用了对象的equals方法判断；
        System.out.println("是否包含张三："+list.contains(p2));
    }
}
