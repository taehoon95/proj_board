package proj_board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proj_board.dto.BoardVO;
import proj_board.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardMapper mapper;
	
	@Override
	public void register(BoardVO board) {
		mapper.insert(board);
	}

	@Override
	public BoardVO get(Long bno) {
		return mapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO board) {
		int res = mapper.update(board);
		if(res == 1) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean remove(Long bno) {
		int res = mapper.delete(bno);
		if(res == 1) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public List<BoardVO> getList() {
		return mapper.getList();
	}
	

}
