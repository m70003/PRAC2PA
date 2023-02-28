import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;

import static java.lang.module.ModuleDescriptor.read;


public class TableWithLabels {
    private final List<List<Double>> data;
    private final List<Integer> labels;

    private List<Row> rows;
    private List<List<Double>> table;

    public TableWithLabels() {
        this.data = new ArrayList<>();
        this.labels = new ArrayList<>();
        this.rows = new ArrayList<>();
    }

    public void addRow(List<Double> row, Integer label) {
        this.data.add(row);
        this.labels.add(label);
    }

    public List<List<Double>> getData() {
        return this.data;
    }

    public int getNumRows() {
        return rows.size();
    }

    public List<Integer> getLabels() {
        return this.labels;
    }

    public int getSize() {
        return this.data.size();
    }

    public Row getRow(int rowNumber) {
        return rows.get(rowNumber);
    }

    public void loadFromCSV(String fileName) throws IOException {
        CSV csv = new CSV(fileName);
        List<List<String>> csvData = (List<List<String>>) csv.read();

        // Convert CSV data into table
        List<List<Double>> table = (List<List<Double>>) new Table();
        for (List<String> row : csvData) {
            List<Double> doubleRow = new ArrayList<>();
            for (String value : row) {
                doubleRow.add(Double.parseDouble(value));
            }
            table.add(doubleRow);
        }

        // Store table
        this.table = table;
    }

    public int getNumColumns() {
        return this.data.get(0).size();
    }

    public void print() {
        for (int i = 0; i < this.getSize(); i++) {
            System.out.print(this.labels.get(i) + ":\t");
            for (int j = 0; j < this.getNumColumns(); j++) {
                System.out.print(this.data.get(i).get(j) + "\t");
            }
            System.out.println();
        }
    }

}
