package com.parking.mongodb.dao;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
																																																																																																																						
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.parking.entity.Customer;
import com.parking.mongodb.converter.CustomerConverter;

//DAO class for different MongoDB CRUD operations
//take special note of "id" String to ObjectId conversion and vice versa
//also take note of "_id" key for primary key
public class MongoDBCustomerDAO {
	
	private DBCollection col;
	
	public MongoDBCustomerDAO(MongoClient mongo) {
		this.col = mongo.getDB("parking").getCollection("customer");
		System.out.print(this.col.getName());
	}
	
	public Customer createCustomer(Customer c) {
		DBObject doc = CustomerConverter.toDBObject(c);
		this.col.insert(doc);
		ObjectId id = (ObjectId) doc.get("_id");
		c.setDriverLicenceId(id.toString());
		return c;
	}
	
	
	public Customer readCustomer(Customer c) {
		DBObject query = BasicDBObjectBuilder.start()
				.append("_id", new ObjectId(c.getDriverLicenceId())).get();
		DBObject data = this.col.findOne(query);
		return CustomerConverter.toCustomer(data);
	}
	
	public void updateCustomer(Customer c) {
		DBObject query = BasicDBObjectBuilder.start()
				.append("_id", new ObjectId(c.getDriverLicenceId())).get();
		this.col.update(query, CustomerConverter.toDBObject(c));
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
