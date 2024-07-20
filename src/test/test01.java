package test;

public class test01 {
    public static void main(String[] args) {
        sayHello();
    }


    public static void sayHello() {
        System.out.println("Hello");
        sayHi();
    }

    private static void sayHi() {
        System.out.println("Hi");
    }
}
