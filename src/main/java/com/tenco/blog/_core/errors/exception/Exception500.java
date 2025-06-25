package com.tenco.blog._core.errors.exception;

// 500 Internal Server Error 상황에서 사용할 커스텀 예외 클래스

public class Exception500 extends RuntimeException{

    public Exception500(String message) {
        super(message);
    }

    // 데이터 베이스 오류, 연결 실패, 파일 처리 중 오류
}
