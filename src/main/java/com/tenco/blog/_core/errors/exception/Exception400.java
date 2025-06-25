package com.tenco.blog._core.errors.exception;

// 400 Bad Request 상황에서 사용할 커스텀 예외 클래스
// RuntimeException 상속하여 처리
public class Exception400 extends RuntimeException{

    // 에러 메세지로 사용할 문자열을 super 클래스에게 전달
    public Exception400(String message) {
        super(message);
    }

    // 예시 - throw new Exception400("잘못된 요청이야");
    // 필수 입력 항목이 누락, 올바르지 않은 데이터 형식

}
