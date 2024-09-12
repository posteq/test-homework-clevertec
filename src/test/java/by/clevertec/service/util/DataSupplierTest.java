package by.clevertec.service.util;

import by.clevertec.commom.helper.DataSupplier;

import java.time.OffsetDateTime;

public class DataSupplierTest implements DataSupplier {
    @Override
    public OffsetDateTime getCurrentDataTime() {
        return OffsetDateTime.parse("2022-08-08T23:23:23.1572Z");
    }
}
