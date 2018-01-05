package cn.f_ms.library.collection.util;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;

/**
 * Collection Element Filter Util
 * TODO: 18-1-5  filter return collection type add default ArrayList impl
 * @author f_ms
 */
public class ElementFilter {

    public interface Filter<Element> {

        /**
         * is accept ?
         *
         * @param element data
         * @return is accept? true == accept, false == not accept
         */
        boolean isAccept(Element element);
    }

    public interface Converter<Input, Output> {

        /**
         * convert input data to output data
         *
         * @param input input data
         * @return output data
         */
        Output convert(Input input);
    }

    public static final int FILTER_ELEMENT_NUM_UNLIMIT = -1;

    /**
     * no instance
     */
    private ElementFilter() {
        throw new IllegalStateException("I have no instance");
    }

    /**
     * is exist some data I want
     *
     * @param sources   source collection
     * @param filter    element filter
     * @param <Element> element type
     * @return is exist? true == exist, false == not exist
     */
    public static <Element> boolean isExist(Iterable<? extends Element> sources, Filter<Element> filter) {
        return filterFirst(sources, filter) != null;
    }

    /**
     * get collection's first element after specify filter
     *
     * @param sources   source collection
     * @param filter    element filter
     * @param <Element> element type
     * @return result element, will return null when none
     */
    public static <Element> Element filterFirst(Iterable<? extends Element> sources, Filter<Element> filter) {
        return filterFirst(sources, filter, new Converter<Element, Element>() {
            @Override
            public Element convert(Element element) {
                return element;
            }
        });
    }

    /**
     * get collection's first data after specify filter and converter
     *
     * @param sources   source collection
     * @param filter    element filter
     * @param converter element converter
     * @param <Element> element type
     * @return result element, will return null when none
     */
    public static <Element, Result> Result filterFirst(Iterable<? extends Element> sources, Filter<Element> filter, Converter<Element, Result> converter) {

        if (sources == null) {
            throw new IllegalArgumentException("sources can't be null");
        }

        if (filter == null) {
            throw new IllegalArgumentException("filter can't be null");
        }

        if (converter == null) {
            throw new IllegalArgumentException("converter can't be null");
        }

        for (Element source : sources) {
            if (filter.isAccept(source)) {
                return converter.convert(source);
            }
        }

        return null;
    }


    /**
     * get array's first element after specify filter
     *
     * @param sources   source array
     * @param filter    element filter
     * @param <Element> element type
     * @return result element, will return null when none
     */
    public static <Element> Element filterFirst(Element[] sources, Filter<Element> filter) {
        return filterFirst(sources, filter, new Converter<Element, Element>() {
            @Override
            public Element convert(Element element) {
                return element;
            }
        });
    }

    /**
     * get array's first data after specify filter and converter
     *
     * @param sources   source array
     * @param filter    element filter
     * @param converter element converter
     * @param <Element> element type
     * @return result element, will return null when none
     */
    public static <Element, Result> Result filterFirst(Element[] sources, Filter<Element> filter, Converter<Element, Result> converter) {

        if (sources == null) {
            throw new IllegalArgumentException("sources can't be null");
        }

        if (filter == null) {
            throw new IllegalArgumentException("filter can't be null");
        }

        if (converter == null) {
            throw new IllegalArgumentException("converter can't be null");
        }

        for (Element source : sources) {
            if (filter.isAccept(source)) {
                return converter.convert(source);
            }
        }

        return null;
    }

    /**
     * get array's all data after specify filter
     *
     * @param sources          source collection
     * @param targetCollection result element container
     * @param filter           element filter
     * @param <Element>        element type
     * @param <Collection>     result element type
     * @return result element container
     */
    public static <Element, Collection extends java.util.Collection<Element>> Collection filter(Element[] sources, Collection targetCollection, Filter<Element> filter) {
        return filter(sources, targetCollection, filter, new Converter<Element, Element>() {
            @Override
            public Element convert(Element element) {
                return element;
            }
        });
    }

