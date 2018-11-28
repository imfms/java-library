package cn.f_ms.library.logic;

/**
 * name - value
 *
 * @author f_ms
 * @date 18-11-28
 */
public class NameValue<ValueType> {

    public final ValueType value;
    public final String name;

    public NameValue(String name, ValueType value) {
        this.name = name;
        this.value = value;
    }

}
