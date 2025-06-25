package com.tenco.blog._core.errors.exception;

// 403 Forbidden 상황에서 사용할 커스텀 예외 클래스

public class Exception403 extends RuntimeException{


    public Exception403(String message) {
        super(message);
    }

    // 권한 없음.(본인이 작성한 게시글만 수정 가능)
    // 관리자만 접근 가능한 페이지

}
