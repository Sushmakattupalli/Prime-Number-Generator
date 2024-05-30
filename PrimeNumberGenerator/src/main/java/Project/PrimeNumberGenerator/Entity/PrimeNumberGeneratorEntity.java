package Project.PrimeNumberGenerator.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Author: Sushma Kattupalli
 * Date: 30-05-2024
 * Description: This entity class defines the structure to store information about prime number generation,including the timestamp,
 *  range, algorithm used, and performance metrics.
 *  
 *  Represents an entity for storing details of prime number generation.
 * This entity is mapped to the "prime_number_generator" table in the database.
 */
@Entity
@Table(name="prime_number_generator")
public class PrimeNumberGeneratorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime timestamp;
    private int rangeStart;
    private int rangeEnd;
    private double timeElapsed;
    private String algorithm;
    private int primeCount;

    /**
     * Default constructor.
     * Initializes a new instance of the PrimeNumberGeneratorEntity class.
     */
    public PrimeNumberGeneratorEntity() {
		
	}

    /**
     * Parameterized constructor.
     * @param id The unique identifier of the entity.
     * @param timestamp The timestamp when the prime number generation occurred.
     * @param rangeStart The starting number of the range for prime number generation.
     * @param rangeEnd The ending number of the range for prime number generation.
     * @param timeElapsed The time taken to generate prime numbers in milliseconds.
     * @param algorithm The algorithm used for prime number generation.
     * @param primeCount The count of prime numbers generated within the specified range.
     */
    public PrimeNumberGeneratorEntity(Long id, LocalDateTime timestamp, int rangeStart, int rangeEnd,
			double timeElapsed, String algorithm, int primeCount) {
		this.id = id;
		this.timestamp = timestamp;
		this.rangeStart = rangeStart;
		this.rangeEnd = rangeEnd;
		this.timeElapsed = timeElapsed;
		this.algorithm = algorithm;
		this.primeCount = primeCount;
	}

    /**
     * Gets the unique identifier of the entity.
     * @return The unique identifier of the entity.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the entity.
     * @param id The unique identifier of the entity.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the timestamp when the prime number generation occurred.
     * @return The timestamp when the prime number generation occurred.
     */
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    /**
     * Sets the timestamp when the prime number generation occurred.
     * @param timestamp The timestamp when the prime number generation occurred.
     */
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    /**
     * Gets the starting number of the range for prime number generation.
     * @return The starting number of the range for prime number generation.
     */
    public int getRangeStart() {
        return rangeStart;
    }

    /**
     * Sets the starting number of the range for prime number generation.
     * @param rangeStart The starting number of the range for prime number generation.
     */
    public void setRangeStart(int rangeStart) {
        this.rangeStart = rangeStart;
    }

    /**
     * Gets the ending number of the range for prime number generation.
     * @return The ending number of the range for prime number generation.
     */
    public int getRangeEnd() {
        return rangeEnd;
    }

    /**
     * Sets the ending number of the range for prime number generation.
     * @param rangeEnd The ending number of the range for prime number generation.
     */
    public void setRangeEnd(int rangeEnd) {
        this.rangeEnd = rangeEnd;
    }

    /**
     * Gets the time taken to generate prime numbers in milliseconds.
     * @return The time taken to generate prime numbers in milliseconds.
     */
    public double getTimeElapsed() {
        return timeElapsed;
    }

    /**
     * Sets the time taken to generate prime numbers in milliseconds.
     * @param timeElapsed The time taken to generate prime numbers in milliseconds.
     */
    public void setTimeElapsed(double timeElapsed) {
        this.timeElapsed = timeElapsed;
    }

    /**
     * Gets the algorithm used for prime number generation.
     * @return The algorithm used for prime number generation.
     */
    public String getAlgorithm() {
        return algorithm;
    }

    /**
     * Sets the algorithm used for prime number generation.
     * @param algorithm The algorithm used for prime number generation.
     */
    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    /**
     * Gets the count of prime numbers generated within the specified range.
     * @return The count of prime numbers generated within the specified range.
     */
    public int getPrimeCount() {
        return primeCount;
    }

    /**
     * Sets the count of prime numbers generated within the specified range.
     * @param primeCount The count of prime numbers generated within the specified range.
     */
    public void setPrimeCount(int primeCount) {
        this.primeCount = primeCount;
    }

    // Overriding toString method for a string representation of the entity
	@Override
	public String toString() {
		return "PrimeNumberGeneratorEntity [id=" + id + ", timestamp=" + timestamp + ", rangeStart=" + rangeStart
				+ ", rangeEnd=" + rangeEnd + ", timeElapsed=" + timeElapsed + ", algorithm=" + algorithm
				+ ", primeCount=" + primeCount + "]";
	}
}
