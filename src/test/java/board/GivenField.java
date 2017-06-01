package board;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static board.Symbol.*;
import static de.fnordbedarf.debugger.Debugger.expect;
import static de.fnordbedarf.debugger.Debugger.show;

/**
 * Created by lora on 25.05.17.
 *
 */
public class GivenField {
    private final static String n = System.getProperty("line.separator");
    private final static String newFieldString =
            n + "___" + n + "___" + n + "___";
    private final static String numberedFieldString =
            n + "012" + n + "345" + n + "678";
    private Symbol[] numberedValues;
    private Field numberedField;
    private Field newField;
    private Cells notSetCells = new Cells(new Cell[]{
            new Cell(notSet), new Cell(notSet), new Cell(notSet),
            new Cell(notSet), new Cell(notSet), new Cell(notSet),
            new Cell(notSet), new Cell(notSet), new Cell(notSet)});
    private Cells numberedCells = new Cells(new Cell[]{
            new Cell(zero), new Cell(one), new Cell(two),
            new Cell(three), new Cell(four), new Cell(five),
            new Cell(six), new Cell(seven), new Cell(eight)});
    
    @Before
    public void before() {
        newField = new Field(notSetCells);
        numberedField = new Field(numberedCells);
    }

    @Test
    public void expect_newField_to_be_not_null() {
        expect(newField)
                .toBeNotNull()
                .otherwiseComplain();
    }

    @Test
    public void expect_cells_length_to_be_equal_to_amountOfCells_length() {
        Cells cells = new Cells(new Cell[]{
                Cell.thatIsNotSet(),
                Cell.thatIsNotSet(),
                Cell.thatIsNotSet()
        });
        expect(new Field(cells).length())
                .toBeEqualTo(cells.length())
                .otherwiseComplain();
    }

    @Test
    public void expect_newField_toString_to_be_equal_to_newFileString() {
        expect(newField.toString())
                .toBeEqualTo(newFieldString)
                .otherwiseComplain();
    }

    @Test
    public void expect_numberedField_toString_to_be_equal_to_numberedFieldString() {
        expect(numberedField.toString())
                .toBeEqualTo(numberedFieldString)
                .otherwiseComplain();
    }

    @Test
    public void expect_numberedField_set_firstCell_to_notSet_to_be_not_equal_to_numberedFieldString() {
        numberedField.set(0, notSet);
        expect(numberedField.toString())
                .toBeNotEqualTo(numberedFieldString)
                .otherwiseComplain();
    }

    @Test
    public void expect_numberedField_set_firstCell_to_notSet_to_be_equal_to_notSet() {
        numberedField.set(0, notSet);
        expect(numberedField.toString())
                .toBeNotEqualTo(numberedFieldString)
                .otherwiseComplain();
    }

    @Test
    public void expect_numberedField_set_cell0_to_notSet_to_be_not_equal_to_numberedFieldString() {
        numberedField.set(0, notSet);
        expect(numberedField.toString())
                .toBeNotEqualTo(numberedFieldString)
                .otherwiseComplain();
    }

    @Test
    public void expect_numberedField_get_zero_to_be_equal_to_zero() {
        expect(numberedField.getSymbolAt(0)).toBeEqualTo(zero);
    }

    @Test
    public void expect_newCell_setSymbol_then_return_previous_value() {
        Symbol firstChange = newField.set(0, Symbol.eight);

        expect(firstChange)
                .toBeEqualTo(Symbol.notSet)
                .otherwiseComplain();

        expect(newField.getSymbolAt(0))
                .toBeEqualTo(Symbol.eight)
                .otherwiseComplain();
    }

    @Test
    public void expect_newField_set_firstToEight_to_be_equal_to_8________() {
        newField.set(0, eight);
        expect(newField.toString())
                .toBeEqualTo(
                        n + "8__" +
                        n + "___" +
                        n + "___")
                .otherwiseComplain();
    }

