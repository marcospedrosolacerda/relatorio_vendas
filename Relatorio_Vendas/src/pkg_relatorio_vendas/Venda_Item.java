package pkg_relatorio_vendas;

public class Venda_Item {
	private long item_id;
	private long item_qty;
	private double item_price;

	protected long getItem_id() {
		return item_id;
	}
	protected void setItem_id(long item_id) {
		this.item_id = item_id;
	}
	protected long getItem_qty() {
		return item_qty;
	}
	protected void setItem_qty(long item_qty) {
		this.item_qty = item_qty;
	}
	protected double getItem_price() {
		return item_price;
	}
	
	protected void setItem_price(double item_price) {
		this.item_price = item_price;
	}
}

