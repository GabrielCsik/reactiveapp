package com.example.diplomovkareactive.repo;


import com.example.diplomovkareactive.entity.SampleTest;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface SampleTestRepository extends ReactiveMongoRepository<SampleTest, String> {

}
