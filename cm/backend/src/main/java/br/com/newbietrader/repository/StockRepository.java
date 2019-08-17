package br.com.newbietrader.repository;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;

import br.com.newbietrader.dto.StockDTO;
import br.com.newbietrader.entity.Stock;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.FindOneAndUpdateOptions;
import com.mongodb.client.model.ReturnDocument;
import org.bson.Document;
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
			Bson condition = Filters.eq("_id", stock.getId());

			Document doc = new Document();
			doc.put("name", stock.getName());
			doc.put("date", stock.getDate());

			Document valueDoc = new Document();
			valueDoc.put("start", stock.getValue().getStart());
			valueDoc.put("end", stock.getValue().getEnd());

			doc.put("value", valueDoc);

			collection.updateOne(condition, new Document("$set", doc));
		} else {
			collection.insertOne(stock);
		}
	}

	public Optional<Stock> findOne(ObjectId id) {
		for (Stock stock : getCollection().find(Filters.eq("_id", id))) {
			return Optional.of(stock);
		}
		return Optional.empty();
	}

	public void delete(ObjectId id) {
		getCollection().findOneAndDelete(Filters.eq("_id", id));
	}

	private MongoCollection<Stock> getCollection() {
		return mongoClient.getDatabase("db1go")
				.getCollection("stocks", Stock.class);
	}

}
