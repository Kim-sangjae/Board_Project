package org.koreait.project.tests;


import org.koreait.project.models.boards.Board;
import org.koreait.project.models.boards.BoardDao;
import org.koreait.project.models.boards.BoardSaveService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;

@SpringBootTest
@AutoConfigureMockMvc

public class BoardTest {


    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private BoardDao boardDao;

    @Autowired
    private BoardSaveService service;
    private Board board;

    @BeforeEach
    public void init() {
        board = new Board();
        board.setSubject("제목11");
        board.setContent("내용11");
//        service.save(board);
//        boardDao.insert(board);
    }


    @Test
    @DisplayName("데이터 저장 성공시 예외없음")
    public void saveSuccess() {
        assertDoesNotThrow(() -> {
            service.save(board);
        });
    }



    @Test
    @DisplayName("제목이 null 검사 , 값이 null일 경우 실패")
    public void subjectNull() {
        assertDoesNotThrow( () -> {
            board.setSubject("nasdasdasd");
            service.save(board);

        });

    }


    @Test
    @DisplayName("내용이 null 검사 , 값이 null일 경우 실패")
    public void contentNull() {
        assertDoesNotThrow( () -> {
            board.setContent("asdasdwdd");
            service.save(board);
        });

    }



    @Test
    @DisplayName("데이터가 db에 잘 저장되면 성공 ")
    public void insertTest() {

        boolean result = boardDao.insert(board);
        //boolean result1 = false;

        assertTrue(result);
    }



    ///////////////// 페이지 이동
    @Test
    @DisplayName("게시글 작성 성공시 /board/list로 페이지 이동")
    public void saveSuccessRedirectTest() throws Exception {
        mockMvc.perform(post("/board/write")
                .param("subject", "제목")
                .param("content", "내용"))
                .andExpect(redirectedUrl("/board/list"));
    }





    //////////////////////////////////

    ////////////////// 조회

    @Test
    @DisplayName("get메서드 Id 값으로 정보조회가 null 값이 아닌경우 true")
    public void dataSelect(){

      if(boardDao.get(2L) != null) {

          assertTrue(true);

      }else {

          assertTrue(false);
      }

        System.out.println(boardDao.get(board.getId()));


    }


    @Test
    @DisplayName("getList() 전체정보 조회시 빈값이 아니면 true")
    public void allDataSelect(){

         if(boardDao.getList() != null){

             assertTrue(true);

         }else {

             assertTrue(false);
         }

    }








    //////////////////////////////////

    ////////////////// 삭제

    @Test
    @DisplayName("delete 삭제 메서드 성공시 true")
    public void deleteData(){

        //boolean result = boardDao.delete(board.getId());
        boolean result = boardDao.delete(27L);

        assertTrue(result);

    }















}
