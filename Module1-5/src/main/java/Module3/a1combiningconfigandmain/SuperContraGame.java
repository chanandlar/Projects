package Module3.a1combiningconfigandmain;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("SuperContraQualifier")
public class SuperContraGame implements GamingConsole {
    public void up(){
        System.out.println("contra going up");
    }public void down(){
        System.out.println("contra going down");
    }public void left(){
        System.out.println("contra going left");
    }public void right(){
        System.out.println("contra going right");
    }
}