    @Test
    public void expect_newField_set_firstRowFirstColumnToEight_to_be_equal_to_8________() {
        newField.set(0,0, eight);
        expect(newField.toString())
                .toBeEqualTo(
                        n + "8__" +
                        n + "___" +
                        n + "___")
                .otherwiseComplain();
    }

    @Test
    public void expect_newField_set_secondRowSecondColumnToEight_to_be_equal_to_8________() {
        newField.set(1,1, eight);
        expect(newField.toString())
                .toBeEqualTo(
                        n + "___" +
                        n + "_8_" +
                        n + "___")
                .otherwiseComplain();
    }

    @Test
    public void expect_newField_setNumbered_be_equal_to_numberedFieldString() {
        newField.set(0,0, zero);
        newField.set(0,1, one);
        newField.set(0,2, two);
        newField.set(1,0, three);
        newField.set(1,1, four);
        newField.set(1,2, five);
        newField.set(2,0, six);
        newField.set(2,1, seven);
        newField.set(2,2, eight);

        expect(newField.toString())
                .toBeEqualTo(
                        n + "012" +
                        n + "345" +
                        n + "678")
                .otherwiseComplain();
    }

    @Test
    public void expect_newField_getSymbolsInRow0_to_be_equal_to____() {
        expect(newField.getSymbolsInRow(0))
                .toHaveTheSameElementsAs(new Symbol[]{notSet, notSet, notSet})
                .otherwiseComplain();
    }

    @Test
    public void expect_newField_getSymbolsInRow_0_to_be_equal_to_notSetnotSetnotSet() {
        expect(newField.getSymbolsInRow(0))
                .toHaveTheSameElementsAs(new Symbol[]{notSet, notSet, notSet})
                .otherwiseComplain();
    }

    @Test
    public void expect_numberedField_getSymbolsInRow_0_to_be_equal_to_notSetnotSetnotSet() {
        expect(numberedField.getSymbolsInRow(0))
                .toHaveTheSameElementsAs(new Symbol[]{zero, one, two})
                .otherwiseComplain();
    }

    @Test
    public void expect_numberedField_getSymbolsInRow_1_to_be_equal_to_notSetnotSetnotSet() {
        expect(numberedField.getSymbolsInRow(1))
                .toHaveTheSameElementsAs(new Symbol[]{three, four, five})
                .otherwiseComplain();
    }

    @Test
    public void expect_numberedField_getSymbolsInRow_2_to_be_equal_to_notSetnotSetnotSet() {
        expect(numberedField.getSymbolsInRow(2))
                .toHaveTheSameElementsAs(new Symbol[]{six, seven, eight})
                .otherwiseComplain();
    }

    @Test
    public void expect_newField_length_to_be_equal_to_nine() {
        expect(newField.length())
                .toBeEqualTo(9)
                .otherwiseComplain();
    }

    @Test
    public void expect_newField_sizeOfRow_to_be_equal_to_three() {
        expect(newField.sizeOfRow())
                .toBeEqualTo(3)
                .otherwiseComplain();
    }

    @Test
    public void expect_newField_set_Index0_previous_symbol_to_be_equal_to_notSet() {
        Symbol previous = newField.set(0, eight);
        expect(previous)
                .toBeEqualTo(notSet)
                .otherwiseComplain();
    }

    @Test
    public void expect_newField_set_Index0_to_eight_to_be_equal_to_eight() {
        newField.set(0, eight);
        expect(newField.getSymbolAt(0, 0))
                .toBeEqualTo(eight)
                .otherwiseComplain();
    }

    @Test
    public void expect_newField_set_Row0Column0Eight_previous_symbol_to_be_equal_to_notSet() {
        Symbol previous = newField.set(0, 0, eight);
        expect(previous)
                .toBeEqualTo(notSet)
                .otherwiseComplain();
    }

    @Test
    public void expect_newField_set_Row0Column0Eight_to_be_equal_to_eight() {
        newField.set(0,0, eight);
        expect(newField.getSymbolAt(0, 0))
                .toBeEqualTo(eight)
                .otherwiseComplain();
    }
}