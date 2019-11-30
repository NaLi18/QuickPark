package com.parking.mongodb.converter;

import org.bson.types.ObjectId;

import com.parking.entity.Customer;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;

public class CustomerConverter {
	// convert Customer Object to MongoDB DBObject
		// take special note of converting id String to ObjectId
		public static DBObject toDBObject(Customer c) {

			BasicDBObjectBuilder builder = BasicDBObjectBuilder.start()
					.append("name", c.getName()).append("password", c.getPassword()).append("phone", c.getPhone()).append("email", c.getEmail());
			if (c.getDriverLicenceId() != null)
				builder = builder.append("_id", new ObjectId(c.getDriverLicenceId()));
			return builder.get();
		}

		// convert DBObject Object to Customer
		// take special note of converting ObjectId to String
		public static Customer toCustomer(DBObject doc) {
			Customer c = new Customer();
			c.setName((String) doc.get("name"));
			c.setPassword((String) doc.get("password"));
			c.setPhone((String) doc.get("phone"));
			c.setEmail((String) doc.get("email"));
			
			ObjectId id = (ObjectId) doc.get("_id");
			c.setDriverLicenceId(id.toString());
			return c;

		}
}
