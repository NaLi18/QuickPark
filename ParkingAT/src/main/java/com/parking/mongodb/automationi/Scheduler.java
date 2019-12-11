package com.parking.mongodb.automationi;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.parking.entity.Customer;
import com.parking.entity.Reservation;
import com.parking.mongodb.dao.MongoDBReservationDAO;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.mongodb.core.query.Criteria;
// //import org.springframework.boot.CommandLineRunner;
// //import org.springframework.boot.SpringApplication;
// import org.springframework.data.mongodb.core.query.Query;
// import org.springframework.data.mongodb.core.query.Update;

@Component
@EnableScheduling
public class Scheduler
{
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    @Autowired
	private MongoDBReservationDAO repository;

	@Scheduled(cron = "* * * ? * *")
	public void reportCurrentTime()
	{
		Reservation r = new Reservation();
        System.out.println("Current time = " + dateFormat.format(new Date()));
        // fetch all customers
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (Reservation reservation: repository.readAllReservation(r)) {
			System.out.println(reservation);
		}
		// Query query = new Query(Criteria.where("firstName").is("Harry"));
        // Update update = new Update().inc("age", 1);
        // Customer p = repository.findAndModify(query, update, Customer.class);
		// System.out.println();
	}
}