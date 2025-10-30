package contract;

import java.io.IOException;
import java.util.Collection;

public interface MediaContent {
    String getAddress();
    Collection<Tag> getTags();
    int getAccessCount();
    long getSize();
}
