package by.clevertec.controller;

import by.clevertec.commom.CakeType;
import by.clevertec.domain.Cake;
import by.clevertec.service.CakeService;

import by.clevertec.service.util.TestData;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class CakeControllerTest {

    @MockBean
    private CakeService cakeService;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldFindAll() throws Exception {
        //given
        when(cakeService.getCakes())
                .thenReturn(List.of(new Cake(UUID.randomUUID(),"cake1", CakeType.BIG, OffsetDateTime.now()) ,
                        new Cake(UUID.randomUUID(),"cake2", CakeType.SMALL, OffsetDateTime.now().plusDays(3)),
                        new Cake(UUID.randomUUID(),"cake3", CakeType.SMALL, OffsetDateTime.now())
                ));

        //when
        //then
        mockMvc.perform(get("/api/v1/cakes"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(3))
                .andExpect(jsonPath("$.[0].cakeType").value(CakeType.BIG.toString()))
                .andExpect(jsonPath("$.[2].cakeType").value(CakeType.SMALL.toString()))
                .andExpect(jsonPath("$.[0].title").value("cake1"));
    }


    @Test
    void shouldNotGetById_WhenCakeIsEmpty() throws Exception{
        //given
        when(cakeService.getCakeById(UUID.randomUUID())).thenReturn(new Cake());

        //when
        //then
        mockMvc.perform(get("/api/v1/cakes/cakeId"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void shouldFindUserById() throws Exception {
        //given
        Cake cake = TestData.generateCake();
        UUID cakeId = cake.getId();
        when(cakeService.getCakeById(any(UUID.class)))
                .thenReturn(cake);

        //when
        //then
        mockMvc.perform(get("/api/v1/cakes/{cakeId}", cakeId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(cakeId.toString()));
    }

    @Test
    void shouldCreate() throws Exception{
       //given
        Cake cake = TestData.generateCake();

        when(cakeService.create(any(Cake.class)))
                .thenReturn(cake);

        //when
        //then
        mockMvc.perform(post("/api/v1/cakes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(cake)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.title").value(cake.getTitle()));
    }

    @Test
    void shouldUpdate() throws Exception{
        //given
        Cake cake = TestData.generateCake();
        UUID cakeId = cake.getId();
        when(cakeService.update(any(UUID.class),any(Cake.class)))
                .thenReturn(cake);

        //when
        //then
        mockMvc.perform(put("/api/v1/cakes/{cakeId}", cakeId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(cake)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(cakeId.toString()))
                .andExpect(jsonPath("$.title").value(cake.getTitle()));
    }

    @Test
    void shouldDelete() throws Exception {
        //given
        UUID cakeId = UUID.randomUUID();

        //when
        //then
        mockMvc.perform(delete("/api/v1/cakes/{cakeId}", cakeId))
                .andExpect(status().isNoContent());
    }
}