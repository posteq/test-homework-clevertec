package by.clevertec.repository;

import by.clevertec.commom.CakeType;
import by.clevertec.entity.CakeEntity;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

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

    public CakeEntity getCakeById(UUID cakeId){
        return db.get(0);
    }

    public CakeEntity
}
