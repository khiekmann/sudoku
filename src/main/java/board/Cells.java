package board;

/**
 * Created by lora on 25.05.17.
 *
 */
public class Cells implements HasLength, Resetable {

    private final Cell[] cells;

    Cells(Cell[] arrayOfCells) {
        cells = arrayOfCells;
    }

    @Override
    public boolean equals(Object object) {
        boolean isEqual = false;
        if (object instanceof Cells) {
            isEqual = (hashCode() == object.hashCode());
        }
        return isEqual;
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    @Override
    public int length() { return cells.length; }

    @Override
    public void reset() {
        for ( Cell cell : cells) {
            cell.reset();
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Cell cell : cells) {
            builder.append(cell);
        }
        return builder.toString();
    }

    Symbol set(int index, Symbol toSymbol) {
        Symbol previous = cells[index].symbol();
        cells[index].symbol(toSymbol);
        return previous;
    }

    Symbol getSymbolAt(int index) {
        return cells[index].symbol();
    }
}