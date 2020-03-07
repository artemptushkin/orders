package ru.example.coyul.single.responsibility.better;

public interface Converter<S, T> {
    T convert(S value);
}
