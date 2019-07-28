package Java面试宝典.多态;


    class classA{
        public void printValue(){
            System.out.println("A");
        }
    }

    class classB extends classA{
        public void printValue(){
            System.out.println("B");
        }
    }


public class one {

    public static void main(String[] args) {
        classB objectB = new classB();
        objectB.printValue();

        classA as = (classA) objectB;
        as.printValue();

        as = new classA();
        as.printValue();
    }

}
