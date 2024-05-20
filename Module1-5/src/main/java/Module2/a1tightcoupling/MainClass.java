package Module2.a1tightcoupling;

public class MainClass {

    public static void main(String[] args) {
        var mariogame=new Mario();
        gameRunner game=new gameRunner(mariogame);
        game.run();
    }
}
