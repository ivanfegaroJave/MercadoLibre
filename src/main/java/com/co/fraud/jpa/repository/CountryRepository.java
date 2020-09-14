package com.co.fraud.jpa.repository;

import com.co.fraud.jpa.entity.CountryDao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

/**
 * Interface based in bring the data from the DB
 *
 * @author Iván García
 * @version v1
 */
public interface CountryRepository extends JpaRepository<CountryDao, UUID> {

    Optional<CountryDao> findByNumberCode(String numberCode);

    CountryDao findFirstByOrderByDistanceCountryDesc();

    CountryDao findFirstByOrderByDistanceCountryAsc();

}
