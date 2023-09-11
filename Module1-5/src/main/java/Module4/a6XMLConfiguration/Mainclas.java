package Module4.a6XMLConfiguration;



import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

@Configuration
@ComponentScan
public class Mainclas {
    public static void main(String[] args){
        var context=new ClassPathXmlApplicationContext("XmlConfiguration.xml");
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
        context.getBean(Module3.a1combiningconfigandmain.gameRunner.class).run();
    }
}
