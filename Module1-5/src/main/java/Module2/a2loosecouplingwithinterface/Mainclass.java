package Module2.a2loosecouplingwithinterface;

public class Mainclass {
    public static void main(String[] args){
        //loosecouplingwithinterface.PacMan game=new loosecouplingwithinterface.PacMan();
        var game=new marioGame();//1.object creation
        //var game=new SuperContraGame();
        var gameRunner=new gameRunner(game);
        //2.object creation + wiring of dependencies
        //game is a dependency of gamerunner
        gameRunner.run();
    }
}
