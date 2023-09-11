package Module3.a2DependencyInjection;


import Module3.a1combiningconfigandmain.GamingConsole;
import Module3.a1combiningconfigandmain.gameRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;
@Component
class Businessclass{
//    @Autowired-setter based dependency injection
//    public void setDependency2(Dependency2 dependency2) {
//        this.dependency2 = dependency2;
//    }
//    @Autowired-setter based dependency injection
//    public void setDependency1(Dependency1 dependency1) {
//        this.dependency1 = dependency1;
//    }


    //@Autowired//Constructor based dependency injection
    public Businessclass(Dependency1 dependency1, Dependency2 dependency2) {
        System.out.println("Constructor based injection");
        this.dependency1 = dependency1;
        this.dependency2 = dependency2;
    }

    //@Autowired-used here for field based injection
    Dependency1 dependency1;
    //@Autowired-used here for field based injection
    Dependency2 dependency2;
    public String toString(){
        return "Using "+dependency1+" and "+dependency2;
    }
}
@Component
class Dependency1{

}
@Component
class Dependency2{

}

@Configuration
@ComponentScan
public class DependencyInjectionMain {
    public static void main(String[] args){
        var context=new AnnotationConfigApplicationContext(DependencyInjectionMain.class);
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        System.out.println(context.getBean(Businessclass.class));
    }
}
