import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class KNNSpecial {

    private List<List<Double>> data;
    private List<Integer> labels;

    public void train(TableWithLabels data) {
        this.data = data.getData();
        this.labels = data.getLabels();
    }

    public String estimate(List<Double> sample, int k) {
        List<Double> distances = new ArrayList<Double>();

        // Calcular la distancia de la muestra a cada ejemplo de entrenamiento
        for (List<Double> example : this.data) {
            double distance = 0.0;
            for (int i = 0; i < example.size(); i++) {
                distance += Math.pow(example.get(i) - sample.get(i), 2);
            }
            distances.add(Math.sqrt(distance));
        }

        // Encontrar los k vecinos más cercanos
        List<Integer> nearestNeighbors = new ArrayList<Integer>();
        for (int i = 0; i < k; i++) {
            int index = distances.indexOf(Collections.min(distances));
            nearestNeighbors.add(index);
            distances.set(index, Double.MAX_VALUE); // Marcamos la distancia como infinita para no volver a seleccionar el mismo vecino
        }

        // Contar la frecuencia de cada clase en los k vecinos más cercanos
        Map<String, Integer> freq = new TreeMap<String, Integer>();
        for (int index : nearestNeighbors) {
            String label = String.valueOf(this.labels.get(index));
            freq.put(label, freq.getOrDefault(label, 0) + 1);
        }

        // Devolver la clase más frecuente
        String result = null;
        int maxFreq = -1;
        for (Map.Entry<String, Integer> entry : freq.entrySet()) {
            if (entry.getValue() > maxFreq) {
                maxFreq = entry.getValue();
                result = entry.getKey();
            }
        }
        return result;
    }
}
