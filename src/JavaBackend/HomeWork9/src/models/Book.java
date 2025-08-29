package models;

public class Book {
    private int id;
    private String bookName;
    private int year;

    public Book(int id, String bookName, int year) {
        this.id = id;
        this.bookName = bookName;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
