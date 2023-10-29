package com.practices.msvc.user.message;

public enum ErrorMessages {

    ENTITY_NOT_FOUND("Entity not found"),
    CANNOT_SAVE_ENTITY("Error saving entity");

    private final String value;

    ErrorMessages(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
