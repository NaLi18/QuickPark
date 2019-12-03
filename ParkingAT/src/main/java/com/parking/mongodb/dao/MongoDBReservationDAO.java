package com.parking.mongodb.dao;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.parking.entity.Reservation;

import com.parking.mongodb.converter.ReservationConverter;

//DAO class for different MongoDB CRUD operations
//take special note of "id" String to ObjectId conversion and vice versa
//also take note of "_id" key for primary key
public class MongoDBReservationDAO {
	
	private DBCollection col;
	
	public MongoDBReservationDAO(MongoClient mongo) {
		this.col = mongo.getDB("parking").getCollection("reservation");
		System.out.print(this.col.getName());
	}
	
	public Reservation createReservation(Reservation r) {
		DBObject doc = ReservationConverter.toDBObject(r);
		this.col.insert(doc);
		//ObjectId id = (ObjectId) doc.get("_id");
		//c.setDriverLicenceId(id.toString());
		return r;
	}
	
	
	public Reservation readReservation(Reservation r) {
		DBObject query = (DBObject) BasicDBObjectBuilder.start()
				.append("userID", r.getUserID()).append("garageID",r.getGarageID());
		DBObject data = this.col.findOne(query);
		return ReservationConverter.toReservation(data);
	}
	
	public void updateReservation(Reservation r) {
		DBObject query = BasicDBObjectBuilder.start()
				.append("userID", new ObjectId(r.getUserID())).get();
		this.col.update(query, ReservationConverter.toDBObject(r));
	}

	public List<Reservation> readAllReservation(Reservation r) {
		List<Reservation> data = new ArrayList<Reservation>();
		DBObject query = new BasicDBObject("userID", r.getUserID()).append("paid",false);
		DBCursor cursor = col.find(query);
		while (cursor.hasNext()) {
			DBObject doc = cursor.next();
			r = ReservationConverter.toReservation(doc);
			data.add(r);
		}
		return data;
	}
	public List<Reservation> readAllHistory(Reservation r) {
		List<Reservation> data = new ArrayList<Reservation>();
		DBObject query = new BasicDBObject("userID", r.getUserID()).append("paid",true);
		DBCursor cursor = col.find(query);
		while (cursor.hasNext()) {
			DBObject doc = cursor.next();
			r = ReservationConverter.toReservation(doc);
			data.add(r);
		}
		return data;
	}

	public void deleteReservation(Reservation r) {
		DBObject query = BasicDBObjectBuilder.start()
				.append("UserID", new ObjectId(r.getUserID())).get();
		this.col.remove(query);
	}
}
