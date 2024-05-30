package Project.PrimeNumberGenerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The main class for the Prime Number Generator application.
 *
 * Author: Sushma Kattupalli
 * Date: 30-05-2024
 * Description: This class initializes and runs the Spring Boot application for the Prime Number Generator.
 *              It uses Spring Boot's auto-configuration to configure the application and start the Spring context.
 */
@SpringBootApplication
public class PrimeNumberGeneratorApplication {

    /**
     * Main method to start the Prime Number Generator application.
     * @param args The command-line arguments passed to the application.
     */
    public static void main(String[] args) {
        SpringApplication.run(PrimeNumberGeneratorApplication.class, args);
    }
}
