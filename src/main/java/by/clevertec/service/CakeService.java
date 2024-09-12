package by.clevertec.service;

import by.clevertec.domain.Cake;
import by.clevertec.entity.CakeEntity;
import by.clevertec.mapper.CakeMapper;
import by.clevertec.repository.CakeRepository;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
public class CakeService {
    private CakeRepository cakeRepository;
    private CakeMapper cakeMapper;

    public List<Cake> getCakes(){
        List<CakeEntity> cakes = cakeRepository.getCakes();
        return cakeMapper.toDomains(cakes);
    }

    public Cake getCakeById(UUID cakeId){
        CakeEntity cake = cakeRepository.getCakeById(cakeId);
        return cakeMapper.toDomain(cake);
    }

    public Cake create(Cake cake){
        CakeEntity cakeEntity = cakeMapper.toEntity(cake);
        CakeEntity createdEntity = cakeRepository.create(cakeEntity);
        return cakeMapper.toDomain(createdEntity);
    }

    public Cake update(UUID cakeId , Cake newCake){
        CakeEntity cakeEntity = cakeMapper.toEntity(newCake);
        CakeEntity updateEntity = cakeRepository.update(cakeId,cakeEntity);
        return cakeMapper.toDomain(updateEntity);
    }

    public void delete(UUID cakeId){
        cakeRepository.delete(cakeId);
    }

}
