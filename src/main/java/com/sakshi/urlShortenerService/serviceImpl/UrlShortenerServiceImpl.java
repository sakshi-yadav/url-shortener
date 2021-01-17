package com.sakshi.urlShortenerService.serviceImpl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lendoapp.service.DataAccessService;
import com.sakshi.urlShortenerService.dto.request.UrlRequestDTO;
import com.sakshi.urlShortenerService.dto.response.UrlResponseDTO;
import com.sakshi.urlShortenerService.entities.ShortenedUrl;
import com.sakshi.urlShortenerService.service.UrlShortenerService;
import com.sakshi.urlShortenerService.utils.UrlShortenerUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class UrlShortenerServiceImpl implements UrlShortenerService {
    @Value("${url.expiration.time}")
    private Long expirationTime;

    private final ObjectMapper mapper;
    private final DataAccessService dataAccessService;
    private final UrlShortenerUtil urlShortenerUtil;

    public UrlShortenerServiceImpl(ObjectMapper mapper, DataAccessService dataAccessService, UrlShortenerUtil urlShortenerUtil) {
        this.dataAccessService = dataAccessService;
        this.mapper = mapper;
        this.urlShortenerUtil = urlShortenerUtil;
    }

    @Override
    public UrlResponseDTO shortenUrl(UrlRequestDTO urlRequestDTO) {
        String shortUrl = urlShortenerUtil.encode(urlRequestDTO.getUrl());

        ShortenedUrl shortenedUrl = new ShortenedUrl();
        shortenedUrl.setUrl(urlRequestDTO.getUrl());
        shortenedUrl.setHits(0L);
        shortenedUrl.setCode(shortUrl);
        shortenedUrl.setExpirationDate(new Date(System.currentTimeMillis() + expirationTime));
        dataAccessService.create(shortenedUrl);

        UrlResponseDTO urlResponseDTO = new UrlResponseDTO();
        urlResponseDTO.setShortUrl(shortUrl);
        return urlResponseDTO;
    }
}
