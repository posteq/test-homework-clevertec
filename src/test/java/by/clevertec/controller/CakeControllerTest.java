package by.clevertec.controller;

import by.clevertec.domain.Cake;
import by.clevertec.service.CakeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest
class CakeControllerTest {

    @MockBean
    private CakeService cakeService;
    @Autowired
    private MockMvc mockMvc;
    @Test
    void shouldFindAll() throws Exception {
        //given
        when(cakeService.getCakes())
                .thenReturn(List.of(new Cake() , new Cake()));
    //when
        mockMvc.perform(get("/api/v1/cakes"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2));
        //then

    }
}