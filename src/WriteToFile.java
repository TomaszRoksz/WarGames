import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {

    String fileName;

    WriteToFile(String fileName){
        this.fileName=fileName;
    }

    public void writeToFile(String report) {

        try {
            FileWriter myWriter = new FileWriter(fileName);
            myWriter.write(report);
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error while printing to a file occurred.");
        }
    }
}



