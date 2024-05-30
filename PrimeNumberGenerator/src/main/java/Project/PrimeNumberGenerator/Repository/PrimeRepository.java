package Project.PrimeNumberGenerator.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Project.PrimeNumberGenerator.Entity.PrimeNumberGeneratorEntity;

/**
 * Repository interface for managing PrimeNumberGeneratorEntity entities.
 *
 * Author: Sushma Kattupalli
 * Date: 30-05-2024
 * Description: This repository interface extends JpaRepository to provide CRUD (Create, Read, Update, Delete) operations
 *              for PrimeNumberGeneratorEntity entities. It allows interaction with the underlying database to store and retrieve data.
 */
@Repository
public interface PrimeRepository extends JpaRepository<PrimeNumberGeneratorEntity, Long> {
}
