package com.parking.mongodb.dao;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.parking.entity.Garage;
import com.parking.mongodb.converter.GarageConverter;

//DAO class for different MongoDB CRUD operations
//take special note of "id" String to ObjectId conversion and vice versa
//also take note of "_id" key for primary key
public class MongoDBGarageDAO {
	
	private DBCollection col;
	
	
	
	public MongoDBGarageDAO(MongoClient mongo) {
		
		
		mongo = new MongoClient("localhost", 27017);
		DB db = mongo.getDB("parking");
		this.col = db.getCollection("garage");
	}
	
	public Garage createCustomer(Garage g) {
		DBObject doc = GarageConverter.toDBObject(g);
		this.col.insert(doc);
		return g;
	}
	
	
	public Garage findGrage(String name) {		
		DBObject query = new BasicDBObject("name", name);
		if(this.col.findOne(query) !=null) {
			DBObject data= this.col.findOne(query);
			return GarageConverter.toGarage(data);
		}
		else {
			return null;
		}
	}
	
	
	public void updateGarage(Garage g) {
		DBObject query = BasicDBObjectBuilder.start()
				.append("_id", new ObjectId(g.getGarageID())).get();
		this.col.update(query, GarageConverter.toDBObject(g));
	}
	public Garage readCustomer(Garage g) {
		DBObject query = BasicDBObjectBuilder.start()
				.append("_id", new ObjectId(g.getGarageID())).get();
		DBObject data = this.col.findOne(query);
		return GarageConverter.toGarage(data);
	}
	public List<Garage> readAllGarage(String add) {
		List<Garage> data = new ArrayList<Garage>();
		DBObject query = new BasicDBObject("city", add);
		DBCursor cursor = col.find(query);
		while (cursor.hasNext()) {
			DBObject doc = cursor.next();
			Garage g = GarageConverter.toGarage(doc);
			data.add(g);
		}
		return data;
	}

	public void deleteGrage(Garage g) {
		DBObject query = BasicDBObjectBuilder.start()
				.append("_id", new ObjectId(g.getGarageID())).get();
		this.col.remove(query);
	}
}
