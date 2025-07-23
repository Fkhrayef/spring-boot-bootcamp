package com.fkhrayef.newsarticlemanagementsystem.Controller;

import com.fkhrayef.newsarticlemanagementsystem.Api.ApiResponse;
import com.fkhrayef.newsarticlemanagementsystem.Model.NewsArticle;
import com.fkhrayef.newsarticlemanagementsystem.Service.NewsArticleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
public class NewsArticleController {
    private final NewsArticleService newsArticleService;

    @GetMapping("get/news-articles")
    public ResponseEntity<?> getNewsArticles() {
        ArrayList<NewsArticle> newsArticles = newsArticleService.getNewsArticles();
        if (!newsArticles.isEmpty())
            return ResponseEntity.status(HttpStatus.OK).body(newsArticles);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("No News Articles yet. Try adding some!"));
    }

    @PostMapping("add/news-article")
    public ResponseEntity<?> addNewsArticle(@Valid @RequestBody NewsArticle newsArticle, Errors errors) {
        if (errors.hasErrors()) {
            ArrayList<String> errorMessages = new ArrayList<>();

            for (FieldError error : errors.getFieldErrors()) {
                errorMessages.add(error.getDefaultMessage());
            }

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessages);
        }

        newsArticleService.addNewsArticle(newsArticle);
        return ResponseEntity.status(HttpStatus.OK).body(newsArticle);
    }

    @PutMapping("update/news-articles/{id}")
    public ResponseEntity<?> updateNewsArticle(@PathVariable("id") String id, @Valid @RequestBody NewsArticle newsArticle, Errors errors) {
        if (errors.hasErrors()) {
            ArrayList<String> errorMessages = new ArrayList<>();

            for (FieldError error : errors.getFieldErrors()) {
                errorMessages.add(error.getDefaultMessage());
            }

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessages);
        }

        Boolean isUpdated = newsArticleService.updateNewsArticle(id, newsArticle);
        if (isUpdated)
            return ResponseEntity.status(HttpStatus.OK).body(newsArticle);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("News Article not Found"));
    }

    @DeleteMapping("delete/news-articles/{id}")
    public ResponseEntity<?> deleteNewsArticle(@PathVariable("id") String id) {
        Boolean isDeleted = newsArticleService.deleteNewsArticle(id);

        if (isDeleted)
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new ApiResponse("Deleted successfully")); // the message won't show up
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("News Article not Found"));
    }

    @PutMapping("update/news-articles/publish/{id}")
    public ResponseEntity<?> publishNewsArticle(@PathVariable("id") String id) {
        NewsArticle newsArticle = newsArticleService.publishNewsArticle(id);
        if (newsArticle != null)
            return ResponseEntity.status(HttpStatus.OK).body(newsArticle);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("News Article not Found"));
    }

    @GetMapping("get/news-articles/published")
    public ResponseEntity<?> getAllPublishedNewsArticles() {
        ArrayList<NewsArticle> publishedNewsArticles = newsArticleService.getAllPublishedNewsArticles();

        if (!publishedNewsArticles.isEmpty())
            return ResponseEntity.status(HttpStatus.OK).body(publishedNewsArticles);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("No News Articles meet your criteria"));
    }

    @GetMapping("get/news-articles/category")
    public ResponseEntity<?> getNewsArticleByCategory(@RequestParam("category") String category) {
        ArrayList<NewsArticle> newsArticlesByCategory = newsArticleService.getNewsArticleByCategory(category);

        // if null, then the category is wrong
        if (newsArticlesByCategory == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("Invalid category: " + category));

        // if empty
        if (!newsArticlesByCategory.isEmpty())
            return ResponseEntity.status(HttpStatus.OK).body(newsArticlesByCategory);
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse("No News Articles meet your criteria"));
    }
}
