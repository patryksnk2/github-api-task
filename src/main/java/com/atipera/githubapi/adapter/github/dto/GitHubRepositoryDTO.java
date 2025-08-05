package com.atipera.githubapi.adapter.github.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record GitHubRepositoryDTO(
        String name,
        OwnerDTO owner,
        @JsonProperty("branches_url") String branchesUrl
) {
}