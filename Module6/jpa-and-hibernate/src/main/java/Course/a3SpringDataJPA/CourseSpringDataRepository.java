package Course.a3SpringDataJPA;

import org.springframework.data.jpa.repository.JpaRepository;
import Course.Course;

import java.util.List;

public interface CourseSpringDataRepository extends JpaRepository<Course, Long> {
    List<Course> findByAuthor(String author);

    List<Course> findByName(String name);
}
