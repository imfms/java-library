package cn.f_ms.library.logic;

/**
 * Desc: is it right?
 *
 * @author f_ms
 * @date 18-3-8
 */

public final class IsRight {

    private final boolean isRight;
    private final String errorMessage;

    /**
     * get a right value
     */
    public IsRight() {
        isRight = true;
        errorMessage = null;
    }

    /**
     * get a error value with error message
     * @param errorMessage error message
     */
    public IsRight(String errorMessage) {
        isRight = false;
        this.errorMessage = errorMessage;
    }

    /**
     * is a right value?
     * @return true == right, false == error
     */
    public boolean isRight() {
        return isRight;
    }

    /**
     * get error message if error
     * @return error message
     */
    public String errorMessage() {
        return errorMessage;
    }

    /**
     * get a right value
     * @return right value
     */
    public static IsRight yes() {
        return new IsRight();
    }

    /**
     * get a error value with errorMessage
     * @param errorMessage error message
     * @return error value
     */
    public static IsRight no(String errorMessage) {
        return new IsRight(errorMessage);
    }

}
