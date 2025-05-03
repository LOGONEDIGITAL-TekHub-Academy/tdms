package com.logonedigital.tdms.infrastructure.user.http.dto;

import lombok.*;


@Builder
public record AuthenticationResponse(
        String token
) {

}


