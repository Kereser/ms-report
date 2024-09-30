package com.emazon.ms_report;

import com.emazon.ms_report.application.dto.ArticleResDTO;
import com.emazon.ms_report.application.dto.BrandResDTO;
import com.emazon.ms_report.application.dto.CategoryArticleResDTO;
import com.emazon.ms_report.application.dto.ReportReqDTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

public class TestCreationUtils {
    private TestCreationUtils() {
    }

    public static final String BRAND_NAME = "BrandName";
    public static final String CATEGORY_NAME = "CategoryName";
    public static final String ARTICLE_NAME = "ArticleName";

    private static Long categoryIdCounter = 1L;
    private static Long brandIdCounter = 1L;
    private static Long articleIdCounter = 1L;

    private static Integer prefixCounter = 1;
    private static Integer categoryPrefixCounter = 1;

    private static final BigDecimal BASIC_PRICE = BigDecimal.valueOf(100.00);
    private static Long baseQuantity = 10L;

    public static CategoryArticleResDTO createCategory() {
        return CategoryArticleResDTO.builder()
                .id(categoryIdCounter++)
                .name(CATEGORY_NAME + categoryPrefixCounter++)
                .build();
    }

    public static BrandResDTO createBrand() {
        return BrandResDTO.builder()
                .id(brandIdCounter++)
                .name(BRAND_NAME + prefixCounter++)
                .description(BRAND_NAME + prefixCounter++)
                .build();
    }

    public static ArticleResDTO createArticleRes() {
        return createArticleRes(null);
    }

    public static ArticleResDTO createArticleRes(Long articleId) {
        Integer articlePrefixCounter = 1;
        return ArticleResDTO.builder()
                .id(articleId == null ? articleIdCounter++ : articleId)
                .name(ARTICLE_NAME + articlePrefixCounter)
                .price(BASIC_PRICE)
                .quantity(baseQuantity++)
                .categories(Set.of(
                        createCategory(),
                        createCategory()
                ))
                .brand(createBrand())
                .updatedAt(LocalDateTime.now())
                .build();
    }

    public static ReportReqDTO createReportReqDTO() {
        return ReportReqDTO.builder()
                .cartId(ConsUtils.LONG_1)
                .userId(ConsUtils.LONG_1)
                .totalPrice(BigDecimal.valueOf(500L))
                .articles(Set.of(createArticleRes()))
                .cartLastUpdatedAt(LocalDateTime.now())
                .build();
    }
}
