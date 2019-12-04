package com.parking.mongodb.converter;

import org.bson.types.ObjectId;

import com.parking.entity.Reservation;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;


public class ReservationConverter {
	// convert Customer Object to MongoDB DBObject
		// take special note of converting id String to ObjectId
		public static DBObject toDBObject(Reservation r) {

			BasicDBObjectBuilder builder = BasicDBObjectBuilder.start()
					.append("_id",r.getReservationID()).append("userID", r.getUserID()).append("garageID", r.getGarageID()).append("checkInTime", r.getCheckInTime()).append("checkOutTime", r.getCheckOutTime())
					.append("checkInDate", r.getCheckInDate()).append("checkOutDate", r.getCheckOutDate()).append("price", r.getPrice()).append("spot", r.getSpots()).append("paid", r.isPaid()) .append("paymentId", r.getPaymentId());
			//if (c.getDriverLicenceId() != null)
			//	builder = builder.append("_id", new ObjectId(c.getDriverLicenceId()));
			return builder.get();
		}

		// convert DBObject Object to Customer
		// take special note of converting ObjectId to String
		public static Reservation toReservation(DBObject doc) {
			Reservation r = new Reservation();
			ObjectId id = (ObjectId) doc.get("_id");
			r.setReservationID(id.toString());
			r.setUserID((String)doc.get("userID"));
			r.setGarageID((String)doc.get("garageID"));
			r.setPaid((Boolean) doc.get("paid"));
			r.setCheckInTime((String)doc.get("checkInTime"));
			r.setPaymentId((String)doc.get("paymentId"));
			r.setCheckOutDate((String)doc.get("checkOutDate"));
			r.setCheckInDate((String)doc.get("checkInDate"));
			r.setCheckOutTime((String)doc.get("checkOutTime"));
			r.setPrice((Double) doc.get("price"));
			r.setSpots((String)doc.get("spot"));
			
			return r;

		}
}

