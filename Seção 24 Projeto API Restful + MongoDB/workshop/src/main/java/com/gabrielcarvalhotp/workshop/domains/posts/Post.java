package com.gabrielcarvalhotp.workshop.domains.posts;

import com.gabrielcarvalhotp.workshop.domains.users.User;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Document
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Post {

    private String id;
    private LocalDate date;
    private String title;
    private String body;
    private AuthorDTO author;
    List<ComentsDTO> comments = new ArrayList<>();
}
