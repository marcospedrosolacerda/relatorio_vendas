package pkg_relatorio_vendas;
public class Cliente {
	private long cnpj;
	private String name;
	private String business_area;
	
	protected long getCnpj() {
		return cnpj;
	}
	protected void setCnpj(long cnpj) {
		this.cnpj = cnpj;
	}
	protected String getName() {
		return name;
	}
	protected void setName(String name) {
		this.name = name;
	}
	protected String getBusinessarea() {
		return business_area;
	}
	protected void setBusinessarea(String business_area) {
		this.business_area = business_area;
	}
	
	
}
