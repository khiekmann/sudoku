package board;

import org.junit.Test;

import static de.fnordbedarf.debugger.Debugger.expect;

/**
 * Created by lora on 28.05.17.
 *
 */
public class GivenSymbol {

    @Test
    public void expect_symbol_valueOf_eight_to_be_equal_to_symbolEight() {
        expect(Symbol.from("8"))
                .toBeEqualTo(Symbol.eight)
                .otherwiseComplain();
    }

    @Test
    public void expect_string_eight_to_be_equal_to_symbolEight() {
        expect(Symbol.from("8"))
                .toBeEqualTo(Symbol.eight)
                .otherwiseComplain();
    }
}
