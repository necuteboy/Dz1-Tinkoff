package com.example.dz1.repository;

import com.example.dz1.entity.mongo.Operation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationRepository extends MongoRepository<Operation, Long>, QuerydslPredicateExecutor<Operation> {
}

