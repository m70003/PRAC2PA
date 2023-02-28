import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class KNNTest {

    private CSV csvReader;


    @Before
    public void setUp() {
        csvReader = new CSV("C:\\Users\\mulla\\IdeaProjects\\PRAC2PA\\src\\main\\java\\iris.csv");
    }

    @Test
    public void testDistanceCalculation() {
        List<Double> point1 = Arrays.asList(1.0, 2.0, 3.0);
        List<Double> point2 = Arrays.asList(4.0, 5.0, 6.0);
        List<Double> point3 = Arrays.asList(0.0, 0.0, 0.0);

        double distance1 = KNN.euclideanDistance(point1, point2);
        double distance2 = KNN.euclideanDistance(point1, point3);

        assertEquals(5.196152, distance1, 0.000001);
        assertEquals(3.741657, distance2, 0.000001);
    }

    @Test
    public void testEstimate() throws IOException {
        List<Double> point1 = Arrays.asList(5.1, 3.5, 1.4, 0.2);
        List<Double> point2 = Arrays.asList(6.4, 3.2, 4.5, 1.5);
        List<Double> point3 = Arrays.asList(6.3, 3.3, 6.0, 2.5);

        TableWithLabels irisTable = new TableWithLabels();
        irisTable.loadFromCSV("C:\\Users\\mulla\\IdeaProjects\\PRAC2PA\\src\\main\\java\\iris.csv");

        KNN knn = new KNN();
        knn.train(irisTable);

        List<Integer> label1 = knn.estimate(point1);
        List<Integer> label2 = knn.estimate(point2);
        List<Integer> label3 = knn.estimate(point3);

        assertEquals(0, label1);
        assertEquals(1, label2);
        assertEquals(2, label3);
    }
}
