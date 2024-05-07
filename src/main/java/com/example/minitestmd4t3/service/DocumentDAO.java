package com.example.minitestmd4t3.service;

import com.example.minitestmd4t3.model.Document;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DocumentDAO {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/minitest3";
    private static final String JDBC_USERNAME = "root";
    private static final String JDBC_PASSWORD = "khoatrinh18122001";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
            System.out.println("THANH CONG");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("lỗi kết nối");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("looix ");
        }
        return connection;
    }


    public List<Document> getAllDocuments() {
        List<Document> documents = new ArrayList<>();
        String query = "SELECT * FROM document";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Document document = new Document();
                    document.setId(rs.getInt("id"));
                    document.setCode(rs.getString("code"));
                    document.setName(rs.getString("name"));
                    document.setYear(rs.getInt("year"));
                    document.setDescription(rs.getString("description"));
                    documents.add(document);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return documents;
    }

    public Document getDocumentById(int id) {
        Document document = null;
        String query = "SELECT * FROM document WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                document = new Document();
                document.setId(rs.getInt("id"));
                document.setCode(rs.getString("code"));
                document.setName(rs.getString("name"));
                document.setYear(rs.getInt("year"));
                document.setDescription(rs.getString("description"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return document;
    }

    public void createDocument(Document document) {
        String query = "INSERT INTO document (id, code, name, year, description) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, document.getId());
            stmt.setString(2, document.getCode());
            stmt.setString(3, document.getName());
            stmt.setInt(4, document.getYear());
            stmt.setString(5, document.getDescription());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateDocument(Document document) {
        String query = "UPDATE document SET code = ?, name = ?, year = ?, description = ? WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, document.getCode());
            stmt.setString(2, document.getName());
            stmt.setInt(3, document.getYear());
            stmt.setString(4, document.getDescription());
            stmt.setInt(5, document.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteDocument(int id) {
        String query = "DELETE FROM document WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

