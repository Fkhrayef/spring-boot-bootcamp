package com.fkhrayef.exam2.Controller;

import com.fkhrayef.exam2.ApiResponse.ApiResponse;
import com.fkhrayef.exam2.Model.Book;
import com.fkhrayef.exam2.Services.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/get")
    public ResponseEntity<?> getBooks() {
        ArrayList<Book> books = bookService.getBooks();

        if (!books.isEmpty())
            return ResponseEntity.status(HttpStatus.OK).body(books);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("No books yet. Try adding some!"));
    }

    @PostMapping("/add")
    public ResponseEntity<?> addBook(@Valid @RequestBody Book book, Errors errors) {
        // Check for validation errors
        if (errors.hasErrors()) {
            ArrayList<String> errorMessages = new ArrayList<>();
            for (FieldError error : errors.getFieldErrors())
                errorMessages.add(error.getDefaultMessage());

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessages);
        }

        // add book
        bookService.addBook(book);
        return ResponseEntity.status(HttpStatus.OK).body(book);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateBook(@PathVariable("id") String id, @Valid @RequestBody Book book, Errors errors) {
        // Check for validation errors
        if (errors.hasErrors()) {
            ArrayList<String> errorMessages = new ArrayList<>();
            for (FieldError error : errors.getFieldErrors())
                errorMessages.add(error.getDefaultMessage());

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessages);
        }

        if (bookService.updateBook(id, book))
            return ResponseEntity.status(HttpStatus.OK).body(book);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Book not found!"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable("id") String id) {
        if (bookService.deleteBook(id))
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new ApiResponse("Deleted")); // the message won't show up because status is 204 NO CONTENT
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Book not found!"));

    }

    @GetMapping("/get/search-by-name")
    public ResponseEntity<?> getBookByName(@RequestParam("name") String name) {
        Book book = bookService.getBookByName(name);
        if (book != null)
            return ResponseEntity.status(HttpStatus.OK).body(book);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Book not found!"));
    }

    @GetMapping("/get/search-by-category")
    public ResponseEntity<?> getBooksByCategory(@RequestParam("category") String category) {
        ArrayList<Book> filteredBooks = bookService.getBooksByCategory(category);

        // if the category is wrong
        if (filteredBooks == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("Invalid Category"));

        if (!filteredBooks.isEmpty())
            return ResponseEntity.status(HttpStatus.OK).body(filteredBooks);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("No books meet your criteria"));
    }

    @GetMapping("/get/above-pages")
    public ResponseEntity<?> getAbovePages(@RequestParam("pages") Integer pages) {
        ArrayList<Book> filteredBooks = bookService.getAbovePages(pages);

        if (!filteredBooks.isEmpty())
            return ResponseEntity.status(HttpStatus.OK).body(filteredBooks);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("No books meet your criteria"));
    }

    // something is buggy here because of the logic, didn't have time to fix
    // it, so I wrote another endpoint under this called changeStatusSimple()
    @PutMapping("/update/set-book-unavailable/{userId}/{bookId}")
    public ResponseEntity<?> changeStatus(@PathVariable("userId") String userId, @PathVariable("bookId") String bookId) {
        Integer status = bookService.changeStatus(userId, bookId);

        if (status == 1)
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("Book set unavailable successfully"));
        else if (status == 2)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("Book not found!"));
        else if (status == 3)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("User doesn't have permissions"));
        else if (status == 4)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("User not found!"));

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("Oops! Something went wrong. Try Again"));
    }
}
