package com.stiggpwnz.vibes.vk.models;

import android.text.Spanned;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.stiggpwnz.vibes.vk.models.Post.HtmlParser;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Audio {

    public int aid;
    public int owner_id;

    @JsonDeserialize(using = HtmlParser.class) public Spanned artist;
    @JsonDeserialize(using = HtmlParser.class) public Spanned title;

    public int duration;
    public int lyrics_id;
}
