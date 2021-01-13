package com.loando.userService.query;

public interface UserSQLQuery {
    String GET_USER_BY_EMAIL = "from User where email=:email";
}
