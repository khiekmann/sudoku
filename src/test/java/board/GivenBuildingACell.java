package board;

import org.junit.Test;

import static de.fnordbedarf.debugger.Debugger.expect;

/**
 * Created by lora on 28.05.17.
 *
 */
public class GivenBuildingACell {

    @Test
    public void expect_building_aCell_to_be_equal_to_cell_thatIsNotSet() {
        expect(Build.ing().aCell())
                .toBeEqualTo(Cell.thatIsNotSet())
                .otherwiseComplain();
    }

    @Test
    public void expect_building_aCell_withSymbol_eight_to_be_equal_to_cell_with_symbol_eight() {
        expect(Build.ing().withSymbol('8').aCell())
                .toBeEqualTo(new Cell(Symbol.eight))
                .otherwiseComplain();
    }
}
