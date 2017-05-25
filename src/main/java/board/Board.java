package board;

/**
 * Created by lora on 25.05.17.
 */
public class Board implements HasSize {

    private final Fields fields;

    public Board() {
        fields = new Fields();
    }

    public Fields getFields() {
        return fields;
    }

    @Override
    public int size() {
        return fields.size();
    }
}
