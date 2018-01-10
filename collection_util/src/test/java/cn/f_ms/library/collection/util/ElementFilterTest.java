package cn.f_ms.library.collection.util;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

/**
 * ElementFilterTest
 *
 * @author f_ms
 * @date 17-12-21
 */
public class ElementFilterTest {

    private List<String> testList;
    private String[] testArray;

    private ElementFilter.Filter<String> testFilter = new ElementFilter.Filter<String>() {
        @Override
        public boolean isAccept(String s) {
            return false;
        }
    };
    private ElementFilter.Converter<String, Integer> testConverter = new ElementFilter.Converter<String, Integer>() {
        @Override
        public Integer convert(String s) {
            return null;
        }
    };

    @Before
    public void doBefore() {
        testList = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {

            for (int j = 0; j < i; j++) {
                testList.add(String.valueOf(i));
            }
        }


        testArray = arrayConvert(testList, String.class);
    }

    @Test
    public void contains() throws Exception {

        /*
        Argument Check Test
         */
        try {
            ElementFilter.contains((Iterable<?>) null, new ElementFilter.Filter<Object>() {
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
            ElementFilter.contains(testList, null);

            fail();
        } catch (IllegalArgumentException e) {
            // throw exception is right
        }

        /*
        feature test
         */
        boolean isExist7 = ElementFilter.contains(testList, new ElementFilter.Filter<String>() {
            @Override
            public boolean isAccept(String s) {
                return "7".equals(s);
            }
        });
        assertThat(isExist7, is(true));

        boolean isExist11 = ElementFilter.contains(testList, new ElementFilter.Filter<String>() {
            @Override
            public boolean isAccept(String s) {
                return "11".equals(s);
            }
        });
        assertThat(isExist11, is(false));
    }

    @Test
    public void contains1() throws Exception {
        /*
        Argument Check Test
         */
        try {
            ElementFilter.contains((Object[]) null, new ElementFilter.Filter<Object>() {
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
            ElementFilter.contains(testArray, null);

            fail();
        } catch (IllegalArgumentException e) {
            // throw exception is right
        }

        /*
        feature test
         */
        boolean isExist7 = ElementFilter.contains(testArray, new ElementFilter.Filter<String>() {
            @Override
            public boolean isAccept(String s) {
                return "7".equals(s);
            }
        });
        assertThat(isExist7, is(true));

        boolean isExist11 = ElementFilter.contains(testArray, new ElementFilter.Filter<String>() {
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
            ElementFilter.filterFirst((Iterable<?>) null, new ElementFilter.Filter<Object>() {
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
            ElementFilter.filterFirst(testList, null);

            fail();
        } catch (IllegalArgumentException e) {
            // throw exception is right
        }

        /*
        feature test
         */
        String result7 = ElementFilter.filterFirst(testList, new ElementFilter.Filter<String>() {
            @Override
            public boolean isAccept(String s) {
                return "7".equals(s);
            }
        });
        assertThat(result7, CoreMatchers.equalTo("7"));

        String result11 = ElementFilter.filterFirst(testList, new ElementFilter.Filter<String>() {
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
            ElementFilter.filterFirst((Iterable<?>) null, new ElementFilter.Filter<Object>() {
                @Override
                public boolean isAccept(Object o) {
                    return false;
                }
            }, new ElementFilter.Converter<Object, Object>() {
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
            ElementFilter.filterFirst(testList, null, new ElementFilter.Converter<String, Object>() {
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
            ElementFilter.filterFirst(testList, new ElementFilter.Filter<String>() {
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
        Integer result7 = ElementFilter.filterFirst(testList, new ElementFilter.Filter<String>() {
            @Override
            public boolean isAccept(String s) {
                return "7".equals(s);
            }
        }, new ElementFilter.Converter<String, Integer>() {
            @Override
            public Integer convert(String s) {
                return Integer.parseInt(s);
            }
        });

        assertThat(result7, CoreMatchers.is(7));

        Integer result11 = ElementFilter.filterFirst(testList, new ElementFilter.Filter<String>() {
            @Override
            public boolean isAccept(String s) {
                return "11".equals(s);
            }
        }, new ElementFilter.Converter<String, Integer>() {
            @Override
            public Integer convert(String s) {
                return Integer.parseInt(s);
            }
        });
        assertThat(result11, CoreMatchers.nullValue());
    }

    @Test
    public void filterFirst2() throws Exception {
        /*
        Argument Check Test
         */
        try {
            ElementFilter.filterFirst((Object[]) null, new ElementFilter.Filter<Object>() {
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
            ElementFilter.filterFirst(testArray, null);

            fail();
        } catch (IllegalArgumentException e) {
            // throw exception is right
        }

        /*
        feature test
         */
        String result7 = ElementFilter.filterFirst(testArray, new ElementFilter.Filter<String>() {
            @Override
            public boolean isAccept(String s) {
                return "7".equals(s);
            }
        });
        assertThat(result7, CoreMatchers.equalTo("7"));

        String result11 = ElementFilter.filterFirst(testArray, new ElementFilter.Filter<String>() {
            @Override
            public boolean isAccept(String s) {
                return "11".equals(s);
            }
        });
        assertThat(result11, CoreMatchers.nullValue());
    }

    @Test
    public void filterFirst3() throws Exception {
        /*
        Argument Check Test
         */
        try {
            ElementFilter.filterFirst((Object[]) null, new ElementFilter.Filter<Object>() {
                @Override
                public boolean isAccept(Object o) {
                    return false;
                }
            }, new ElementFilter.Converter<Object, Object>() {
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
            ElementFilter.filterFirst(testArray, null, new ElementFilter.Converter<String, Object>() {
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
            ElementFilter.filterFirst(testArray, new ElementFilter.Filter<String>() {
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
        Integer result7 = ElementFilter.filterFirst(testArray, new ElementFilter.Filter<String>() {
            @Override
            public boolean isAccept(String s) {
                return "7".equals(s);
            }
        }, new ElementFilter.Converter<String, Integer>() {
            @Override
            public Integer convert(String s) {
                return Integer.parseInt(s);
            }
        });

        assertThat(result7, CoreMatchers.is(7));

        Integer result11 = ElementFilter.filterFirst(testArray, new ElementFilter.Filter<String>() {
            @Override
            public boolean isAccept(String s) {
                return "11".equals(s);
            }
        }, new ElementFilter.Converter<String, Integer>() {
            @Override
            public Integer convert(String s) {
                return Integer.parseInt(s);
            }
        });
        assertThat(result11, CoreMatchers.nullValue());
    }

    @Test
    public void filterFirstIndex() throws Exception {
        /*
        Argument Check Test
         */
        try {
            ElementFilter.filterFirstIndex((Iterable<?>) null, new ElementFilter.Filter<Object>() {
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
            ElementFilter.filterFirstIndex(testList, null);

            fail();
        } catch (IllegalArgumentException e) {
            // throw exception is right
        }

        /*
        feature test
         */
        int result7Index = ElementFilter.filterFirstIndex(testList, new ElementFilter.Filter<String>() {
            @Override
            public boolean isAccept(String s) {
                return "7".equals(s);
            }
        });

        assertThat(result7Index, is(testList.indexOf("7")));

        int result11Index = ElementFilter.filterFirstIndex(testList, new ElementFilter.Filter<String>() {
            @Override
            public boolean isAccept(String s) {
                return "11".equals(s);
            }
        });
        assertThat(result11Index, is(ElementFilter.INDEX_NONE));
    }

    @Test
    public void filterFirstIndex1() throws Exception {
        /*
        Argument Check Test
        */
        try {
            ElementFilter.filterFirstIndex((Iterable<?>) null, new ElementFilter.Filter<Object>() {
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
            ElementFilter.filterFirstIndex(testArray, null);

            fail();
        } catch (IllegalArgumentException e) {
            // throw exception is right
        }

        /*
        feature test
         */
        int result7Index = ElementFilter.filterFirstIndex(testArray, new ElementFilter.Filter<String>() {
            @Override
            public boolean isAccept(String s) {
                return "7".equals(s);
            }
        });

        assertThat(result7Index, is(Arrays.asList(testArray).indexOf("7")));

        int result11Index = ElementFilter.filterFirstIndex(testArray, new ElementFilter.Filter<String>() {
            @Override
            public boolean isAccept(String s) {
                return "11".equals(s);
            }
        });
        assertThat(result11Index, is(ElementFilter.INDEX_NONE));
    }

    @Test
    public void convert() throws Exception {

        /*
        argument check test
         */

        // sources be null
        try {
            ElementFilter.convert((String[])null, (ArrayList<Integer>)null, (ElementFilter.Converter<String, Integer>)null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // result container be null
        try {
            ElementFilter.convert(testArray, (ArrayList<Integer>)null, (ElementFilter.Converter<String, Integer>)null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // converter be null
        try {
            ElementFilter.convert(testArray, new ArrayList<Integer>(), (ElementFilter.Converter<String, Integer>)null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        /*
        feature test
         */
        ArrayList<Integer> resultContainer = ElementFilter.convert(
                testArray,
                new ArrayList<Integer>(testArray.length),
                new ElementFilter.Converter<String, Integer>() {
                    @Override
                    public Integer convert(String s) {
                        return Integer.parseInt(s);
                    }
                }
        );

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
        argument check test
         */

        // sources be null
        try {
            ElementFilter.convert((Iterable<String>)null, (ArrayList<Integer>)null, (ElementFilter.Converter<String, Integer>)null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // result container be null
        try {
            ElementFilter.convert(testList, (ArrayList<Integer>)null, (ElementFilter.Converter<String, Integer>)null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // converter be null
        try {
            ElementFilter.convert(testList, new ArrayList<Integer>(), (ElementFilter.Converter<String, Integer>)null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        /*
        feature test
         */
        ArrayList<Integer> resultContainer = ElementFilter.convert(
                testList,
                new ArrayList<Integer>(testList.size()),
                new ElementFilter.Converter<String, Integer>() {
                    @Override
                    public Integer convert(String s) {
                        return Integer.parseInt(s);
                    }
                }
        );

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
        argument check test
         */

        // sources be null
        try {
            ElementFilter.convert((String[])null, (Class<Integer>)null, (ElementFilter.Converter<String, Integer>)null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // result container be null
        try {
            ElementFilter.convert(testArray, (Class<Integer>)null, (ElementFilter.Converter<String, Integer>)null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // converter be null
        try {
            ElementFilter.convert(testArray, Integer.class, (ElementFilter.Converter<String, Integer>)null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        /*
        feature test
         */
        Integer[] resultContainer = ElementFilter.convert(
                testArray,
                Integer.class,
                new ElementFilter.Converter<String, Integer>() {
                    @Override
                    public Integer convert(String s) {
                        return Integer.parseInt(s);
                    }
                }
        );

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
        argument check test
         */

        // sources be null
        try {
            ElementFilter.convert((String[])null, (Integer[])null, (ElementFilter.Converter<String, Integer>)null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // result container be null
        try {
            ElementFilter.convert(testArray, (Integer[])null, (ElementFilter.Converter<String, Integer>)null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // converter be null
        try {
            ElementFilter.convert(testArray, new Integer[1], (ElementFilter.Converter<String, Integer>)null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        /*
        feature test
         */

        Integer[] resultContainer = ElementFilter.convert(
                testArray,
                new Integer[testArray.length],
                new ElementFilter.Converter<String, Integer>() {
                    @Override
                    public Integer convert(String s) {
                        return Integer.parseInt(s);
                    }
                }
        );

        Integer[] testContainer = new Integer[testArray.length];
        for (int i = 0; i < testArray.length; i++) {
            testContainer[i] = Integer.parseInt(testArray[i]);
        }

        boolean isSame = Arrays.equals(resultContainer, testContainer);

        assertThat(isSame, is(true));

        /*
        exception test
         */
        // when result container less result num
        try {
            ElementFilter.convert(
                    testArray,
                    new Integer[testArray.length - 1],
                    new ElementFilter.Converter<String, Integer>() {
                        @Override
                        public Integer convert(String s) {
                            return Integer.parseInt(s);
                        }
                    }
            );
            fail();
        } catch (ArrayIndexOutOfBoundsException e) {
            assertThat(e.getMessage(), equalTo("try to write value to index 54, but array's length == 54 (index = 0-53)"));
        }

    }

    @Test
    public void convert4() throws Exception {

        /*
        argument check test
         */

        // sources be null
        try {
            ElementFilter.convert((Collection<String>)null, (Class<Integer>)null, (ElementFilter.Converter<String, Integer>)null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // result container be null
        try {
            ElementFilter.convert(testList, (Class<Integer>)null, (ElementFilter.Converter<String, Integer>)null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // converter be null
        try {
            ElementFilter.convert(testList, Integer.class, (ElementFilter.Converter<String, Integer>)null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        /*
        feature test
         */
        Integer[] resultContainer = ElementFilter.convert(
                testList,
                Integer.class,
                new ElementFilter.Converter<String, Integer>() {
                    @Override
                    public Integer convert(String s) {
                        return Integer.parseInt(s);
                    }
                }
        );

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
        argument check test
         */

        // sources be null
        try {
            ElementFilter.convert((Iterable<String>)null, (Integer[])null, (ElementFilter.Converter<String, Integer>)null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // result container be null
        try {
            ElementFilter.convert(testList, (Integer[])null, (ElementFilter.Converter<String, Integer>)null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // converter be null
        try {
            ElementFilter.convert(testList, new Integer[1], (ElementFilter.Converter<String, Integer>)null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        /*
        feature test
         */
        Integer[] resultContainer = ElementFilter.convert(
                testList,
                new Integer[testList.size()],
                new ElementFilter.Converter<String, Integer>() {
                    @Override
                    public Integer convert(String s) {
                        return Integer.parseInt(s);
                    }
                }
        );

        Integer[] testContainer = new Integer[testList.size()];
        for (int i = 0; i < testList.size(); i++) {
            testContainer[i] = Integer.parseInt(testList.get(i));
        }

        boolean isSame = Arrays.equals(resultContainer, testContainer);

        assertThat(isSame, is(true));

        /*
        exception test
         */
        // when result container less result num
        try {
            ElementFilter.convert(
                    testList,
                    new Integer[testList.size() - 1],
                    new ElementFilter.Converter<String, Integer>() {
                        @Override
                        public Integer convert(String s) {
                            return Integer.parseInt(s);
                        }
                    }
            );
            fail();
        } catch (ArrayIndexOutOfBoundsException e) {
            assertThat(e.getMessage(), equalTo("try to write value to index 54, but array's length == 54 (index = 0-53)"));
        }
    }

    @Test
    public void convert6() throws Exception {

        /*
        argument check test
         */

        // sources be null
        try {
            ElementFilter.convert((String[])null, (ElementFilter.Converter<String, Integer>)null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // converter be null
        try {
            ElementFilter.convert(testArray, (ElementFilter.Converter<String, Integer>)null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        /*
        feature test
         */
        List<Integer> resultContainer = ElementFilter.convert(
                testArray,
                new ElementFilter.Converter<String, Integer>() {
                    @Override
                    public Integer convert(String s) {
                        return Integer.parseInt(s);
                    }
                }
        );

        ArrayList<Integer> testContainer = new ArrayList<>(testArray.length);
        for (String s : testArray) {
            testContainer.add(Integer.parseInt(s));
        }

        boolean isSame = Objects.equals(resultContainer, testContainer);

        assertThat(isSame, is(true));
    }

    @Test
    public void convert7() throws Exception {

        /*
        argument check test
         */

        // sources be null
        try {
            ElementFilter.convert((Iterable<String>)null, (ElementFilter.Converter<String, Integer>)null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // converter be null
        try {
            ElementFilter.convert(testList, (ElementFilter.Converter<String, Integer>)null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        /*
        feature test
         */
        List<Integer> resultContainer = ElementFilter.convert(
                testList,
                new ElementFilter.Converter<String, Integer>() {
                    @Override
                    public Integer convert(String s) {
                        return Integer.parseInt(s);
                    }
                }
        );

        ArrayList<Integer> testContainer = new ArrayList<>(testList.size());
        for (String s : testList) {
            testContainer.add(Integer.parseInt(s));
        }

        boolean isSame = Objects.equals(resultContainer, testContainer);

        assertThat(isSame, is(true));
    }

    @Test
    public void filter() throws Exception {
        /*
        feature test
         */
        {
            // unlimit result num
            ArrayList<String> resultContainer = ElementFilter.filter(testArray, new ArrayList<String>(), new ElementFilter.Filter<String>() {
                @Override
                public boolean isAccept(String s) {
                    return "7".equals(s);
                }
            });

            ArrayList<String> expectContainer = new ArrayList<>();
            for (int i = 0; i < 7; i++) {
                expectContainer.add(String.valueOf(7));
            }

            boolean isSame = expectContainer.equals(resultContainer);
            assertThat(isSame, is(true));
        }

        /*
        Argument Check Test
        */
        // sources be null
        try {
            ElementFilter.filter((String[]) null, (ArrayList<String>) null, (ElementFilter.Filter<String>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // container be null
        try {
            ElementFilter.filter(testArray, (ArrayList<String>) null, (ElementFilter.Filter<String>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // filter be null
        try {
            ElementFilter.filter(testArray, new ArrayList<String>(), (ElementFilter.Filter<String>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void filter1() throws Exception {
        /*
        feature test
        */
        {
            ArrayList<String> resultContainer = ElementFilter.filter(testList, new ArrayList<String>(), new ElementFilter.Filter<String>() {
                @Override
                public boolean isAccept(String s) {
                    return "7".equals(s);
                }
            });

            ArrayList<String> expectContainer = new ArrayList<>();
            for (int i = 0; i < 7; i++) {
                expectContainer.add(String.valueOf(7));
            }

            boolean isSame = expectContainer.equals(resultContainer);
            assertThat(isSame, is(true));
        }

        /*
        Argument Check Test
         */
        // sources be null
        try {
            ElementFilter.filter((Iterable<String>) null, (ArrayList<String>) null, (ElementFilter.Filter<String>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // container be null
        try {
            ElementFilter.filter(testList, (ArrayList<String>) null, (ElementFilter.Filter<String>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // filter be null
        try {
            ElementFilter.filter(testList, new ArrayList<String>(), (ElementFilter.Filter<String>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void filter2() throws Exception {
        /*
        feature test
         */
        {
            String[] resultContainer = ElementFilter.filter(testArray, new String[7], new ElementFilter.Filter<String>() {
                @Override
                public boolean isAccept(String s) {
                    return "7".equals(s);
                }
            });

            String[] expectContainer = new String[7];
            for (int i = 0; i < 7; i++) {
                expectContainer[i] = String.valueOf(7);
            }

            boolean isSame = Arrays.equals(resultContainer, expectContainer);
            assertThat(isSame, is(true));
        }

        {
            // array length not enough
            try {
                ElementFilter.filter(testArray, new String[4], new ElementFilter.Filter<String>() {
                    @Override
                    public boolean isAccept(String s) {
                        return "7".equals(s);
                    }
                });
                fail();
            } catch (ArrayIndexOutOfBoundsException e) {
                assertThat(e.getMessage(), equalTo("try to write value to index 4, but array's length == 4 (index = 0-3)"));
            }
        }

        /*
        Argument Check Test
        */
        // sources be null
        try {
            ElementFilter.filter((String[]) null, (String[]) null, (ElementFilter.Filter<String>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // container be null
        try {
            ElementFilter.filter(testArray, (String[]) null, (ElementFilter.Filter<String>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // filter be null
        try {
            ElementFilter.filter(testArray, new String[1], (ElementFilter.Filter<String>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void filter3() throws Exception {
        /*
        feature test
         */
        {
            String[] resultContainer = ElementFilter.filter(testList, new String[7], new ElementFilter.Filter<String>() {
                @Override
                public boolean isAccept(String s) {
                    return "7".equals(s);
                }
            });

            String[] expectContainer = new String[7];
            for (int i = 0; i < 7; i++) {
                expectContainer[i] = String.valueOf(7);
            }

            boolean isSame = Arrays.equals(resultContainer, expectContainer);
            assertThat(isSame, is(true));
        }

        {
            // array length not enough
            try {
                ElementFilter.filter(testList, new String[4], new ElementFilter.Filter<String>() {
                    @Override
                    public boolean isAccept(String s) {
                        return "7".equals(s);
                    }
                });
                fail();
            } catch (ArrayIndexOutOfBoundsException e) {
                assertThat(e.getMessage(), equalTo("try to write value to index 4, but array's length == 4 (index = 0-3)"));
            }
        }

        /*
        Argument Check Test
         */
        // sources be null
        try {
            ElementFilter.filter((Iterable<String>) null, (String[]) null, (ElementFilter.Filter<String>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // container be null
        try {
            ElementFilter.filter(testList, (String[]) null, (ElementFilter.Filter<String>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // filter be null
        try {
            ElementFilter.filter(testList, new String[1], (ElementFilter.Filter<String>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void filter4() throws Exception {
        /*
        feature test
         */
        {
            // unlimit result num
            ArrayList<Integer> resultContainer = ElementFilter.filter(testArray, new ArrayList<Integer>(), new ElementFilter.Filter<String>() {
                @Override
                public boolean isAccept(String s) {
                    return "7".equals(s);
                }
            }, new ElementFilter.Converter<String, Integer>() {
                @Override
                public Integer convert(String s) {
                    return Integer.parseInt(s);
                }
            });

            ArrayList<Integer> expectContainer = new ArrayList<>();
            for (int i = 0; i < 7; i++) {
                expectContainer.add(7);
            }

            boolean isSame = expectContainer.equals(resultContainer);
            assertThat(isSame, is(true));
        }

        /*
        Argument Check Test
        */
        // sources be null
        try {
            ElementFilter.filter((String[]) null, (ArrayList<Integer>) null, (ElementFilter.Filter<String>) null, (ElementFilter.Converter<String, Integer>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // container be null
        try {
            ElementFilter.filter(testArray, (ArrayList<Integer>) null, (ElementFilter.Filter<String>) null, (ElementFilter.Converter<String, Integer>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // filter be null
        try {
            ElementFilter.filter(testArray, new ArrayList<Integer>(), (ElementFilter.Filter<String>) null, (ElementFilter.Converter<String, Integer>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // converter be null
        try {
            ElementFilter.filter(testArray, new ArrayList<Integer>(), new ElementFilter.Filter<String>() {
                @Override
                public boolean isAccept(String s) {
                    return false;
                }
            }, (ElementFilter.Converter<String, Integer>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void filter5() throws Exception {
        /*
        feature test
         */
        {
            ArrayList<Integer> resultContainer = ElementFilter.filter(testList, new ArrayList<Integer>(), new ElementFilter.Filter<String>() {
                @Override
                public boolean isAccept(String s) {
                    return "7".equals(s);
                }
            }, new ElementFilter.Converter<String, Integer>() {
                @Override
                public Integer convert(String s) {
                    return Integer.parseInt(s);
                }
            });

            ArrayList<Integer> expectContainer = new ArrayList<>();
            for (int i = 0; i < 7; i++) {
                expectContainer.add(7);
            }

            boolean isSame = expectContainer.equals(resultContainer);
            assertThat(isSame, is(true));
        }

        /*
        Argument Check Test
         */
        // sources be null
        try {
            ElementFilter.filter((Iterable<String>) null, (ArrayList<Integer>) null, (ElementFilter.Filter<String>) null, (ElementFilter.Converter<String, Integer>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // container be null
        try {
            ElementFilter.filter(testList, (ArrayList<Integer>) null, (ElementFilter.Filter<String>) null, (ElementFilter.Converter<String, Integer>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // filter be null
        try {
            ElementFilter.filter(testList, new ArrayList<Integer>(), (ElementFilter.Filter<String>) null, (ElementFilter.Converter<String, Integer>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // converter be null
        try {
            ElementFilter.filter(testList, new ArrayList<Integer>(), new ElementFilter.Filter<String>() {
                @Override
                public boolean isAccept(String s) {
                    return false;
                }
            }, (ElementFilter.Converter<String, Integer>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void filter6() throws Exception {
        /*
        feature test
         */
        {
            Integer[] resultContainer = ElementFilter.filter(testArray, new Integer[7], new ElementFilter.Filter<String>() {
                @Override
                public boolean isAccept(String s) {
                    return "7".equals(s);
                }
            }, new ElementFilter.Converter<String, Integer>() {
                @Override
                public Integer convert(String s) {
                    return Integer.parseInt(s);
                }
            });

            Integer[] expectContainer = new Integer[7];
            for (int i = 0; i < 7; i++) {
                expectContainer[i] = 7;
            }

            boolean isSame = Arrays.equals(resultContainer, expectContainer);
            assertThat(isSame, is(true));
        }

        {
            // array length not enough
            try {
                ElementFilter.filter(testArray, new Integer[4], new ElementFilter.Filter<String>() {
                    @Override
                    public boolean isAccept(String s) {
                        return "7".equals(s);
                    }
                }, new ElementFilter.Converter<String, Integer>() {
                    @Override
                    public Integer convert(String s) {
                        return Integer.parseInt(s);
                    }
                });
                fail();
            } catch (ArrayIndexOutOfBoundsException e) {
                assertThat(e.getMessage(), equalTo("try to write value to index 4, but array's length == 4 (index = 0-3)"));
            }
        }

        /*
        Argument Check Test
        */
        // sources be null
        try {
            ElementFilter.filter((String[]) null, (Integer[]) null, (ElementFilter.Filter<String>) null, (ElementFilter.Converter<String, Integer>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // container be null
        try {
            ElementFilter.filter(testArray, (Integer[]) null, (ElementFilter.Filter<String>) null, (ElementFilter.Converter<String, Integer>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // filter be null
        try {
            ElementFilter.filter(testArray, new Integer[1], (ElementFilter.Filter<String>) null, (ElementFilter.Converter<String, Integer>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // converter be null
        try {
            ElementFilter.filter(testArray, new Integer[1], new ElementFilter.Filter<String>() {
                @Override
                public boolean isAccept(String s) {
                    return false;
                }
            }, (ElementFilter.Converter<String, Integer>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void filter7() throws Exception {
        /*
        feature test
         */
        {
            // unlimit result num
            Integer[] resultContainer = ElementFilter.filter(testList, new Integer[7], new ElementFilter.Filter<String>() {
                @Override
                public boolean isAccept(String s) {
                    return "7".equals(s);
                }
            }, new ElementFilter.Converter<String, Integer>() {
                @Override
                public Integer convert(String s) {
                    return Integer.parseInt(s);
                }
            });

            Integer[] expectContainer = new Integer[7];
            for (int i = 0; i < 7; i++) {
                expectContainer[i] = 7;
            }

            boolean isSame = Arrays.equals(resultContainer, expectContainer);
            assertThat(isSame, is(true));
        }

        {
            // array length not enough
            try {
                ElementFilter.filter(testList, new Integer[4], new ElementFilter.Filter<String>() {
                    @Override
                    public boolean isAccept(String s) {
                        return "7".equals(s);
                    }
                }, new ElementFilter.Converter<String, Integer>() {
                    @Override
                    public Integer convert(String s) {
                        return Integer.parseInt(s);
                    }
                });
                fail();
            } catch (ArrayIndexOutOfBoundsException e) {
                assertThat(e.getMessage(), equalTo("try to write value to index 4, but array's length == 4 (index = 0-3)"));
            }
        }

        /*
        Argument Check Test
         */
        // sources be null
        try {
            ElementFilter.filter((Iterable<String>) null, (Integer[]) null, (ElementFilter.Filter<String>) null, (ElementFilter.Converter<String, Integer>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // container be null
        try {
            ElementFilter.filter(testList, (Integer[]) null, (ElementFilter.Filter<String>) null, (ElementFilter.Converter<String, Integer>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // filter be null
        try {
            ElementFilter.filter(testList, new Integer[1], (ElementFilter.Filter<String>) null, (ElementFilter.Converter<String, Integer>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // converter be null
        try {
            ElementFilter.filter(testList, new Integer[1], new ElementFilter.Filter<String>() {
                @Override
                public boolean isAccept(String s) {
                    return false;
                }
            }, (ElementFilter.Converter<String, Integer>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void filter8() throws Exception {
        /*
        feature test
         */
        {
            // unlimit result num
            ArrayList<Integer> resultContainer = ElementFilter.filter(ElementFilter.FILTER_ELEMENT_NUM_UNLIMIT, testArray, new ArrayList<Integer>(), new ElementFilter.Filter<String>() {
                @Override
                public boolean isAccept(String s) {
                    return "7".equals(s);
                }
            }, new ElementFilter.Converter<String, Integer>() {
                @Override
                public Integer convert(String s) {
                    return Integer.parseInt(s);
                }
            });

            ArrayList<Integer> expectContainer = new ArrayList<>();
            for (int i = 0; i < 7; i++) {
                expectContainer.add(7);
            }

            boolean isSame = expectContainer.equals(resultContainer);
            assertThat(isSame, is(true));
        }

        {
            // limit 5 result
            ArrayList<Integer> resultContainer = ElementFilter.filter(5, testArray, new ArrayList<Integer>(), new ElementFilter.Filter<String>() {
                @Override
                public boolean isAccept(String s) {
                    return "7".equals(s);
                }
            }, new ElementFilter.Converter<String, Integer>() {
                @Override
                public Integer convert(String s) {
                    return Integer.parseInt(s);
                }
            });

            ArrayList<Integer> expectContainer = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                expectContainer.add(7);
            }

            boolean isSame = expectContainer.equals(resultContainer);
            assertThat(isSame, is(true));
        }

        /*
        Argument Check Test
        */
        // limit result count less -1
        try {
            ElementFilter.filter(-2, (String[]) null, (ArrayList<Integer>) null, (ElementFilter.Filter<String>) null, (ElementFilter.Converter<String, Integer>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // sources be null
        try {
            ElementFilter.filter(ElementFilter.FILTER_ELEMENT_NUM_UNLIMIT, (String[]) null, (ArrayList<Integer>) null, (ElementFilter.Filter<String>) null, (ElementFilter.Converter<String, Integer>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // container be null
        try {
            ElementFilter.filter(ElementFilter.FILTER_ELEMENT_NUM_UNLIMIT, testArray, (ArrayList<Integer>) null, (ElementFilter.Filter<String>) null, (ElementFilter.Converter<String, Integer>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // filter be null
        try {
            ElementFilter.filter(ElementFilter.FILTER_ELEMENT_NUM_UNLIMIT, testArray, new ArrayList<Integer>(), (ElementFilter.Filter<String>) null, (ElementFilter.Converter<String, Integer>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // converter be null
        try {
            ElementFilter.filter(ElementFilter.FILTER_ELEMENT_NUM_UNLIMIT, testArray, new ArrayList<Integer>(), new ElementFilter.Filter<String>() {
                @Override
                public boolean isAccept(String s) {
                    return false;
                }
            }, (ElementFilter.Converter<String, Integer>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void filter9() throws Exception {
        /*
        feature test
         */
        {
            // unlimit result num
            ArrayList<Integer> resultContainer = ElementFilter.filter(ElementFilter.FILTER_ELEMENT_NUM_UNLIMIT, testList, new ArrayList<Integer>(), new ElementFilter.Filter<String>() {
                @Override
                public boolean isAccept(String s) {
                    return "7".equals(s);
                }
            }, new ElementFilter.Converter<String, Integer>() {
                @Override
                public Integer convert(String s) {
                    return Integer.parseInt(s);
                }
            });

            ArrayList<Integer> expectContainer = new ArrayList<>();
            for (int i = 0; i < 7; i++) {
                expectContainer.add(7);
            }

            boolean isSame = expectContainer.equals(resultContainer);
            assertThat(isSame, is(true));
        }

        {
            // limit 5 result
            ArrayList<Integer> resultContainer = ElementFilter.filter(5, testList, new ArrayList<Integer>(), new ElementFilter.Filter<String>() {
                @Override
                public boolean isAccept(String s) {
                    return "7".equals(s);
                }
            }, new ElementFilter.Converter<String, Integer>() {
                @Override
                public Integer convert(String s) {
                    return Integer.parseInt(s);
                }
            });

            ArrayList<Integer> expectContainer = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                expectContainer.add(7);
            }

            boolean isSame = expectContainer.equals(resultContainer);
            assertThat(isSame, is(true));
        }

        /*
        Argument Check Test
         */
        // limit result count less -1
        try {
            ElementFilter.filter(-2, (Iterable<String>) null, (ArrayList<Integer>) null, (ElementFilter.Filter<String>) null, (ElementFilter.Converter<String, Integer>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // sources be null
        try {
            ElementFilter.filter(ElementFilter.FILTER_ELEMENT_NUM_UNLIMIT, (Iterable<String>) null, (ArrayList<Integer>) null, (ElementFilter.Filter<String>) null, (ElementFilter.Converter<String, Integer>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // container be null
        try {
            ElementFilter.filter(ElementFilter.FILTER_ELEMENT_NUM_UNLIMIT, testList, (ArrayList<Integer>) null, (ElementFilter.Filter<String>) null, (ElementFilter.Converter<String, Integer>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // filter be null
        try {
            ElementFilter.filter(ElementFilter.FILTER_ELEMENT_NUM_UNLIMIT, testList, new ArrayList<Integer>(), (ElementFilter.Filter<String>) null, (ElementFilter.Converter<String, Integer>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // converter be null
        try {
            ElementFilter.filter(ElementFilter.FILTER_ELEMENT_NUM_UNLIMIT, testList, new ArrayList<Integer>(), new ElementFilter.Filter<String>() {
                @Override
                public boolean isAccept(String s) {
                    return false;
                }
            }, (ElementFilter.Converter<String, Integer>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void filter10() throws Exception {

        /*
        feature test
         */
        {
            // unlimit result num
            Integer[] resultContainer = ElementFilter.filter(ElementFilter.FILTER_ELEMENT_NUM_UNLIMIT, testArray, new Integer[7], new ElementFilter.Filter<String>() {
                @Override
                public boolean isAccept(String s) {
                    return "7".equals(s);
                }
            }, new ElementFilter.Converter<String, Integer>() {
                @Override
                public Integer convert(String s) {
                    return Integer.parseInt(s);
                }
            });

            Integer[] expectContainer = new Integer[7];
            for (int i = 0; i < 7; i++) {
                expectContainer[i] = 7;
            }

            boolean isSame = Arrays.equals(resultContainer, expectContainer);
            assertThat(isSame, is(true));
        }

        {
            // limit 5 result
            Integer[] resultContainer = ElementFilter.filter(5, testArray, new Integer[5], new ElementFilter.Filter<String>() {
                @Override
                public boolean isAccept(String s) {
                    return "7".equals(s);
                }
            }, new ElementFilter.Converter<String, Integer>() {
                @Override
                public Integer convert(String s) {
                    return Integer.parseInt(s);
                }
            });

            Integer[] expectContainer = new Integer[5];
            for (int i = 0; i < 5; i++) {
                expectContainer[i] = 7;
            }

            boolean isSame = Arrays.equals(resultContainer, expectContainer);
            assertThat(isSame, is(true));
        }

        {
            // array length not enough
            try {
                ElementFilter.filter(5, testArray, new Integer[4], new ElementFilter.Filter<String>() {
                    @Override
                    public boolean isAccept(String s) {
                        return "7".equals(s);
                    }
                }, new ElementFilter.Converter<String, Integer>() {
                    @Override
                    public Integer convert(String s) {
                        return Integer.parseInt(s);
                    }
                });
                fail();
            } catch (ArrayIndexOutOfBoundsException e) {
                assertThat(e.getMessage(), equalTo("try to write value to index 4, but array's length == 4 (index = 0-3)"));
            }
        }

        /*
        Argument Check Test
        */
        // limit result count less -1
        try {
            ElementFilter.filter(-2, (String[]) null, (Integer[]) null, (ElementFilter.Filter<String>) null, (ElementFilter.Converter<String, Integer>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // sources be null
        try {
            ElementFilter.filter(ElementFilter.FILTER_ELEMENT_NUM_UNLIMIT, (String[]) null, (Integer[]) null, (ElementFilter.Filter<String>) null, (ElementFilter.Converter<String, Integer>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // container be null
        try {
            ElementFilter.filter(ElementFilter.FILTER_ELEMENT_NUM_UNLIMIT, testArray, (Integer[]) null, (ElementFilter.Filter<String>) null, (ElementFilter.Converter<String, Integer>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // filter be null
        try {
            ElementFilter.filter(ElementFilter.FILTER_ELEMENT_NUM_UNLIMIT, testArray, new Integer[1], (ElementFilter.Filter<String>) null, (ElementFilter.Converter<String, Integer>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // converter be null
        try {
            ElementFilter.filter(ElementFilter.FILTER_ELEMENT_NUM_UNLIMIT, testArray, new Integer[1], new ElementFilter.Filter<String>() {
                @Override
                public boolean isAccept(String s) {
                    return false;
                }
            }, (ElementFilter.Converter<String, Integer>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void filter11() throws Exception {
        /*
        feature test
         */
        {
            // unlimit result num
            Integer[] resultContainer = ElementFilter.filter(ElementFilter.FILTER_ELEMENT_NUM_UNLIMIT, testList, new Integer[7], new ElementFilter.Filter<String>() {
                @Override
                public boolean isAccept(String s) {
                    return "7".equals(s);
                }
            }, new ElementFilter.Converter<String, Integer>() {
                @Override
                public Integer convert(String s) {
                    return Integer.parseInt(s);
                }
            });

            Integer[] expectContainer = new Integer[7];
            for (int i = 0; i < 7; i++) {
                expectContainer[i] = 7;
            }

            boolean isSame = Arrays.equals(resultContainer, expectContainer);
            assertThat(isSame, is(true));
        }

        {
            // limit 5 result
            Integer[] resultContainer = ElementFilter.filter(5, testList, new Integer[5], new ElementFilter.Filter<String>() {
                @Override
                public boolean isAccept(String s) {
                    return "7".equals(s);
                }
            }, new ElementFilter.Converter<String, Integer>() {
                @Override
                public Integer convert(String s) {
                    return Integer.parseInt(s);
                }
            });

            Integer[] expectContainer = new Integer[5];
            for (int i = 0; i < 5; i++) {
                expectContainer[i] = 7;
            }

            boolean isSame = Arrays.equals(resultContainer, expectContainer);
            assertThat(isSame, is(true));
        }

        {
            // array length not enough
            try {
                ElementFilter.filter(5, testList, new Integer[4], new ElementFilter.Filter<String>() {
                    @Override
                    public boolean isAccept(String s) {
                        return "7".equals(s);
                    }
                }, new ElementFilter.Converter<String, Integer>() {
                    @Override
                    public Integer convert(String s) {
                        return Integer.parseInt(s);
                    }
                });
                fail();
            } catch (ArrayIndexOutOfBoundsException e) {
                assertThat(e.getMessage(), equalTo("try to write value to index 4, but array's length == 4 (index = 0-3)"));
            }
        }

        /*
        Argument Check Test
         */
        // limit result count less -1
        try {
            ElementFilter.filter(-2, (Iterable<String>) null, (Integer[]) null, (ElementFilter.Filter<String>) null, (ElementFilter.Converter<String, Integer>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // sources be null
        try {
            ElementFilter.filter(ElementFilter.FILTER_ELEMENT_NUM_UNLIMIT, (Iterable<String>) null, (Integer[]) null, (ElementFilter.Filter<String>) null, (ElementFilter.Converter<String, Integer>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // container be null
        try {
            ElementFilter.filter(ElementFilter.FILTER_ELEMENT_NUM_UNLIMIT, testList, (Integer[]) null, (ElementFilter.Filter<String>) null, (ElementFilter.Converter<String, Integer>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // filter be null
        try {
            ElementFilter.filter(ElementFilter.FILTER_ELEMENT_NUM_UNLIMIT, testList, new Integer[1], (ElementFilter.Filter<String>) null, (ElementFilter.Converter<String, Integer>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // converter be null
        try {
            ElementFilter.filter(ElementFilter.FILTER_ELEMENT_NUM_UNLIMIT, testList, new Integer[1], new ElementFilter.Filter<String>() {
                @Override
                public boolean isAccept(String s) {
                    return false;
                }
            }, (ElementFilter.Converter<String, Integer>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void filter12() throws Exception {
        /*
        feature test
         */
        {
            // unlimit result num
            List<String> resultContainer = ElementFilter.filter(testArray, new ElementFilter.Filter<String>() {
                @Override
                public boolean isAccept(String s) {
                    return "7".equals(s);
                }
            });

            ArrayList<String> expectContainer = new ArrayList<>();
            for (int i = 0; i < 7; i++) {
                expectContainer.add(String.valueOf(7));
            }

            boolean isSame = expectContainer.equals(resultContainer);
            assertThat(isSame, is(true));
        }

        /*
        Argument Check Test
        */
        // sources be null
        try {
            ElementFilter.filter((String[]) null, (ElementFilter.Filter<String>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // filter be null
        try {
            ElementFilter.filter(testArray, (ElementFilter.Filter<String>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void filter13() throws Exception {
        /*
        feature test
        */
        {
            List<String> resultContainer = ElementFilter.filter(testList, new ElementFilter.Filter<String>() {
                @Override
                public boolean isAccept(String s) {
                    return "7".equals(s);
                }
            });

            ArrayList<String> expectContainer = new ArrayList<>();
            for (int i = 0; i < 7; i++) {
                expectContainer.add(String.valueOf(7));
            }

            boolean isSame = expectContainer.equals(resultContainer);
            assertThat(isSame, is(true));
        }

        /*
        Argument Check Test
         */
        // sources be null
        try {
            ElementFilter.filter((Iterable<String>) null, (ElementFilter.Filter<String>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // filter be null
        try {
            ElementFilter.filter(testList, (ElementFilter.Filter<String>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }
    }


    @Test
    public void filter14() throws Exception {
        /*
        feature test
         */
        {
            // unlimit result num
            List<Integer> resultContainer = ElementFilter.filter(testArray, new ElementFilter.Filter<String>() {
                @Override
                public boolean isAccept(String s) {
                    return "7".equals(s);
                }
            }, new ElementFilter.Converter<String, Integer>() {
                @Override
                public Integer convert(String s) {
                    return Integer.parseInt(s);
                }
            });

            ArrayList<Integer> expectContainer = new ArrayList<>();
            for (int i = 0; i < 7; i++) {
                expectContainer.add(7);
            }

            boolean isSame = expectContainer.equals(resultContainer);
            assertThat(isSame, is(true));
        }

        /*
        Argument Check Test
        */
        // sources be null
        try {
            ElementFilter.filter((String[]) null, (ElementFilter.Filter<String>) null, (ElementFilter.Converter<String, Integer>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // filter be null
        try {
            ElementFilter.filter(testArray, (ElementFilter.Filter<String>) null, (ElementFilter.Converter<String, Integer>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // converter be null
        try {
            ElementFilter.filter(testArray, new ElementFilter.Filter<String>() {
                @Override
                public boolean isAccept(String s) {
                    return false;
                }
            }, (ElementFilter.Converter<String, Integer>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void filter15() throws Exception {
        /*
        feature test
         */
        {
            List<Integer> resultContainer = ElementFilter.filter(testList, new ElementFilter.Filter<String>() {
                @Override
                public boolean isAccept(String s) {
                    return "7".equals(s);
                }
            }, new ElementFilter.Converter<String, Integer>() {
                @Override
                public Integer convert(String s) {
                    return Integer.parseInt(s);
                }
            });

            ArrayList<Integer> expectContainer = new ArrayList<>();
            for (int i = 0; i < 7; i++) {
                expectContainer.add(7);
            }

            boolean isSame = expectContainer.equals(resultContainer);
            assertThat(isSame, is(true));
        }

        /*
        Argument Check Test
         */
        // sources be null
        try {
            ElementFilter.filter((Iterable<String>) null, (ElementFilter.Filter<String>) null, (ElementFilter.Converter<String, Integer>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // filter be null
        try {
            ElementFilter.filter(testList, (ElementFilter.Filter<String>) null, (ElementFilter.Converter<String, Integer>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // converter be null
        try {
            ElementFilter.filter(testList, new ElementFilter.Filter<String>() {
                @Override
                public boolean isAccept(String s) {
                    return false;
                }
            }, (ElementFilter.Converter<String, Integer>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void filter16() throws Exception {
        /*
        feature test
         */
        {
            // unlimit result num
            List<Integer> resultContainer = ElementFilter.filter(ElementFilter.FILTER_ELEMENT_NUM_UNLIMIT, testArray, new ElementFilter.Filter<String>() {
                @Override
                public boolean isAccept(String s) {
                    return "7".equals(s);
                }
            }, new ElementFilter.Converter<String, Integer>() {
                @Override
                public Integer convert(String s) {
                    return Integer.parseInt(s);
                }
            });

            ArrayList<Integer> expectContainer = new ArrayList<>();
            for (int i = 0; i < 7; i++) {
                expectContainer.add(7);
            }

            boolean isSame = expectContainer.equals(resultContainer);
            assertThat(isSame, is(true));
        }

        {
            // limit 5 result
            List<Integer> resultContainer = ElementFilter.filter(5, testArray, new ElementFilter.Filter<String>() {
                @Override
                public boolean isAccept(String s) {
                    return "7".equals(s);
                }
            }, new ElementFilter.Converter<String, Integer>() {
                @Override
                public Integer convert(String s) {
                    return Integer.parseInt(s);
                }
            });

            ArrayList<Integer> expectContainer = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                expectContainer.add(7);
            }

            boolean isSame = expectContainer.equals(resultContainer);
            assertThat(isSame, is(true));
        }

        /*
        Argument Check Test
        */
        // limit result count less -1
        try {
            ElementFilter.filter(-2, (String[]) null, (ElementFilter.Filter<String>) null, (ElementFilter.Converter<String, Integer>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // sources be null
        try {
            ElementFilter.filter(ElementFilter.FILTER_ELEMENT_NUM_UNLIMIT, (String[]) null, (ElementFilter.Filter<String>) null, (ElementFilter.Converter<String, Integer>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // filter be null
        try {
            ElementFilter.filter(ElementFilter.FILTER_ELEMENT_NUM_UNLIMIT, testArray, (ElementFilter.Filter<String>) null, (ElementFilter.Converter<String, Integer>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // converter be null
        try {
            ElementFilter.filter(ElementFilter.FILTER_ELEMENT_NUM_UNLIMIT, testArray, new ElementFilter.Filter<String>() {
                @Override
                public boolean isAccept(String s) {
                    return false;
                }
            }, (ElementFilter.Converter<String, Integer>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    public void filter17() throws Exception {
        /*
        feature test
         */
        {
            // unlimit result num
            List<Integer> resultContainer = ElementFilter.filter(ElementFilter.FILTER_ELEMENT_NUM_UNLIMIT, testList, new ElementFilter.Filter<String>() {
                @Override
                public boolean isAccept(String s) {
                    return "7".equals(s);
                }
            }, new ElementFilter.Converter<String, Integer>() {
                @Override
                public Integer convert(String s) {
                    return Integer.parseInt(s);
                }
            });

            ArrayList<Integer> expectContainer = new ArrayList<>();
            for (int i = 0; i < 7; i++) {
                expectContainer.add(7);
            }

            boolean isSame = expectContainer.equals(resultContainer);
            assertThat(isSame, is(true));
        }

        {
            // limit 5 result
            List<Integer> resultContainer = ElementFilter.filter(5, testList, new ElementFilter.Filter<String>() {
                @Override
                public boolean isAccept(String s) {
                    return "7".equals(s);
                }
            }, new ElementFilter.Converter<String, Integer>() {
                @Override
                public Integer convert(String s) {
                    return Integer.parseInt(s);
                }
            });

            ArrayList<Integer> expectContainer = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                expectContainer.add(7);
            }

            boolean isSame = expectContainer.equals(resultContainer);
            assertThat(isSame, is(true));
        }

        /*
        Argument Check Test
         */
        // limit result count less -1
        try {
            ElementFilter.filter(-2, (Iterable<String>) null, (ElementFilter.Filter<String>) null, (ElementFilter.Converter<String, Integer>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // sources be null
        try {
            ElementFilter.filter(ElementFilter.FILTER_ELEMENT_NUM_UNLIMIT, (Iterable<String>) null, (ElementFilter.Filter<String>) null, (ElementFilter.Converter<String, Integer>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // filter be null
        try {
            ElementFilter.filter(ElementFilter.FILTER_ELEMENT_NUM_UNLIMIT, testList, (ElementFilter.Filter<String>) null, (ElementFilter.Converter<String, Integer>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // converter be null
        try {
            ElementFilter.filter(ElementFilter.FILTER_ELEMENT_NUM_UNLIMIT, testList, new ElementFilter.Filter<String>() {
                @Override
                public boolean isAccept(String s) {
                    return false;
                }
            }, (ElementFilter.Converter<String, Integer>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }
    }

    private static <T> T[] arrayConvert(List<? extends Object> sources, Class<T> resultTypeClass) {

        T[] resultArr = (T[]) Array.newInstance(resultTypeClass, sources.size());

        for (int i = 0; i < sources.size(); i++) {
            resultArr[i] = (T) sources.get(i);
        }

        return resultArr;
    }
}