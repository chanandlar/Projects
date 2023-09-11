package Course;


import Course.a1JDBC.Coursejdbcrepository;
import Course.a2JPA.CourseJPArepository;
import Course.a3SpringDataJPA.CourseSpringDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Coursecommandlinerunner implements CommandLineRunner {
    //@Autowired
    //private Coursejdbcrepository repository
//    @Autowired
//    private CourseJPArepository repository;

    @Autowired
    private CourseSpringDataRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Course(1,"Learn AWS now","Ranga"));
        repository.save(new Course(2,"Learn Spring","Ranga"));
        repository.save(new Course(3,"Learn SpringBoot","Ranga"));

        repository.deleteById(1l);

        System.out.println(repository.findById(2l));
        System.out.println(repository.findById(3l));

        System.out.println(repository.findAll());
        System.out.println(repository.count());
        System.out.println(repository.findByAuthor("Shoeb"));
        System.out.println(repository.findByName("LearnSpringBoot"));
    }
}
