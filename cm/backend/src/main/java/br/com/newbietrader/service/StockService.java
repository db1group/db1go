package br.com.newbietrader.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.com.newbietrader.adapter.StockAdapter;
import br.com.newbietrader.dto.StockDTO;
import br.com.newbietrader.entity.Stock;
import br.com.newbietrader.repository.StockRepository;
import org.bson.types.ObjectId;

@ApplicationScoped
public class StockService {

	@Inject
	private StockRepository stockRepository;

	public List<StockDTO> findAll() {
		return stockRepository.findAll().stream()
				.map(StockAdapter::toDTO)
				.collect(Collectors.toList());
	}

	public void save(StockDTO dto) {
		Stock stock = StockAdapter.toEntity(dto);
		stockRepository.save(stock);
	}

	public void update(ObjectId id, StockDTO dto) {
		Stock stock = stockRepository.findOne(id)
				.orElseThrow(() -> new RuntimeException("Stock de ID " + id + " não encontrado"));
		stock.setDate(dto.getDate());
		stock.setName(dto.getName());
		stock.getValue().setStart(dto.getValue().getStart());
		stock.getValue().setEnd(dto.getValue().getEnd());
		stockRepository.save(stock);
	}

	public StockDTO findOne(ObjectId id) {
		Stock stock = stockRepository.findOne(id)
				.orElseThrow(() -> new RuntimeException("Stock de ID " + id + " não encontrado"));
		return StockAdapter.toDTO(stock);
	}

}
