package board;

import org.junit.Before;
import org.junit.Test;

import static board.Symbol.*;
import static de.fnordbedarf.debugger.Debugger.expect;

/**
 * Created by lora on 28.05.17.
 *
 */
public class GivenBuildingCells {

    private static final String symbolsAsString = "012345678";
    private static final Cells numberedCells = new Cells(new Cell[]{
            new Cell(zero),  new Cell(one),   new Cell(two),
            new Cell(three), new Cell(four),  new Cell(five),
            new Cell(six),   new Cell(seven), new Cell(eight)});

    private Cells builtCells;

    @Before
    public void before() {
        builtCells = Build.ing()
                .withSymbols(symbolsAsString)
                .cells();
    }

    @Test
    public void expect_builtCells_toString_to_be_equal_to_symbolsAsString() {
        expect(builtCells.toString())
                .toBeEqualTo(symbolsAsString)
                .otherwiseComplain();
    }

    @Test
    public void expect_builtCells_to_be_equal_to_numberedCells() {
        expect(builtCells)
                .toBeEqualTo(numberedCells)
                .otherwiseComplain();
    }
}