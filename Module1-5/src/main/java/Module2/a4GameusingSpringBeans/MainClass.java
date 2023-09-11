package Module2.a4GameusingSpringBeans;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainClass {
    public static void main(String[] args){
        var context=new AnnotationConfigApplicationContext(SpringConfiguration.class);
        context.getBean(gameRunner.class).run();
    }
}
