package pkg_relatorio_vendas;
import java.util.*;
public class Vendas {

	private long sale_id;
	private String salesman_name;
	private ArrayList<Venda_Item> venda_item;
	
	protected ArrayList<Venda_Item> getVenda_Item() {
		return venda_item;
	}
	protected void setVenda_Item(ArrayList<Venda_Item> venda_item) {
		this.venda_item = venda_item;
	}
	
	protected long getSale_id() {
		return sale_id;
	}
	protected void setSale_id(long sale_id) {
		this.sale_id = sale_id;
	}

	
	protected String getSalesman_name() {
		return salesman_name;
	}
	protected void setSalesman_name(String salesman_name) {
		this.salesman_name = salesman_name;
	}
	
	
}

