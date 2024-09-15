package by.clevertec.entity;

import by.clevertec.commom.CakeType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@Accessors(chain = true)
@AllArgsConstructor
public class CakeEntity {
    private UUID id;
    private String title;
    private CakeType cakeType;
    private OffsetDateTime expiredPeriod;

}
