package com.example.Calculating_next_number.Controller;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import com.example.Calculating_next_number.Request.UserRequestBody;
import com.example.Calculating_next_number.Response.NextNumberResponse;
import com.example.Calculating_next_number.Service.NextNumberService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {NextNumberController.class})
@ExtendWith(SpringExtension.class)
class NextNumberControllerTest {
    @Autowired
    private NextNumberController nextNumberController;

    @MockBean
    private NextNumberService nextNumberService;

    @Test
    void testFetchNextNumber() throws Exception {
        when(nextNumberService.operations((UserRequestBody) any())).thenReturn(new NextNumberResponse(1, 42, 42));

        UserRequestBody userRequestBody = new UserRequestBody();
        userRequestBody.setCategoryCode(1);
        String content = (new ObjectMapper()).writeValueAsString(userRequestBody);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/FetchNextNumber")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(nextNumberController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"categoryCode\":1,\"oldValue\":42,\"newValue\":42}"));
    }
}

