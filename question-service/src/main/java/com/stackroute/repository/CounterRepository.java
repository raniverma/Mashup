package com.stackroute.repository;

import com.stackroute.domain.Counters;
import org.springframework.data.mongodb.repository.MongoRepository;

/*counter repository interface*/
public interface CounterRepository extends MongoRepository<Counters, Integer> {
}
