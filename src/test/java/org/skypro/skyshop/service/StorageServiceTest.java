package org.skypro.skyshop.service;

import org.junit.Assert;
import org.junit.Test;
import org.skypro.skyshop.model.search.Searchable;

import java.util.Map;
import java.util.UUID;

public class StorageServiceTest {

    public StorageService storageServiceTest = new StorageService();

    @Test
    public void createElementsTest() {
        Map<UUID, Searchable> collection = storageServiceTest.getAllElements();
        Assert.assertEquals(15, collection.size());
    }
}
