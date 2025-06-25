package com.tenco.blog.board;


import com.tenco.blog.user.User;
import lombok.Data;

/*
* 클라이언트에게 넘어온 데이터를 
* Object로 변환해서 전달하는 DTO 역할을 담당한다*/
public class BoardRequest {

    // 게시글 저장 DTO
    @Data
    public static class SaveDTO {
        private String title;
        private String content;
        // username 제거 : 세선에서 가져올 예정

        // (User) <-- toEntity() 호출할 때 세선에서 가져와서 넣어 주면 됨
        public Board toEntity(User user) {
            return Board.builder()
                    .title(this.title)
                    .user(user)
                    .content(this.content)
                    .build();
        }

        public void validate() {
            if(title == null || title.trim().isEmpty()){
                throw new IllegalArgumentException("제목은 필수야");
            }

            if(content == null || content.trim().isEmpty()){
                throw new IllegalArgumentException("제목은 필수야");
            }

        }

    }

    // 게시글 수정용 DTO 설계
    @Data
    public static class UpdateDTO {
        private String title;
        private String content;

        // toEntity 메서드 안 만들 예정 (더티 체킹 활용)
        // em.find() <--- Board <-- 영속화 <-- 상태값을 변경하면 자동 갱신

        public void validate() {
            if(title == null || title.trim().isEmpty()){
                throw new IllegalArgumentException("제목은 필수야");
            }

            if(content == null || content.trim().isEmpty()){
                throw new IllegalArgumentException("제목은 필수야");
            }

        }
    }

}
