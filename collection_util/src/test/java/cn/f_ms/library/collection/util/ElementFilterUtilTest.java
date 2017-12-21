package cn.f_ms.library.collection.util;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

/**
 * ElementFilterUtilTest
 *
 * @author f_ms
 * @date 17-12-21
 */
public class ElementFilterUtilTest {

    List<String> testDatas;

    @Before
    public void doBefore() {
        testDatas = new ArrayList<>();

        for (int i = 0; i < 10; i++) {

            for (int j = 0; j < i; j++) {

                testDatas.add(String.valueOf(j));
            }
        }
    }

    @Test
    public void isExist() throws Exception {

        /*
        Argument Check Test
         */
        try {
            ElementFilterUtil.isExist(null, new ElementFilterUtil.Filter<Object>() {
                @Override
                public boolean isAccept(Object o) {
                    return false;
                }
            });

            fail();
        } catch (IllegalArgumentException e) {
            // throw exception is right
        }

        try {
            ElementFilterUtil.isExist(testDatas, null);

            fail();
        } catch (IllegalArgumentException e) {
            // throw exception is right
        }

        /*
        feature test
         */
        boolean isExist7 = ElementFilterUtil.isExist(testDatas, new ElementFilterUtil.Filter<String>() {
            @Override
            public boolean isAccept(String s) {
                return "7".equals(s);
            }
        });
        assertThat(isExist7, is(true));

        boolean isExist11 = ElementFilterUtil.isExist(testDatas, new ElementFilterUtil.Filter<String>() {
            @Override
            public boolean isAccept(String s) {
                return "11".equals(s);
            }
        });
        assertThat(isExist11, is(false));
    }

    @Test
    public void filterFirst() throws Exception {
    }

    @Test
    public void filterFirst1() throws Exception {
    }

    @Test
    public void filter() throws Exception {
    }

    @Test
    public void filter1() throws Exception {
    }

    @Test
    public void filter2() throws Exception {
    }

    @Test
    public void filter3() throws Exception {
    }

    @Test
    public void convert() throws Exception {
    }

    @Test
    public void convert1() throws Exception {
    }

    @Test
    public void convert2() throws Exception {
    }

    @Test
    public void convert3() throws Exception {
    }

    @Test
    public void convert4() throws Exception {
    }

    @Test
    public void convert5() throws Exception {
    }

    @Test
    public void filter4() throws Exception {
    }

    @Test
    public void filter5() throws Exception {
    }

    @Test
    public void filter6() throws Exception {
    }

    @Test
    public void filter7() throws Exception {
    }

    @Test
    public void filter8() throws Exception {
    }

    @Test
    public void filter9() throws Exception {
    }

    @Test
    public void filter10() throws Exception {
    }

    @Test
    public void filter11() throws Exception {
    }

}