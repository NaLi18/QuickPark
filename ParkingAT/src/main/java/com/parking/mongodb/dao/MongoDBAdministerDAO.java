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
import com.parking.entity.Administer;
import com.parking.mongodb.converter.AdministerConverter;

//DAO class for different MongoDB CRUD operations
//take special note of "id" String to ObjectId conversion and vice versa
//also take note of "_id" key for primary key
public class MongoDBAdministerDAO {
	private DBCollection col;
	
//	@SuppressWarnings("deprecation")
	public MongoDBAdministerDAO(MongoClient mongo) {
		mongo = new MongoClient("localhost", 27017);
		DB db = mongo.getDB("parking");
		this.col = db.getCollection("administer");
	}
	
	public Administer createAdminister(Administer c) {
		DBObject doc = AdministerConverter.toDBObject(c);
		this.col.insert(doc);
		return c;
	}
	
	
	public boolean findAdminister(String email, String password) {
		DBObject query = new BasicDBObject("adminEmail", email).append("adminPassword", password);
		
		return this.col.findOne(query) !=null;
	}
	
	public void updateAdminister(Administer c) {
		DBObject query = BasicDBObjectBuilder.start()
				.append("_id", new ObjectId(c.getAdministerId())).get();
		this.col.update(query, AdministerConverter.toDBObject(c));
	}

	public List<Administer> readAllAdminister() {
		List<Administer> data = new ArrayList<Administer>();
		DBCursor cursor = col.find();
		while (cursor.hasNext()) {
			DBObject doc = cursor.next();
			Administer c = AdministerConverter.toAdminister(doc);
			data.add(c);
		}
		return data;
	}

	public void deleteAdminister(Administer c) {
		DBObject query = BasicDBObjectBuilder.start()
				.append("_id", new ObjectId(c.getAdministerId())).get();
		this.col.remove(query);
	}
}
