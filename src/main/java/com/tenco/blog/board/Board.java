package com.tenco.blog.board;

import com.tenco.blog.user.User;
import com.tenco.blog.util.MyDateUtil;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;


@NoArgsConstructor// JPA 에서 엔티티는 기본 생성자가 필요하다
@AllArgsConstructor
@Builder
@Data
// @Table : 실제 데이터베이스 테이블 명을 지정할 때 사용
@Table(name = "board_tb") // 데이터베이스에서 테이블 이름을 지정해줌(찾음)
// @Entity : JPA 가 이 클래스를 데이터베이스 테이블과 맵핑하는 객체(엔티티)로 인식
@Entity
public class Board {

    private static final Logger log = LoggerFactory.getLogger(Board.class);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private String content;

    // V2에서 사용했던 방식
    // private String username;
    // V3에서 Board 엔티티는 User 엔티티와 연관관계가 성립이 된다.

    // 다대일
    // 여러개의 게시글에는 한명의 작성자를 가질 수 있다.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id") // 외래키 컬럼명 명시
    private User user;

    

    @CreationTimestamp // 하이버 네이트가 제공하는 어노테이션
    private Timestamp createdAt;

    public Board(String title, String content, String username) {
        this.title = title;
        this.content = content;
        // this.username = username;
    }

    // 게시글에 소유자를 직접 확인하는 기능을 만들자
    public boolean isOwner(Long checkUserId) {
        log.info("게시글 소유자 확인 요청 - 작성자 : {}", checkUserId);
        return this.user.getId().equals(checkUserId);
    }

    // 머스테치에서 포현할 시간을 포맷기능을 (행위) 스르로 만들자
    public String getTime(){

        return MyDateUtil.timestampFormat(createdAt);
    }
}
