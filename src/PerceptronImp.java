public class PerceptronImp {
    private double[][] W;

    private final int qtdaInput, qtdaOutput;

    public PerceptronImp(int qtdaInput, int qtdaOutput) {
        this.qtdaInput = qtdaInput;
        this.qtdaOutput = qtdaOutput;
        this.W = new double[this.qtdaOutput][this.qtdaInput + 1];

        //inicializar com pesos aleatórios
        for (int i = 0; i < this.qtdaOutput; i++) {
            for (int j = 0; j < this.qtdaInput + 1; j++) {
                this.W[i][j] = Math.random() * 2 - 1;
            }
        }
    }

    public double[] treinar(double[] Xin, double[] Yout) {
        double[] X = new double[Xin.length + 1];
        X[0] = 1;
        for (int i = 0; i < Xin.length; i++) {
            X[i + 1] = Xin[i];
        }

        double[] out = new double[this.qtdaOutput];
        for (int i = 0; i < this.qtdaOutput; i++) {
            double u = 0;
            for (int j = 0; j < this.qtdaInput + 1; j++) {
                u += X[j] * W[i][j];
            }
            out[i] = 1.0 / (1.0 + Math.exp(-u));
        }

        for (int i = 0; i < this.qtdaOutput; i++) {
            for (int j = 0; j < this.qtdaInput + 1; j++) {
                double ni = 0.3;
                W[i][j] += ni * (Yout[i] - out[i]) * X[j];
            }
        }
        return out;
    }
}
