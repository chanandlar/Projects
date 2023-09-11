package Module5.a1Course;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Arrays;
import java.util.List;

@RestController
public class CourseController {
    @RequestMapping("/courses")
    public List<Course> retreiveAllCourses(){
        return Arrays.asList (
                new Course(1, "a", "b"),
                new Course(2, "c", "d"),
                new Course(2, "c", "d"),
                new Course(3, "e", "f"),
                new Course(4, "g", "h"),
                new Course(4, "g", "h")
        );
    }
}
