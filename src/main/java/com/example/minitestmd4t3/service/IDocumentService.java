package com.example.minitestmd4t3.service;

import com.example.minitestmd4t3.model.Document;

import java.util.List;

public interface IDocumentService {
    List<Document> showAll();

    void saveList(Document document);

    Document searchById(int id);


    void update(int id, Document document);

    void delete(int id);
}
