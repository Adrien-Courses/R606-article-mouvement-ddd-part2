package fr.adriencaubel.ddd.web;

import fr.adriencaubel.ddd.application.InventoryUseCase;
import fr.adriencaubel.ddd.domain.Stock;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/articles")
@RequiredArgsConstructor
public class ArticleController {

    private final InventoryUseCase inventoryUseCase;

    @GetMapping("{id}/stock")
    public Stock stock(@PathVariable("id") Long id, @RequestParam("providerId") Long providerId) {
        return inventoryUseCase.stock(id, providerId);
    }
}
