package com.practices.msvc.course.message;

public enum ErrorMessages {

    ENTITY_NOT_FOUND("Entity not found"),
    CANNOT_SAVE_ENTITY("Error saving entity"),
    ERROR_GETTING_ENTITY("Error getting entity");

    private final String value;

    ErrorMessages(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
