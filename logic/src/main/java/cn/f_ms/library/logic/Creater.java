package cn.f_ms.library.logic;

/**
 * product creater
 *
 * @author f_ms
 * @date 18-11-22
 * @deprecated {@link Creator}
 */
@Deprecated
public interface Creater<Product> {
    /**
     * create product
     *
     * @return product
     */
    Product create();
}
