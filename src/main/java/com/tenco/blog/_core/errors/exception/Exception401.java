package com.tenco.blog._core.errors.exception;

// 401 UnAuthorized 상황에서 사용할 커스텀 예외 클래스
public class Exception401 extends RuntimeException{

    public Exception401(String message) {
        super(message);
    }

    // 로그인이 필요한, 세션이 만료

}
