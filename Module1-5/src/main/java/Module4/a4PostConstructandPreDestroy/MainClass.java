package Module4.a4PostConstructandPreDestroy;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class SomeClass{
    public SomeClass(SomeDependency someDependency) {
        this.someDependency = someDependency;
        System.out.println("All Depepdencies are ready");
    }
    @PostConstruct
    public void initialize(){
        someDependency.getReady();
    }
    @PreDestroy
    public void Cleanup(){
        someDependency.cleanup();
    }

    private SomeDependency someDependency;

}
@Component
class SomeDependency{
    public void getReady(){
        System.out.println("Some logic using some dependency");
    }
    public void cleanup(){
        System.out.println("Clean-up");
    }
}

@Configuration
@ComponentScan
public class MainClass {
    public static void main(String[] args){
        var context=new AnnotationConfigApplicationContext(MainClass.class);
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
    }
}
