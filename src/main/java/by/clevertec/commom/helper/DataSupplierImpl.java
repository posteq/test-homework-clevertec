package by.clevertec.commom.helper;

import java.time.OffsetDateTime;

public class DataSupplierImpl implements DataSupplier {
    @Override
    public OffsetDateTime getCurrentDataTime() {
        return OffsetDateTime.now();
    }
}
