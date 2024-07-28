package com.gabrielcarvalhotp.workshop.domains.posts;

import java.time.LocalDate;

public record ComentsDTO(
        String text,
        LocalDate date,
        AuthorDTO author
) {
}
