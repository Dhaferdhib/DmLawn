import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class WhoseCode {

    @Test
    public void whoseCodeToComment(){
        Random random = new Random();
        List<String> attendanceList = Arrays.asList("Hamdi", "Anouar", "Mehrez", "Sahar");
        System.out.println(attendanceList.get(Math.abs(random.nextInt())% attendanceList.size()));
    }
}
