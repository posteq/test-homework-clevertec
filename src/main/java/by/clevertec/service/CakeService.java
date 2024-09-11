package by.clevertec.service;

import by.clevertec.domain.Cake;
import by.clevertec.entity.CakeEntity;
import by.clevertec.mapper.CakeMapper;
import by.clevertec.mapper.CakeMapperImpl;
import by.clevertec.repository.CakeRepository;

import java.util.List;
import java.util.UUID;

public class CakeService {
    private final CakeRepository cakeRepository = new CakeRepository();
    private final CakeMapper cakeMapper = new CakeMapperImpl();

    public List<Cake> getCakes(){
        return null;
    }

    public Cake getCakeById(UUID cakeId){
        return new Cake();
    }

    public Cake create(Cake cake){
        return cake;
    }

    public Cake update(UUID cakeId , Cake newCake){
        return new Cake();
    }

    public void delete(UUID cakeId){
        //without body
    }

}
