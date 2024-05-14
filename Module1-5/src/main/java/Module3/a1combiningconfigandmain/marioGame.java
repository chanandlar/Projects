package Module3.a1combiningconfigandmain;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class marioGame implements GamingConsole {
    public void up() {
        System.out.println("mario going up");
    }

    public void down() {
        System.out.println("mario going down");
    }

    public void left() {
        System.out.println("mario going left");
    }

    public void right() {
        System.out.println("mario going right");
    }
}
