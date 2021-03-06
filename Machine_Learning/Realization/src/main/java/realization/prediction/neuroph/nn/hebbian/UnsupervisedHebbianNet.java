package realization.prediction.neuroph.nn.hebbian;

import org.neuroph.core.NeuralNetwork;
import org.neuroph.core.data.DataSet;
import org.neuroph.core.data.DataSetRow;
import org.neuroph.nnet.UnsupervisedHebbianNetwork;

import java.util.Arrays;

/**
 * Supervised and unsupervised Hebbian networks are feedforward networks that use Hebbian learning rule.
 * <p>
 * From the point of view of artificial neural networks,Hebb's principle can be described as a method of
 * determining how to alter the weights between neurons based on their activation.
 * <p>
 * The weight between two neurons will increase if the two neurons activate simultaneously,
 * and it is reduced if they activate separately.
 * <p>
 * Configuration
 * -------------
 * - Input Function: WeightedSum
 * - Transfer Function: LINEAR
 * - Learning Rule: UnsupervisedHebbianLearning
 * - Network Type: UNSUPERVISED_HEBBIAN_NET
 * - Neuron Type: Neuron (input neuron:2, output neuron:1, total layers: 2)
 * - Bias: no
 * <p>
 * <p>
 * Below example is of AND logic function simulation
 * http://neuroph.sourceforge.net/tutorials/Hebbian.html
 * <p>
 * <p>
 * Created by hdhamee on 4/20/16.
 */
public class UnsupervisedHebbianNet {
    public static void main(String args[]) {

        // create training set (logical AND function)
        DataSet trainingSet = new DataSet(2, 1);
        trainingSet.addRow(new DataSetRow(new double[]{0, 0}, new double[]{0}));
        trainingSet.addRow(new DataSetRow(new double[]{0, 1}, new double[]{0}));
        trainingSet.addRow(new DataSetRow(new double[]{1, 0}, new double[]{0}));
        trainingSet.addRow(new DataSetRow(new double[]{1, 1}, new double[]{1}));

        // create perceptron neural network
        NeuralNetwork myPerceptron = new UnsupervisedHebbianNetwork(2, 1);

        // learn the training set
        myPerceptron.learn(trainingSet);

        // test perceptron
        System.out.println("Testing trained perceptron");
        testNeuralNetwork(myPerceptron, trainingSet);

        // save trained perceptron
        myPerceptron.save("mySamplePerceptron.nnet");


        // load saved neural network
        NeuralNetwork loadedPerceptron = NeuralNetwork.createFromFile("mySamplePerceptron.nnet");

        // test loaded neural network
        System.out.println("Testing loaded perceptron");
        testNeuralNetwork(loadedPerceptron, trainingSet);
    }

    /**
     * Prints network output for the each element from the specified training set.
     *
     * @param neuralNet neural network
     * @param testSet   data set used for testing
     */
    public static void testNeuralNetwork(NeuralNetwork neuralNet, DataSet testSet) {

        for (DataSetRow trainingElement : testSet.getRows()) {
            neuralNet.setInput(trainingElement.getInput());
            neuralNet.calculate();
            double[] networkOutput = neuralNet.getOutput();

            System.out.print("Input: " + Arrays.toString(trainingElement.getInput()));
            System.out.println(" Output: " + Arrays.toString(networkOutput));
        }
    }
}
