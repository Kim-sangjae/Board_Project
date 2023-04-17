package org.koreait.project.models.boards;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

@RequiredArgsConstructor
@Component
public class BoardDao {


    private final JdbcTemplate jdbcTemplate;

    private Board boardMapper(ResultSet rs , int i ) throws SQLException {

        Board board = new Board();

        board.setId(rs.getLong("id"));
        board.setSubject(rs.getString("subject"));
        board.setContent(rs.getString("content"));
        board.setRegDt(rs.getTimestamp("regDt").toLocalDateTime());


        Timestamp modDt = rs.getTimestamp("modDt");
        if(modDt != null){
            board.setModDt(modDt.toLocalDateTime());
        }

        return board;
    };





    // 게시글 추가 메서드
    public boolean insert(Board board){
        String sql = "INSERT INTO BOARD (id , subject , content)" + "VALUES(seq_board.nextval,?,?)";
        int cnt = jdbcTemplate.update(sql,board.getSubject(),board.getContent());

        return cnt>0;
    }



    // 게시글 조회메서드
    public Board get(Long id){
        String sql = "SELECT * FROM BOARD WHERE ID = ?";
        Board board = jdbcTemplate.queryForObject(sql,this::boardMapper,id);

        return board;
    }



    // 테이블 전체정보 담기
    public List<Board> getList(){
        String sql = "SELECT * FROM BOARD ORDER BY ID";
        List<Board> list = jdbcTemplate.query(sql,this::boardMapper);

        return list;
    }




    // 데이터 삭제
    public boolean delete(Long id){
        String sql = "DELETE FROM BOARD WHERE ID = ?";
        Board board = this.get(id);

        int cnt = jdbcTemplate.update(sql, id);

        return cnt > 0;
    }










    private Board TimeMapper(ResultSet rs) throws SQLException {

        Board board = new Board();


        board.setRegDt(rs.getTimestamp("regDt").toLocalDateTime());


        return board;
    };







    //시간대별 카운드
//    public List<Board> countTime(){
//        String sql = "SELECT TO_CHAR(REGDT, 'YYYY-MM-DD HH24'), COUNT(*) FROM BOARD GROUP BY TO_CHAR(REGDT, 'YYYY-MM-DD HH24')";
//
//        //count time
//        List<Board> list = jdbcTemplate.query(sql,(rs,i)->{
//            Board bod = new Board();
//
//
//
//        });
//
//        return list;
//    }




}
