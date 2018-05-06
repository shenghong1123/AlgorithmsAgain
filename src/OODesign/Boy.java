package OODesign;

public class Boy extends Man {

    public Boy() {
        System.out.println("inside the boy constructor");
    }

    public Boy(int h, int w) {
        height = h;
        weight = w;
    }
    // Boy inherits Human class, no need to implement all methods in HumanBehavior
    @Override
    public void Eat() {
        System.out.println("Boy is eating");
    }

    public void CheckZ() {
        System.out.println(this.z);
    }


}
