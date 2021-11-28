package com.example.api.remoteservices.giphy;

import com.example.api.remoteservices.giphy.data.Gif;
import feign.Param;
import feign.RequestLine;

public interface Giphy {

    @RequestLine("GET /v1/gifs/search?api_key={apiGifKey}&q={happyQuerry}")
    Gif rich(@Param("apiGifKey") String apiGifKey, @Param("happyQuerry") String happyQuerry);

}
