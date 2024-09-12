package by.clevertec.repository;

import by.clevertec.commom.CakeType;
import by.clevertec.entity.CakeEntity;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class CakeRepository {
    public static final  List<CakeEntity> db = List.of(
            new CakeEntity(UUID.randomUUID(),"cake1", CakeType.BIG, OffsetDateTime.now()),
            new CakeEntity(UUID.randomUUID(),"cake2", CakeType.BIG, OffsetDateTime.now()),
            new CakeEntity(UUID.randomUUID(),"cake3", CakeType.BIG, OffsetDateTime.now()),
            new CakeEntity(UUID.randomUUID(),"cake4", CakeType.SMALL, OffsetDateTime.now())
    );

    public List<CakeEntity> getCakes(){
        return db;
    }

    public Optional<CakeEntity> getCakeById(UUID cakeId){
        return Optional.of(db.get(0));
    }

    public CakeEntity create(CakeEntity cakeEntity){
        return cakeEntity;
    }

    public CakeEntity update(UUID cakeId , CakeEntity newCakeEntity){
        return newCakeEntity;
    }

    public void delete(UUID cakeId){
        //without body
    }
}
