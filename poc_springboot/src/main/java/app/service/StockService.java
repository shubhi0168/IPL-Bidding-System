package app.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.dao.StockRepository;
import app.model.Stock;

@Transactional
@Service
public class StockService {
	
	@Autowired
	private StockRepository stockRepository;

	public List<Stock> getAll() {
		// TODO Auto-generated method stub
		return stockRepository.findAll();
	}

	public Stock getProduct(int product_id)
	{
		Stock s =new Stock();
		Optional<Stock> o = stockRepository.findById(product_id);
		if(o.isPresent())
		{
			s = o.get();
		}
		return s;


	}

	public boolean updateProduct(Stock s) {
		boolean status = false;
		if(stockRepository.existsById(s.getProduct_id()))
		{
			stockRepository.save(s);
			status = true;
		}
		return status;
	}
}
