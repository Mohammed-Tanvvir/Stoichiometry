import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileManager {

    private File historyFile;

    public FileManager(String fileName) {
        this.historyFile = new File(fileName);
    }

public void writeHistory(String input) {
    FileWriter writer = null;
    try {
        writer = new FileWriter(historyFile, true); // true for append mode
        writer.write(input + "\n");
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        if (writer != null) {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
}