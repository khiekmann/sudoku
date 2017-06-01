package board;

import java.util.Arrays;

/**
 * Created by lora on 28.05.17.
 *
 */
class Build {

    private static final String n = System.getProperty("line.separator");

    private Symbol symbol = Symbol.notSet;
    private String stringOfSymbols;
    private Cell[] arrayOfCells;
    private Field[] arrayOfFields;
    private int amountOfFields;

    static Build ing() {
        return new Build();
    }

    private void symbol(Symbol symbol) {
        this.symbol = symbol;
    }

    private void symbolAt(int index) {
        char symbolChar = stringOfSymbols.charAt(index);
        symbol(Symbol.from(symbolChar));
    }

    Build withSymbol(char symbolAsChar) {
        symbol(Symbol.from(symbolAsChar));
        return this;
    }

    Build withSymbols(String symbolsAsString) {
        stringOfSymbols = sanitizing(symbolsAsString);
        return this;
    }

    private String sanitizing(String dirtyString) {
        return dirtyString
                .replaceAll(" ", "")
                .replaceAll(n, "")
                .trim();
    }

    private void createArrayOfCells() {
        initializeArrayOfCells();
        populateArrayOfCells();
    }

    private void initializeArrayOfCells() {
        arrayOfCells = new Cell[stringOfSymbols.length()];
    }

    private void populateArrayOfCells() {
        for (int index = 0; index < stringOfSymbols.length(); index++) {
            symbolAt(index);
            arrayOfCells[index] = aCell();
        }
    }

    private void createArrayOfFields() {
        initializeArrayOfFields();
        populateArrayOfFields();
    }

    private void initializeArrayOfFields() {
        calcAmountOfFields();
        arrayOfFields = new Field[amountOfFields];
    }

    private void calcAmountOfFields() {
        amountOfFields = squareRootOf(stringOfSymbols.length());
    }

    private int squareRootOf(int number) {
        return (int) Math.sqrt(number);
    }

    private void populateArrayOfFields() { // TODO: clean code
        String localStringOfSymbols = stringOfSymbols;
        for (int index = 0; index < amountOfFields; index++) {
            int beginIndex = index * amountOfFields;
            int endIndex = index * amountOfFields + amountOfFields;
            stringOfSymbols = localStringOfSymbols.substring(beginIndex, endIndex);
            createArrayOfCells();
            Field field = aField();
            arrayOfFields[index] = field;
        }
    }

    Cell aCell() {
        Cell cell = Cell.thatIsNotSet();
        cell.symbol(symbol);
        return cell;
    }

    Cells cells() {
        createArrayOfCells();
        return new Cells(arrayOfCells);
    }

    Field aField() {
        return new Field(cells());
    }

    Fields fields() {
        createArrayOfFields();
        return new Fields(arrayOfFields);
    }

    Board aBoard() {
        return new Board(fields());
    }
}