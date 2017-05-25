package board;

/**
 * Created by lora on 25.05.17.
 */
public enum CellValue {

    notSet("_");

    private final String value;

    CellValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
