package board;

import org.junit.Test;

import static de.fnordbedarf.debugger.Debugger.expect;
import static org.junit.Assert.assertEquals;

/**
 * Created by lora on 25.05.17.
 */
public class GivenCell {
    @Test
    public void whenNewCellThenNotNull() {
        expect(new Cell()).toBeNotNull().otherwiseComplain();
    }

    @Test
    public void whenNewCellThenToBeEqualToWithoutValue() {
        Cell cellWithoutValue = Cell.withoutValue();
        expect(new Cell()).toBeEqualTo(cellWithoutValue).otherwiseComplain();
    }

    @Test
    public void whenNewCellToStringThenToBeEqualToCellValueNotSet() {
        String newCellToString = new Cell().toString();
        String cellValueNotSet = CellValue.notSet.toString();
        expect(newCellToString).toBeEqualTo(cellValueNotSet).otherwiseComplain();
    }
}
