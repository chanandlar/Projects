package Module3.a1combiningconfigandmain;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class Combinedmainandconfig {
//    @Bean
//    public GamingConsole Game(){
//        return new PacMan();
//    }

//    @Bean
//    public gameRunner Gamerunner(GamingConsole game){
//        System.out.println("Parameter :"+ game);
//        return new gameRunner(game);
//    }
    public static void main(String[] args){
        var context=new AnnotationConfigApplicationContext(Combinedmainandconfig.class);
        context.getBean(GamingConsole.class).up();
        context.getBean(gameRunner.class).run();
    }
}
