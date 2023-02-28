import java.util.ArrayList;
import java.util.List;

public class Row {
    private List<String> values;

    public Row() {
        values = new ArrayList<>();
    }

    public void addValue(String value) {
        values.add(value);
    }

    public String getValue(int column) {
        return values.get(column);
    }

    public int numValues() {
        return values.size();
    }
}
