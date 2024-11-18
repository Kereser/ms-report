package com.emazon.ms_report;

public class ConsUtils {
    private ConsUtils() {
    }

    /*** Roles ***/
    public static final String CLIENT = "CLIENT";
    public static final String USERNAME = "USERNAME";
    public static final String PASSWORD = "password";
    public static final String ROLE = "ROLE_";

    public static final String AUTHORIZATION = "Authorization";
    public static final String BEARER = "Bearer ";

    /*** Methods ***/
    public static final String GET = "GET";
    public static final String POST = "POST";
    public static final String PUT = "PUT";
    public static final String DELETE = "DELETE";
    public static final String REQUESTED_WITH = "X-Requested-With";
    public static final String CONTENT_TYPE = "Content-Type";
    public static final String FRONT_URL = "http://localhost:4200";
    public static final String MATCH_ALL_URL = "/**";

    /*** Validations ***/
    public static final int INTEGER_3 = 3;
    public static final int INTEGER_30 = 30;
    public static final int INTEGER_120 = 120;

    public static final Long LONG_0 = 0L;
    public static final Long LONG_1 = 1L;
    public static final Long LONG_2 = 2L;

    /*** Routes ***/
    public static final String BASIC_URL = "/reports";
    public static final String SWAGGER_URL = "/swagger-ui/**";
    public static final String SWAGGER_DOCS_URL = "/v3/api-docs/**";

    /*** Test fields ***/
    public static final String FIELD_MESSAGE = "$.message";
    public static final String FIELD_TOTAL_PRICE = "$.fieldErrors.totalPrice";
    public static final String FIELD_CART_ID = "$.fieldErrors.cartId";
    public static final String FIELD_USER_ID = "$.fieldErrors.userId";
    public static final String FIELD_ARTICLES = "$.fieldErrors.articles";
    public static final String FIELD_CART_LAST_UPADTED_AT = "$.fieldErrors.cartLastUpdatedAt";

    public static final String REQUIRED_BODY = "Required request body is missing";

    public static final String EMPTY = "";
    public static final String COLON_DELIMITER = ":";
    public static final String COMMA_DELIMITER = ",";
}
