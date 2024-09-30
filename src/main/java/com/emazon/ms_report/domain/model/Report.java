package com.emazon.ms_report.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

public class Report {
    private String id;
    private Long cartId;
    private Long userId;
    private String userEmail;
    private LocalDateTime cartLastUpdatedAt;
    private BigDecimal totalPrice;
    private Set<ReportArticle> articles;
    private LocalDateTime date;
    private String annotations;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public LocalDateTime getCartLastUpdatedAt() {
        return cartLastUpdatedAt;
    }

    public void setCartLastUpdatedAt(LocalDateTime cartLastUpdatedAt) {
        this.cartLastUpdatedAt = cartLastUpdatedAt;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Set<ReportArticle> getArticles() {
        return articles;
    }

    public void setArticles(Set<ReportArticle> articles) {
        this.articles = articles;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getAnnotations() {
        return annotations;
    }

    public void setAnnotations(String annotations) {
        this.annotations = annotations;
    }
}
