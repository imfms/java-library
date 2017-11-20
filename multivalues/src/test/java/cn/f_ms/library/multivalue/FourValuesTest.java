package cn.f_ms.library.multivalue;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * FourValuesTest
 *
 * @author f_ms
 * @date 17-11-20
 */
public class FourValuesTest {

    @Test
    public void test() {

        String valueA = "value_a";
        StringBuffer valueB = new StringBuffer("value_b");
        StringBuilder valueC = new StringBuilder("value_c");
        String[] valueD = {"value_d"};

        FourValues<String, StringBuffer, StringBuilder, String[]> values = new FourValues<>(valueA, valueB, valueC, valueD);

        assertThat(valueA, is(values.first()));
        assertThat(valueB, is(values.second()));
        assertThat(valueC, is(values.third()));
        assertThat(valueD, is(values.fourth()));
    }

}