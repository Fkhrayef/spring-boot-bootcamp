package com.fkhrayef.exam2.Services;

import com.fkhrayef.exam2.Model.Book;
import com.fkhrayef.exam2.Model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BookService {
    private final UserService userService;
    ArrayList<Book> books = new ArrayList<>();

    public BookService(UserService userService) {
        this.userService = userService;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public Boolean updateBook(String id, Book book) {
        // Look for the book and update it if found
        for (int i = 0; i < books.size() ; i++) {
            if (books.get(i).getId().equals(id)) {
                books.set(i, book);
                return true;
            }
        }
        // if not found, return false
        return false;
    }

    public Boolean deleteBook(String id) {
        // Look for the book and delete it if found
        for (Book book : books) {
            if (book.getId().equals(id))
                books.remove(book);
            return true;
        }
        // if not found, return false
        return false;
    }

    public Book getBookByName(String name) {
        // Look for the book and return it if found
        for (Book book : books) {
            if (book.getName().equalsIgnoreCase(name))
                return book;
        }
        // if not found, return null
        return null;
    }

    public ArrayList<Book> getBooksByCategory(String category) {
        // if category is wrong return null
        if (!(category.equals("novel") || category.equals("academic")))
            return null;

        ArrayList<Book> filteredBooks = new ArrayList<>();

        for (Book book : books) {
            if (book.getCategory().equals(category))
                filteredBooks.add(book);
        }

        return filteredBooks;
    }

    public ArrayList<Book> getAbovePages(Integer pages) {
        ArrayList<Book> filteredBooks = new ArrayList<>();

        for (Book book : books) {
            if (book.getNumberOfPages() >= pages)
                filteredBooks.add(book);
        }

        return filteredBooks;
    }

    public Integer changeStatus(String userId, String bookId) {
        for (User user : userService.getUsers()) {
            if (user.getId().equals(userId)) {
                if (user.getRole().equals("librarian")) {
                    for (Book book : books) {
                        if (book.getId().equals(bookId)) {
                            book.setIsAvailable(false);
                            return 1; // updated successfully
                        }
                    }
                    return 2; // book not found
                }
                return 3; // user doesn't have permissions
            }
        }
        return 4; // user not found
    }
}
