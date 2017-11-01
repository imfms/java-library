package cn.f_ms.library.logic;

import java.math.BigDecimal;

public class ArithmeticUtil {

    /**
     * add
     *
     * @param num1 firstValue
     * @param num2 secondValue
     * @return result
     */
    public static double add(double num1, double num2) {
        return new BigDecimal(Double.toString(num1))
                .add(new BigDecimal(Double.toString(num2)))
                .doubleValue();
    }

    /**
     * add
     *
     * @param num1 firstValue
     * @param num2 secondValue
     * @return result
     */
    public static String add(String num1, String num2) {
        return new BigDecimal(num1)
                .add(new BigDecimal(num2))
                .toString();
    }

    /**
     * sub
     *
     * @param num1 firstValue
     * @param num2 secondValue
     * @return result
     */
    public static double sub(double num1, double num2) {
        return new BigDecimal(Double.toString(num1))
                .subtract(new BigDecimal(Double.toString(num2)))
                .doubleValue();
    }

    /**
     * sub
     *
     * @param num1 firstValue
     * @param num2 secondValue
     * @return result
     */
    public static double sub(String num1, String num2) {
        return new BigDecimal(num1)
                .subtract(new BigDecimal(num2))
                .doubleValue();
    }

    /**
     * mul
     *
     * @param num1 firstValue
     * @param num2 secondValue
     * @return result
     */
    public static double mul(double num1, double num2) {
        return new BigDecimal(Double.toString(num1))
                .multiply(new BigDecimal(Double.toString(num2)))
                .doubleValue();
    }

    /**
     * mul
     *
     * @param num1 firstValue
     * @param num2 secondValue
     * @return result
     */
    public static double mul(String num1, String num2) {
        return new BigDecimal(num1)
                .multiply(new BigDecimal(num2))
                .doubleValue();
    }

    /**
     * 除法
     *
     * @param num1  firstValue
     * @param num2  secondValue
     * @param scale
     * @return result
     */
    public static double div(double num1, double num2, int scale) {
        return new BigDecimal(Double.toString(num1))
                .divide(new BigDecimal(Double.toString(num2)), scale)
                .doubleValue();
    }

    /**
     * 除法
     *
     * @param num1  firstValue
     * @param num2  secondValue
     * @param scale
     * @return result
     */
    public static double div(String num1, String num2, int scale) {
        return new BigDecimal(num1)
                .divide(new BigDecimal(num2), scale)
                .doubleValue();
    }

}
