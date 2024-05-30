package UnitTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import Project.PrimeNumberGenerator.impl.PrimeNumber;

public class TestPrimeNumber {
	PrimeNumber generator = new PrimeNumber();

	    @Test
	    public void testSieveOfEratosthenes() {
	        List<Integer> primes = generator.Algorithm1(1, 10);
	        assertEquals(Arrays.asList(2, 3, 5, 7), primes);
	    }

	    @Test
	    public void testSegmentedSieve() {
	        List<Integer> primes = generator.Algorithm2(1, 10);
	        assertEquals(Arrays.asList(2, 3, 5, 7), primes);
	    }
	}

