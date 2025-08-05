package com.atipera.githubapi;

import com.atipera.githubapi.adapter.github.dto.RepositoryResponseDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GitHubControllerIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void should_return_branches_when_user_and_branches_exist() {
        // Given
        String username = "test";

        // When
        ResponseEntity<List<RepositoryResponseDTO>> response = restTemplate.exchange(
                "/api/repos/{username}",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<>() {},
                username
        );

        // Then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(4, response.getBody().size(), "Expected number of repositories");

        RepositoryResponseDTO firstRepo = response.getBody().getFirst();
        assertEquals("HelloWorld", firstRepo.repositoryName());
        assertEquals("test", firstRepo.ownerLogin());
        assertNotNull(firstRepo.branches());
        assertEquals(2, firstRepo.branches().size(), "Expected number of branches for HelloWorld repo");
        assertNotNull(firstRepo.branches().getFirst().commit().sha(), "Commit SHA should not be null");
    }
}
