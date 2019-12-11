package com.parking.mongodb.listener;

import java.net.UnknownHostException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

@WebListener
public class MongoDBContextListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent sce) {
		MongoClient mongo = (MongoClient) sce.getServletContext()
							.getAttribute("MONGO_CLIENT");
		mongo.close();
		System.out.println("MongoClient closed successfully");
	}

	public void contextInitialized(ServletContextEvent sce) {
		ServletContext ctx = sce.getServletContext();
		MongoClientURI uri = new MongoClientURI(
			    "mongodb://dbUser:avPfuLAPYbvM5hEE@cluster0-shard-00-00-di5uy.mongodb.net:27017,cluster0-shard-00-01-di5uy.mongodb.net:27017,cluster0-shard-00-02-di5uy.mongodb.net:27017/test?ssl=true&replicaSet=Cluster0-shard-0&authSource=admin&retryWrites=true&w=majority");
			MongoClient mongoClient = new MongoClient(uri);
			MongoDatabase database = mongoClient.getDatabase("parking");

		/*
		MongoClient mongo = new MongoClient(
				ctx.getInitParameter("MONGODB_HOST"), 
				Integer.parseInt(ctx.getInitParameter("MONGODB_PORT")));
				*/
		System.out.println("MongoClient initialized successfully");
		sce.getServletContext().setAttribute("MONGO_CLIENT", mongoClient);
	}

}