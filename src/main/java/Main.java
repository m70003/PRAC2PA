import jdk.internal.access.JavaNetHttpCookieAccess;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        KNNSpecial knn = new KNNSpecial();
        JavaNetHttpCookieAccess CSVParser = null;
        TableWithLabels data = (TableWithLabels) CSVParser.parse("iris.csv");
        knn.train(data);

        List<Double> sample1 = Arrays.asList(5.7, 2.8, 4.1, 1.3);
        List<Double> sample2 = Arrays.asList(6.5, 3.0, 5.5, 1.8);

        String class1 = knn.estimate(sample1, 5);
        String class2 = knn.estimate(sample2, 5);

        System.out.println("Sample 1: " + sample1 + " - Class: " + class1);
        System.out.println("Sample 2: " + sample2 + " - Class: " + class2);
    }
}
