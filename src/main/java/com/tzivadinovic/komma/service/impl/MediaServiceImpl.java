package com.tzivadinovic.komma.service.impl;

import com.tzivadinovic.komma.entity.Media;
import com.tzivadinovic.komma.exception.MediaUploadException;
import com.tzivadinovic.komma.repository.MediaRepository;
import com.tzivadinovic.komma.service.MediaService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@Data
@Service
@RequiredArgsConstructor
public class MediaServiceImpl implements MediaService {
    private final MediaRepository mediaRepository;

    @Value("${media.upload.path}")
    private String mediaUploadPath;

    @Override
    public List<Media> findAll() {
        return mediaRepository.findAll();
    }

    @Override
    public Media save(Media media) {
        return mediaRepository.save(media);
    }

    @Override
    public Media upload(MultipartFile file) {
        if (file == null || file.isEmpty()) throw new MediaUploadException();

        String filename = getUploadedFilename(file);
        String contentType = file.getContentType();
        Path path = Paths.get(mediaUploadPath, "static/media", filename);
        String pathStr = path.toString();
        String uri = Paths.get("files", filename).toString();

        Optional<Media> existingMedia = mediaRepository.findByUri(uri);
        if (existingMedia.isPresent()) return existingMedia.get();

        try {
            BufferedImage src = ImageIO.read(new ByteArrayInputStream(file.getBytes()));

            File destinationFile = new File(pathStr);
            destinationFile.getParentFile().mkdirs();
            ImageIO.write(src, contentType == null ? "png" : contentType.split("/")[1], destinationFile);

            Media media = new Media();
            media.setUri(uri);
            return mediaRepository.save(media);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String getUploadedFilename(MultipartFile file) {
        String uuid = UUID.randomUUID().toString();
        String extension = FilenameUtils.getExtension(file.getOriginalFilename());
        return String.format("%s.%s", uuid, extension);
    }

    @Override
    public Media update(Media media) {
        return mediaRepository.save(media);
    }

    @Override
    public Media findById(Integer mediaId) {
        return mediaRepository.findById(mediaId).orElseThrow(() -> new NoSuchElementException("MediaService.media.notFound"));
    }

    @Override
    public void deleteById(Integer mediaId) {
        mediaRepository.deleteById(mediaId);
    }
}
