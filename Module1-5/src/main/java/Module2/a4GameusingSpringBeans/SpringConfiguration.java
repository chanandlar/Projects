package Module2.a4GameusingSpringBeans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfiguration {
    @Bean
    public GamingConsole Game(){
        return new PacMan();
    }

    @Bean
    public gameRunner Gamerunner(){
        return new gameRunner(Game());
    }
}
