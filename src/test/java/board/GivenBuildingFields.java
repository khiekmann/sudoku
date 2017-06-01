package board;

import org.junit.Before;
import org.junit.Test;

import static de.fnordbedarf.debugger.Debugger.expect;

/**
 * Created by lora on 28.05.17.
 *
 */
public class GivenBuildingFields {

    private static final String n = System.getProperty("line.separator");
    private static final Number nine = 9;

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

    private Fields builtNotSetFields;
    private Fields builtNumberedFields;

    private String sanitizing(Object stringObject) {
        return stringObject.toString()
                .replace(n, "")
                .replace(" ", "");
    }

    @Before
    public void before() {
        builtNotSetFields = Build.ing()
                .withSymbols(notSetString)
                .fields();
        builtNumberedFields = Build.ing()
                .withSymbols(numberedFieldsString)
                .fields();
    }

    @Test
    public void expect_builtNotSetFields_to_be_not_null() {
        expect(builtNotSetFields)
                .toBeNotNull()
                .otherwiseComplain();
    }

    @Test
    public void expect_builtNotSetFields_to_be_equal_to_notSetString() {
        expect(sanitizing(builtNotSetFields))
                .toBeEqualTo(sanitizing(notSetString))
                .otherwiseComplain();
    }

    @Test
    public void expect_builtNumberedFields_to_be_equal_to_numberedFields() {
        expect(sanitizing(builtNumberedFields))
                .toBeEqualTo(sanitizing(numberedFieldsString))
                .otherwiseComplain();
    }

    @Test
    public void expect_newField_length_then_to_be_equal_to_nine() {
        expect(builtNotSetFields.length()).toBeEqualTo(nine).otherwiseComplain();
    }

    @Test
    public void expect_numberedField_length_then_to_be_equal_to_nine() {
        expect(builtNumberedFields.length()).toBeEqualTo(nine).otherwiseComplain();
    }

    @Test
    public void expect_numberedFields_toString_to_be_equal_to_numberedFieldsString() {
        expect(builtNumberedFields.toString())
                .toBeEqualTo(sanitizing(numberedFieldsString))
                .otherwiseComplain();
    }
}