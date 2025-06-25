package com.tenco.blog.board;

import com.tenco.blog.user.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;

@Import(BoardRepository.class)
@DataJpaTest
public class BoardRepositoryTest {

    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void deleteById_JPQL_삭제_테스트() {
        // given
        Long deleteId = 1L;

        // when
        boardRepository.deleteById(deleteId);

        // then
        List<Board> boardList = boardRepository.findByAll();
        Assertions.assertThat(boardList.size()).isEqualTo(9);

    }


}
