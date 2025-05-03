package com.logonedigital.tdms.domain.model.shared.vo;

import lombok.NonNull;

public record FullName
        (
                @NonNull String firstName,
                @NonNull String lastName
        ) {

    public FullName {
        if( firstName.isBlank() || lastName.isBlank()){
            throw new IllegalArgumentException("First name and last name cannot be blank");
        }
    }

    @Override
    public @NonNull String firstName() {
        return firstName;
    }

    public @NonNull String lastName() {
        return lastName;
    }

    @NonNull
    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
