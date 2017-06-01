package board;

import org.junit.Before;
import org.junit.Test;

import static board.Symbol.eight;
import static board.Symbol.notSet;
import static de.fnordbedarf.debugger.Debugger.expect;

/**
 * Created by lora on 28.05.17.
 *
 */
public class GivenBuildingABoard {

    private static final String n = System.getProperty("line.separator");
    private static final String notSetString =
            "_ _ _  _ _ _  _ _ _" + n +
            "_ _ _  _ _ _  _ _ _" + n +
            "_ _ _  _ _ _  _ _ _" + n +
            n +
            "_ _ _  _ _ _  _ _ _" + n +
            "_ _ _  _ _ _  _ _ _" + n +
            "_ _ _  _ _ _  _ _ _" + n +
            n +
            "_ _ _  _ _ _  _ _ _" + n +
            "_ _ _  _ _ _  _ _ _" + n +
            "_ _ _  _ _ _  _ _ _" + n;

    private static final String numberedFieldsString =
            "0 1 2  3 4 5  6 7 8 " + n +
            "1 2 3  4 5 6  7 8 0 " + n +
            "2 3 4  5 6 7  8 0 1" + n +
            n +
            "3 4 5  6 7 8  0 1 2 " + n +
            "4 5 6  7 8 0  1 2 3 " + n +
            "5 6 7  8 0 1  2 3 4 " + n +
            n +
            "6 7 8  0 1 2  3 4 5 " + n +
            "7 8 0  1 2 3  4 5 6 " + n +
            "8 0 1  2 3 4  5 6 7 " + n;

    private Board boardThatIsNotSet;
    private Board numberedBoard;

    @Before
    public void before() {
        boardThatIsNotSet = Build.ing()
                .withSymbols(notSetString)
                .aBoard();
        numberedBoard = Build.ing()
                .withSymbols(numberedFieldsString)
                .aBoard();
    }

    private String sanitizing(Object stringObject) {
        return stringObject.toString()
                .replace(n, "")
                .replace(" ", "");
    }

    @Test
    public void expect_building_withSymbols_notSetString_to_be_not_null() {
        expect(Build.ing()
                .withSymbols(notSetString)
                .aBoard())
                .toBeNotNull();
    }

    @Test
    public void expect_boardThatIsNotSet_to_be_not_null() {
        expect(boardThatIsNotSet)
                .toBeNotNull();
    }

    @Test
    public void expect_numberedBoard_to_be_not_null() {
        expect(numberedBoard)
                .toBeNotNull();
    }

    @Test
    public void expect_boardThatIsNotSet_toString_to_be_equal_to_notSetString() {
        expect(sanitizing(boardThatIsNotSet))
                .toBeEqualTo(sanitizing(notSetString))
                .otherwiseComplain();
    }

    @Test
    public void expect_numberedBoard_toString_to_be_equal_to_numberedFieldsString() {
        expect(sanitizing(numberedBoard))
                .toBeEqualTo(sanitizing(numberedFieldsString))
                .otherwiseComplain();
    }

    @Test
    public void expect_building_withSymbols_notSetString_to_be_equal_to_boardThatIsNotSet() {
        expect(Build.ing()
                .withSymbols(notSetString)
                .aBoard())
                .toBeEqualTo(boardThatIsNotSet)
                .otherwiseComplain();
    }

    @Test
    public void expect_building_withSymbols_numberedFieldsString_to_be_equal_to_numberedBoard() {
        expect(Build.ing()
                .withSymbols(numberedFieldsString)
                .aBoard())
                .toBeEqualTo(numberedBoard)
                .otherwiseComplain();
    }
}