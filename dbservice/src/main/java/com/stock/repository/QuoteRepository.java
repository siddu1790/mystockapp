package com.stock.repository;

import com.stock.model.Quote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuoteRepository extends JpaRepository<Quote, Integer> {

    @Query(value = "SELECT * FROM QUOTE q WHERE USER_NAME = :userName", nativeQuery = true)
    List<Quote> findByUserName(@Param("userName") String userName);
}
