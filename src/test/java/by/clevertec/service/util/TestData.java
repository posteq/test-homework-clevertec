package by.clevertec.service.util;

import by.clevertec.commom.CakeType;
import by.clevertec.entity.CakeEntity;

import java.time.OffsetDateTime;
import java.util.UUID;

public class TestData {
    public static CakeEntity generateCakeEntity(){
        return new CakeEntity(
                UUID.randomUUID(),
                "cake",
                CakeType.SMALL,
                OffsetDateTime.now().plusDays(3));
    }
}
