package board;

/**
 * Created by lora on 25.05.17.
 *
 */
public class Field implements HasSize, HasLength, Resetable {

    private static final String n = System.getProperty("line.separator");

    private Cells cells;
    private int sizeOfRow;

    public Field(Cells cells) {
        this.cells = cells;
        this.sizeOfRow = squareRootOfCellsLength();
    }

    private int squareRootOfCellsLength() {
        int squareRoot = 0;
        if (cells != null) {
            squareRoot = (int) Math.sqrt(cells.length());
        }
        return squareRoot;
    }

    @Override
    public boolean equals(Object object) {
        boolean isEquals = false;
        if (object instanceof Field) {
            isEquals = (hashCode() == object.hashCode());
        }
        return isEquals;
    }

    @Override
    public int hashCode() {
        return cells.hashCode();
    }

    @Override
    public void reset() {
        cells.reset();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(cells.toString());

        for (int i = 0; i < sizeOfRow; i++ ) {
            builder.insert(i * sizeOfRow + i , n);
        }
        return builder.toString();
    }

    @Override
    public int length() {
        return cells.length();
    }

    @Override
    public int sizeOfRow() { return sizeOfRow; }

    Symbol set(int indexX, int indexY, Symbol toSymbol) {
        int index = indexX * sizeOfRow + indexY;
        return set(index, toSymbol);
    }

    Symbol set(int index, Symbol toSymbol) {
        return cells.set(index, toSymbol);
    }

    Symbol[] getSymbolsInRow(int indexOfRow) {
        int start = indexOfRow * sizeOfRow;
        Symbol[] rowValues = new Symbol[sizeOfRow];
        for (int i = 0; i < sizeOfRow; i++) {
            rowValues[i] = cells.getSymbolAt(start + i);
        }
        return rowValues;
    }

    Symbol getSymbolAt(int index) {
        return cells.getSymbolAt(index);
    }

    Symbol getSymbolAt(int indexX, int indexY) {
        int index = sizeOfRow * indexX + indexY;
        return cells.getSymbolAt(index);
    }
}