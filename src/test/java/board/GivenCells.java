package board;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static board.Symbol.*;
import static de.fnordbedarf.debugger.Debugger.expect;

/**
 * Created by lora on 25.05.17.
 *
 */
public class GivenCells {

    private static final String newCellsString = "_________";
    private static final String numberedCellsString = "012345678";

    private Cells newCells;
    private Cells numberedCells;

    @Before
    public void before() {
        newCells = new Cells(new Cell[]{
                Cell.thatIsNotSet(), Cell.thatIsNotSet(), Cell.thatIsNotSet(),
                Cell.thatIsNotSet(), Cell.thatIsNotSet(), Cell.thatIsNotSet(),
                Cell.thatIsNotSet(), Cell.thatIsNotSet(), Cell.thatIsNotSet()});
        numberedCells = new Cells(new Cell[]{
                new Cell(zero),  new Cell(one),   new Cell(two),
                new Cell(three), new Cell(four),  new Cell(five),
                new Cell(six),   new Cell(seven), new Cell(eight)});
    }

    @Test
    public void expect_newCells_to_not_be_null() {
        expect(newCells)
                .toNotBeNull()
                .otherwiseComplain();
    }

    @Test
    public void expect_numberedCells_to_not_be_null() {
        expect(numberedCells)
                .toNotBeNull()
                .otherwiseComplain();
    }

    @Test
    public void expect_cells_length_to_be_equal_to_amountOfCells_length() {
        Cell[] amountOfCells = new Cell[]{
                Cell.thatIsNotSet(),
                Cell.thatIsNotSet()
        };
        expect(new Cells(amountOfCells).length())
                .toBeEqualTo(amountOfCells.length)
                .otherwiseComplain();
    }

    @Test
    public void expect_newCells_toString_to_be_equal_to_newCellsString() {
        expect(newCells.toString())
                .toBeEqualTo(newCellsString)
                .otherwiseComplain();
    }

    @Test
    public void expect_numberedCells_toString_to_be_equal_to_numberedCellsString() {
        expect(numberedCells.toString())
                .toBeEqualTo(numberedCellsString)
                .otherwiseComplain();
    }

    @Test
    public void expect_newCell_set_firstToEight_to_be_equal_to_8________() {
        newCells.set(0, eight);
        expect(newCells.toString())
                .toBeEqualTo("8________")
                .otherwiseComplain();
    }

    @Test
    public void expect_numberedCell_reset_to_be_equal_to_newCell() {
        numberedCells.reset();
        expect(numberedCells)
                .toBeEqualTo(newCells)
                .otherwiseComplain();
    }
}