package org.skypro.skyshop.model.search;

import java.util.UUID;

public class SearchResult {
    private final UUID id;
    private final String name;
    private final String contentType;

    public SearchResult(UUID id, String name, String contentType) {
        this.id = id;
        this.name = name;
        this.contentType = contentType;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContentType() {
        return contentType;
    }

    public static SearchResult fromSearchable(Searchable searchable) {
        return new SearchResult(searchable.getID(), searchable.getName(), searchable.getSearchTerm());
    }

    @Override
    public String toString() {
        return "SearchResult{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", contentType='" + getContentType() + '\'' +
                '}';
    }
}
