package Module3.a3BusinessCalculationExercise;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class Mainclass {
    public static void main(String[] args){
        var context=new AnnotationConfigApplicationContext(Mainclass.class);
        System.out.println(context.getBean(BusinessCalculationService.class).findMax());
    }
}
