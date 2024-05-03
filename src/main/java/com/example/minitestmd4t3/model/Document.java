package com.example.minitestmd4t3.model;

public class Document {
    private int id;
    private String code;
    private String name;
    private int year;
    private String description;

    public Document() {
    }

    public Document(int id, String code, String name, int year, String description) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.year = year;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", code=" + code +
                ", name='" + name + '\'' +
                ", year=" + year +
                ", description='" + description + '\'' +
                '}';
    }
}
