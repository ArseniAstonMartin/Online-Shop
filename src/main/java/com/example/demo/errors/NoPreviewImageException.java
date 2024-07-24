package com.example.demo.errors;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NoPreviewImageException extends Exception {
    public NoPreviewImageException(String message) {
        super(message);
    }

}