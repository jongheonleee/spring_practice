package com.example.pattern.template;

// 기존의 LineCallbackGeneric의 추상화 레벨을 더 올림
// Integer 타입으로 고정된 부분을 Generic을 통해 추상화시킴
public interface LineCallbackGeneric <T> {
    T doSomethingWithLine(String line, T value);
}
