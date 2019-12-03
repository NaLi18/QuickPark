package com.parking.mongodb.converter;

import org.bson.types.ObjectId;


import com.parking.entity.GarageOwner;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;

public class GarageOwnerConverter {

	// convert GarageOwner Object to MongoDB DBObject
	// take special note of converting id String to ObjectId
	public static DBObject toDBObject(GarageOwner o) {

		BasicDBObjectBuilder builder = BasicDBObjectBuilder.start()
				.append("id", o.getGarageOwnerID()).append("name", o.getName()).append("password", o.getPassword()).append("phone", o.getPhone()).append("email", o.getEmail());
//		if (o.getGarageOwnerID() != null)
//			builder = builder.append("_id", new ObjectId(o.getGarageOwnerID()));
		return builder.get();
	}

	// convert DBObject Object to GarageOwner
	// take special note of converting ObjectId to String
	public static GarageOwner toGarageOwner(DBObject doc) {
		GarageOwner o = new GarageOwner();
		o.setName((String) doc.get("name"));
		o.setPassword((String) doc.get("password"));
		o.setPhone((String) doc.get("phone"));
		o.setEmail((String) doc.get("email"));
		
		//ObjectId id = (ObjectId) doc.get("_id");
		o.setGarageOwnerID((String) doc.get("id"));
		return o;

	}
}