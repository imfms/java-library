package cn.f_ms.library.logic;

/**
 * action wrapper
 *
 * @author f_ms
 * @date 18-10-10
 */
public interface Action<Arg, Return> {
    /**
     * on action happended
     * @param arg arg
     * @return return type
     */
    Return onAction(Arg arg);
}
