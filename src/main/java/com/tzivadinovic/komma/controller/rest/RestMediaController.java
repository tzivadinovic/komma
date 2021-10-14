package com.tzivadinovic.komma.controller.rest;

import com.tzivadinovic.komma.entity.Media;
import com.tzivadinovic.komma.service.MediaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/media")
@RequiredArgsConstructor
public class RestMediaController {
    private final MediaService mediaService;

//    @PostMapping
//    public ResponseEntity<Media> saveMedia(@RequestBody Media media) {
//        return ResponseEntity.ok(mediaService.save(media));
//    }

    @PostMapping
    public ResponseEntity<Media> uploadMedia(@RequestParam(value = "file", required = false) MultipartFile file) {
        return ResponseEntity.status(CREATED).body(mediaService.upload(file));
    }
}
