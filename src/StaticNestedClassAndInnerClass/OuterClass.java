package StaticNestedClassAndInnerClass;

public class OuterClass {

    /*
    Nested class are divided into "static nested class" and "inner class"
    Static nested class is a static member, so don't need a outer class instance
    Inner class is an instance member, so do need a outer class instance
     */

    static class StaticNestedClass {

    }

    class InnerClass {

    }

    public static void main(String[] args) {
         OuterClass.StaticNestedClass staticNestedClass = new OuterClass.StaticNestedClass();
         OuterClass outerClass = new OuterClass();

         // InnerClass innerClass = new InnerClass();
         // Above is wrong!!!

         InnerClass innerClass = outerClass.new InnerClass();
    }
}
