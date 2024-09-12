package by.clevertec.service;

import by.clevertec.domain.Cake;
import by.clevertec.entity.CakeEntity;
import by.clevertec.exeption.CakeNotFoundException;
import by.clevertec.mapper.CakeMapper;
import by.clevertec.repository.CakeRepository;

import by.clevertec.service.util.TestData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

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
        List<CakeEntity> cakeEntities = List.of(TestData.generateCakeEntity());
        List<Cake> cakes = List.of(new Cake());

        when(cakeRepository.getCakes())
                .thenReturn(cakeEntities);
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
        CakeEntity cakeEntity = new CakeEntity();
        Cake newCake = new Cake();
        when(cakeRepository.getCakeById(cakeId))
                .thenReturn(Optional.of(cakeEntity));
        when(cakeMapper.toDomain(cakeEntity))
                .thenReturn(newCake);
        //when
        Cake actualCake = cakeService.getCakeById(cakeId);
        //then

        assertEquals(newCake,actualCake);
    }

    @Test
    void shouldNotGetCakeById_WhenNotFound() {
        //given
        UUID cakeId = UUID.randomUUID();
//        CakeEntity cakeEntity = new CakeEntity();
//        Cake newCake = new Cake();
        when(cakeRepository.getCakeById(cakeId))
                .thenReturn(Optional.empty());
//        when(cakeMapper.toDomain(cakeEntity))
//                .thenReturn(newCake);
        //when then
        assertThrows(
                CakeNotFoundException.class,
                () -> cakeService.getCakeById(cakeId)
        );
    }

    @Test
    void shouldCreate() {
    }

    @Test
    void shouldUpdate() {
    }

    @Test
    void shouldDelete() {
        UUID cakeId = UUID.randomUUID();

        cakeService.delete(cakeId);
    }
}