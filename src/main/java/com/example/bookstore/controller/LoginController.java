package com.example.bookstore.controller;

import com.example.bookstore.data.dto.LoginRequestDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class LoginController {

  @Value("${spring.security.oauth2.client.registration.keycloak.client-id}")
  private String clientId;

  @Value("${spring.security.oauth2.client.registration.keycloak.client-secret}")
  private String clientSecret;

  @Value("${spring.security.oauth2.resourceserver.jwt.issuer-uri}")
  private String baseUrl;

  @PostMapping("/login")
  public ResponseEntity<?> login(@RequestBody LoginRequestDto loginRequestDto) {
    String tokenUrl = baseUrl + "/protocol/openid-connect/token";

    MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<>();
    requestBody.add("client-id", clientId);
    requestBody.add("username", loginRequestDto.username());
    requestBody.add("password", loginRequestDto.password());
    requestBody.add("grant_type", "password");
    requestBody.add("client_secret", clientSecret);

    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<String> response = restTemplate.postForEntity(tokenUrl, requestBody, String.class);

    return ResponseEntity.ok(response.getBody());
  }
}
