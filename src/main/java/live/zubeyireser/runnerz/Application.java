package live.zubeyireser.runnerz;

import live.zubeyireser.runnerz.run.Location;
import live.zubeyireser.runnerz.run.Run;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class Application {

	/*
	* Simple Logging Facade for Java (SLF4J):
	* The Simple Logging Facade for Java (SLF4J) serves as a simple facade or
	* abstraction for various logging frameworks  (e.g. java.util.logging, logback, log4j)
	* allowing the end user to plug in the desired logging framework at deployment time.
	* */
	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	/*    This is a functional interface and can therefore be used as the assignment target for a lambda expression or method reference.*/
	@Bean
	CommandLineRunner runner() {
		return args -> {
			Run run = new Run(1,"First Run", LocalDateTime.now(),LocalDateTime.now().plusMinutes(30),3, Location.OUTDOOR);
			log.info("Run: " + run);
		};
	}
}
