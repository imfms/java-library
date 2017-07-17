package cn.f_ms.logic_library;

public interface Converter<Source, Target> {
  Target convert(Source source);
}