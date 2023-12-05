package elib.book;

import java.util.List;
import java.util.ArrayList;
public class Cart {
	private List<Book> items;
	  
	  public Cart() {
	    items = new ArrayList<>();
	  }
	  
	  public void addItem(Book product) {
	    items.add(product);
	  }
	  
	  public List<Book> getItems() {
	    return items;
	  }
	  
//	  public double getTotal() {
//	    double total = 0.0;
//	    for (Book item : items) {
//	      total += item.getPprice();
//	    }
//	    return total;
//	  }
}
