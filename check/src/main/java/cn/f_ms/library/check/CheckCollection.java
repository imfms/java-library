package cn.f_ms.library.check;

import java.util.Collection;

/**
 * CheckCollection
 *
 * @author imf_m
 * @date 2017/7/16
 */

public class CheckCollection {

    private CheckCollection() { throw new IllegalStateException("I have no instance"); }

    public static <T> boolean isEmptyWithNull(Collection<T> collection) {
        if (CheckNull.isNull(collection)) { return true; }

        return collection.isEmpty();
    }

    public static <T> boolean isEmptyWithNull(T[] tArr) {
        if (CheckNull.isNull(tArr)) { return true; }

        return tArr.length <= 0;
    }

    public static <T> T[] ifExistNullThrowException(T[] tArr, RuntimeException exception) {
        tArr = CheckNull.ifNullThrowArg(tArr, "iterable can't be null");
        exception = CheckNull.ifNullThrowArg(exception, "exception can't be null");

        if (isExistNull(tArr)) {
            throw exception;
        }
        return tArr;
    }

    public static <T> Iterable<T> ifExistNullThrowException(Iterable<T> iterable, RuntimeException exception) {
        iterable = CheckNull.ifNullThrowArg(iterable, "iterable can't be null");
        exception = CheckNull.ifNullThrowArg(exception, "exception can't be null");

        if (isExistNull(iterable)) {
            throw exception;
        }
        return iterable;
    }

    public static <T> boolean isAllNull(Iterable<T> iterable) {
        iterable = CheckNull.ifNullThrowArg(iterable, "iterable can't be null");

        for (T t : iterable) {
            if (!CheckNull.isNull(t)) {
                return false;
            }
        }

        return true;
    }

    public static <T> boolean isExistNull(Iterable<T> iterable) {
        iterable = CheckNull.ifNullThrowArg(iterable, "iterable can't be null");

        for (T t : iterable) {
            if (CheckNull.isNull(t)) {
                return true;
            }
        }

        return false;
    }
    public static <T> boolean isExistNull(T[] tArr) {
        tArr = CheckNull.ifNullThrowArg(tArr, "iterable can't be null");

        for (T t : tArr) {
            if (CheckNull.isNull(t)) {
                return true;
            }
        }

        return false;
    }

}
