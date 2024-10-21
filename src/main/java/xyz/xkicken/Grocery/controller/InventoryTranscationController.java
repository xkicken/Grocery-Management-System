package xyz.xkicken.Grocery.controller;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xyz.xkicken.Grocery.InventoryTransaction.model.InventoryTableDisplay;
import xyz.xkicken.Grocery.InventoryTransaction.service.InventoryTransactionService;

@RestController
@RequestMapping("/api/inventory")
public class InventoryTranscationController {
    private final InventoryTransactionService inventoryTransactionService;

    public InventoryTranscationController(InventoryTransactionService inventoryTransactionService) {
        this.inventoryTransactionService = inventoryTransactionService;
    }

    @GetMapping("/table/paginated")
    public Page<InventoryTableDisplay> getInventoryTableView(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "100") Integer size,
            @RequestParam(defaultValue = "inventoryTransactionId") String sortBy,
            @RequestParam(defaultValue = "asc") String direction
    ) {
        return inventoryTransactionService.getInventoryTableView(page, size, sortBy, direction);
    }

    @GetMapping("/table/paginated/search")
    public Page<InventoryTableDisplay> getInventoryTableViewBySearch(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "100") Integer size,
            @RequestParam String query
    ) {
        return inventoryTransactionService.getInventoryTableViewBySearch(page, size, query);
    }
}
