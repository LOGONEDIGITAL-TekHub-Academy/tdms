package com.logonedigital.tdms.domain.model.user;

import lombok.NonNull;

import java.util.UUID;

public record UserId(
       @NonNull UUID value
) {
    public static UserId generate() {
        return new UserId(UUID.randomUUID());
    }
}
