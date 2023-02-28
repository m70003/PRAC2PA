import java.util.List;

public class KNN {

    private TableWithLabels trainingData;

    public void train(TableWithLabels data) {
        this.trainingData = data;
    }

    public List<Integer> estimate(List<Double> sample) {
        List<Integer> nearestLabel = null;
        double nearestDistance = Double.MAX_VALUE;

        // Loop through all the rows in the training data
        for (int i = 0; i < trainingData.getNumRows(); i++) {
            List<Double> trainingSample = (List<Double>) trainingData.getRow(i);

            // Calculate the Euclidean distance between the sample and the training data row
            double distance = euclideanDistance(sample, trainingSample);

            // If the distance is smaller than the current nearest distance, update the nearest label
            if (distance < nearestDistance) {
                nearestDistance = distance;
                nearestLabel = trainingData.getLabels();
            }
        }

        return nearestLabel;
    }

    static double euclideanDistance(List<Double> sample1, List<Double> sample2) {
        double distanceSquared = 0.0;

        // Loop through all the dimensions (features) and calculate the squared difference
        for (int i = 0; i < sample1.size(); i++) {
            double diff = sample1.get(i) - sample2.get(i);
            distanceSquared += diff * diff;
        }

        return Math.sqrt(distanceSquared);
    }
}
