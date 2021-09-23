package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import app.model.Stock;
import app.service.StockService;

@CrossOrigin(origins="*")
@RestController
public class StockController {
	
	@Autowired
	private StockService stockService;
	
	
	@GetMapping("/stocks")
	public List<Stock> list() {
	    return stockService.getAll();
	}

	@GetMapping("/getProductInfo")
	public Stock getProduct(@RequestParam("product_id") int product_id) {
		System.out.println("Inside get product");
		System.out.println("received id" + product_id);
		return stockService.getProduct(product_id);
	}


	@PostMapping("/updateproductInfo")
	public boolean updateProduct(@RequestBody Stock s)
	{
		System.out.println("Inside update product");
		boolean status = stockService.updateProduct(s);
		return status;
	}
}
