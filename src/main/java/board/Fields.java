package board;

/**
 * Created by lora on 25.05.17.
 */
public class Fields implements HasSize{

    private final int[] fields;

    public Fields() {
        fields = new int[9];
    }

    @Override
    public int size() {
        return fields.length;
    }
}
