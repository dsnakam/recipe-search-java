import java.nio.file.Paths;
import java.util.Scanner;

public class FileReader {

    private Scanner scanner;

    public FileReader(String filePath) {

        try {
            this.scanner =
                new Scanner(Paths.get(filePath));

        } catch (Exception e) {

            throw new RuntimeException(e);
        }
    }

    public boolean hasNextLine() {
        return scanner.hasNextLine();
    }

    public String nextLine() {
        return scanner.nextLine();
    }
}