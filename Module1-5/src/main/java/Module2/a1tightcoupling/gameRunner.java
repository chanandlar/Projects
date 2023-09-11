package Module2.a1tightcoupling;

public class gameRunner {
    Mario game;
    public gameRunner(Mario game){
        this.game=game;
    }public void run(){
        System.out.println(game+"Running");
        game.up();
        game.down();
        game.left();
        game.right();
    }
}
