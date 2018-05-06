package OODesign;

public abstract class Human implements HumanBehavior{

    public int height;
    public int weight;
    protected final int z = 1;

    public Human() {
        System.out.println("inside the human constructor");
    }

    public Human(int h, int w) {
        height = h;
        weight = w;
    }

    public void Eat() {
        System.out.println("human is eating");
    }

    public void Sleep() {
        System.out.println("human is sleeping");
    }

    public final void FinalMethod() {
        System.out.println("This is final");
    }
}
