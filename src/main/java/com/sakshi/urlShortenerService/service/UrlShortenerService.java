package com.sakshi.urlShortenerService.service;

import com.sakshi.urlShortenerService.dto.request.UrlRequestDTO;
import com.sakshi.urlShortenerService.dto.response.UrlResponseDTO;
import org.springframework.stereotype.Service;

@Service
public interface UrlShortenerService{
    UrlResponseDTO shortenUrl(UrlRequestDTO urlRequestDTO);
}
