package board;

import javax.annotation.PostConstruct;

/**
 * Created by lora on 25.05.17.
 */
public class Cell {

    private final CellValue value;

    static Cell withoutValue() {
        return new Cell();
    }

    Cell() {
        this.value = CellValue.notSet;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
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
    public String toString() {
        return value.toString();
    }
}
