import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Checkpoint {
    public static List<String> loadLines (String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        List<String> list = new ArrayList<>();
        String line;
        while (reader.ready()){
            line = reader.readLine();
            list.add(line);
        }
        reader.close();
        return list;
    }
    public static Map<String, Integer> processLines(List<String> lines) {
        Map<String, Integer> mappa = new HashMap<>();
        for(String line : lines){
            if(lines.isEmpty()){
                continue;
            }
            if(!line.contains("$")){
                System.out.println("Errore: La linea non contiene '$' " + line);
                continue;
            }
            int index = line.indexOf("$");
            if(index == -1){
                System.out.println("Line without '$': " + line);
            } else {
                String key = line.substring(0, index).trim();
                String value = line.substring(index + 1).trim();
                int count = value.split("\\s+").length;
                mappa.put(key, count);
            }
        }
        return mappa;
    }
    public static void writeLines(String filePath, HashMap<String, Integer> lines) throws IOException {
        try (PrintWriter writer = new PrintWriter(filePath)) {
            for (String key : lines.keySet()) {
                writer.println(key + " - " + lines.get(key));
            }
        }
    }
}
