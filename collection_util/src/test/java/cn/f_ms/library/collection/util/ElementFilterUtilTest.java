package cn.f_ms.library.collection.util;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

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

    private List<String> testList;

    private String[] testArray;

    @Before
    public void doBefore() {
        testList = new ArrayList<>();

        for (int i = 10; i > 0; i--) {

            for (int j = 10; j > i; j--) {

                testList.add(String.valueOf(j));
            }
        }

         testArray = arrayConvert(testList, String.class);
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
            ElementFilterUtil.isExist(testList, null);

            fail();
        } catch (IllegalArgumentException e) {
            // throw exception is right
        }

        /*
        feature test
         */
        boolean isExist7 = ElementFilterUtil.isExist(testList, new ElementFilterUtil.Filter<String>() {
            @Override
            public boolean isAccept(String s) {
                return "7".equals(s);
            }
        });
        assertThat(isExist7, is(true));

        boolean isExist11 = ElementFilterUtil.isExist(testList, new ElementFilterUtil.Filter<String>() {
            @Override
            public boolean isAccept(String s) {
                return "11".equals(s);
            }
        });
        assertThat(isExist11, is(false));
    }

    @Test
    public void filterFirst() throws Exception {

        /*
        Argument Check Test
         */
        try {
            ElementFilterUtil.filterFirst(null, new ElementFilterUtil.Filter<Object>() {
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
            ElementFilterUtil.filterFirst(testList, null);

            fail();
        } catch (IllegalArgumentException e) {
            // throw exception is right
        }

        /*
        feature test
         */
        String result7 = ElementFilterUtil.filterFirst(testList, new ElementFilterUtil.Filter<String>() {
            @Override
            public boolean isAccept(String s) {
                return "7".equals(s);
            }
        });
        assertThat(result7, CoreMatchers.equalTo("7"));

        String result11 = ElementFilterUtil.filterFirst(testList, new ElementFilterUtil.Filter<String>() {
            @Override
            public boolean isAccept(String s) {
                return "11".equals(s);
            }
        });
        assertThat(result11, CoreMatchers.nullValue());
    }

    @Test
    public void filterFirst1() throws Exception {

        /*
        Argument Check Test
         */
        try {
            ElementFilterUtil.filterFirst(null, new ElementFilterUtil.Filter<Object>() {
                @Override
                public boolean isAccept(Object o) {
                    return false;
                }
            }, new ElementFilterUtil.Converter<Object, Object>() {
                @Override
                public Object convert(Object o) {
                    return null;
                }
            });

            fail();
        } catch (IllegalArgumentException e) {
            // throw exception is right
        }

        try {
            ElementFilterUtil.filterFirst(testList, null, new ElementFilterUtil.Converter<String, Object>() {
                @Override
                public Object convert(String s) {
                    return null;
                }
            });

            fail();
        } catch (IllegalArgumentException e) {
            // throw exception is right
        }

        try {
            ElementFilterUtil.filterFirst(testList, new ElementFilterUtil.Filter<String>() {
                @Override
                public boolean isAccept(String s) {
                    return false;
                }
            }, null);

            fail();
        } catch (IllegalArgumentException e) {
            // throw exception is right
        }

        /*
        feature test
         */
        Integer result7 = ElementFilterUtil.filterFirst(testList, new ElementFilterUtil.Filter<String>() {
            @Override
            public boolean isAccept(String s) {
                return "7".equals(s);
            }
        }, new ElementFilterUtil.Converter<String, Integer>() {
            @Override
            public Integer convert(String s) {
                return Integer.parseInt(s);
            }
        });

        assertThat(result7, CoreMatchers.is(7));

        Integer result11 = ElementFilterUtil.filterFirst(testList, new ElementFilterUtil.Filter<String>() {
            @Override
            public boolean isAccept(String s) {
                return "11".equals(s);
            }
        }, new ElementFilterUtil.Converter<String, Integer>() {
            @Override
            public Integer convert(String s) {
                return Integer.parseInt(s);
            }
        });
        assertThat(result11, CoreMatchers.nullValue());
    }

    @Test
    public void convert() throws Exception {

        /*
        // TODO: 17-12-21 argument check test
         */

        /*
        feature test
         */
        ArrayList<Integer> resultContainer = ElementFilterUtil.convert(
                testArray,
                new ArrayList<Integer>(testArray.length),
                new ElementFilterUtil.Converter<String, Integer>() {
                    @Override
                    public Integer convert(String s) {
                        return Integer.parseInt(s);
                    }
                });

        ArrayList<Integer> testContainer = new ArrayList<>(testArray.length);
        for (String s : testArray) {
            testContainer.add(Integer.parseInt(s));
        }

        boolean isSame = Objects.equals(resultContainer, testContainer);

        assertThat(isSame, is(true));
    }

    @Test
    public void convert1() throws Exception {

        /*
        // TODO: 17-12-21 argument check test
         */

        /*
        feature test
         */
        ArrayList<Integer> resultContainer = ElementFilterUtil.convert(
                testList,
                new ArrayList<Integer>(testList.size()),
                new ElementFilterUtil.Converter<String, Integer>() {
                    @Override
                    public Integer convert(String s) {
                        return Integer.parseInt(s);
                    }
                });

        ArrayList<Integer> testContainer = new ArrayList<>(testList.size());
        for (String s : testList) {
            testContainer.add(Integer.parseInt(s));
        }

        boolean isSame = Objects.equals(resultContainer, testContainer);

        assertThat(isSame, is(true));
    }

    @Test
    public void convert2() throws Exception {

        /*
        // TODO: 17-12-21 argument check test
         */

        /*
        feature test
         */
        Integer[] resultContainer = ElementFilterUtil.convert(
                testArray,
                Integer.class,
                new ElementFilterUtil.Converter<String, Integer>() {
                    @Override
                    public Integer convert(String s) {
                        return Integer.parseInt(s);
                    }
                });

        Integer[] testContainer = new Integer[testArray.length];
        for (int i = 0; i < testArray.length; i++) {
            testContainer[i] = Integer.parseInt(testArray[i]);
        }

        boolean isSame = Arrays.equals(resultContainer, testContainer);

        assertThat(isSame, is(true));
    }

    @Test
    public void convert3() throws Exception {

        /*
        // TODO: 17-12-21 argument check test
         */

        try {
            ElementFilterUtil.convert(
                    testArray,
                    new Integer[testArray.length - 1],
                    new ElementFilterUtil.Converter<String, Integer>() {
                        @Override
                        public Integer convert(String s) {
                            return Integer.parseInt(s);
                        }
                    });
            fail();
        } catch (ArrayIndexOutOfBoundsException e) {
            //  expect exception
        }

        /*
        feature test
         */

        Integer[] resultContainer = ElementFilterUtil.convert(
                testArray,
                new Integer[testArray.length],
                new ElementFilterUtil.Converter<String, Integer>() {
                    @Override
                    public Integer convert(String s) {
                        return Integer.parseInt(s);
                    }
                });

        Integer[] testContainer = new Integer[testArray.length];
        for (int i = 0; i < testArray.length; i++) {
            testContainer[i] = Integer.parseInt(testArray[i]);
        }

        boolean isSame = Arrays.equals(resultContainer, testContainer);

        assertThat(isSame, is(true));

    }

    @Test
    public void convert4() throws Exception {

        /*
        // TODO: 17-12-21 argument check test
         */

        /*
        feature test
         */
        Integer[] resultContainer = ElementFilterUtil.convert(
                testList,
                Integer.class,
                new ElementFilterUtil.Converter<String, Integer>() {
                    @Override
                    public Integer convert(String s) {
                        return Integer.parseInt(s);
                    }
                });

        Integer[] testContainer = new Integer[testList.size()];
        for (int i = 0; i < testList.size(); i++) {
            testContainer[i] = Integer.parseInt(testList.get(i));
        }

        boolean isSame = Arrays.equals(resultContainer, testContainer);

        assertThat(isSame, is(true));
    }

    @Test
    public void convert5() throws Exception {

        /*
        // TODO: 17-12-21 argument check test
         */

        /*
        feature test
         */
        Integer[] resultContainer = ElementFilterUtil.convert(
                testList,
                new Integer[testList.size()],
                new ElementFilterUtil.Converter<String, Integer>() {
                    @Override
                    public Integer convert(String s) {
                        return Integer.parseInt(s);
                    }
                });

        Integer[] testContainer = new Integer[testList.size()];
        for (int i = 0; i < testList.size(); i++) {
            testContainer[i] = Integer.parseInt(testList.get(i));
        }

        boolean isSame = Arrays.equals(resultContainer, testContainer);

        assertThat(isSame, is(true));
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

        // TODO: 17-12-21

        Integer[] resultContainer = ElementFilterUtil.filter(ElementFilterUtil.FILTER_ELEMENT_NUM_UNLIMIT, testList, new Integer[testList.size()], new ElementFilterUtil.Filter<String>() {
            @Override
            public boolean isAccept(String s) {
                return true;
            }
        }, new ElementFilterUtil.Converter<String, Integer>() {
            @Override
            public Integer convert(String s) {
                return Integer.parseInt(s);
            }
        });

    }

    public static <T> T[] arrayConvert(Object[] sources, Class<T> resultTypeClass) {
        return arrayConvert(Arrays.asList(sources), resultTypeClass);
    }

    public static <T> T[] arrayConvert(List<? extends Object> sources, Class<T> resultTypeClass) {

        T[] resultArr = (T[]) Array.newInstance(resultTypeClass, sources.size());

        for (int i = 0; i < sources.size(); i++) {
            resultArr[i] = (T) sources.get(i);
        }

        return resultArr;
    }



}