package com.example.minitestmd4t3.service;

import com.example.minitestmd4t3.model.Document;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DocumentService implements IDocumentService {
    private static Map<Integer, Document> documents;

//    static {
//        documents = new HashMap<>();
//        documents.put(1, new Document(1, "Python", "Lập trình tự động hóa", 2023, "tài liệu mật"));
//        documents.put(2, new Document(2, "Java", "Lập trình web", 2022, "tài liệu mật"));
//        documents.put(3, new Document(3, "C++", "Lập trình nhúng", 2022, "tài liệu mật"));
//        documents.put(4, new Document(4, "JS", "Thiết kế giao diện", 2024, "tài liệu công khai"));
//        documents.put(5, new Document(5, "html", "Văn bản", 2020, "tài liệu công khai"));
//    }
    @Override
    public List<Document> showAll() {
        return new ArrayList<>(documents.values());
    }

    @Override
    public void saveList(Document post) {
        documents.put(post.getId(), post);
    }

    @Override
    public Document searchById(int id) {
        return documents.get(id);
    }

    @Override
    public void update(int id, Document post) {
        documents.put(id, post);
    }

    @Override
    public void delete(int id) {
        documents.remove(id);
    }
}
