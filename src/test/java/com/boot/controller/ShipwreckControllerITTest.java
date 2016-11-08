package com.boot.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.http.MediaType;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.boot.config.ApplicationConfig;
import com.boot.config.WebConfig;
/*
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebConfig.class, ApplicationConfig.class})
@ActiveProfiles({"h2"})
@TransactionConfiguration
@Transactional
@WebAppConfiguration
public class ShipwreckControllerITTest {

    MockMvc mockMvc;
	
	  @Autowired
	   ShipwreckController shipwreckController;

	   @Before
	    public void setUp() {
	        mockMvc = MockMvcBuilders
	                .standaloneSetup(shipwreckController)
	                .build();
	    }

	   @Test
	    public void shouldgetAllWrecks() throws Exception {

	        mockMvc
	                .perform(get("/api/v1/")
	                        .accept(MediaType.APPLICATION_JSON))
	                .andDo(MockMvcResultHandlers.print())
	                .andExpect(status().isOk())
	                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
	    }


	    @Test
	    public void shouldGetAccount() throws Exception {


	        mockMvc
	                .perform(get("/accounts/1")
	                        .accept(MediaType.APPLICATION_JSON))
	                .andExpect(status().isOk())
	                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
	    }


	    @Test
	    public void shouldGetAllAccounts() throws Exception {
	        when(accountServiceMock.getAllAccountNumbers()).thenReturn(Arrays.asList(1, 2));

	        mockMvc
	                .perform(get("/accounts")
	                        .accept(MediaType.APPLICATION_JSON))
	                .andExpect(status().isOk())
	                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
	                .andExpect(jsonPath("[0]").value(1))
	                .andExpect(jsonPath("[1]").value(2));
	    }


	    @Test
	    public void shouldDepositToAccount() throws Exception {
	        Map<String, Integer> body = Collections.singletonMap("amount", 50);
	        String json = toJsonString(body);

	        mockMvc
	                .perform(post("/accounts/1/deposit")
	                        .contentType(MediaType.APPLICATION_JSON)
	                        .content(json))
	                .andExpect(status().isNoContent());

	        verify(accountServiceMock).deposit(1, 50);
	    }


	    @Test
	    public void shouldDeleteAccount() throws Exception {
	        mockMvc
	                .perform(delete("/accounts/1"))
	                .andExpect(status().isNoContent());

	        verify(accountServiceMock).deleteAccount(1);
	    }


	    @Test
	    public void shouldNotDepositNegativeAmount() throws Exception {
	        Map<String, Integer> body = Collections.singletonMap("amount", -50);
	        String json = toJsonString(body);

	        mockMvc
	                .perform(post("/accounts/1/deposit")
	                        .contentType(MediaType.APPLICATION_JSON)
	                        .content(json))
	                .andExpect(status().isBadRequest());

	        verifyZeroInteractions(accountServiceMock);
	    }


	    @Test
	    public void shouldWithdrawFromAccount() throws Exception {
	        Map<String, Integer> body = Collections.singletonMap("amount", 50);
	        String json = toJsonString(body);

	        mockMvc
	                .perform(post("/accounts/1/withdraw")
	                        .accept(MediaType.APPLICATION_JSON)
	                        .contentType(MediaType.APPLICATION_JSON)
	                        .content(json))
	                .andExpect(status().isOk());

	        verify(accountServiceMock).withdraw(1, 50);
	    }


	    @Test
	    public void shouldNotWithdrawNegativeAmount() throws Exception {
	        Map<String, Integer> body = Collections.singletonMap("amount", -50);
	        String json = toJsonString(body);

	        mockMvc
	                .perform(post("/accounts/1/withdraw")
	                        .accept(MediaType.APPLICATION_JSON)
	                        .contentType(MediaType.APPLICATION_JSON)
	                        .content(json))
	                .andExpect(status().isBadRequest());

	        verifyZeroInteractions(accountServiceMock);
	    }

	    private String toJsonString(Map<String, ?> map) {
	        ObjectMapper objectMapper = new ObjectMapper();
	        try {
	            return objectMapper.writeValueAsString(map);
	        } catch (JsonProcessingException e) {
	            throw new RuntimeException(e);
	        }
	    }

}

*/