package com.sakshi.urlShortenerService.controller;

import com.lendoapp.response.ApiResponse;
import com.sakshi.urlShortenerService.constants.CommonConstants;
import com.sakshi.urlShortenerService.dto.request.UrlRequestDTO;
import com.sakshi.urlShortenerService.service.UrlShortenerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/url/shortner")
public class UrlShortenerController {
    private final UrlShortenerService urlShortenerService;

    public UrlShortenerController(UrlShortenerService urlShortenerService) {
        this.urlShortenerService = urlShortenerService;
    }

    @PostMapping
    public ApiResponse create(@RequestBody UrlRequestDTO urlRequestDTO){
        return new ApiResponse(HttpStatus.OK, true,urlShortenerService.shortenUrl(urlRequestDTO), CommonConstants.REQUEST_COMPLEDTED_SUCCESSFULLY);
    }
}

