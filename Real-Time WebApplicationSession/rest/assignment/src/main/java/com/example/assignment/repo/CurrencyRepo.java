package com.example.assignment.repo;

import com.example.assignment.dao.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface CurrencyRepo extends JpaRepository<Currency,Integer> {

    @Query(value = "select * from currency where isfake=true",nativeQuery = true)
    List<Currency>  fakeuser();

    @Query(value="select count(*) from currency where currency_id=:id",nativeQuery = true)
    int usercheck(@Param("id") String id);

    @Query(value = "Select * from currency where timestamp=:timestamp",nativeQuery = true)
    List<Currency> dailyresult(@Param("timestamp") LocalDate timestamp);

    @Query(value="Select * from currency where email=:email",nativeQuery = true)
    List<Currency> findByEmail(@Param("email") String email);


}
