package cn.f_ms.library.check;

import static cn.f_ms.library.check.CheckCollection.isExistNull;

/**
 * Check Null
 *
 * @author imf_m
 * @time 2017/7/16
 */

public class CheckNull {

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

    public static <T> T[] ifArgsExistNullThrowException(RuntimeException exception, T... args) {
        args = CheckNull.ifNullThrowArg(args, "args can't be null");

        if (CheckCollection.isExistNull(args)) {
            throw exception;
        }

        return args;
    }

    public static boolean isNull(Object obj) {
        return obj == null;
    }

}
