package com.parking.mongodb.converter;

import org.bson.types.ObjectId;

import com.parking.entity.Administer;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;

public class AdministerConverter {
	// convert Administer Object to MongoDB DBObject
		// take special note of converting id String to ObjectId
		public static DBObject toDBObject(Administer a) {

			BasicDBObjectBuilder builder = BasicDBObjectBuilder.start()
					.append("administerId",a.getAdministerId())
					.append("adminName", a.getAdminName())
					.append("adminPassword", a.getAdminPassword())
					.append("adminPhone", a.getAdminPhone())
					.append("adminEmail", a.getAdminEmail());
			return builder.get();
		}

		// convert DBObject Object to Administer
		// take special note of converting ObjectId to String
		public static Administer toAdminister(DBObject doc) {
			Administer a = new Administer();
			a.setAdministerId((String) doc.get("administerId"));
			a.setAdminName((String) doc.get("adminName"));
			a.setAdminPassword((String) doc.get("adminPassword"));
			a.setAdminPhone((String) doc.get("adminPhone"));
			a.setAdminEmail((String) doc.get("adminEmail"));
			
			return a;

		}
}
