package board;

import org.junit.Before;
import org.junit.Test;

import static de.fnordbedarf.debugger.Debugger.expect;
import static board.Symbol.*;


/**
 * Created by lora on 25.05.17.
 *
 */
public class GivenCell {

    private Cell newCell;
    private static final Cell cellWithValueOne = new Cell(one);

    @Before
    public void before() {
        newCell = Cell.thatIsNotSet();
    }

    @Test
    public void expect_newCell_to_be_not_null() {
        expect(newCell)
                .toBeNotNull()
                .otherwiseComplain();
    }

    @Test
    public void expect_newCell_to_be_equal_to_cell_thatIsNotSet() {
        expect(newCell)
                .toBeEqualTo(Cell.thatIsNotSet())
                .otherwiseComplain();
    }

    @Test
    public void expect_newCell_value_to_be_equal_to_cellValue_notSet() {
        expect(newCell.symbol())
                .toBeEqualTo(Symbol.notSet)
                .otherwiseComplain();
    }

    @Test
    public void expect_newCell_toString_to_be_equal_to_cellValueNotSet_toString() {
        expect(newCell.toString())
                .toBeEqualTo(Symbol.notSet.toString())
                .otherwiseComplain();
    }

    @Test
    public void expect_newCell_symbol_to_be_equal_to_notSet() {
        expect(newCell.symbol())
                .toBeEqualTo(Symbol.notSet)
                .otherwiseComplain();
    }

    @Test
    public void expect_newCellOne_value_to_be_equal_to_cellValue_One() {
        expect(new Cell(one).symbol())
                .toBeEqualTo(one)
                .otherwiseComplain();
    }

    @Test
    public void expect_newCellOne_to_be_equal_to_cellOne() {
        expect(new Cell(one))
                .toBeEqualTo(cellWithValueOne)
                .otherwiseComplain();
    }

    @Test
    public void expect_newCell_setSymbol_return_previous_value() {
        Symbol firstChange = newCell.symbol(eight);

        expect(firstChange)
                .toBeEqualTo(notSet)
                .otherwiseComplain();

        expect(newCell.symbol())
                .toBeEqualTo(eight)
                .otherwiseComplain();
    }

    @Test
    public void expect_cellWithValueOne_reset_to_be_equal_to_newCell() {
        cellWithValueOne.reset();
        expect(cellWithValueOne)
                .toBeEqualTo(newCell)
                .otherwiseComplain();
    }
}