package pkg_relatorio_vendas;

public class Resultado_Relatorio {
	
	int quantidade_clientes;
	int quantidade_vendedores;
	String id_vendamaiscara;
	String pior_vendedor;
	
	
	protected int getQuantidade_clientes() {
		return quantidade_clientes;
	}
	protected void setQuantidade_clientes(int quantidade_clientes) {
		this.quantidade_clientes = quantidade_clientes;
	}
	protected int getQuantidade_vendedores() {
		return quantidade_vendedores;
	}
	protected void setQuantidade_vendedores(int quantidade_vendedores) {
		this.quantidade_vendedores = quantidade_vendedores;
	}
	protected String getId_vendamaiscara() {
		return id_vendamaiscara;
	}
	protected void setId_vendamaiscara(String id_vendamaiscara) {
		this.id_vendamaiscara = id_vendamaiscara;
	}
	protected String getPior_vendedor() {
		return pior_vendedor;
	}
	protected void setPior_vendedor(String pior_vendedor) {
		this.pior_vendedor = pior_vendedor;
	}
	

}
