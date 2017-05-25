package board;

/**
 * Created by lora on 25.05.17.
 */
public class Field implements HasSize, HasLength{

    private static final String n = System.getProperty("line.separator");

    private final int sizeOfEachSide;
    private final Cells cells;

    public Field(int sizeOfEachSide) {
        this.sizeOfEachSide = sizeOfEachSide;
        cells = new Cells(sizeOfEachSide);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(cells.toString());
        for ( int i = 0; i < sizeOfEachSide; i++ ) {
            builder.insert(i * sizeOfEachSide + i , n);
        }
        return builder.toString();
    }

    @Override
    public int size() {
        return sizeOfEachSide;
    }

    @Override
    public int length() {
        return cells.length();
    }
}