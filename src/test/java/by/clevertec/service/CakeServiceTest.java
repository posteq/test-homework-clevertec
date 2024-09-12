package by.clevertec.service;

import by.clevertec.domain.Cake;
import by.clevertec.entity.CakeEntity;
import by.clevertec.mapper.CakeMapper;
import by.clevertec.repository.CakeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CakeServiceTest {
    @Mock
    private CakeRepository cakeRepository;
    @Mock
    private CakeMapper cakeMapper;
    @InjectMocks
    private CakeService cakeService;

//    @BeforeEach
//    void setup(){
//        cakeRepository = mock(CakeRepository.class);
//        cakeMapper = mock(CakeMapper.class);
//        cakeService = new CakeService(cakeRepository,cakeMapper);
//    }

    @Test
    void shouldGetCakes() {
        //given
        CakeEntity cakeEntity = new CakeEntity();

        List<CakeEntity> cakeEntities = List.of(cakeEntity);
        List<Cake> cakes = List.of(new Cake());

        when(cakeRepository.getCakes())
                .thenReturn(List.of(cakeEntity));
        when(cakeMapper.toDomains(cakeEntities))
                .thenReturn(cakes);
        //when
        List<Cake> actualCakes = cakeService.getCakes();
        //then
        assertFalse(actualCakes.isEmpty());
    }

    @Test
    void shouldGetCakeById() {
        //given
        UUID cakeId = UUID.randomUUID();
        //when
        Cake actualCake = cakeService.getCakeById(cakeId);
        //then
    }

    @Test
    void shouldCreate() {
    }

    @Test
    void shouldUpdate() {
    }

    @Test
    void shouldDelete() {
    }
}