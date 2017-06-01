package board;

/**
 * Created by lora on 25.05.17.
 *
 */
public class Cell implements Resetable{

    private Symbol symbol;

    static Cell with(Symbol symbol) {
        return new Cell(symbol);
    }

    static Cell thatIsNotSet() {
        return new Cell();
    }

    private Cell() { this(Symbol.notSet); }

    Cell(Symbol symbol) {
        this.symbol = symbol;
    }

    @Override
    public int hashCode() {
        return symbol.hashCode();
    }

    @Override
    public boolean equals(Object object) {
        boolean isEqual = false;
        if (object instanceof Cell) {
            isEqual = hashCode() == object.hashCode();
        }
        return isEqual;
    }

    @Override
    public void reset() {
        symbol = Symbol.notSet;
    }

    @Override
    public String toString() {
        return symbol.toString();
    }

    Symbol symbol(Symbol symbol) {
        Symbol previous = this.symbol;
        this.symbol = symbol;
        return previous;
    }

    Symbol symbol() {
        return symbol;
    }
}