package proj_board.service;

import java.util.List;

import proj_board.domain.Criteria;
import proj_board.dto.BoardVO;

public interface BoardService {
	
	public void register(BoardVO board);
	
	public BoardVO get(Long bno);
	
	public boolean modify(BoardVO board);
	
	public boolean remove(Long bno);
	
	/*페이징용*/
	public List<BoardVO> getList(Criteria cri);
}
