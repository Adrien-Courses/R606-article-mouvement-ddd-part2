package fr.adriencaubel.ddd.web.dto;

public record OrderRequestModel(Long articleId, int quantity, Long providerId, Long clientId) {
}
