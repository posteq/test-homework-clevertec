package by.clevertec.commom.helper;

import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;

@Component
public class DataSupplierImpl implements DataSupplier {
    @Override
    public OffsetDateTime getCurrentDataTime() {
        return OffsetDateTime.now();
    }
}
