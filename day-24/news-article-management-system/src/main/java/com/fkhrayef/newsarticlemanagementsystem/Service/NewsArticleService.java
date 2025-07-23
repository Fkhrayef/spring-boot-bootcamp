package com.fkhrayef.newsarticlemanagementsystem.Service;

import com.fkhrayef.newsarticlemanagementsystem.Model.NewsArticle;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;

@Service
public class NewsArticleService {

    ArrayList<NewsArticle> newsArticles = new ArrayList<>();

    public ArrayList<NewsArticle> getNewsArticles() {
        return newsArticles;
    }

    public void addNewsArticle(NewsArticle newsArticle) {
        // all news articles are not published by default
        newsArticle.setIsPublished(false);
        // so if the publish date is in the past, we cannot allow it!
        if (newsArticle.getPublishDate() != null && newsArticle.getPublishDate().isBefore(LocalDate.now())) {
            newsArticle.setPublishDate(null);
        }
        newsArticles.add(newsArticle);
    }

    public Boolean updateNewsArticle(String id, NewsArticle newsArticle) {
        for (NewsArticle n : newsArticles) {
            if (n.getId().equals(id)) {
                n.setId(newsArticle.getId());
                n.setTitle(newsArticle.getTitle());
                n.setAuthor(newsArticle.getAuthor());
                n.setContent(newsArticle.getContent());
                n.setCategory(newsArticle.getCategory());
                n.setImageUrl(newsArticle.getImageUrl());
//              n.setIsPublished(newsArticle.getIsPublished()); not allowed!! only using the publish endpoint
                // if the article is not published, we cannot allow publish date in the past
                if (!n.getIsPublished() && newsArticle.getPublishDate() != null && newsArticle.getPublishDate().isBefore(LocalDate.now()))
                    newsArticle.setPublishDate(null);
                else
                    n.setPublishDate(newsArticle.getPublishDate());
                return true;
            }
        }
        return false;
    }

    public Boolean deleteNewsArticle(String id) {
        for (NewsArticle n : newsArticles) {
            if (n.getId().equals(id)) {
                newsArticles.remove(n);
                return true;
            }
        }
        return false;
    }

    public NewsArticle publishNewsArticle(String id) {
        for (NewsArticle n : newsArticles) {
            if (n.getId().equals(id)) {
                n.setIsPublished(true);
                n.setPublishDate(LocalDate.now());
                return n;
            }
        }
        return null;
    }

    public ArrayList<NewsArticle> getAllPublishedNewsArticles() {
        ArrayList<NewsArticle> publishedNewsArticles = new ArrayList<>();

        for (NewsArticle n : newsArticles) {
            if (n.getIsPublished())
                publishedNewsArticles.add(n);
        }

        return publishedNewsArticles;
    }

    public ArrayList<NewsArticle> getNewsArticleByCategory(String category) {
        ArrayList<NewsArticle> newsArticlesByCategory = new ArrayList<>();

        if (!(category.equals("sports") || category.equals("politics") || category.equals("technology"))) {
            return null;
        }

        for (NewsArticle n : newsArticles) {
            if (n.getCategory().equals(category))
                newsArticlesByCategory.add(n);
        }

        return newsArticlesByCategory;
    }
}
