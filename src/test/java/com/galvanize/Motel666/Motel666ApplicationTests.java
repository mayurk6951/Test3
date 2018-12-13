package com.galvanize.Motel666;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Motel666ApplicationTests {

	@Autowired
	private MockMvc mocmvc;

	@MockBean
	MotelRepo motelRepo;

	@Before
	public void setup() {

	}
	@Test
	public void contextLoads() {
	}

	@Test
	public void test_getAllbyTT() throws Exception {
		MotelEntity objf = new MotelEntity();
		when(motelRepo.save(objf)).thenReturn(objf);
		mocmvc.perform(MockMvcRequestBuilders.get("event/1544401072/1544401077"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andDo(print());

		verify(motelRepo, times(1)).save(isA(MotelEntity.class));
		verifyNoMoreInteractions(motelRepo);

	}

	@Test
	public void test_getAllbyUID() throws Exception {
		MotelEntity objf = new MotelEntity();
		when(motelRepo.save(objf)).thenReturn(objf);
		mocmvc.perform(MockMvcRequestBuilders.get("event/1b468f7d-79e8-40c1-80a2-0dd7226e7771"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andDo(print());

		verify(motelRepo, times(1)).save(isA(MotelEntity.class));
		verifyNoMoreInteractions(motelRepo);

	}

	@Test
	public void test_getAllbyTTNoCrud() throws Exception {
		MotelEntity objf = new MotelEntity();
		when(motelRepo.save(objf)).thenReturn(objf);
		mocmvc.perform(MockMvcRequestBuilders.get("event/1544401072/1544401077"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
				.andDo(print());

		verify(motelRepo, times(1)).save(isA(MotelEntity.class));
		verifyNoMoreInteractions(motelRepo);

	}
}

