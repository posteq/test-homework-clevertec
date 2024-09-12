package by.clevertec.mapper;

import by.clevertec.domain.Cake;
import by.clevertec.entity.CakeEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface CakeMapper {

    List<Cake> toDomains(List<CakeEntity> cakeEntities);
    Cake toDomain(CakeEntity cakeEntity);
    CakeEntity toEntity(Cake cake);
}
