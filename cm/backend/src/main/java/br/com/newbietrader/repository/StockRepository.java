package br.com.newbietrader.repository;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;

import br.com.newbietrader.dto.StockDTO;
import br.com.newbietrader.entity.Stock;
import com.mongodb.client.model.Filters;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

@ApplicationScoped
public class StockRepository {

	@Inject
	private MongoClient mongoClient;

	public List<Stock> findAll() {
		MongoCollection<Stock> collection = getCollection();
		List<Stock> result = new LinkedList<Stock>();
		for (Stock stock : collection.find()) {
			result.add(stock);
		}
		return result;
	}

	public void save(Stock stock) {
		MongoCollection<Stock> collection = getCollection();
		if (stock.getId() != null) {
			System.out.println("Stock ID " + stock.getId() + " alterado com sucesso");
		}
		collection.insertOne(stock);
	}

	public Optional<Stock> findOne(ObjectId id) {
		List<Stock> stocks = this.findAll();
		for(Stock stock : stocks) {
			if (stock.getId().equals(id)) {
				return Optional.of(stock);
			}
		}
		return Optional.empty();
	}

	private MongoCollection<Stock> getCollection() {
		return mongoClient.getDatabase("db1go")
				.getCollection("stocks", Stock.class);
	}

}
