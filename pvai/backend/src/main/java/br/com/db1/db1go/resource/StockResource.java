package br.com.db1.db1go.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.db1.db1go.domain.dto.StockDTO;
import br.com.db1.db1go.service.StockService;

@RestController
public class StockResource {

    @Autowired
    private StockService stockService;
    
    @GetMapping("/api/v1/stock")
    public List<StockDTO> getAll() {
        return stockService.getAll();
    }
    
    @PostMapping("/api/v1/stock")
    public void save(@RequestBody StockDTO stock) {
        stockService.save(stock);
    }
    
}
