package Module3.a1combiningconfigandmain;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component

public class gameRunner {
    GamingConsole game;
//    public gameRunner(GamingConsole game){
//        this.game=game;
//    }
    public gameRunner(@Qualifier("SuperContraQualifier") GamingConsole game){
        this.game=game;
    }
    public void run(){
        System.out.println(game+"Running");
        game.up();
        game.down();
        game.left();
        game.right();
    }
}
