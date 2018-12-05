package cn.f_ms.library.logic;

/**
 * product creator
 *
 * @author f_ms
 * @date 18-12-5
 */
public interface Creater<Argument, Product> {
    /**
     * create product
     *
     * @param argument argument
     * @return product
     */
    Product create(Argument argument);
}
