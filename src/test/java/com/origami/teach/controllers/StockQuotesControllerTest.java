package com.origami.teach.controllers;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.origami.teach.applications.SpringBoot;
import com.origami.teach.util.DatabaseUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBoot.class)
@AutoConfigureMockMvc
public class StockQuotesControllerTest {
    @Autowired
    private MockMvc mvc;


    private void initDb() throws Exception {
        DatabaseUtils.initializeDatabase(DatabaseUtils.initializationFile);
    }

    @Before
    public void setUp() throws Exception {
        initDb();
    }

    @After
    public void tearDown() throws Exception {
        initDb();
    }

    @Test
    public void getStockQuotes() throws Exception {
        String url = "/api/StockQuotes/GetStockQuotes?symbol=GOOG&from=2019-01-01&until=2019-12-31";
        String expectedResult = "[{\"id\":1,\"price\":85.00,\"date\":\"2019-08-19T00:00:00.000+0000\",\"symbol\":\"GOOG\"},{\"id\":2,\"price\":527.35,\"date\":\"2019-02-03T00:00:00.000+0000\",\"symbol\":\"GOOG\"}]";

        mvc.perform(MockMvcRequestBuilders.get(url)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().string(equalTo(expectedResult)));
    }
}
