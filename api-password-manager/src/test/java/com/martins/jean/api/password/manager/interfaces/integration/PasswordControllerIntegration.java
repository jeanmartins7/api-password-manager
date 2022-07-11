package com.martins.jean.api.password.manager.interfaces.integration;

import com.martins.jean.api.password.manager.interfaces.json.request.PasswordRequest;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import java.net.URI;
import java.net.URISyntaxException;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PasswordControllerIntegration {

    private String baseUrl;
    private URI uri;

    @Autowired
    private TestRestTemplate testRestTemplate;
    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() throws URISyntaxException {
        baseUrl = "http://localhost:" + port + "/api/v1/password-manager/verify";
        uri = new URI(baseUrl);
    }

    @Test
    @DisplayName("when post verify password and returns password is valid")
    void post_verifyPassword_ReturnsTrue() throws URISyntaxException {
        PasswordRequest passwordRequest = getRequestPasswordEmpty();
        passwordRequest.setPassword("AbTp9!fok");


        ResponseEntity<Boolean> passwordVerifyResponse = testRestTemplate.postForEntity(uri, passwordRequest, Boolean.class);

        Assertions.assertNotNull(passwordVerifyResponse);
        Assertions.assertEquals(200, passwordVerifyResponse.getStatusCodeValue());
        Assertions.assertEquals(true, passwordVerifyResponse.getBody());

    }

    @Test
    @DisplayName("when post verify password and returns password is not valid because password no has  9 Characters")
    void post_verifyPassword_ReturnsFalseBecausePasswordNotHasNineCharacter() throws URISyntaxException {
        PasswordRequest passwordRequest = getRequestPasswordEmpty();
        passwordRequest.setPassword("AbTp9!fk");

        ResponseEntity<Boolean> passwordVerifyResponse = testRestTemplate.postForEntity(uri, passwordRequest, Boolean.class);

        Assertions.assertNotNull(passwordVerifyResponse);
        Assertions.assertEquals(400, passwordVerifyResponse.getStatusCodeValue());
        Assertions.assertEquals(false, passwordVerifyResponse.getBody());

    }

    @Test
    @DisplayName("when post verify password and returns password is not valid because password no has Upper Characters")
    void post_verifyPassword_ReturnsFalseBecausePasswordNotHasUpperCharacter() throws URISyntaxException {
        PasswordRequest passwordRequest = getRequestPasswordEmpty();
        passwordRequest.setPassword("abtp9!fok");

        ResponseEntity<Boolean> passwordVerifyResponse = testRestTemplate.postForEntity(uri, passwordRequest, Boolean.class);

        Assertions.assertNotNull(passwordVerifyResponse);
        Assertions.assertEquals(400, passwordVerifyResponse.getStatusCodeValue());
        Assertions.assertEquals(false, passwordVerifyResponse.getBody());

    }

    @Test
    @DisplayName("when post verify password and returns password is not valid because password no has Low Characters")
    void post_verifyPassword_ReturnsFalseBecausePasswordNotHasLowCharacter() throws URISyntaxException {
        PasswordRequest passwordRequest = getRequestPasswordEmpty();
        passwordRequest.setPassword("ABTP9!FOK");

        ResponseEntity<Boolean> passwordVerifyResponse = testRestTemplate.postForEntity(uri, passwordRequest, Boolean.class);

        Assertions.assertNotNull(passwordVerifyResponse);
        Assertions.assertEquals(400, passwordVerifyResponse.getStatusCodeValue());
        Assertions.assertEquals(false, passwordVerifyResponse.getBody());

    }

    @Test
    @DisplayName("when post verify password and returns password is not valid because password no has number Characters")
    void post_verifyPassword_ReturnsFalseBecausePasswordNotHasNumberCharacter() throws URISyntaxException {
        PasswordRequest passwordRequest = getRequestPasswordEmpty();
        passwordRequest.setPassword("AbTpm!fok");

        ResponseEntity<Boolean> passwordVerifyResponse = testRestTemplate.postForEntity(uri, passwordRequest, Boolean.class);

        Assertions.assertNotNull(passwordVerifyResponse);
        Assertions.assertEquals(400, passwordVerifyResponse.getStatusCodeValue());
        Assertions.assertEquals(false, passwordVerifyResponse.getBody());

    }

    @Test
    @DisplayName("when post verify password and returns password is not valid because password no has Character Special ")
    void post_verifyPassword_ReturnsFalseBecausePasswordNotHasSpecialCharacter() throws URISyntaxException {
        PasswordRequest passwordRequest = getRequestPasswordEmpty();
        passwordRequest.setPassword("AbTp9lfok");

        ResponseEntity<Boolean> passwordVerifyResponse = testRestTemplate.postForEntity(uri, passwordRequest, Boolean.class);

        Assertions.assertNotNull(passwordVerifyResponse);
        Assertions.assertEquals(400, passwordVerifyResponse.getStatusCodeValue());
        Assertions.assertEquals(false, passwordVerifyResponse.getBody());

    }

    @Test
    @DisplayName("when post verify password and returns password is not valid because password has same Characters")
    void post_verifyPassword_ReturnsFalseBecausePasswordHasSameCharacter() throws URISyntaxException {
        PasswordRequest passwordRequest = getRequestPasswordEmpty();
        passwordRequest.setPassword("AbTp9!fokA");

        ResponseEntity<Boolean> passwordVerifyResponse = testRestTemplate.postForEntity(uri, passwordRequest, Boolean.class);

        Assertions.assertNotNull(passwordVerifyResponse);
        Assertions.assertEquals(400, passwordVerifyResponse.getStatusCodeValue());
        Assertions.assertEquals(false, passwordVerifyResponse.getBody());

    }

    @Test
    @DisplayName("when post verify password and returns password is not valid because password has White Space")
    void post_verifyPassword_ReturnsFalseBecausePasswordHasWhiteSpace() throws URISyntaxException {
        PasswordRequest passwordRequest = getRequestPasswordEmpty();
        passwordRequest.setPassword("Ab9! fok");

        ResponseEntity<Boolean> passwordVerifyResponse = testRestTemplate.postForEntity(uri, passwordRequest, Boolean.class);

        Assertions.assertNotNull(passwordVerifyResponse);
        Assertions.assertEquals(400, passwordVerifyResponse.getStatusCodeValue());
        Assertions.assertEquals(false, passwordVerifyResponse.getBody());

    }

    private PasswordRequest getRequestPasswordEmpty() {
        return PasswordRequest.builder()
                .password("")
                .build();
    }
}
