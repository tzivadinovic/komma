package com.tzivadinovic.komma.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@ResponseStatus(value = NOT_FOUND, reason = "Empty file")
public class MediaUploadException extends RuntimeException{
}
