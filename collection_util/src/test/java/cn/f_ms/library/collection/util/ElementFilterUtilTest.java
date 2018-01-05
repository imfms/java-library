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
 * ElementFilterUtilTest
 *
 * @author f_ms
 * @date 17-12-21
 */
public class ElementFilterUtilTest {

    private List<String> testList;
    private String[] testArray;

    private ElementFilterUtil.Filter<String> testFilter = new ElementFilterUtil.Filter<String>() {
        @Override
        public boolean isAccept(String s) {
            return false;
        }
    };
    private ElementFilterUtil.Converter<String, Integer> testConverter = new ElementFilterUtil.Converter<String, Integer>() {
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
            ElementFilterUtil.filterFirst((Iterable<?>) null, new ElementFilterUtil.Filter<Object>() {
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
            ElementFilterUtil.filterFirst((Iterable<?>) null, new ElementFilterUtil.Filter<Object>() {
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
    public void filterFirst2() throws Exception {
        /*
        Argument Check Test
         */
        try {
            ElementFilterUtil.filterFirst((Object[]) null, new ElementFilterUtil.Filter<Object>() {
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
            ElementFilterUtil.filterFirst(testArray, null);

            fail();
        } catch (IllegalArgumentException e) {
            // throw exception is right
        }

        /*
        feature test
         */
        String result7 = ElementFilterUtil.filterFirst(testArray, new ElementFilterUtil.Filter<String>() {
            @Override
            public boolean isAccept(String s) {
                return "7".equals(s);
            }
        });
        assertThat(result7, CoreMatchers.equalTo("7"));

        String result11 = ElementFilterUtil.filterFirst(testArray, new ElementFilterUtil.Filter<String>() {
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
            ElementFilterUtil.filterFirst((Object[]) null, new ElementFilterUtil.Filter<Object>() {
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
            ElementFilterUtil.filterFirst(testArray, null, new ElementFilterUtil.Converter<String, Object>() {
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
            ElementFilterUtil.filterFirst(testArray, new ElementFilterUtil.Filter<String>() {
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
        Integer result7 = ElementFilterUtil.filterFirst(testArray, new ElementFilterUtil.Filter<String>() {
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

        Integer result11 = ElementFilterUtil.filterFirst(testArray, new ElementFilterUtil.Filter<String>() {
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
        argument check test
         */

        // sources be null
        try {
            ElementFilterUtil.convert((String[])null, (ArrayList<Integer>)null, (ElementFilterUtil.Converter<String, Integer>)null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // result container be null
        try {
            ElementFilterUtil.convert(testArray, (ArrayList<Integer>)null, (ElementFilterUtil.Converter<String, Integer>)null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // converter be null
        try {
            ElementFilterUtil.convert(testArray, new ArrayList<Integer>(), (ElementFilterUtil.Converter<String, Integer>)null);
            fail();
        } catch (IllegalArgumentException e) {
        }

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
            ElementFilterUtil.convert((Iterable<String>)null, (ArrayList<Integer>)null, (ElementFilterUtil.Converter<String, Integer>)null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // result container be null
        try {
            ElementFilterUtil.convert(testList, (ArrayList<Integer>)null, (ElementFilterUtil.Converter<String, Integer>)null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // converter be null
        try {
            ElementFilterUtil.convert(testList, new ArrayList<Integer>(), (ElementFilterUtil.Converter<String, Integer>)null);
            fail();
        } catch (IllegalArgumentException e) {
        }

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
            ElementFilterUtil.convert((String[])null, (Class<Integer>)null, (ElementFilterUtil.Converter<String, Integer>)null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // result container be null
        try {
            ElementFilterUtil.convert(testArray, (Class<Integer>)null, (ElementFilterUtil.Converter<String, Integer>)null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // converter be null
        try {
            ElementFilterUtil.convert(testArray, Integer.class, (ElementFilterUtil.Converter<String, Integer>)null);
            fail();
        } catch (IllegalArgumentException e) {
        }

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
            ElementFilterUtil.convert((String[])null, (Integer[])null, (ElementFilterUtil.Converter<String, Integer>)null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // result container be null
        try {
            ElementFilterUtil.convert(testArray, (Integer[])null, (ElementFilterUtil.Converter<String, Integer>)null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // converter be null
        try {
            ElementFilterUtil.convert(testArray, new Integer[1], (ElementFilterUtil.Converter<String, Integer>)null);
            fail();
        } catch (IllegalArgumentException e) {
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
            ElementFilterUtil.convert(
                    testArray,
                    new Integer[testArray.length - 1],
                    new ElementFilterUtil.Converter<String, Integer>() {
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
            ElementFilterUtil.convert((Collection<String>)null, (Class<Integer>)null, (ElementFilterUtil.Converter<String, Integer>)null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // result container be null
        try {
            ElementFilterUtil.convert(testList, (Class<Integer>)null, (ElementFilterUtil.Converter<String, Integer>)null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // converter be null
        try {
            ElementFilterUtil.convert(testList, Integer.class, (ElementFilterUtil.Converter<String, Integer>)null);
            fail();
        } catch (IllegalArgumentException e) {
        }

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
            ElementFilterUtil.convert((Iterable<String>)null, (Integer[])null, (ElementFilterUtil.Converter<String, Integer>)null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // result container be null
        try {
            ElementFilterUtil.convert(testList, (Integer[])null, (ElementFilterUtil.Converter<String, Integer>)null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // converter be null
        try {
            ElementFilterUtil.convert(testList, new Integer[1], (ElementFilterUtil.Converter<String, Integer>)null);
            fail();
        } catch (IllegalArgumentException e) {
        }

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
            ElementFilterUtil.convert(
                    testList,
                    new Integer[testList.size() - 1],
                    new ElementFilterUtil.Converter<String, Integer>() {
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
    public void filter() throws Exception {
        /*
        feature test
         */
        {
            // unlimit result num
            ArrayList<String> resultContainer = ElementFilterUtil.filter(testArray, new ArrayList<String>(), new ElementFilterUtil.Filter<String>() {
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
            ElementFilterUtil.filter((String[]) null, (ArrayList<String>) null, (ElementFilterUtil.Filter<String>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // container be null
        try {
            ElementFilterUtil.filter(testArray, (ArrayList<String>) null, (ElementFilterUtil.Filter<String>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // filter be null
        try {
            ElementFilterUtil.filter(testArray, new ArrayList<String>(), (ElementFilterUtil.Filter<String>) null);
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
            ArrayList<String> resultContainer = ElementFilterUtil.filter(testList, new ArrayList<String>(), new ElementFilterUtil.Filter<String>() {
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
            ElementFilterUtil.filter((Iterable<String>) null, (ArrayList<String>) null, (ElementFilterUtil.Filter<String>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // container be null
        try {
            ElementFilterUtil.filter(testList, (ArrayList<String>) null, (ElementFilterUtil.Filter<String>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // filter be null
        try {
            ElementFilterUtil.filter(testList, new ArrayList<String>(), (ElementFilterUtil.Filter<String>) null);
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
            String[] resultContainer = ElementFilterUtil.filter(testArray, new String[7], new ElementFilterUtil.Filter<String>() {
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
                ElementFilterUtil.filter(testArray, new String[4], new ElementFilterUtil.Filter<String>() {
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
            ElementFilterUtil.filter((String[]) null, (String[]) null, (ElementFilterUtil.Filter<String>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // container be null
        try {
            ElementFilterUtil.filter(testArray, (String[]) null, (ElementFilterUtil.Filter<String>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // filter be null
        try {
            ElementFilterUtil.filter(testArray, new String[1], (ElementFilterUtil.Filter<String>) null);
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
            String[] resultContainer = ElementFilterUtil.filter(testList, new String[7], new ElementFilterUtil.Filter<String>() {
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
                ElementFilterUtil.filter(testList, new String[4], new ElementFilterUtil.Filter<String>() {
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
            ElementFilterUtil.filter((Iterable<String>) null, (String[]) null, (ElementFilterUtil.Filter<String>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // container be null
        try {
            ElementFilterUtil.filter(testList, (String[]) null, (ElementFilterUtil.Filter<String>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // filter be null
        try {
            ElementFilterUtil.filter(testList, new String[1], (ElementFilterUtil.Filter<String>) null);
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
            ArrayList<Integer> resultContainer = ElementFilterUtil.filter(testArray, new ArrayList<Integer>(), new ElementFilterUtil.Filter<String>() {
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
            ElementFilterUtil.filter((String[]) null, (ArrayList<Integer>) null, (ElementFilterUtil.Filter<String>) null, (ElementFilterUtil.Converter<String, Integer>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // container be null
        try {
            ElementFilterUtil.filter(testArray, (ArrayList<Integer>) null, (ElementFilterUtil.Filter<String>) null, (ElementFilterUtil.Converter<String, Integer>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // filter be null
        try {
            ElementFilterUtil.filter(testArray, new ArrayList<Integer>(), (ElementFilterUtil.Filter<String>) null, (ElementFilterUtil.Converter<String, Integer>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // converter be null
        try {
            ElementFilterUtil.filter(testArray, new ArrayList<Integer>(), new ElementFilterUtil.Filter<String>() {
                @Override
                public boolean isAccept(String s) {
                    return false;
                }
            }, (ElementFilterUtil.Converter<String, Integer>) null);
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
            ArrayList<Integer> resultContainer = ElementFilterUtil.filter(testList, new ArrayList<Integer>(), new ElementFilterUtil.Filter<String>() {
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
            ElementFilterUtil.filter((Iterable<String>) null, (ArrayList<Integer>) null, (ElementFilterUtil.Filter<String>) null, (ElementFilterUtil.Converter<String, Integer>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // container be null
        try {
            ElementFilterUtil.filter(testList, (ArrayList<Integer>) null, (ElementFilterUtil.Filter<String>) null, (ElementFilterUtil.Converter<String, Integer>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // filter be null
        try {
            ElementFilterUtil.filter(testList, new ArrayList<Integer>(), (ElementFilterUtil.Filter<String>) null, (ElementFilterUtil.Converter<String, Integer>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // converter be null
        try {
            ElementFilterUtil.filter(testList, new ArrayList<Integer>(), new ElementFilterUtil.Filter<String>() {
                @Override
                public boolean isAccept(String s) {
                    return false;
                }
            }, (ElementFilterUtil.Converter<String, Integer>) null);
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
            Integer[] resultContainer = ElementFilterUtil.filter(testArray, new Integer[7], new ElementFilterUtil.Filter<String>() {
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
                ElementFilterUtil.filter(testArray, new Integer[4], new ElementFilterUtil.Filter<String>() {
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
            ElementFilterUtil.filter((String[]) null, (Integer[]) null, (ElementFilterUtil.Filter<String>) null, (ElementFilterUtil.Converter<String, Integer>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // container be null
        try {
            ElementFilterUtil.filter(testArray, (Integer[]) null, (ElementFilterUtil.Filter<String>) null, (ElementFilterUtil.Converter<String, Integer>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // filter be null
        try {
            ElementFilterUtil.filter(testArray, new Integer[1], (ElementFilterUtil.Filter<String>) null, (ElementFilterUtil.Converter<String, Integer>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // converter be null
        try {
            ElementFilterUtil.filter(testArray, new Integer[1], new ElementFilterUtil.Filter<String>() {
                @Override
                public boolean isAccept(String s) {
                    return false;
                }
            }, (ElementFilterUtil.Converter<String, Integer>) null);
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
            Integer[] resultContainer = ElementFilterUtil.filter(testList, new Integer[7], new ElementFilterUtil.Filter<String>() {
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
                ElementFilterUtil.filter(testList, new Integer[4], new ElementFilterUtil.Filter<String>() {
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
            ElementFilterUtil.filter((Iterable<String>) null, (Integer[]) null, (ElementFilterUtil.Filter<String>) null, (ElementFilterUtil.Converter<String, Integer>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // container be null
        try {
            ElementFilterUtil.filter(testList, (Integer[]) null, (ElementFilterUtil.Filter<String>) null, (ElementFilterUtil.Converter<String, Integer>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // filter be null
        try {
            ElementFilterUtil.filter(testList, new Integer[1], (ElementFilterUtil.Filter<String>) null, (ElementFilterUtil.Converter<String, Integer>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // converter be null
        try {
            ElementFilterUtil.filter(testList, new Integer[1], new ElementFilterUtil.Filter<String>() {
                @Override
                public boolean isAccept(String s) {
                    return false;
                }
            }, (ElementFilterUtil.Converter<String, Integer>) null);
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
            ArrayList<Integer> resultContainer = ElementFilterUtil.filter(ElementFilterUtil.FILTER_ELEMENT_NUM_UNLIMIT, testArray, new ArrayList<Integer>(), new ElementFilterUtil.Filter<String>() {
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

            ArrayList<Integer> expectContainer = new ArrayList<>();
            for (int i = 0; i < 7; i++) {
                expectContainer.add(7);
            }

            boolean isSame = expectContainer.equals(resultContainer);
            assertThat(isSame, is(true));
        }

        {
            // limit 5 result
            ArrayList<Integer> resultContainer = ElementFilterUtil.filter(5, testArray, new ArrayList<Integer>(), new ElementFilterUtil.Filter<String>() {
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
            ElementFilterUtil.filter(-2, (String[]) null, (ArrayList<Integer>) null, (ElementFilterUtil.Filter<String>) null, (ElementFilterUtil.Converter<String, Integer>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // sources be null
        try {
            ElementFilterUtil.filter(ElementFilterUtil.FILTER_ELEMENT_NUM_UNLIMIT, (String[]) null, (ArrayList<Integer>) null, (ElementFilterUtil.Filter<String>) null, (ElementFilterUtil.Converter<String, Integer>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // container be null
        try {
            ElementFilterUtil.filter(ElementFilterUtil.FILTER_ELEMENT_NUM_UNLIMIT, testArray, (ArrayList<Integer>) null, (ElementFilterUtil.Filter<String>) null, (ElementFilterUtil.Converter<String, Integer>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // filter be null
        try {
            ElementFilterUtil.filter(ElementFilterUtil.FILTER_ELEMENT_NUM_UNLIMIT, testArray, new ArrayList<Integer>(), (ElementFilterUtil.Filter<String>) null, (ElementFilterUtil.Converter<String, Integer>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // converter be null
        try {
            ElementFilterUtil.filter(ElementFilterUtil.FILTER_ELEMENT_NUM_UNLIMIT, testArray, new ArrayList<Integer>(), new ElementFilterUtil.Filter<String>() {
                @Override
                public boolean isAccept(String s) {
                    return false;
                }
            }, (ElementFilterUtil.Converter<String, Integer>) null);
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
            ArrayList<Integer> resultContainer = ElementFilterUtil.filter(ElementFilterUtil.FILTER_ELEMENT_NUM_UNLIMIT, testList, new ArrayList<Integer>(), new ElementFilterUtil.Filter<String>() {
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

            ArrayList<Integer> expectContainer = new ArrayList<>();
            for (int i = 0; i < 7; i++) {
                expectContainer.add(7);
            }

            boolean isSame = expectContainer.equals(resultContainer);
            assertThat(isSame, is(true));
        }

        {
            // limit 5 result
            ArrayList<Integer> resultContainer = ElementFilterUtil.filter(5, testList, new ArrayList<Integer>(), new ElementFilterUtil.Filter<String>() {
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
            ElementFilterUtil.filter(-2, (Iterable<String>) null, (ArrayList<Integer>) null, (ElementFilterUtil.Filter<String>) null, (ElementFilterUtil.Converter<String, Integer>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // sources be null
        try {
            ElementFilterUtil.filter(ElementFilterUtil.FILTER_ELEMENT_NUM_UNLIMIT, (Iterable<String>) null, (ArrayList<Integer>) null, (ElementFilterUtil.Filter<String>) null, (ElementFilterUtil.Converter<String, Integer>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // container be null
        try {
            ElementFilterUtil.filter(ElementFilterUtil.FILTER_ELEMENT_NUM_UNLIMIT, testList, (ArrayList<Integer>) null, (ElementFilterUtil.Filter<String>) null, (ElementFilterUtil.Converter<String, Integer>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // filter be null
        try {
            ElementFilterUtil.filter(ElementFilterUtil.FILTER_ELEMENT_NUM_UNLIMIT, testList, new ArrayList<Integer>(), (ElementFilterUtil.Filter<String>) null, (ElementFilterUtil.Converter<String, Integer>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // converter be null
        try {
            ElementFilterUtil.filter(ElementFilterUtil.FILTER_ELEMENT_NUM_UNLIMIT, testList, new ArrayList<Integer>(), new ElementFilterUtil.Filter<String>() {
                @Override
                public boolean isAccept(String s) {
                    return false;
                }
            }, (ElementFilterUtil.Converter<String, Integer>) null);
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
            Integer[] resultContainer = ElementFilterUtil.filter(ElementFilterUtil.FILTER_ELEMENT_NUM_UNLIMIT, testArray, new Integer[7], new ElementFilterUtil.Filter<String>() {
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

            Integer[] expectContainer = new Integer[7];
            for (int i = 0; i < 7; i++) {
                expectContainer[i] = 7;
            }

            boolean isSame = Arrays.equals(resultContainer, expectContainer);
            assertThat(isSame, is(true));
        }

        {
            // limit 5 result
            Integer[] resultContainer = ElementFilterUtil.filter(5, testArray, new Integer[5], new ElementFilterUtil.Filter<String>() {
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
                ElementFilterUtil.filter(5, testArray, new Integer[4], new ElementFilterUtil.Filter<String>() {
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
            ElementFilterUtil.filter(-2, (String[]) null, (Integer[]) null, (ElementFilterUtil.Filter<String>) null, (ElementFilterUtil.Converter<String, Integer>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // sources be null
        try {
            ElementFilterUtil.filter(ElementFilterUtil.FILTER_ELEMENT_NUM_UNLIMIT, (String[]) null, (Integer[]) null, (ElementFilterUtil.Filter<String>) null, (ElementFilterUtil.Converter<String, Integer>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // container be null
        try {
            ElementFilterUtil.filter(ElementFilterUtil.FILTER_ELEMENT_NUM_UNLIMIT, testArray, (Integer[]) null, (ElementFilterUtil.Filter<String>) null, (ElementFilterUtil.Converter<String, Integer>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // filter be null
        try {
            ElementFilterUtil.filter(ElementFilterUtil.FILTER_ELEMENT_NUM_UNLIMIT, testArray, new Integer[1], (ElementFilterUtil.Filter<String>) null, (ElementFilterUtil.Converter<String, Integer>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // converter be null
        try {
            ElementFilterUtil.filter(ElementFilterUtil.FILTER_ELEMENT_NUM_UNLIMIT, testArray, new Integer[1], new ElementFilterUtil.Filter<String>() {
                @Override
                public boolean isAccept(String s) {
                    return false;
                }
            }, (ElementFilterUtil.Converter<String, Integer>) null);
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
            Integer[] resultContainer = ElementFilterUtil.filter(ElementFilterUtil.FILTER_ELEMENT_NUM_UNLIMIT, testList, new Integer[7], new ElementFilterUtil.Filter<String>() {
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

            Integer[] expectContainer = new Integer[7];
            for (int i = 0; i < 7; i++) {
                expectContainer[i] = 7;
            }

            boolean isSame = Arrays.equals(resultContainer, expectContainer);
            assertThat(isSame, is(true));
        }

        {
            // limit 5 result
            Integer[] resultContainer = ElementFilterUtil.filter(5, testList, new Integer[5], new ElementFilterUtil.Filter<String>() {
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
                ElementFilterUtil.filter(5, testList, new Integer[4], new ElementFilterUtil.Filter<String>() {
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
            ElementFilterUtil.filter(-2, (Iterable<String>) null, (Integer[]) null, (ElementFilterUtil.Filter<String>) null, (ElementFilterUtil.Converter<String, Integer>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // sources be null
        try {
            ElementFilterUtil.filter(ElementFilterUtil.FILTER_ELEMENT_NUM_UNLIMIT, (Iterable<String>) null, (Integer[]) null, (ElementFilterUtil.Filter<String>) null, (ElementFilterUtil.Converter<String, Integer>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // container be null
        try {
            ElementFilterUtil.filter(ElementFilterUtil.FILTER_ELEMENT_NUM_UNLIMIT, testList, (Integer[]) null, (ElementFilterUtil.Filter<String>) null, (ElementFilterUtil.Converter<String, Integer>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // filter be null
        try {
            ElementFilterUtil.filter(ElementFilterUtil.FILTER_ELEMENT_NUM_UNLIMIT, testList, new Integer[1], (ElementFilterUtil.Filter<String>) null, (ElementFilterUtil.Converter<String, Integer>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }

        // converter be null
        try {
            ElementFilterUtil.filter(ElementFilterUtil.FILTER_ELEMENT_NUM_UNLIMIT, testList, new Integer[1], new ElementFilterUtil.Filter<String>() {
                @Override
                public boolean isAccept(String s) {
                    return false;
                }
            }, (ElementFilterUtil.Converter<String, Integer>) null);
            fail();
        } catch (IllegalArgumentException e) {
        }
    }

    public static <T> T[] arrayConvert(List<? extends Object> sources, Class<T> resultTypeClass) {

        T[] resultArr = (T[]) Array.newInstance(resultTypeClass, sources.size());

        for (int i = 0; i < sources.size(); i++) {
            resultArr[i] = (T) sources.get(i);
        }

        return resultArr;
    }
}