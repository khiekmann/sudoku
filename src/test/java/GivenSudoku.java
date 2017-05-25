import board.Board;
import board.Field;
import org.junit.Test;

import static de.fnordbedarf.debugger.Debugger.expect;

/**
 * Created by lora on 25.05.17.
 *
 */
public class GivenSudoku {

    private static final String n = System.getProperty("line.separator");
    private static final int nine = 9;
    private static final int eachSideIsThree = 3;

    @Test
    public void expectBoardToHaveNineFields() {
        expect(new Board().getFields().size()).toBeEqualTo(nine).otherwiseComplain();
    }

    @Test
    public void expectFieldToHaveNineCells() {
        expect(new Field(eachSideIsThree).length()).toBeEqualTo(nine).otherwiseComplain();
    }
}