package cn.f_ms.logic_library;

/**
 * 输入|输出
 *
 * @author imf_m
 * @time 2017/7/22
 */

public interface InputOutput<InputData, OutputData> {

    void input(InputData inputData);

    OutputData output();

}
