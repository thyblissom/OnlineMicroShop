package com.sampleshop.main.controller;

import com.sampleshop.main.exceptions.ResourceNotFoundException;
import com.sampleshop.main.model.MusicSample;
import com.sampleshop.main.repository.AutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/shop")
public class ShopItemController {

    private static final String MUSIC_ROUTE = "/music-samples";

    @Autowired
    AutoRepository musicSampleRepository;

    @GetMapping(MUSIC_ROUTE)
    public List<MusicSample> getMusicSamples() {
        return musicSampleRepository.findAll();
    }

    @PostMapping(MUSIC_ROUTE)
    public MusicSample postMusicSample(@Valid @RequestBody MusicSample musicSample) {
        return musicSampleRepository.save(musicSample);
    }

    @GetMapping(MUSIC_ROUTE + "/{id}")
    public MusicSample getSingleMusicSample(@PathVariable(value = "id") Long id) {
        return musicSampleRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Music sample", "id", id));
    }

    @PostMapping(MUSIC_ROUTE + "/{id}")
    public MusicSample updateSingleMusicSample(@PathVariable(value = "id") Long id,
                                               @Valid @RequestBody MusicSample reqMusicSample) {
        MusicSample newMusicSample = musicSampleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Music sample", "id", id));

        return getUpdatedMusicSample(newMusicSample, reqMusicSample);
    }

    private MusicSample getUpdatedMusicSample(MusicSample newMusicSample, MusicSample reqMusicSample) {
        // todo should be validated if reqMusicSample has values.
        // I suppose it should contain values cause otherwise request wouldn't reach this.
        // Since this is about update, maybe we should not need to add all data to update.
        newMusicSample.setName(reqMusicSample.getName());
        newMusicSample.setPrice(reqMusicSample.getPrice());
        newMusicSample.setThumbnailLink(reqMusicSample.getThumbnailLink());
        newMusicSample.setAudioQuality(reqMusicSample.getAudioQuality());
        newMusicSample.setAudioLink(reqMusicSample.getAudioLink());

        return newMusicSample;
    }

    @DeleteMapping(MUSIC_ROUTE + "/{id}")
    public ResponseEntity<?> deleteMusicSample(@PathVariable(value = "id") Long id) {

        MusicSample note = musicSampleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Music sample", "id", id));

        musicSampleRepository.delete(note);

        return ResponseEntity.ok().build();
    }

}
