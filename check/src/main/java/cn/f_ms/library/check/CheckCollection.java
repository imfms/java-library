package cn.f_ms.library.check;

import java.util.Collection;

/**
 * Check collection utils
 *
 * @author imf_m
 * @date 2017/7/16
 */

public class CheckCollection {

    private CheckCollection() {
        throw new IllegalStateException("I have no instance");
    }

    /**
     * is collection 'null' or empty
     *
     * @param collection collection
     * @return true == collection is 'null' or empty
     */
    public static boolean isEmptyWithNull(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    /**
     * is array 'null' or empty
     *
     * @param array array
     * @return true == array is 'null' or empty
     */
    public static boolean isEmptyWithNull(Object[] array) {
        return array == null || array.length <= 0;
    }

    /**
     * if array contain null element, throw specify RuntimeException
     *
     * @param array            array
     * @param runtimeException when array contain null element I will throw this runtimeException
     * @param <T>              array element type
     * @return input array
     */
    public static <T> T[] ifExistNullThrowException(T[] array, RuntimeException runtimeException) {
        CheckNull.ifNullThrowArgException(array, "array can't be null");
        CheckNull.ifNullThrowArgException(runtimeException, "runtimeException can't be null");

        if (isExistNull(array)) {
            throw runtimeException;
        }
        return array;
    }

    /**
     * if array contain null,
     * throw IllegalArgumentException("index value 'null_index' is null, array element can't container null value")
     *
     * @param array array
     * @param <T>   array element type
     * @return input array
     */
    public static <T> T[] ifExistNullThrowArgException(T[] array) {
        CheckNull.ifNullThrowArgException(array, "array can't be null");

        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                throw new IllegalArgumentException(
                        String.format("index value '%s' is null, array element can't container null element", i)
                );
            }
        }

        return array;
    }

    /**
     * if array contain null element, throw specify RuntimeException
     *
     * @param iterator         iterator
     * @param runtimeException when iterator contain null element I will throw this runtimeException
     * @param <Data>           iterator element type
     * @param <Iterator>       iterator type
     * @return input iterator
     */
    public static <Data, Iterator extends Iterable<Data>>
    Iterator ifExistNullThrowException(Iterator iterator, RuntimeException runtimeException) {
        CheckNull.ifNullThrowArgException(iterator, "iterator can't be null");
        CheckNull.ifNullThrowArgException(runtimeException, "runtimeException can't be null");

        if (isExistNull(iterator)) {
            throw runtimeException;
        }
        return iterator;
    }

    /**
     * if iterator contain null element,
     * I will throw IllegalArgumentException("iterator element can't container null value")
     *
     * @param iterator   iterator
     * @param <Data>     iterator element type
     * @param <Iterator> iterator type
     * @return input iterator
     */
    public static <Data, Iterator extends Iterable<Data>> Iterator ifExistNullThrowArgException(Iterator iterator) {
        return ifExistNullThrowException(iterator, new IllegalArgumentException("iterator element can't container null value"));
    }

    /**
     * is specify iterator's element all null ?
     *
     * @param iterator iterator
     * @return true == iterator's element all null
     */
    public static boolean isAllNull(Iterable<?> iterator) {
        CheckNull.ifNullThrowArgException(iterator, "iterable can't be null");

        for (Object obj : iterator) {
            if (obj != null) {
                return false;
            }
        }

        return true;
    }

    /**
     * is specify iterator contain null element ?
     *
     * @param iterator iterator
     * @return true == specify iterator contain null element
     */
    public static boolean isExistNull(Iterable<?> iterator) {
        CheckNull.ifNullThrowArgException(iterator, "iterator can't be null");

        for (Object obj : iterator) {
            if (obj == null) {
                return true;
            }
        }

        return false;
    }

    /**
     * is array iterator contain null element ?
     *
     * @param array iterator
     * @return true == specify array contain null element
     */
    public static boolean isExistNull(Object[] array) {
        CheckNull.ifNullThrowArgException(array, "array can't be null");

        for (Object obj : array) {
            if (obj == null) {
                return true;
            }
        }

        return false;
    }

}
