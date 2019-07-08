package com.sample.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sample.api.controller.UserController;
import com.sample.api.dto.User;
import com.sample.api.repository.UserRespository;
import org.apache.http.entity.ContentType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.Base64Utils;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UserRespository userRespository;

	@Test
	public void shouldAddNewUserTest() throws Exception {
		User newUser = new User.Builder()
				.setId(11L)
				.setFirstName("Denisio")
				.setLastName("CoolMan")
				.setEmail("coolman@gmail.com")
				.setPassword("310892")
				.setAwesome(true).build();

		given(userRespository.save(newUser)).willReturn(newUser);

        this.mockMvc.perform(MockMvcRequestBuilders
        		.post("/users")
				.header(HttpHeaders.AUTHORIZATION, "Basic " + Base64Utils.encodeToString("dklopyshko:310892".getBytes()))
				.header(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(newUser)))
				.andDo(print())
				.andExpect(status().isCreated());
	}
}
