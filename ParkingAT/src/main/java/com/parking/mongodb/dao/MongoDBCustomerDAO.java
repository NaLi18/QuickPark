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
import com.parking.entity.Customer;
import com.parking.mongodb.converter.CustomerConverter;

//DAO class for different MongoDB CRUD operations
//take special note of "id" String to ObjectId conversion and vice versa
//also take note of "_id" key for primary key
public class MongoDBCustomerDAO {
	
	private DBCollection col;
	
	
	
	public MongoDBCustomerDAO(MongoClient mongo) {
		
		
		mongo = new MongoClient("localhost", 27017);
		DB db = mongo.getDB("parking");
		this.col = db.getCollection("customer");
	}
	
	public Customer createCustomer(Customer c) {
		DBObject doc = CustomerConverter.toDBObject(c);
		this.col.insert(doc);
		return c;
	}
	
	
	public Customer findCustomer(String email, String password) {		
		DBObject query = new BasicDBObject("email", email).append("password", password);
		if(this.col.findOne(query) !=null) {
			DBObject data= this.col.findOne(query);
			return CustomerConverter.toCustomer(data);
		}
		else {
			return null;
		}
	}
	
	
	public Customer updateCustomer(Customer c) {
		DBObject query = new BasicDBObject("email", c.getEmail());
		this.col.update(query, CustomerConverter.toDBObject(c));
		DBObject data = this.col.findOne(query);
		return CustomerConverter.toCustomer(data);
	}
	public Customer readCustomer(Customer c) {
		DBObject query = BasicDBObjectBuilder.start()
				.append("_id", new ObjectId(c.getDriverLicenceId())).get();
		DBObject data = this.col.findOne(query);
		return CustomerConverter.toCustomer(data);
	}
	public List<Customer> readAllCustomer() {
		List<Customer> data = new ArrayList<Customer>();
		DBCursor cursor = col.find();
		while (cursor.hasNext()) {
			DBObject doc = cursor.next();
			Customer c = CustomerConverter.toCustomer(doc);
			data.add(c);
		}
		return data;
	}

	public void deleteCustomer(Customer c) {
		DBObject query = BasicDBObjectBuilder.start()
				.append("_id", new ObjectId(c.getDriverLicenceId())).get();
		this.col.remove(query);
	}
}
