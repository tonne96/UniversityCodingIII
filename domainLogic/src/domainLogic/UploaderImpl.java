package domainLogic;

import contract.Uploader;

public class UploaderImpl implements Uploader {
    private final String name;

    public UploaderImpl(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Uploader u) {
            return u.getName().equals(this.name);
        }
        return false;
    }
}
