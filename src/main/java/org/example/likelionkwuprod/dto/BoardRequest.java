package org.example.likelionkwuprod.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BoardRequest {
    @JsonProperty
    private String username;

    @JsonProperty
    private String boardTitle;

    @JsonProperty
    private String boardContent;
}
