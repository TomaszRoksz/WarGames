import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors

public class WriteToFile {

    public  void writeToFile(String report) {
        try {
            FileWriter myWriter = new FileWriter("War_report.txt");
            myWriter.write(report);
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error while printing to a file occurred.");
        }
    }
}



