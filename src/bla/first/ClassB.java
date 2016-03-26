package bla.first;

public class ClassB extends ClassA {

    public static void blub() {
        System.out.println("blub in B");
    }

    public void doA() {
        System.out.println("doA in B");
    }

    public void doB() {
        super.doB();
        System.out.println("doB in B");
    }
}