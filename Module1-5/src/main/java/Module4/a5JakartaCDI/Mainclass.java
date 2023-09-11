package Module4.a5JakartaCDI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
@Component
//@Named
class BusinessService{
    private DataService dataService;

    public DataService getDataService() {
        System.out.println("Setter Based Injection");
        return dataService;
    }
    //@Inject
    @Autowired
    public void setDataService(DataService dataService) {
        this.dataService = dataService;
    }
}
@Component
class DataService{

}
@Configuration
@ComponentScan
public class Mainclass {
    public static void main(String[] args){
        var context=new AnnotationConfigApplicationContext(Mainclass.class);
        System.out.println(context.getBean(BusinessService.class).getDataService());
    }
}
