package com.rent.flow.notification;

import com.rent.flow.notification.Utils.UserRegisteredEvent;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationEventPublisher;

@SpringBootApplication
public class NotificationApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotificationApplication.class, args);
	}

	@Autowired
	private ApplicationEventPublisher publisher;

	public void registerUser(String email) {
		// Save the user to the database or do whatever setup is needed
		publisher.publishEvent(new UserRegisteredEvent(email));
	}
}
