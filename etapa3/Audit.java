import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Audit {


    public void write (String action, LocalDateTime timestamp) throws IOException {
        FileWriter file =  new FileWriter("text\\registru.text", true);
        file.write("\n");
        file.write(action);
        file.write(",");
        file.write(timestamp.toString());


        file.close();


    }
}
