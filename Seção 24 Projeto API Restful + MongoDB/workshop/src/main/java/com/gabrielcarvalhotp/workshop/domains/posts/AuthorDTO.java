package com.gabrielcarvalhotp.workshop.domains.posts;

import com.gabrielcarvalhotp.workshop.domains.users.User;

public record AuthorDTO(String id, String name) {
    public AuthorDTO(User user) {
        this(user.getId(), user.getName());
    }
}
