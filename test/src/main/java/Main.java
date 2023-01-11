public class Main {

    static class A {
        public A() {
            System.out.println("A");
        }
    }

    static class B extends A {
        public B() {
            System.out.println("B");
        }
    }

    public static void main(String[] args) {
        new B();
    }
}
