package app.dao;

import app.model.Account;

import app.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>{
/*
    @Query("from Account where accno = :x")
    List<Account> getonaccno(@Param("x") int accno);

        @Query("from Account where accno = :x")
        List<Integer> getbalanceonaccno(@Param("x") int accno);

        @Query("from Account where balance = :x")
        List<Integer> getaccnoonbalance(@Param("x") int balance);
*/
    @Query("from Account where balance = :x")
    List<Account> getonbalance(@Param("x") int balance);
}
