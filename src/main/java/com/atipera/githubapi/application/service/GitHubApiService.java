package com.atipera.githubapi.application.service;

import com.atipera.githubapi.adapter.github.client.GitHubClient;
import com.atipera.githubapi.adapter.github.dto.BranchDTO;
import com.atipera.githubapi.adapter.github.dto.GitHubRepositoryDTO;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GitHubApiService {
    private final GitHubClient client;

    public List<GitHubRepositoryDTO> getGitHubRepositories(@NonNull String username) {
        return client.getGitHubRepositories(username).stream().filter(repo -> !repo.fork()).toList();
    }
    public List<BranchDTO> getBranchesForRepo(@NonNull String repoUrl){
        return client.getBranchesForRepo(repoUrl);
    }
}
