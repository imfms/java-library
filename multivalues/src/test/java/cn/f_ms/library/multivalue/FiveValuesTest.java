package cn.f_ms.library.multivalue;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * FiveValuesTest
 *
 * @author f_ms
 * @date 17-11-20
 */
public class FiveValuesTest {

    @Test
    public void test() {

        String valueA = "value_a";
        StringBuffer valueB = new StringBuffer("value_b");
        StringBuilder valueC = new StringBuilder("value_c");
        String[] valueD = {"value_d"};
        Integer valueE = 3;

        FiveValues<String, StringBuffer, StringBuilder, String[], Integer> values = new FiveValues<>(valueA, valueB, valueC, valueD, valueE);

        assertThat(valueA, is(values.first()));
        assertThat(valueB, is(values.second()));
        assertThat(valueC, is(values.third()));
        assertThat(valueD, is(values.fourth()));
        assertThat(valueE, is(values.fifth()));
    }

}