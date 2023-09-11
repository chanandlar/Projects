package Module2.a3Beans;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

record Person(String name,int age,Address address){};
record Address(String firstline,String city){};

@Configuration
public class HelloWorldConfiguration {
    @Bean
    public String name(){
        return "Shoeb";
    }
    @Bean
    public int age(){
        return 23;
    }
    @Bean
    public Person person(){
        return new Person("Younus",11,new Address("Oldcity","Hyderabad"));
    }
    @Bean
    public Person person2(){
        return new Person(name(),age(),address());
    }
    @Bean
    public Person person3(String name,int age,@Qualifier("addressqualifier")Address address){
        return new Person(name,age,address);
    }
    @Bean(name="addressbean")
    @Qualifier("addressqualifier")
    public Address address(){
        return new Address("Paramount Colony","Tolichowki");
    }

    @Bean
    @Primary
    public Address address2(){ return new Address("OldCity","Hyderabad");}

}
