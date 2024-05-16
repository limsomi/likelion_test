package org.example.likelionkwuprod.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class CommentRequest {
    @JsonProperty
    private String username;

    @JsonProperty
    private String commentContent;
}
