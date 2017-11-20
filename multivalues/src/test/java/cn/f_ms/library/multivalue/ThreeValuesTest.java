package cn.f_ms.library.multivalue;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * ThreeValuesTest
 *
 * @author f_ms
 * @date 17-11-20
 */
public class ThreeValuesTest {

    @Test
    public void test() {

        String valueA = "value_a";
        StringBuffer valueB = new StringBuffer("value_b");
        StringBuilder valueC = new StringBuilder("value_c");

        ThreeValues<String, StringBuffer, StringBuilder> values = new ThreeValues<>(valueA, valueB, valueC);

        assertThat(valueA, is(values.first()));
        assertThat(valueB, is(values.second()));
        assertThat(valueC, is(values.third()));
    }

}