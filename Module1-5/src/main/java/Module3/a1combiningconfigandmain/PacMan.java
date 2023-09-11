package Module3.a1combiningconfigandmain;


import org.springframework.stereotype.Component;

@Component
public class PacMan implements GamingConsole {
    public void up(){
        System.out.println("Pac going up");
    }public void down(){
        System.out.println("Pac going down");
    }public void left(){
        System.out.println("Pac going left");
    }public void right(){
        System.out.println("Pac going right");
    }
}
