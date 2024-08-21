package com.example.pattern.template;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Calculator {

    /**
     * templates list
     * - 1. file read
     * - 2. line read
     * - 3. line read with generic
     */

    // 1. file read
    public Integer fileReadTemplate(String filepath, BufferedReaderCallback callback) throws IOException {
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(filepath));
            Integer result = callback.doSomethingWithReader(br);
            return result;
        }
        catch (IOException e) {
            System.out.println("e.getMessage() = " + e.getMessage());
            throw e;
        }
        finally {
            if (br != null) {
                try { br.close(); }
                catch (IOException e) { System.out.println("e.getMessage() = " + e.getMessage()); }
            }
        }
    }

    // 2. line read - 변경되는 부분 => 1. 초기값, 2. 라인별 처리(복합 할당문)
    public Integer lineReadTemplate(String filepath, LineCallback callback, int initVal) throws IOException {
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(filepath));
            Integer result = initVal; // 1. 초기값
            String line = null;

            while ((line = br.readLine()) != null) {
                result = callback.doSomethingWithLine(line, result); // 2. 라인별 처리(복합 할당문)
            }

            return result;
        }
        catch (IOException e) {
            System.out.println("e.getMessage() = " + e.getMessage());
            throw e;
        }
        finally {
            if (br != null) {
                try { br.close(); }
                catch (IOException e) { System.out.println("e.getMessage() = " + e.getMessage()); }
            }
        }
    }

    // 3. line read with generic
    public <T> T lineReadTemplateWithGeneric(String filepath, LineCallbackGeneric<T> callback, T initVal) throws IOException {
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(filepath));
            T result = initVal;
            String line = null;

            while ((line = br.readLine()) != null) {
                result = callback.doSomethingWithLine(line, result);
            }

            return result;
        }
        catch (IOException e) {
            System.out.println("e.getMessage() = " + e.getMessage());
            throw e;
        }
        finally {
            if (br != null) {
                try { br.close(); }
                catch (IOException e) { System.out.println("e.getMessage() = " + e.getMessage()); }
            }
        }
    }

    /**
     * features list
     * - 1. summing
     * - 2. multiplying
     * - 3. concatenate (문자열 생성)
     */

    // <Client> : Concrete CallBack, using Template, CallBack
    public Integer calcSum(String filepath) throws IOException {
        // <call-back>
        LineCallback sumCallback = new LineCallback() {
            @Override
            public Integer doSomethingWithLine(String line, Integer value) {
                return value + Integer.valueOf(line);
            }
        };

        // call & return
        return lineReadTemplate(filepath, sumCallback, 0);
    }

    public Integer calcMultiply(String filepath) throws IOException {
        // <call-back>
        LineCallback multiplyCallback = new LineCallback() {
            @Override
            public Integer doSomethingWithLine(String line, Integer value) {
                return value * Integer.valueOf(line);
            }
        };

        // call & return
        return lineReadTemplate(filepath, multiplyCallback, 1);

    }

    public String concatenate(String filepath) throws IOException {
        // <call-back>
        LineCallbackGeneric<String> concatenateCallback = new LineCallbackGeneric<String>() {
            @Override
            public String doSomethingWithLine(String line, String value) {
                return value + line;
            }
        };

        // call & return
        return lineReadTemplateWithGeneric(filepath, concatenateCallback, "");
    }
}
