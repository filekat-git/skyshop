package org.skypro.skyshop.service;

import org.skypro.skyshop.model.search.SearchResult;
import org.skypro.skyshop.model.search.Searchable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

@Service
public class SearchService {

    private final StorageService storageService;

    public SearchService(StorageService storageService) {
        this.storageService = storageService;
    }

    public List<SearchResult> search(String searchTerm){
        List<SearchResult> searchResults = new ArrayList<>();
        Map<UUID, Searchable> elements = storageService.getAllElements();
        List<Searchable> listOfElements = elements.values().stream()
                .filter(Objects::nonNull)
                .filter(el -> el.getSearchTerm().toLowerCase().contains(searchTerm.toLowerCase()))
                .toList();
        for (Searchable listOfElement : listOfElements) {
            searchResults.add(SearchResult.fromSearchable(listOfElement));
        }
        return searchResults;
    }
}
