package cn.f_ms.check_library;

import java.util.Collection;

/**
 * CheckCollection
 *
 * @author imf_m
 * @time 2017/7/16
 */

public class CheckCollection {

    public static <T> boolean isEmptyWithNull(Collection<T> collection) {
        if (CheckNull.isNull(collection)) { return true; }

        return collection.isEmpty();
    }

    public <T> boolean isEmptyWithNull(T[] tArr) {
        if (CheckNull.isNull(tArr)) { return true; }

        return tArr.length <= 0;
    }

}
