package org.skypro.skyshop.model.article;

import org.skypro.skyshop.model.search.Searchable;

import java.util.Objects;
import java.util.UUID;

public class Article implements Searchable {

    private final UUID id;
    private final String name;
    private String content;

    public Article(UUID id, String name, String content) {
        this.id = id;
        this.name = name;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    @Override
    public UUID getID() {
        return this.id;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return getName() + "\n" + getContent();
    }

    @Override
    public String getContentType() {
        return "Article";
    }

    @Override
    public String getSearchTerm() {
        return toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(getName(), article.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
