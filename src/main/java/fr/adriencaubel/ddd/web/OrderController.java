package fr.adriencaubel.ddd.web;

import fr.adriencaubel.ddd.application.CreateOrderUseCase;
import fr.adriencaubel.ddd.web.dto.OrderRequestModel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {
    private final CreateOrderUseCase createOrderUseCase;

    /**
     * curl --request POST \
     *   --url http://localhost:8087/api/orders \
     *   --header 'content-type: application/json' \
     *   --data '{
     *   "clientId": 1,
     *   "articleId": 1,
     *   "quantity": 1,
     *   "providerId": 1
     * }'
     */
    @PostMapping
    public void createOrder(@RequestBody OrderRequestModel orderRequestModel) {
        createOrderUseCase.create(orderRequestModel.articleId(), orderRequestModel.providerId(), orderRequestModel.clientId(), orderRequestModel.quantity());
    }
}
