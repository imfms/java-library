package cn.f_ms.library.logic;

/**
 * named action wrapper
 *
 * @author f_ms
 * @date 18-10-10
 */
public interface NamedAction<Arg, Return> extends Action<Arg, Return> {

    /**
     * get action's name
     *
     * @return action's name
     */
    String getName();
}
