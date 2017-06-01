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
public class GivenBuildingAField {

    private static final String n = System.getProperty("line.separator");

    private Field fieldThatIsNotSet;

    @Before
    public void before() {
        Cells cells = new Cells(new Cell[] {
                new Cell(notSet), new Cell(notSet), new Cell(notSet),
                new Cell(notSet), new Cell(notSet), new Cell(notSet),
                new Cell(notSet), new Cell(notSet), new Cell(notSet)});
        fieldThatIsNotSet = new Field(cells);
    }

    @Test
    public void expect_building_aField_to_be_not_null() {
        expect(Build.ing()
                .withSymbols("_________")
                .aField())
                .toBeNotNull();
    }

    @Test
    public void expect_building_aField_to_be_equal_to_fieldThatIsNotSet() {
        expect(Build.ing()
                .withSymbols("_________")
                .aField())
                .toBeEqualTo(fieldThatIsNotSet)
                .otherwiseComplain();
    }

    @Test
    public void expect_building_aField_withLineSeparators_to_be_equal_to_fieldThatIsNotset() {
        expect(Build.ing()
                .withSymbols(
                        n + "___" +
                        n + "___" +
                        n + "___")
                .aField())
                .toBeEqualTo(fieldThatIsNotSet)
                .otherwiseComplain();
    }

    @Test
    public void expect_newField_set_FirstRowFirstColumn_to_eight_to_be_equal_to_eight() {
        Field newField =
                Build.ing()
                        .withSymbols("_________")
                        .aField();
        newField.set(0,0, eight);
        expect(newField.getSymbolAt(0, 0))
                .toBeEqualTo(eight)
                .otherwiseComplain();
    }
}