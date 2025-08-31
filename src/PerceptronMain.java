import converter.DatTwoCDataConverter;
import converter.Register;
import enumeration.DataClasses;

import java.util.Map;

public class PerceptronMain {

    private final DatTwoCDataConverter dataConverter = new DatTwoCDataConverter();
    public Register dataParser(String[] data, DataClasses dataClass) {
        Map<String[], DataClasses> convertedData = dataConverter.converter();
    }

    public static void main(String[] args) {
        // Vertebral-column Base
        PerceptronImp PerceptronImpE = new PerceptronImp(2, 1);
        for (int epoch = 0; epoch < 10000; epoch++) {
            double errE = 0;
            for (int a = 0; a < baseI.length; a++) {
                double[] out = PerceptronImpE.treinar(baseI[a][0], baseI[a][1]);
                errE += Math.abs(out[0] - baseI[a][1][0]);
            }
            System.out.printf("[Vertebral-column] Epoch: %d - Error: %.4f%n", epoch, errE);
        }
    }
}
