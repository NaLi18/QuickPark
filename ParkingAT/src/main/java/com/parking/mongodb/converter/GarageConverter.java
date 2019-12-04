package com.parking.mongodb.converter;

import org.bson.types.ObjectId;
import java.lang.*;
import com.parking.entity.Garage;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;

public class GarageConverter {
	// convert Customer Object to MongoDB DBObject
		// take special note of converting id String to ObjectId
		public static DBObject toDBObject(Garage g) {

			BasicDBObjectBuilder builder = BasicDBObjectBuilder.start()
					.append("city", g.getCity())
					.append("address", g.getLocation())
					.append("name", g.getName())
					.append("section", g.getSection())
					.append("lat", g.getLatitude())
					.append("lng", g.getLongitude())
					.append("unitPrice",g.getUnitPrice())
					.append("capacity",g.getCapacity())
					.append("ownerName", g.getOwnerID())
					.append("Rate", g.getRate())
					.append("_id", g.getGarageID())
					.append("spot", g.getSpot());
			return builder.get();
		}

		// convert DBObject Object to Customer
		// take special note of converting ObjectId to String
		public static Garage toGarage(DBObject doc) {
			Garage g = new Garage();
			g.setCity((String)doc.get("city"));
			g.setCapacity(((Long)doc.get("capacity")).intValue());
			g.setOwnerID((String)doc.get("ownerName"));
			g.setName((String) doc.get("name"));
			//g.setSection((String[])doc.get("section"));
			g.setLocation((String) doc.get("address"));
			g.setLatitude((Double) doc.get("lat"));
			g.setLongitude((Double) doc.get("lng"));
			g.setUnitPrice((Double) doc.get("unitPrice"));
			g.setRate((Double)doc.get("Rate"));
			g.setSpot(((Long)doc.get("spot")).intValue());
			//g.setGarageID((String) doc.get("_id"));
			return g;
		}
}
