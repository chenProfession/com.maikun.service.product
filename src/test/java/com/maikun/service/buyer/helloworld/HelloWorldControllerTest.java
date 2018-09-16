package com.maikun.service.buyer.helloworld;

import com.maikun.service.buyer.result.ResultService;
import com.maikun.service.buyer.result.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(HelloWorldController.class)
@Slf4j
public class HelloWorldControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ResultService resultService;

    @Test
    public void testSayHello() throws Exception {
        this.mvc.perform(get("/hello/sayhello").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("{'content':'Demo for Maikun Restful Web Service, welcome everyone !'}"));
    }

    @Test
    public void testGetResult() throws Exception {
        given(this.resultService.success()).willReturn(new ResultVO(0,"success"));
        String result = this.mvc.perform(get("/hello/result").accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        log.info(result);
    }

    @Test
    public void testSyncOrder() throws Exception {
        String result = this.mvc.perform(get("/hello/sync-order").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        log.info(result);
    }
}