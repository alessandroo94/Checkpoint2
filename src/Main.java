import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String inputFilePath = "input.txt";
        String outputFilePath = "output.txt";

        try {
            List<String> lines = Checkpoint.loadLines(inputFilePath);
            Map<String, Integer> mappa = Checkpoint.processLines(lines);
            System.out.println(mappa.get("Light"));
            Checkpoint.writeLines(outputFilePath, (HashMap<String, Integer>) mappa);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}