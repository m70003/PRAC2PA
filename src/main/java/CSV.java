import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSV {
    private String fileName;

    public CSV(String fileName) {
        this.fileName = fileName;
    }

    public Table read() {
        Table table = new Table();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            boolean firstLine = true;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (firstLine) {
                    for (String value : values) {
                        table.addHeader(value);
                    }
                    firstLine = false;
                } else {
                    Row row = new Row();
                    for (String value : values) {
                        row.addValue(value);
                    }
                    table.addRow(row);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }

        return table;
    }

    public List<String[]> read2() {
        List<String[]> data = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;

            // Leer cada línea del archivo CSV
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");

                // Agregar los valores de la fila a la lista
                data.add(values);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }
}

