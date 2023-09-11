package Module4.a2LazyInitialization;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
class classA{

}

@Component
@Lazy
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
        System.out.println("Context initialized");
        context.getBean(classB.class);
    }
}
