package se.kth.iv1350.PoS.integration;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.*;

import se.kth.iv1350.PoS.model.*;

class SaleTest {

	Sale sale;
	
	@BeforeEach
	public void setUp() {
		sale = new Sale();
	}
	@AfterEach
	public void tearDown() {
		sale = null;
	}
	
	@Test
	public void constructorTest() {
		assertNotNull("null PriceModifiers", sale.getPriceModifiers());
		assertTrue("variable priceModifers is wrong type", sale.getPriceModifiers() instanceof PriceModifiers);
	}
	
	@Test
	public void addItemTest() {
		ItemInformation itemInfo = new ItemInformation();
		Item item = new Item(itemInfo);
		sale.addItem(item);
		List<Item> items = sale.getItems();
		assertTrue("Item not added", items.contains(item));
		assertEquals("Item not added in correct spot", item, items.get(0));
	}

}