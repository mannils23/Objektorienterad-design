package se.kth.iv1350.PoS.model;

import java.util.*;
import se.kth.iv1350.PoS.integration.*;

/**
 * Represent an active sale
 *
 */
public class Sale {

	private List<Item> items;

	private Amount runningTotal;

	private Taxes taxes;

	private SaleDTO saleDTO;

	private TotalPrice totalPrice;

	private Change change;
	
	private PaymentDTO payment;
	
	
	/**
	 * Creates a new instance, representing a sale.
	 */
	public Sale() {
		taxes = new Taxes();
		items = new ArrayList<Item>();
	}
	/**
	 * Adds an <code>Item</code> to the sale.
	 * @param item The item to be added.
	 */
	public void addItem(Item item) {
		items.add(item);
	}
	/**
	 * Returns the list of all items in the current sale.
	 * @return The list of items.
	 */
	public List<Item> getItems() {
		return items;
	}
	/**
	 * Returns a <code>SaleDTO</code> object with information from the sale.
	 * @return The <code>SaleDTO</code> with sale information.
	 */
	public SaleDTO getSaleInformation() {
		SaleDTO saleInfo = new SaleDTO(this);
		return saleInfo;
	}
	/**
	 * Returns the total price, as an object of {@link TotalPrice}, of a {@link Sale}.
	 * @return The <code>TotalPrice</code> of the current <code>Sale</code>.
	 */
	public TotalPrice getTotalPrice() {
		TotalPrice totalPrice = new TotalPrice(runningTotal);
		totalPrice.applyTaxes(taxes);
		return totalPrice;
	}
	/**
	 * Pays the current {@link Sale} with a {@link PaymentDTO};
	 * @param payment The <code>PaymentDTO</code> representing the payment.
	 */
	public void pay(PaymentDTO payment) {
		this.payment = payment;
		return;
	}
	/**
	 * Returns the {@link Change} of the current {@link Sale}.
	 * @return The <code>Change</code> representing the change of the <code>Sale</code>.
	 */
	public Change getChange() {
		change = new Change(payment, totalPrice);
		return change;
	}
	/**
	 * Returns the payment information as a {@link PaymentDTO}
	 * @return The <code>PaymentDTO</code> representing the payment for the <code>Sale</code>.
	 */
	public PaymentDTO getPayment() {
		return payment;
	}
}
