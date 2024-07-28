package com.gabrielcarvalhotp.workshop.controllers.helpers;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

public class URIHelper {

    public static <T> URI createUri(String path, T id) {
        return ServletUriComponentsBuilder.fromCurrentRequestUri().path(path).buildAndExpand(id).toUri();
    }

    public static String decodeUrlParam(String param) {
        return URLDecoder.decode(param, StandardCharsets.UTF_8);
    }
}
