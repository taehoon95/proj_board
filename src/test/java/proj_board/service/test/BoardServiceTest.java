package proj_board.service.test;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import proj_board.config.ContextRoot;
import proj_board.dto.BoardVO;
import proj_board.service.BoardService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ContextRoot.class})
@WebAppConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BoardServiceTest {

	private static final Log log = LogFactory.getLog(BoardServiceTest.class);
	
	@Autowired
	private BoardService service;
	
	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Test
	public void test1Register() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		
		BoardVO board = new BoardVO();
		board.setTitle("새로 작성하는 글12");
		board.setWriter("newMember2");
		board.setContent("새로 작성하는 내용2");
		service.register(board);
		
		log.debug(board.getBno()+"");
	}

	@Test
	public void test2Get() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		
		service.get(11L);
	}

	@Test
	public void test3Modify() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		BoardVO board = new BoardVO();
		board.setBno(12L);
		board.setTitle("수정 하는 글2");
		board.setWriter("updateMember2");
		board.setContent("수정 하는 내용2");
		boolean res = service.modify(board);
		Assert.assertEquals(true,res);
	}

	@Test
	public void test5Remove() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		boolean res = service.remove(13L);
		Assert.assertEquals(true, res);
	}

//	@Test
//	public void test4GetList() {
//		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
//		Assert.assertNotNull(service.getList());
//	}

}
