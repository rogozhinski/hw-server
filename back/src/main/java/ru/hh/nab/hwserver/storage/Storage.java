package ru.hh.nab.hwserver.storage;

import java.util.HashMap;

public class Storage {

    private HashMap <String, DTO> storageMap = new HashMap<>();

    public Storage() {}

    public void addItem (String id, DTO item) {
        this.storageMap.put(id, item);
    }

    public DTO getItem (String id) {
        return this.storageMap.get(id);
    }

    public void removeItem (String id) {
        this.storageMap.remove(id);
    }
}
