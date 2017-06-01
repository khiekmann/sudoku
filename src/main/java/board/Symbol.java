package board;

/**
 * Created by lora on 25.05.17.
 *
 */
public enum Symbol {

    notSet("_"),
    zero("0"),
    one("1"),
    two("2"),
    three("3"),
    four("4"),
    five("5"),
    six("6"),
    seven("7"),
    eight("8");

    private final String mark;

    Symbol(String mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return mark;
    }

    public static Symbol from(String symbolAsString) {
        Symbol symbol = Symbol.notSet;
        for (Symbol aSymbol : values()) {
            if (symbolAsString.equals(aSymbol.mark)) {
                symbol = aSymbol;
                break;
            }
        }
        return symbol;
    }

    public static Symbol from(char symbolChar) {
        String symbolAsString = String.valueOf(symbolChar);
        return Symbol.from(symbolAsString);
    }
}