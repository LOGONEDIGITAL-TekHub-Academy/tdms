package com.logonedigital.tdms.domain.model.shared.vo;

import com.logonedigital.tdms.domain.model.shared.RegexPatterns;
import lombok.NonNull;

public record Email(@NonNull String value) {
    public Email {
        if (!value.matches(RegexPatterns.EMAIL)) {
            throw new IllegalArgumentException("Invalid email format");
        }
    }


}
