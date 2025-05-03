package com.logonedigital.tdms.domain.shared.vo;

import com.logonedigital.tdms.domain.shared.RegexPatterns;
import lombok.NonNull;

public record Email(@NonNull String value) {
    public Email {
        if (!value.matches(RegexPatterns.EMAIL)) {
            throw new IllegalArgumentException("Invalid email format");
        }
    }


}
