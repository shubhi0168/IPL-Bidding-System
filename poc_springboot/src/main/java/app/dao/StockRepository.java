package app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.model.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {

}
