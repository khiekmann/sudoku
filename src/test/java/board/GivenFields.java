package board;

import org.junit.Before;
import org.junit.Test;

import static board.Symbol.*;
import static de.fnordbedarf.debugger.Debugger.expect;

/**
 * Created by lora on 25.05.17.
 *
 */
public class GivenFields{

    private static final String n = System.getProperty("line.separator");
    private static final int nine = 9;
    private static final String notSetString =
            "_ _ _  _ _ _  _ _ _ " + n +
            "_ _ _  _ _ _  _ _ _ " + n +
            "_ _ _  _ _ _  _ _ _ " + n +
                    n +
            "_ _ _  _ _ _  _ _ _ " + n +
            "_ _ _  _ _ _  _ _ _ " + n +
            "_ _ _  _ _ _  _ _ _ " + n +
                    n +
            "_ _ _  _ _ _  _ _ _ " + n +
            "_ _ _  _ _ _  _ _ _ " + n +
            "_ _ _  _ _ _  _ _ _ " + n;

    private static final String numberedFieldsString =
            "0 1 2  3 4 5  6 7 8 " + n +
            "1 2 3  4 5 6  7 8 0 " + n +
            "2 3 4  5 6 7  8 0 1 " + n +
                    n +
            "3 4 5  6 7 8  0 1 2 " + n +
            "4 5 6  7 8 0  1 2 3 " + n +
            "5 6 7  8 0 1  2 3 4 " + n +
                    n +
            "6 7 8  0 1 2  3 4 5 " + n +
            "7 8 0  1 2 3  4 5 6 " + n +
            "8 0 1  2 3 4  5 6 7 " + n;

    private Fields newFields;
    private Fields numberedFields;

    @Before
    public void before() {
        newFields = Build.ing().withSymbols(notSetString).fields();
        numberedFields = Build.ing().withSymbols(numberedFieldsString).fields();
    }

    @Test
    public void expect_newFields_to_not_be_null() {
        expect(newFields).toNotBeNull().otherwiseComplain();
    }

    @Test
    public void expect_newField_length_to_be_equal_to_nine() {
        expect(newFields.length()).toBeEqualTo(nine).otherwiseComplain();
    }

    @Test
    public void expect_numberedField_length_to_be_equal_to_nine() {
        expect(numberedFields.length()).toBeEqualTo(nine).otherwiseComplain();
    }
    
    @Test
    public void expect_numberedField_get0_to_be_equal_to_zero() {
        expect(numberedFields.getSymbolAt(0))
                .toBeEqualTo(Symbol.zero)
                .otherwiseComplain();
    }

    @Test
    public void expect_numberedField_get1_to_be_equal_to_one() {
        expect(numberedFields.getSymbolAt(1))
                .toBeEqualTo(one)
                .otherwiseComplain();
    }

    @Test
    public void expect_numberedField_get2_to_be_equal_to_two() {
        expect(numberedFields.getSymbolAt(2))
                .toBeEqualTo(two)
                .otherwiseComplain();
    }

    @Test
    public void expect_numberedField_get3_to_be_equal_to_three() {
        expect(numberedFields.getSymbolAt(3))
                .toBeEqualTo(three)
                .otherwiseComplain();
    }

    @Test
    public void expect_numberedField_get4_to_be_equal_to_four() {
        expect(numberedFields.getSymbolAt(4))
                .toBeEqualTo(four)
                .otherwiseComplain();
    }

    @Test
    public void expect_numberedField_get9_to_be_equal_to_eight() {
        expect(numberedFields.getSymbolAt(10))
                .toBeEqualTo(two)
                .otherwiseComplain();
    }

    @Test
    public void expect_numberedField_get80_to_be_equal_to_two() {
        expect(numberedFields.getSymbolAt(80))
                .toBeEqualTo(seven)
                .otherwiseComplain();
    }

    @Test
    public void expect_numberedField_get80_to_be_equal_to_eight() {
        expect(numberedFields.getSymbolAt(72))
                .toBeEqualTo(eight)
                .otherwiseComplain();
    }
}