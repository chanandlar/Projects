package Module4.a1EagerInitialization;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
class classA{

}

@Component
class classB{
    classA aobj;
    classB(classA aobj){
        System.out.println("Some initialization logic");
        this.aobj=aobj;
    }
}
@Configuration
@ComponentScan
public class Mainclass {
    public static void main(String[] args){
        var context= new AnnotationConfigApplicationContext(Mainclass.class);
    }
}
