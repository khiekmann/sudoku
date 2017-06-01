package board;

/**
 * Created by lora on 25.05.17.
 *
 */
public class Board implements HasSize, HasLength, Resetable{

    private static final String n = System.getProperty("line.separator");

    private final Fields fields;
    private final int sizeOfRow;

    public Board(Fields fields) {
        this.fields = fields;
        this.sizeOfRow = squareRootOfFieldsLength();
    }

    private int squareRootOfFieldsLength() {
        int squareRoot = 0;
        if (fields != null) {
            squareRoot = (int) Math.sqrt(fields.length());
        }
        return squareRoot;
    }

    @Override
    public boolean equals(Object object) {
        boolean isEquals = false;
        if (object instanceof Board) {
            isEquals = (hashCode() == object.hashCode());
        }
        return isEquals;
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    @Override
    public int length() {
        return fields.length();
    }

    @Override
    public void reset() {
        fields.reset();
    }

    @Override
    public int sizeOfRow() {
        return sizeOfRow;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(fields.toString());

        for (int i = 0; i < sizeOfRow; i++ ) {
            builder.insert(i * sizeOfRow + i , n);
        }
        return builder.toString();
    }
}