package cn.f_ms.library.logic;

public interface Converter<Source, Target> {
  Target convert(Source source);
}