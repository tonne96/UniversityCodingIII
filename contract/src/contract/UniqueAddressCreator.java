package contract;

import java.util.concurrent.atomic.AtomicInteger;

public interface UniqueAddressCreator {
    // Quelle : https://stackoverflow.com/questions/4818699/practical-uses-for-atomicinteger
    // erzeuge eine einzigartige Indexnummer
    AtomicInteger index = new AtomicInteger(1);
    static String createUniqueAddress() {
        int id = index.getAndIncrement();
        return "media://ID=" + id;
    }
}
