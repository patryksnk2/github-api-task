package com.atipera.githubapi.application.controller;

import com.atipera.githubapi.application.service.GitHubApiService;
import com.atipera.githubapi.adapter.github.dto.GitHubRepositoryDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api.github")
public class GitHubController {
    private final GitHubApiService gitHubApiService;

    @GetMapping("/{username}/repos")
    public ResponseEntity<List<GitHubRepositoryDTO>> getRepositories( @Validated @PathVariable String username) {
        List<GitHubRepositoryDTO> repositories = gitHubApiService.getGitHubRepositories(username);
        return ResponseEntity.ok(repositories);
    }
}
