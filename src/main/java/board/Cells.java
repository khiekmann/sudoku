package board;

/**
 * Created by lora on 25.05.17.
 */
public class Cells implements HasSize, HasLength{

    private static final String n = System.getProperty("line.separator");

    private final int size;
    private final Cell[] cells;

    public Cells(int sizeOfEachSide) {
        this.size = sizeOfEachSide;
        cells = new Cell[sizeOfEachSide * sizeOfEachSide];
        reset();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int length() { return cells.length; }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Cell cell : cells) {
            builder.append(cell);
        }
        return builder.toString();
    }

    private void reset() {
        for ( int i = 0; i < cells.length; i++) {
            cells[i] = Cell.withoutValue();
        }
    }
}