package board;

import org.junit.Before;
import org.junit.Test;

import static de.fnordbedarf.debugger.Debugger.expect;

/**
 * Created by lora on 25.05.17.
 */
public class GivenCells {

    private static final String n = System.getProperty("line.separator");
    private static final int nine = 9;
    private static final String newCellsToString = "_________";
    private Cells newCells;
    private int sizeOfEachSide = 3;

    @Before
    public void before() {
        newCells = new Cells(sizeOfEachSide);
    }

    @Test
    public void whenNewCellsThenToNotBeNull() {
        expect(newCells).toNotBeNull().otherwiseComplain();
    }

    @Test
    public void whenNewCellsLengthThenToBeEqualToNine() {
        expect(newCells.length()).toBeEqualTo(nine).otherwiseComplain();
    }

    @Test
    public void whenNewCellsToStringThenToBeEqualToNewCellsToString() {
        expect(newCells.toString()).toBeEqualTo(newCellsToString).otherwiseComplain();
    }
}