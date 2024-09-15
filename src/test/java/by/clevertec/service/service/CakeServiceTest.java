package by.clevertec.service.service;

import by.clevertec.commom.helper.DataSupplier;
import by.clevertec.domain.Cake;
import by.clevertec.entity.CakeEntity;
import by.clevertec.exeption.CakeNotFoundException;
import by.clevertec.mapper.CakeMapper;
import by.clevertec.repository.CakeRepository;
import by.clevertec.service.CakeService;
import by.clevertec.service.util.DataSupplierTest;
import by.clevertec.service.util.TestData;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CakeServiceTest {
    @Mock
    private CakeRepository cakeRepository;
    @Mock
    private CakeMapper cakeMapper;
    @Spy
    private DataSupplier dataSupplier = new DataSupplierTest();
    @InjectMocks
    private CakeService cakeService;

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
        when(cakeRepository.getCakeById(cakeId))
                .thenReturn(Optional.empty());

        //when
        //then
        assertThrows(
                CakeNotFoundException.class,
                () -> cakeService.getCakeById(cakeId)
        );
    }

    @Test
    void shouldCreate() {
        //given
        UUID cakeId = UUID.randomUUID();
        Cake cake = TestData.generateCake().setId(cakeId);
        CakeEntity cakeEntity = TestData.generateCakeEntity().setId(cakeId);

        when(cakeRepository.create(cakeEntity))
                .thenReturn(cakeEntity);
        when(cakeMapper.toEntity(cake))
                .thenReturn(cakeEntity);
        when(cakeMapper.toDomain(cakeEntity))
                .thenReturn(cake);

        //when
        Cake actualCake = cakeService.create(cake);

        //then
        assertEquals(cake , actualCake);

    }

    @Test
    void shouldUpdate() {
        //given
        UUID newCakeId = UUID.randomUUID();
        CakeEntity cakeEntities = TestData.generateCakeEntity();
        Cake cake = new Cake();
        cake.setId(newCakeId);

        when(cakeRepository.update(newCakeId, cakeEntities))
                .thenReturn(Optional.of(cakeEntities));
        when(cakeMapper.toDomain(cakeEntities))
                .thenReturn(cake);
        when(cakeMapper.toEntity(cake))
                .thenReturn(cakeEntities);

        //when
        Cake actualCake = cakeService.update(newCakeId,cake);
        //then
        assertEquals(newCakeId , actualCake.getId());

    }

    @ParameterizedTest
    @NullSource
    void shouldNotUpdate_WhenCakeEntityNull(CakeEntity cakeEntities) {
        //given
        UUID newCakeId = UUID.randomUUID();
        Cake cake = new Cake();
        cake.setId(newCakeId);

        //when
        //then
        assertThrows(
                CakeNotFoundException.class,
                () -> cakeService.update(newCakeId,cake)
        );
    }

    @Test
    void shouldDelete() {
        //given
        UUID cakeId = UUID.randomUUID();
        //when
        cakeService.delete(cakeId);
        //then
        verify(cakeRepository).delete(cakeId);
    }
}