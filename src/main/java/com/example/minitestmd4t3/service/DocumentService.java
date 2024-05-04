package com.example.minitestmd4t3.service;

import com.example.minitestmd4t3.model.Document;

import java.util.List;


public class DocumentService implements IDocumentService {
    private DocumentDAO documentDAO = new DocumentDAO();

    @Override
    public List<Document> showAll() {
        return documentDAO.getAllDocuments();
    }

    @Override
    public void saveList(Document document) {
        documentDAO.createDocument(document);
    }

    @Override
    public Document searchById(int id) {
        return documentDAO.getDocumentById(id);
    }

    @Override
    public void update(int id, Document document) {
        documentDAO.updateDocument(document);
    }

    @Override
    public void delete(int id) {
        documentDAO.deleteDocument(id);
    }
}

