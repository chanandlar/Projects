package Course;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class JpaAndHibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaAndHibernateApplication.class, args);
	}
}
