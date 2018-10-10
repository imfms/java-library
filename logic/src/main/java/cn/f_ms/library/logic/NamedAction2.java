package cn.f_ms.library.logic;

/**
 * named action wrapper
 *
 * @author f_ms
 * @date 18-10-10
 */
public abstract class NamedAction2<Arg, Return> implements NamedAction<Arg, Return> {

    private final String name;

    public NamedAction2() {
        this(null);
    }
    public NamedAction2(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

}
