package Module3.a3BusinessCalculationExercise;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Primary
class MongoDbDataService implements DataService{
    public int[] retrieveData(){
        return new int[] { 11, 22, 33, 44, 55 };
    }
}
@Component
class MySQLDataService implements DataService{
    public int[] retrieveData(){
        return new int[] { 1, 2, 3, 4, 5 };
    }
}
@Component
public class BusinessCalculationService {
    DataService dataService;

    public BusinessCalculationService(DataService dataService) {
        this.dataService = dataService;
    }

    public int findMax(){
        return Arrays.stream(dataService.retrieveData())
                .max().orElse(0);
    }
}
