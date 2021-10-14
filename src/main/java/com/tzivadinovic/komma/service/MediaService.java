package com.tzivadinovic.komma.service;

import com.tzivadinovic.komma.entity.Media;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface MediaService {

    List<Media> findAll();

    Media save(Media media);

    Media upload(MultipartFile file);

    Media update(Media media);

    Media findById(Integer mediaId);

    void deleteById(Integer mediaId);
}
