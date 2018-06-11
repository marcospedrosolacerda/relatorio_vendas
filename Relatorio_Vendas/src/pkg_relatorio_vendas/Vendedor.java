package pkg_relatorio_vendas;
public class Vendedor {
	private long cpf;
	private String name;
	private  double salary;
	
	protected long getCpf() {
		return cpf;
	}
	protected void setCpf(long cpf) {
		this.cpf = cpf;
	}
	protected String getName() {
		return name;
	}
	protected void setName(String name) {
		this.name = name;
	}
	protected double getSalary() {
		return salary;
	}
	protected void setSalary(double salary) {
		this.salary = salary;
	}
	
}
