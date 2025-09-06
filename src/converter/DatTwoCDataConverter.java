package converter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class DatTwoCDataConverter {
    private final String filePath = "src/vertebral-column/column_2C.dat";

    public List<Register> converter() {
        List<Register> dataset = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.isBlank()) continue;
                String[] tokens = splitLine(line);
                if (tokens.length < 2) continue;

                String classToken = tokens[tokens.length - 1];

                double[] features = new double[tokens.length - 1];
                for (int i = 0; i < tokens.length - 1; i++) {
                    features[i] = Double.parseDouble(tokens[i]);
                }

                double[] target = new double[] { "AB".equalsIgnoreCase(classToken) ? 1.0 : 0.0 };

                dataset.add(new Register(features, target));
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return dataset;
    }


    private String[] splitLine(String line) {
        return line.trim().split("\\s+");
    }
}
