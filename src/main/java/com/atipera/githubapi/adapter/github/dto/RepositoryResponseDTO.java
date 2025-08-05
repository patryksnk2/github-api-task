package com.atipera.githubapi.adapter.github.dto;

import java.util.List;

public record RepositoryResponseDTO(String repositoryName, String ownerLogin, List<BranchDTO> branches) {
}