    /**
     * get collection's some data after specify filter
     *
     * @param sources          source collection
     * @param targetCollection result element container
     * @param filter           element filter
     * @param <Element>        element type
     * @param <Collection>     result element type
     * @return result element container
     */
    public static <Element, Collection extends java.util.Collection<Element>> Collection filter(Iterable<? extends Element> sources, Collection targetCollection, Filter<Element> filter) {
        return filter(sources, targetCollection, filter, new Converter<Element, Element>() {
            @Override
            public Element convert(Element element) {
                return element;
            }
        });
    }

    /**
     * get array's some data after specify filter
     *
     * @param sources     source collection
     * @param targetArray result element container
     * @param filter      element filter
     * @param <Element>   element type
     * @return result element container
     */
    public static <Element> Element[] filter(Element[] sources, Element[] targetArray, Filter<Element> filter) {
        return filter(sources, targetArray, filter, new Converter<Element, Element>() {
            @Override
            public Element convert(Element element) {
                return element;
            }
        });
    }

    /**
     * get collection's some data after specify filter
     *
     * @param sources     source collection
     * @param targetArray result element container
     * @param filter      element filter
     * @param <Element>   element type
     * @return result element container
     * @throws ArrayIndexOutOfBoundsException targetArray length less actual result element number
     */
    public static <Element> Element[] filter(Iterable<? extends Element> sources, Element[] targetArray, Filter<Element> filter) {
        return filter(sources, targetArray, filter, new Converter<Element, Element>() {
            @Override
            public Element convert(Element element) {
                return element;
            }
        });
    }

    /**
     * convert array's data after specify converter
     *
     * @param sources          source collection
     * @param targetCollection result element container
     * @param converter        element convert
     * @param <Element>        element type
     * @param <Collection>     result element type
     * @return result element container
     */
    public static <Element, Result, Collection extends java.util.Collection<Result>> Collection convert(Element[] sources, Collection targetCollection, Converter<Element, Result> converter) {
        return filter(
                sources,
                targetCollection,
                new Filter<Element>() {
                    @Override
                    public boolean isAccept(Element element) {
                        return true;
                    }
                },
                converter
        );
    }


    /**
     * convert collection's data after specify converter
     *
     * @param sources          source collection
     * @param targetCollection result element container
     * @param converter        element convert
     * @param <Element>        element type
     * @param <Collection>     result element type
     * @return result element container
     */
    public static <Element, Result, Collection extends java.util.Collection<Result>> Collection convert(Iterable<? extends Element> sources, Collection targetCollection, Converter<Element, Result> converter) {
        return filter(
                sources,
                targetCollection, new Filter<Element>() {
                    @Override
                    public boolean isAccept(Element element) {
                        return true;
                    }
                },
                converter
        );
    }

    /**
     * convert array's data after specify converter
     * // TODO: 17-12-21 try remove resultClass argument
     *
     * @param sources   source collection
     * @param converter element convert
     * @param <Element> element type
     * @return result element container
     */
    public static <Element, Result> Result[] convert(Element[] sources, Class<Result> resultClass, Converter<Element, Result> converter) {

        if (resultClass == null) {
            throw new IllegalArgumentException("resultClass can't be null");
        }

        Result[] targetArray = (Result[]) Array.newInstance(resultClass, sources.length);

        return convert(sources, targetArray, converter);
    }

    /**
     * convert array's data after specify converter
     *
     * @param sources     source collection
     * @param targetArray result element container
     * @param converter   element convert
     * @param <Element>   element type
     * @return result element container
     */
    public static <Element, Result> Result[] convert(Element[] sources, Result[] targetArray, Converter<Element, Result> converter) {
        return filter(
                sources,
                targetArray,
                new Filter<Element>() {
                    @Override
                    public boolean isAccept(Element element) {
                        return true;
                    }
                },
                converter
        );
    }

    /**
     * convert collection's data after specify converter
     *
     * @param sources   source collection
     * @param converter element convert
     * @param <Element> element type
     * @return result element container
     * @throws ArrayIndexOutOfBoundsException targetArray length less actual result element number
     */
    public static <Element, Result> Result[] convert(Collection<? extends Element> sources, Class<Result> resultClass, Converter<Element, Result> converter) {

        if (resultClass == null) {
            throw new IllegalArgumentException("resultClass can't be null");
        }

        Result[] targetArray = (Result[]) Array.newInstance(resultClass, sources.size());

        return convert(sources, targetArray, converter);
    }

