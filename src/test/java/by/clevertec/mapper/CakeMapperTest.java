package by.clevertec.mapper;

import by.clevertec.commom.CakeType;
import by.clevertec.domain.Cake;
import by.clevertec.entity.CakeEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CakeMapperTest {

    @Mock
    CakeMapper cakeMapper;

    @Test
    void shouldMapToDomain() {
        //given
        UUID cakeId = UUID.randomUUID();
        CakeEntity cakeEntity = new CakeEntity(cakeId, "cake1", CakeType.SMALL, OffsetDateTime.now());
        Cake cake = new Cake(cakeId, "cake1", CakeType.SMALL, OffsetDateTime.now());

        when(cakeMapper.toDomain(cakeEntity)).thenReturn(cake);

        //when
        Cake result = cakeMapper.toDomain(cakeEntity);
        //then
        assertNotNull(cake);
        assertEquals(cake, result);
    }

    @Test
    void shouldMapToDomains() {
        //given
        UUID cakeId = UUID.randomUUID();
        CakeEntity cakeEntity = new CakeEntity(cakeId, "cake2", CakeType.SMALL, OffsetDateTime.now());
        Cake cake = new Cake(cakeId, "cake2", CakeType.SMALL, OffsetDateTime.now());

        List<CakeEntity> cakeEntities = List.of(cakeEntity);
        List<Cake> cakes = List.of(cake);

        when(cakeMapper.toDomains(cakeEntities)).thenReturn(cakes);

        //when
        List<Cake> result = cakeMapper.toDomains(cakeEntities);
        //then
        assertNotNull(cake);
        assertEquals(cake, result.getFirst());
    }

    @Test
    void shouldMapToEntity() {
        //given
        UUID cakeId = UUID.randomUUID();
        CakeEntity cakeEntity = new CakeEntity(cakeId, "cake3", CakeType.SMALL, OffsetDateTime.now());
        Cake cake = new Cake(cakeId, "cake3", CakeType.SMALL, OffsetDateTime.now());

        when(cakeMapper.toEntity(cake)).thenReturn(cakeEntity);

        //when
        CakeEntity result = cakeMapper.toEntity(cake);
        //then
        assertNotNull(cake);
        assertEquals(cakeEntity, result);
    }
}