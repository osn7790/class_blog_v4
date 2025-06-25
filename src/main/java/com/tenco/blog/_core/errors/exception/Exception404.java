package com.tenco.blog._core.errors.exception;

// 404 Not Found 상황에서 사용할 커스텀 예외 클래스
public class Exception404 extends RuntimeException{

    public Exception404(String message) {
        super(message);
    }

    // 요청한 리소스가 없을 때 ...
}
