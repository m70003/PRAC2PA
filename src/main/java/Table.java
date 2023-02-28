import java.util.ArrayList;
import java.util.List;

public class Table {
    private List<String> headers;
    private List<Row> rows;

    public Table() {
        headers = new ArrayList<>();
        rows = new ArrayList<>();
    }

    public void addHeader(String header) {
        headers.add(header);
    }

    public void addRow(Row row) {
        rows.add(row);
    }

    public int numRows() {
        return rows.size();
    }

    public int numColumns() {
        return headers.size();
    }

    public String getHeader(int column) {
        return headers.get(column);
    }

    public Row getRowAt(int rowNumber) {
        return rows.get(rowNumber);
    }
}
