package com.example.minitestmd4t3.controller;

import com.example.minitestmd4t3.model.Document;
import com.example.minitestmd4t3.service.DocumentService;
import com.example.minitestmd4t3.service.IDocumentService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "PostServlet", urlPatterns = "/documents")
public class DocumentServlet extends HttpServlet {

    private final IDocumentService documentService = new DocumentService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        String action = req.getParameter("action");

        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                createDocument(req, resp);
                break;
            case "edit":
                updateDocument(req, resp);
                break;
            case "delete":
                deleteDocument(req, resp);
                break;
            default:
                break;
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(req, resp);
                break;
            case "edit":
                showEditForm(req, resp);
                break;
            case "delete":
                showDeleteForm(req, resp);
                break;
            case "view":
                viewDocument(req, resp);
                break;
            default:
                listDocuments(req, resp);
                break;
        }
    }

    private void viewDocument(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Document document = this.documentService.searchById(id);
        RequestDispatcher dispatcher;

        if (document == null) {
            dispatcher = req.getRequestDispatcher("view/error-404.jsp");
        } else {
            req.setAttribute("document", document);
            dispatcher = req.getRequestDispatcher("view/view.jsp");
            dispatcher.forward(req,resp);
        }
    }

    private void listDocuments(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Document> documents = this.documentService.showAll();
        req.setAttribute("documents", documents);

        RequestDispatcher dispatcher;
        dispatcher = req.getRequestDispatcher("view/list.jsp");
        dispatcher.forward(req,resp);
    }

    private void createDocument(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        String code = req.getParameter("code");
        String name = req.getParameter("name");
        int year = Integer.parseInt(req.getParameter("year"));
        String description = req.getParameter("description");

        Document document = new Document(id, code, name, year, description);
        this.documentService.saveList(document);
        RequestDispatcher dispatcher;
        dispatcher = req.getRequestDispatcher("view/create.jsp");
        dispatcher.forward(req,resp);
        req.setAttribute("message", "New document was created");
    }

    private void showCreateForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("view/create.jsp");
        dispatcher.forward(req,resp);
    }

    private void updateDocument(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String code = req.getParameter("code");
        String name = req.getParameter("name");
        int year = Integer.parseInt(req.getParameter("year"));
        String description = req.getParameter("description");

        Document document = this.documentService.searchById(id);
        RequestDispatcher dispatcher;
        if (document == null) {
            dispatcher = req.getRequestDispatcher("error.jsp");
        } else {
            document.setId(id);
            document.setCode(code);
            document.setName(name);
            document.setYear(year);
            document.setDescription(description);
            this.documentService.update(id, document);
            req.setAttribute("document", document);
            req.setAttribute("message", "Document information was updated");
            dispatcher = req.getRequestDispatcher("view/edit.jsp");
            dispatcher.forward(req,resp);
        }
    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Document document = this.documentService.searchById(id);
        RequestDispatcher dispatcher;
        if (document == null) {
            dispatcher = req.getRequestDispatcher("error.jsp");
        } else {
            req.setAttribute("post", document);
            dispatcher = req.getRequestDispatcher("view/edit.jsp");
            dispatcher.forward(req,resp);
        }
    }

    private void deleteDocument(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        Document document = this.documentService.searchById(id);
        RequestDispatcher dispatcher;
        if (document == null) {
            dispatcher = req.getRequestDispatcher("error.jsp");
        } else {
            this.documentService.delete(id);
            try {
                resp.sendRedirect("/documents");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void showDeleteForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Document document = this.documentService.searchById(id);
        RequestDispatcher dispatcher;
        if (document == null) {
            dispatcher = req.getRequestDispatcher("error.jsp");
        } else {
            req.setAttribute("document", document);
            dispatcher = req.getRequestDispatcher("view/delete.jsp");
            dispatcher.forward(req,resp);
        }
    }
}
