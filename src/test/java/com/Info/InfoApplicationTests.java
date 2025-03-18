package com.Info;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
@AutoConfigureMockMvc
class InfoApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void contextLoads() {
    }

    @Test
    void mainPage()
            throws Exception {
        mockMvc.perform(get("http://localhost:8080/main"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }

    @Test
    void allTables()
            throws Exception {
        mockMvc.perform(get("http://localhost:8080/all_tables"))
                .andExpect(status().isOk())
                .andExpect(view().name("all_tables"));
    }

    @Test
    void allProcedures()
            throws Exception {
        mockMvc.perform(get("http://localhost:8080/procedures"))
                .andExpect(status().isOk())
                .andExpect(view().name("procedures"));
    }
}
