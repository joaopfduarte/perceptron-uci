package converter;

import enumeration.DataClasses;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DatTwoCDataConverter {
    private final String filePath = "src/vertebral-column/column_2C.dat";

    public Map<String[], DataClasses> converter() {
        Map<String[], DataClasses> parsedLine = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line + "\n");
                String[] data = splitLine(line);
                String classData = data[data.length - 1];
                DataClasses dataClass = getDataClass(classData);
                String[] dataWithoutClass = Arrays.copyOf(data, data.length - 1);
                parsedLine.put(dataWithoutClass, dataClass);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return parsedLine;
    }

    private String[] splitLine(String line) {
        return line.split(" ");
    }

    private DataClasses getDataClass(String data) {
        return DataClasses.valueOf(data);
    }
}
