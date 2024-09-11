package by.clevertec.mapper;

import by.clevertec.domain.Cake;
import by.clevertec.entity.CakeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface CakeMapper {

    List<Cake> toCake(List<CakeEntity> cakeEntities);
}