    /**
     * convert collection's data after specify converter
     *
     * @param sources     source collection
     * @param targetArray result element container
     * @param converter   element convert
     * @param <Element>   element type
     * @return result element container
     * @throws ArrayIndexOutOfBoundsException targetArray length less actual result element number
     */
    public static <Element, Result> Result[] convert(Iterable<? extends Element> sources, Result[] targetArray, Converter<Element, Result> converter) {
        return filter(
                sources,
                targetArray,
                new Filter<Element>() {
                    @Override
                    public boolean isAccept(Element element) {
                        return true;
                    }
                },
                converter
        );
    }

    /**
     * get array's some data after specify filter and converter
     *
     * @param sources          source collection
     * @param targetCollection result element container
     * @param filter           element filter
     * @param converter        element convert
     * @param <Element>        element type
     * @param <Collection>     result element type
     * @return result element container
     */
    public static <Element, Result, Collection extends java.util.Collection<Result>> Collection filter(Element[] sources, Collection targetCollection, Filter<Element> filter, Converter<Element, Result> converter) {
        return filter(FILTER_ELEMENT_NUM_UNLIMIT, sources, targetCollection, filter, converter);
    }

    /**
     * get collection's some data after specify filter and converter
     *
     * @param sources          source collection
     * @param targetCollection result element container
     * @param filter           element filter
     * @param converter        element convert
     * @param <Element>        element type
     * @param <Collection>     result element type
     * @return result element container
     */
    public static <Element, Result, Collection extends java.util.Collection<Result>> Collection filter(Iterable<? extends Element> sources, Collection targetCollection, Filter<Element> filter, Converter<Element, Result> converter) {
        return filter(FILTER_ELEMENT_NUM_UNLIMIT, sources, targetCollection, filter, converter);
    }

    /**
     * get array's some data after specify filter and converter
     *
     * @param sources     source collection
     * @param targetArray result element container
     * @param filter      element filter
     * @param converter   element convert
     * @param <Element>   element type
     * @return result element container
     */
    public static <Element, Result> Result[] filter(Element[] sources, Result[] targetArray, Filter<Element> filter, Converter<Element, Result> converter) {
        return filter(FILTER_ELEMENT_NUM_UNLIMIT, sources, targetArray, filter, converter);
    }

    /**
     * get collection's some data after specify filter and converter
     *
     * @param sources     source collection
     * @param targetArray result element container
     * @param filter      element filter
     * @param converter   element convert
     * @param <Element>   element type
     * @return result element container
     * @throws ArrayIndexOutOfBoundsException targetArray length less actual result element number
     */
    public static <Element, Result> Result[] filter(Iterable<? extends Element> sources, Result[] targetArray, Filter<Element> filter, Converter<Element, Result> converter) {
        return filter(FILTER_ELEMENT_NUM_UNLIMIT, sources, targetArray, filter, converter);
    }

    /**
     * get array's some data after specify filter and converter
     *
     * @param maxTargetElementNum max target filter element num,
     *                            value < -1 will throw exception, value == -1 is get all element
     * @param sources             source collection
     * @param targetCollection    result element container
     * @param filter              element filter
     * @param converter           element convert
     * @param <Element>           element type
     * @param <Collection>        result element type
     * @return result element container
     */
    public static <Element, Result, Collection extends java.util.Collection<Result>> Collection filter(int maxTargetElementNum, Element[] sources, Collection targetCollection, Filter<Element> filter, Converter<Element, Result> converter) {
        if (sources == null) {
            throw new IllegalArgumentException("sources can't be null");
        }

        return filter(maxTargetElementNum, Arrays.asList(sources), targetCollection, filter, converter);
    }

