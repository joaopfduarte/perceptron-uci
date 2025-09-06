import converter.DatTwoCDataConverter;
import converter.Register;
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
            int errCls = 0;
            for (Register sample : data) {
                double[] out = perceptron.treinar(sample.getFeatures(), sample.getTarget());
                errE += Math.abs(out[0] - sample.getTarget()[0]);

                double pred = out[0] >= 0.5 ? 1.0 : 0.0;
                if (pred != sample.getTarget()[0]) {
                    errCls++;
                }
            }
            int total = data.size();
            double taxaErroClss = (double) errCls / total;
            System.out.printf(
                    "[Vertebral-column 2C] Epoch: %d - ApproxError: %.4f - ClassError: %d/%d (%.2f%%)%n",
                    epoch, errE, errCls, total, taxaErroClss * 100.0
            );
        }
    }

}
