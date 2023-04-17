package org.koreait.project.validator;

public interface CommonValidator<T> {

    void check(T t);


    default void NotBlankCheck(String str, RuntimeException e) {
        if (str == null || str.isBlank()) {
            throw e;
        }
    }





}
