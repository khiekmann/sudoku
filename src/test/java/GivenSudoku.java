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
    private static final String newFieldToString =
            " _ _ _ " + n +
            " _ _ _ " + n +
            " _ _ _ " + n;

    @Test
    public void expectBoardToHaveNineFields() {
        expect(new Board().getFields().size()).toBeEqualTo(nine).otherwiseComplain();
    }

    @Test
    public void expectFieldToHaveNineCells() {
        expect(new Field().getCells().size()).toBeEqualTo(nine).otherwiseComplain();
    }

    @Test
    public void expectFieldToStringToBeEqualToNewFieldToString() {
        expect(new Field().toString()).toBeEqualTo(newFieldToString);
    }
}
