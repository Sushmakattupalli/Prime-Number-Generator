package Project.PrimeNumberGenerator.Controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Project.PrimeNumberGenerator.Entity.PrimeNumberGeneratorEntity;
import Project.PrimeNumberGenerator.Repository.PrimeRepository;
import Project.PrimeNumberGenerator.impl.PrimeNumber;

/**
 * Author: Sushma Kattupalli
 * Date: 30-05-2024
 * Description: This class defines a REST controller for generating prime numbers within a given range
 *              using different algorithms. It also logs the details of each prime number generation request.
 */
@RestController
public class PrimeNumberController {

    /**
     * Autowired instance of PrimeNumber service to utilize its methods for prime number generation.
     */
    @Autowired
    private PrimeNumber primenumber;

    /**
     * Autowired instance of PrimeRepository to save log entries.
     */
    @Autowired
    private PrimeRepository primerepository;

    /**
     * Endpoint to generate prime numbers within a specified range using a selected algorithm.
     * @param start: The starting number of the range.
     * @param end: The ending number of the range.
     * @param algorithm: The algorithm to use for prime number generation ("algorithm1" or "algorithm2").
     * @return A list of prime numbers within the specified range.
     * @throws IllegalArgumentException if an invalid algorithm is specified.
     */
    @GetMapping("/number")
    public List<Integer> getnumber(@RequestParam("start") int start,
                                   @RequestParam("end") int end,
                                   @RequestParam("algorithm") String algorithm) {

        // Record the start time for performance measurement
        long startTime = System.nanoTime();

        // Declare a variable to hold the list of prime numbers
        List<Integer> number;

        // Determine which algorithm to use based on the "algorithm" parameter
        if ("algorithm1".equalsIgnoreCase(algorithm)) {
            number = primenumber.Algorithm1(start, end);
        } else if ("algorithm2".equalsIgnoreCase(algorithm)) {
            number = primenumber.Algorithm2(start, end);
        } else {
            // Throw an exception if an invalid algorithm is specified
            throw new IllegalArgumentException("Invalid algorithm: " + algorithm);
        }

        // Record the end time for performance measurement
        long endTime = System.nanoTime();

        // Calculate the time taken to execute the algorithm
        double timeElapsed = (endTime - startTime) / 1_000_000.0;

        // Create a new log entry to save to the database
        PrimeNumberGeneratorEntity log = new PrimeNumberGeneratorEntity();
        log.setTimestamp(LocalDateTime.now());
        log.setRangeStart(start);
        log.setRangeEnd(end);
        log.setTimeElapsed(timeElapsed);
        log.setAlgorithm(algorithm);
        log.setPrimeCount(number.size());
        primerepository.save(log);
     // Return the list of prime numbers
        return number;
    }
}
