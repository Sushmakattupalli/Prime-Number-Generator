package Project.PrimeNumberGenerator.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

/**
 * Provides methods to generate prime numbers using different algorithms.
 *
 * Author: Sushma Kattupalli
 * Date: 30-05-2024
 * Description: This service class contains two algorithms for generating prime numbers within a given range.
 *              Algorithm1 implements the Sieve of Eratosthenes algorithm, while Algorithm2 implements the Segmented Sieve algorithm.
 *              Both algorithms return a list of prime numbers within the specified range.
 */
@Service
public class PrimeNumber {

    /**
     * Algorithm1 (Sieve of Eratosthenes): algorithm to find all prime numbers in a given range.
     * The Sieve of Eratosthenes is an ancient algorithm for finding all prime numbers up to any given limit.
 	 * It works by iteratively marking the multiples of each prime number as composite (not prime), starting from 2.
 	 * After processing all numbers up to the given limit, the remaining unmarked numbers are prime.
 	 *  
     * @param start The starting number of the range.
     * @param end   The ending number of the range.
     * @return A list of prime numbers within the specified range.
     */
	public List<Integer> Algorithm1(int start, int end) {
	    // Initialize an array to mark numbers as prime or composite
	    boolean[] checkPrime = new boolean[end + 1];
	    
	    // Initialize all numbers from 2 to end as prime initially
	    for (int i = 2; i <= end; i++) {
	        checkPrime[i] = true;
	    }

	    // Apply the Sieve of Eratosthenes algorithm
	    for (int factor = 2; factor * factor <= end; factor++) {
	        if (checkPrime[factor]) {
	            // Mark multiples of the current prime factor as composite
	            for (int j = factor; factor * j <= end; j++) {
	                checkPrime[factor * j] = false;
	            }
	        }
	    }

	    // Collect the prime numbers within the specified range
	    List<Integer> prime = new ArrayList<>();
	    for (int i = Math.max(start, 2); i <= end; i++) {
	        if (checkPrime[i]) {
	            prime.add(i);
	        }
	    }
	    return prime;
	}

    /**
     * Algorithm2 (Segmented Sieve): algorithm to find all prime numbers in a given range.
     * The Segmented Sieve is an optimized version of the Sieve of Eratosthenes, particularly suitable for finding primes in large ranges.
     * It breaks down the range into smaller segments and uses the Sieve of Eratosthenes on each segment individually.
     * The algorithm also utilizes the knowledge of already found primes up to the square root of the segment's upper bound to optimize the process.
     *
     * @param start The starting number of the range.
     * @param end   The ending number of the range.
     * @return A list of prime numbers within the specified range.
     */
	public List<Integer> Algorithm2(int start, int end) {
	    // Initialize a list to store prime numbers within the range
	    List<Integer> prime = new ArrayList<>();
	    
	    // Adjust start if it's less than 2
	    if (start < 2) start = 2;
	    
	    // Calculate the limit for sieving prime numbers
	    int limit = (int) Math.sqrt(end) + 1;
	    
	    // Initialize an array to mark numbers as prime or composite within the range
	    boolean[] checkPrime = new boolean[end - start + 1];

	    // Initialize all numbers within the range as prime initially
	    for (int i = 0; i <= end - start; i++) {
	        checkPrime[i] = true;
	    }

	    // Apply the Segmented Sieve algorithm
	    for (int i = 2; i <= limit; i++) {
	        // Calculate the minimum multiple of i within the range
	        int min = Math.max(i * i, (start + i - 1) / i * i);
	        // Mark multiples of i as composite
	        for (int j = min; j <= end; j += i) {
	            checkPrime[j - start] = false;
	        }
	    }

	    // Collect the prime numbers within the specified range
	    for (int i = start; i <= end; i++) {
	        if (checkPrime[i - start]) {
	            prime.add(i);
	        }
	    }
	    return prime;
	}
}
