package cn.f_ms.check_library;

/**
 * Check Null
 *
 * @author imf_m
 * @time 2017/7/16
 */

public class CheckNull {

    public static <T> T[] ifArgsExistNullThrowException(RuntimeException exception, T... args) {
        args = ifNullThrowArg(args, "args can't be null");

        if (isExistNull(args)) {
            throw exception;
        }

        return args;
    }

    public static <T> T[] ifExistNullThrowException(T[] tArr, RuntimeException exception) {
        tArr = ifNullThrowArg(tArr, "iterable can't be null");
        exception = ifNullThrowArg(exception, "exception can't be null");

        if (isExistNull(tArr)) {
            throw exception;
        }
        return tArr;
    }

    public static <T> Iterable<T> ifExistNullThrowException(Iterable<T> iterable, RuntimeException exception) {
        iterable = ifNullThrowArg(iterable, "iterable can't be null");
        exception = ifNullThrowArg(exception, "exception can't be null");

        if (isExistNull(iterable)) {
            throw exception;
        }
        return iterable;
    }

    public static <T> boolean isAllNull(Iterable<T> iterable) {
        iterable = ifNullThrowArg(iterable, "iterable can't be null");

        for (T t : iterable) {
            if (!isNull(t)) {
                return false;
            }
        }

        return true;
    }

    public static <T> boolean isExistNull(Iterable<T> iterable) {
        iterable = ifNullThrowArg(iterable, "iterable can't be null");

        for (T t : iterable) {
            if (isNull(t)) {
                return true;
            }
        }

        return false;
    }
    public static <T> boolean isExistNull(T[] tArr) {
        tArr = ifNullThrowArg(tArr, "iterable can't be null");

        for (T t : tArr) {
            if (isNull(t)) {
                return true;
            }
        }

        return false;
    }

    public static <T> T ifNullThrowNull(T obj) { return ifNullThrowNull(obj, null); }
    public static <T> T ifNullThrowNull(T obj, String errorMsg) {
        return ifNullThrowException(obj, new NullPointerException(errorMsg));
    }

    public static <T> T ifNullThrowArg(T obj) { return ifNullThrowNull(obj, null); }
    public static <T> T ifNullThrowArg(T obj, String errorMsg) {
        return ifNullThrowException(obj, new IllegalArgumentException(errorMsg));
    }

    public static <T> T ifNullThrowException(T obj, RuntimeException exception) {
        if (!isNull(obj)) {
            return obj;
        }
        else {
            throw exception;
        }
    }

    public static boolean isNull(Object obj) {
        return obj == null;
    }

}
