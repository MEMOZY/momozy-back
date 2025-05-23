package com.memozy.memozy_back.global.feign.oauth.kakao;

import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "kakaoApiClient", url = "https://kapi.kakao.com")
public interface KakaoServerClient {

    @PostMapping(value = "/v2/user/me")
    KakaoSocialUserProfile getUserInformation(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String accessToken
    );


}