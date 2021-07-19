package proj_board.mapper;

import java.util.List;

import proj_board.dto.BoardVO;

public interface BoardMapper {

	/* @Select("select * from tbl_board where bno > 0") */
	public List<BoardVO> getList();

	public BoardVO read(Long bno);
	
	public int insert(BoardVO board);
	
	public int delete(Long bno);
	
	public int update(BoardVO board);
}
