package cn.f_ms.library.logic;

/**
 * Input|Output
 *
 * @author imf_m
 * @date 2017/7/22
 */

public interface InputOutput<InputData, OutputData> {

    void input(InputData inputData);

    OutputData output();

}
