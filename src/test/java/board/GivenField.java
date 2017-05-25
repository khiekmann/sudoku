package board;

import org.junit.Before;
import org.junit.Test;

import static de.fnordbedarf.debugger.Debugger.expect;

/**
 * Created by lora on 25.05.17.
 */
public class GivenField {
    private String n = System.getProperty("line.separator");
    private final String newFieldToString =
            n + "___" +
            n + "___" +
            n + "___";


    private int nine = 9;
    private int sizeOfEachSide = 3;
    private Field newField;

    @Before
    public void before() {
        newField = new Field(sizeOfEachSide);
    }

    @Test
    public void whenNewFieldThenToBeNotNull() {
        expect(newField).toBeNotNull().otherwiseComplain();
    }

    @Test
    public void whenNewFieldWithSizeThreeThenLengthEqualToNine() {
        expect(newField.length()).toBeEqualTo(nine).otherwiseComplain();
    }

    @Test
    public void whenNewFieldToStringThenToBeEqualToNewFieldToString() {
        expect(newField.toString()).toBeEqualTo(newFieldToString).otherwiseComplain();
    }
}
