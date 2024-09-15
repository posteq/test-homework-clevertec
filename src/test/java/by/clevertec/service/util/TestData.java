package by.clevertec.service.util;

import by.clevertec.commom.CakeType;
import by.clevertec.domain.Cake;
import by.clevertec.entity.CakeEntity;

import java.time.OffsetDateTime;
import java.util.UUID;

public class TestData {
    public static CakeEntity generateCakeEntity(){
        return new CakeEntity(
                UUID.randomUUID(),
                "cake",
                CakeType.SMALL,
                OffsetDateTime.now());
    }

    public static Cake generateCake(){
        return new Cake(
                UUID.randomUUID(),
                "cakeTest",
                CakeType.SMALL,
                OffsetDateTime.now());
    }
}
