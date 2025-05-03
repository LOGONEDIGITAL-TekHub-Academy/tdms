package com.logonedigital.tdms.domain.model.user;

public enum Role {
    TECHDREAMER("ROLE_TECHDREAMER"),
    TECHMENTOR("ROLE_TECHMENTOR"),
    ADMIN("ROLE_ADMIN"),
    UNKNOWN("ROLE_UNKNOWN");

    Role(String role) {
        assert role != null  && !role.trim().isEmpty()  : "Role cannot be null";
    }
}
