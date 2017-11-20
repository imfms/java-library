package cn.f_ms.library.check;

/**
 * Check object null utils
 *
 * @author imf_m
 * @date 2017/7/16
 */
public class CheckNull {

    /**
     * if specify obj is null, throw NullPointerException("value can't be null")
     *
     * @param obj obj
     * @param <T> obj type
     * @return input obj
     */
    public static <T> T ifNullThrowNpe(T obj) {
        return ifNullThrowNpe(obj, "value can't be null");
    }

    /**
     * if specify obj is null, throw NullPointerException() with input errorMessage
     *
     * @param obj          obj
     * @param errorMessage throw NullPointerException's errorMessage
     * @param <T>          obj type
     * @return input obj
     */
    public static <T> T ifNullThrowNpe(T obj, String errorMessage) {
        return ifNullThrowException(obj, new NullPointerException(errorMessage));
    }

    /**
     * if specify obj is null, throw IllegalArgumentException("value can't be null")
     *
     * @param obj obj
     * @param <T> obj type
     * @return input obj
     */
    public static <T> T ifNullThrowArgException(T obj) {
        return ifNullThrowArgException(obj, "value can't be null");
    }

    /**
     * if specify obj is null, throw IllegalArgumentException() with input errorMessage
     *
     * @param obj          obj
     * @param errorMessage throw IllegalArgumentException's errorMessage
     * @param <T>          obj type
     * @return input obj
     */
    public static <T> T ifNullThrowArgException(T obj, String errorMessage) {
        return ifNullThrowException(obj, new IllegalArgumentException(errorMessage));
    }

    /**
     * if specify obj is null, throw specify runtimeException
     *
     * @param obj              obj
     * @param runtimeException runtimeException,
     *                         if this arg is null, will throw IllegalArgumentException("runtimeException can't be null")
     * @param <T>              obj type
     * @return input obj
     */
    public static <T> T ifNullThrowException(T obj, RuntimeException runtimeException) {
        if (runtimeException == null) {
            throw new IllegalArgumentException("runtimeException can't be null");
        }

        if (obj == null) {
            throw runtimeException;
        }

        return obj;
    }
}
