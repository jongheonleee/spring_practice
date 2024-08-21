package com.example.pattern.template;

/**
 * - 파일의 각 라인과 현재까지 계산한 값을 넘겨주도록 되어있음
 * - 새로운 계산 결과를 리턴 값을 통해 다시 전달
 */

public interface LineCallback {
    Integer doSomethingWithLine(String line, Integer value);
}
