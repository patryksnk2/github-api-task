package com.atipera.githubapi.api.controller;

import com.atipera.githubapi.adapter.github.dto.RepositoryResponseDTO;
import com.atipera.githubapi.application.service.GitHubApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/repos")
public class GitHubController {
    private final GitHubApiService gitHubApiService;

    @GetMapping("/{username}")
    public ResponseEntity<List<RepositoryResponseDTO>> getUserRepositories(@PathVariable String username) {
        List<RepositoryResponseDTO> repos = gitHubApiService.getRepositoriesWithBranches(username);
        return ResponseEntity.ok(repos);
    }
}
