package com.parking.mongodb.dao;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.parking.entity.GarageOwner;
import com.parking.mongodb.converter.GarageOwnerConverter;

//DAO class for different MongoDB CRUD operations
//take special note of "id" String to ObjectId conversion and vice versa
//also take note of "_id" key for primary key
public class MongoDBGarageOwnerDAO {
	private DBCollection col;
	
//	@SuppressWarnings("deprecation")
	public MongoDBGarageOwnerDAO(MongoClient mongo) {
//		this.col = mongo.getDB("parking").getCollection("GarageOwner");
		mongo = new MongoClient("localhost", 27017);
		DB db = mongo.getDB("parking");
		this.col = db.getCollection("garageOwner");
	}
	
	public GarageOwner createGarageOwner(GarageOwner c) {
		DBObject doc = GarageOwnerConverter.toDBObject(c);
		this.col.insert(doc);
//		ObjectId id = (ObjectId) doc.get("_id");
//		c.setGarageOwnerID(id.toString());
		return c;
	}
	
	
	public boolean findGarageOwner(String email, String password) {
		DBObject query = new BasicDBObject("email", email).append("password", password);
		
		return this.col.findOne(query) !=null;
	}
	
	public void updateGarageOwner(GarageOwner c) {
		DBObject query = BasicDBObjectBuilder.start()
				.append("_id", new ObjectId(c.getGarageOwnerID())).get();
		this.col.update(query, GarageOwnerConverter.toDBObject(c));
	}

	public List<GarageOwner> readAllGarageOwner() {
		List<GarageOwner> data = new ArrayList<GarageOwner>();
		DBCursor cursor = col.find();
		while (cursor.hasNext()) {
			DBObject doc = cursor.next();
			GarageOwner c = GarageOwnerConverter.toGarageOwner(doc);
			data.add(c);
		}
		return data;
	}

	public void deleteGarageOwner(GarageOwner c) {
		DBObject query = BasicDBObjectBuilder.start()
				.append("_id", new ObjectId(c.getGarageOwnerID())).get();
		this.col.remove(query);
	}
}
