package com.sampleshop.main.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "shop_music_samples")
@EntityListeners(AuditingEntityListener.class)
public class MusicSample {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    private String name;

    @NotBlank
    private String price;

    @NotBlank
    private String audioQuality;

    @NotBlank
    private String thumbnailLink;

    @NotBlank
    private String audioLink;

    public int getId() {
        return id;
    }

    public MusicSample setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public MusicSample setName(String name) {
        this.name = name;
        return this;
    }

    public String getPrice() {
        return price;
    }

    public MusicSample setPrice(String price) {
        this.price = price;
        return this;
    }

    public String getAudioQuality() {
        return audioQuality;
    }

    public MusicSample setAudioQuality(String audioQuality) {
        this.audioQuality = audioQuality;
        return this;
    }

    public String getThumbnailLink() {
        return thumbnailLink;
    }

    public MusicSample setThumbnailLink(String thumbnailLink) {
        this.thumbnailLink = thumbnailLink;
        return this;
    }

    public String getAudioLink() {
        return audioLink;
    }

    public MusicSample setAudioLink(String audioLink) {
        this.audioLink = audioLink;
        return this;
    }
}
