import java.util.Map;

public class RowWithLabel extends Row {
    private int label;

    public RowWithLabel() {
        super();
    }

    public void setLabel(int label) {
        this.label = label;
    }

    public int getLabel() {
        return label;
    }

    public String getLabelAsString(Map<Integer, String> labelsToIndex) {
        return labelsToIndex.get(label);
    }
}

