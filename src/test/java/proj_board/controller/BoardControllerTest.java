package proj_board.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import proj_board.config.ContextRoot;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ContextRoot.class})
@WebAppConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BoardControllerTest {

	@Autowired
	private WebApplicationContext ctx;
	
	private MockMvc mockMvc;
	
	@Before
	public void setUp()  {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build(); 
	}

	@Test
	public void test01list() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/board/list")).andReturn().getModelAndView().getModelMap();
	}
	
	@Test
	public void test02Get() throws Exception{
		mockMvc.perform(MockMvcRequestBuilders.get("/board/get").param("bno", "2")).andReturn().getModelAndView().getModelMap();
	}

	@Test
	public void test03Modify() throws Exception{
		String resultPage = mockMvc.perform(
				MockMvcRequestBuilders.post("/board/modify")
				.param("bno", "1")
				.param("title", "방금 수정된 제목")
				.param("content", "방금 수정된 내용")
				.param("writer", "modiUser"))
				.andReturn()
				.getModelAndView()
				.getViewName();
		
		Assert.assertNotNull(resultPage);
	}
	
	@Test
	public void test04Remove() throws Exception{
		String resultPage = mockMvc.perform(
				MockMvcRequestBuilders.post("/board/remove")
				.param("bno", "14"))
				.andReturn()
				.getModelAndView()
				.getViewName();
		
		Assert.assertNotNull(resultPage);
	}

}
