package com.atipera.githubapi.adapter.github.client;

import com.atipera.githubapi.adapter.github.dto.BranchDTO;
import com.atipera.githubapi.adapter.github.dto.GitHubRepositoryDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RequiredArgsConstructor
@Component
public class GitHubClient {
    private final RestTemplate restTemplate;

    public List<GitHubRepositoryDTO> getGitHubRepositories(String username) {
        String url = String.format("https://api.github.com/users/%s/repos", username);
        ResponseEntity<List<GitHubRepositoryDTO>> response = exchangeRequest(url, new ParameterizedTypeReference<List<GitHubRepositoryDTO>>() {
        });

        return response.getBody();
    }

    public List<BranchDTO> getBranchesForRepo(String repoUrl) {
        ResponseEntity<List<BranchDTO>> response = exchangeRequest(repoUrl, new ParameterizedTypeReference<List<BranchDTO>>() {
        });
        return response.getBody();
    }

    private <T> ResponseEntity<T> exchangeRequest(String url, ParameterizedTypeReference<T> typeReference) {
        return restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                typeReference
        );
    }
}
