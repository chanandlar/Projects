package Module2.a3Beans;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class Mainclass {
    public static void main(String[] args){
        try{
            //Launch a spring context
            var context=new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
            //Configure the things we want spring to manage - @Configuration
            //HelloWorldConfiguration - @Configuration
            //name - @Bean

            //3.Retrieving Beans managed by Spring
//            System.out.println(context.getBean("name"));
//            System.out.println(context.getBean("age"));
//            System.out.println(context.getBean("person"));
//            System.out.println(context.getBean("addressbean"));
//            System.out.println(context.getBean("person2"));
            System.out.println(context.getBean("person3"));

            System.out.println(context.getBean(Address.class));
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

        }
        catch (BeansException bexp){
            bexp.printStackTrace();
        }
    }
}
