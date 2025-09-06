import converter.DatTwoCDataConverter;
import converter.Register;
import enumeration.DataClasses;

import java.util.Map;
import java.util.List;

public class PerceptronMain {

    public static void main(String[] args) {
        DatTwoCDataConverter dataConverter = new DatTwoCDataConverter();
        List<Register> data = dataConverter.converter();

        if (data.isEmpty()) {
            System.err.println("Nenhum dado foi carregado do arquivo.");
            return;
        }

        PerceptronImp perceptron = new PerceptronImp(6, 1);

        for (int epoch = 0; epoch < 10000; epoch++) {
            double errE = 0.0;
            for (Register sample : data) {
                double[] out = perceptron.treinar(sample.getFeatures(), sample.getTarget());
                errE += Math.abs(out[0] - sample.getTarget()[0]);
            }
            System.out.printf("[Vertebral-column 2C] Epoch: %d - Error: %.4f%n", epoch, errE);
        }
    }

}
