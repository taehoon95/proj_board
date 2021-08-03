package proj_board.mapper.test;

import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import proj_board.config.ContextRoot;
import proj_board.domain.Criteria;
import proj_board.dto.BoardVO;
import proj_board.mapper.BoardMapper;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ContextRoot.class})
@WebAppConfiguration
public class BoardMapperTest {
	
	private static final Log log = LogFactory.getLog(BoardMapperTest.class);

	@Autowired
	private BoardMapper mapper;
	
	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

//	@Test
//	public void testGetList() {
//		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
//		Assert.assertNotNull(mapper.getList());
//	}
//	
//	@Test
//	public void testInsert() {
//		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
//		BoardVO board = new BoardVO();
//		board.setTitle("새로 작성하는 글12");
//		board.setWriter("newMember2");
//		board.setContent("새로 작성하는 내용2");
//		int res = mapper.insert(board);
//		Assert.assertEquals(1,res);
//	}
//
//	@Test
//	public void testRead() {
//		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
//		Assert.assertNotNull(mapper.read(11L));
//	}
//	
//	@Test
//	public void testDelete() {
//		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
//		Assert.assertNotNull(mapper.delete(14L));
//	}
//
//	@Test
//	public void testUpdate() {
//		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
//		BoardVO board = new BoardVO();
//		board.setBno(12L);
//		board.setTitle("수정 하는 글2");
//		board.setWriter("updateMember2");
//		board.setContent("수정 하는 내용2");
//		int res = mapper.update(board);
//		Assert.assertEquals(1,res);
//	}
	
	@Test
	public void testPaging() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		
		Criteria cri = new Criteria();
		cri.setAmount(10);
		cri.setPageNum(1);
		List<BoardVO> list = mapper.getListWithPaging(cri);
		
		Assert.assertNotNull(list);
	}
}
