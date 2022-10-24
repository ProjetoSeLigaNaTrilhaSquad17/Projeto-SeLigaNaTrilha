package com.unit17.seliganatrilha.dtos;

import com.unit17.seliganatrilha.models.Link;

public class LinkDto {

    private String link;

    public Link convertToLink() {
        return new Link(this.link);
    }
}
