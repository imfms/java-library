package cn.f_ms.library.logic;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Desc: $
 *
 * @author f_ms
 * @time 18-3-8
 */
public class IsRightTest {

    @Test
    public void conRight() {
        assertThat(new IsRight().isRight(), is(true));
    }

    @Test
    public void conError() {
        IsRight isRight = new IsRight("test reason");

        assertThat(isRight.isRight(), is(false));
        assertThat(isRight.errorMessage(), equalTo("test reason"));
    }

    @Test
    public void isRight() throws Exception {
        assertThat(new IsRight().isRight(), is(true));
    }

    @Test
    public void errorMessage() throws Exception {
        assertThat(new IsRight("test reason").errorMessage(), equalTo("test reason"));
    }

    @Test
    public void yes() throws Exception {
        assertThat(IsRight.yes().isRight(), is(true));
    }

    @Test
    public void no() throws Exception {
        IsRight isRight = IsRight.no("test reason");

        assertThat(isRight.isRight(), is(false));
        assertThat(isRight.errorMessage(), equalTo("test reason"));
    }

}