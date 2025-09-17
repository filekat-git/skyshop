package org.skypro.skyshop.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.model.search.SearchResult;
import org.skypro.skyshop.model.search.Searchable;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class SearchServiceTest {

    //    @Mock
    //    private StorageService storageService;
    private StorageService storageService = Mockito.mock(StorageService.class);

    @InjectMocks
    private SearchService searchService;

    @Test
    public void givenEmptyStorage_whenSearch_thenReturnEmptyList() {
        Mockito.when(storageService.getAllElements()).thenReturn(Collections.emptyMap());

        List<SearchResult> result = searchService.search("мяч");

        verify(storageService, Mockito.times(1)).getAllElements();

        Assertions.assertTrue(result.isEmpty());
    }

    @ParameterizedTest
    @ValueSource(strings = {"мяч", "Мяч"})
    public void givenNotEmptyStorage_whenSearchingElementExists_thenReturnListOfElements(String stringParam) {
        Map<UUID, Searchable> mapElements = fillTestedService();

        Mockito.when(storageService.getAllElements()).thenReturn(mapElements);

        List<SearchResult> result = searchService.search(stringParam);

        Assertions.assertEquals(2, result.size());
        Assertions.assertTrue(result.get(0).getName().contains("Мяч"));
    }

    @Test
    public void givenNotEmptyStorage_whenSearchingElementDoesNotExist_thenReturnEmptyList() {
        Map<UUID, Searchable> mapElements = fillTestedService();

        Mockito.when(storageService.getAllElements()).thenReturn(mapElements);

        List<SearchResult> result = searchService.search("ball");

        Assertions.assertTrue(result.isEmpty());
    }

    private Map<UUID, Searchable> fillTestedService() {
        Map<UUID, Searchable> mapElements = new HashMap<>();
        UUID id = UUID.randomUUID();
        Product p1 = new SimpleProduct(id, "Мяч футзальный (Мяч для футбола в зале)", 500);
        mapElements.put(id, p1);
        id = UUID.randomUUID();
        Product p22 = new SimpleProduct(id, "Мяч баскетбольный (размер 5)", 350);
        mapElements.put(id, p22);

        return mapElements;
    }
}
