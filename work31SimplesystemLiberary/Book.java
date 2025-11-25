package work31SimplesystemLiberary;

import java.util.Comparator;

public class Book implements Comparable<Book> {
    private String isbn;
    private String title;
    private String author;
    private int stock;

    public Book(String isbn, String title, String author, int stock) {
        this.isbn = isbn; this.title = title; this.author = author; this.stock = stock;
    }

    public String getIsbn() { return isbn; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }

    @Override
    public String toString() {
        return "ISBN:" + isbn + " 书名:" + title + " 作者:" + author + " 库存:" + stock;
    }

    @Override
    public int compareTo(Book o) {     // 按 ISBN 升序
        return this.isbn.compareTo(o.isbn);
    }
}