    /**
     * get collection's some data after specify filter and converter
     *
     * @param maxTargetElementNum max target filter element num,
     *                            value < -1 will throw exception, value == -1 is get all element
     * @param sources             source collection
     * @param targetCollection    result element container
     * @param filter              element filter
     * @param converter           element convert
     * @param <Element>           element type
     * @param <Collection>        result element type
     * @return result element container
     */
    public static <Element, Result, Collection extends java.util.Collection<Result>> Collection filter(int maxTargetElementNum, Iterable<? extends Element> sources, Collection targetCollection, Filter<Element> filter, Converter<Element, Result> converter) {

        if (sources == null) {
            throw new IllegalArgumentException("sources can't be null");
        }

        if (filter == null) {
            throw new IllegalArgumentException("filter can't be null");
        }

        if (converter == null) {
            throw new IllegalArgumentException("converter can't be null");
        }

        if (targetCollection == null) {
            throw new IllegalArgumentException("targetCollection can't be null");
        }

        if (maxTargetElementNum < FILTER_ELEMENT_NUM_UNLIMIT) {
            throw new IllegalArgumentException("maxTargetElementNum can't less -1");
        }

        if (maxTargetElementNum == 0) {
            return targetCollection;
        }

        int currentElementNum = 0;

        for (Element source : sources) {
            if (filter.isAccept(source)) {

                targetCollection.add(
                        converter.convert(source)
                );

                currentElementNum++;

                // -1 == no limit
                if (maxTargetElementNum != FILTER_ELEMENT_NUM_UNLIMIT
                        && currentElementNum >= maxTargetElementNum) {
                    return targetCollection;
                }
            }
        }

        return targetCollection;
    }

    /**
     * get array's some data after specify filter and converter
     *
     * @param maxTargetElementNum max target filter element num,
     *                            value < -1 will throw exception, value == -1 is get all element
     * @param sources             source collection
     * @param targetArray         result element container
     * @param filter              element filter
     * @param converter           element convert
     * @param <Element>           element type
     * @return result element container
     */
    public static <Element, Result> Result[] filter(int maxTargetElementNum, Element[] sources, Result[] targetArray, Filter<Element> filter, Converter<Element, Result> converter) {
        if (sources == null) {
            throw new IllegalArgumentException("sources can't be null");
        }
        return filter(maxTargetElementNum, Arrays.asList(sources), targetArray, filter, converter);
    }

    /**
     * get collection's some data after specify filter and converter
     *
     * @param maxTargetElementNum max target filter element num,
     *                            value < -1 will throw exception, value == -1 is get all element
     * @param sources             source collection
     * @param targetArray         result element container
     * @param filter              element filter
     * @param converter           element convert
     * @param <Element>           element type
     * @return result element container
     * @throws ArrayIndexOutOfBoundsException targetArray length less actual result element number
     */
    public static <Element, Result> Result[] filter(int maxTargetElementNum, Iterable<? extends Element> sources, Result[] targetArray, Filter<Element> filter, Converter<Element, Result> converter) {

        if (sources == null) {
            throw new IllegalArgumentException("sources can't be null");
        }

        if (filter == null) {
            throw new IllegalArgumentException("filter can't be null");
        }

        if (converter == null) {
            throw new IllegalArgumentException("converter can't be null");
        }

        if (targetArray == null) {
            throw new IllegalArgumentException("targetArray can't be null");
        }

        if (maxTargetElementNum < FILTER_ELEMENT_NUM_UNLIMIT) {
            throw new IllegalArgumentException("maxTargetElementNum can't less -1");
        }

        if (maxTargetElementNum == 0) {
            return targetArray;
        }

        int currentElementNum = 0;
        int currentArrayIndex = 0;
        for (Element source : sources) {
            if (filter.isAccept(source)) {

                if (targetArray.length - 1 < currentArrayIndex) {
                    throw new ArrayIndexOutOfBoundsException(
                            String.format("try to write value to index %s, but array's length == %s (index = 0-%s)", currentArrayIndex, targetArray.length, (targetArray.length - 1))
                    );
                }

                targetArray[currentArrayIndex] = converter.convert(source);

                currentArrayIndex++;
                currentElementNum++;

                // -1 == no limit
                if (maxTargetElementNum != FILTER_ELEMENT_NUM_UNLIMIT
                        && currentElementNum >= maxTargetElementNum) {
                    return targetArray;
                }
            }
        }

        return targetArray;
    }
}
