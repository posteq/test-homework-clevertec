package by.clevertec.mapper;

import by.clevertec.domain.Cake;
import by.clevertec.entity.CakeEntity;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-11T17:11:54+0300",
    comments = "version: 1.6.0, compiler: javac, environment: Java 21.0.4 (Oracle Corporation)"
)
public class CakeMapperImpl implements CakeMapper {

    @Override
    public List<Cake> toDomains(List<CakeEntity> cakeEntities) {
        if ( cakeEntities == null ) {
            return null;
        }

        List<Cake> list = new ArrayList<Cake>( cakeEntities.size() );
        for ( CakeEntity cakeEntity : cakeEntities ) {
            list.add( toDomain( cakeEntity ) );
        }

        return list;
    }

    @Override
    public Cake toDomain(CakeEntity cakeEntity) {
        if ( cakeEntity == null ) {
            return null;
        }

        Cake.CakeBuilder cake = Cake.builder();

        cake.id( cakeEntity.getId() );
        cake.title( cakeEntity.getTitle() );
        cake.cakeType( cakeEntity.getCakeType() );
        cake.expiredPeriod( cakeEntity.getExpiredPeriod() );

        return cake.build();
    }

    @Override
    public CakeEntity toEntity(Cake cake) {
        if ( cake == null ) {
            return null;
        }

        CakeEntity.CakeEntityBuilder cakeEntity = CakeEntity.builder();

        cakeEntity.id( cake.getId() );
        cakeEntity.title( cake.getTitle() );
        cakeEntity.cakeType( cake.getCakeType() );
        cakeEntity.expiredPeriod( cake.getExpiredPeriod() );

        return cakeEntity.build();
    }
}
