package OODesign;

public class Test {
    public static void main(String[] args) throws Exception {
        Human human = new Boy();
        human.Eat();
        ((Boy) human).CheckZ();
    }
}
