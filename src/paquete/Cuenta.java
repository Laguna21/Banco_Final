package paquete;

public abstract class Cuenta {
	protected String cbu;
	protected double saldo;
	protected Cliente cliente;

	public Cuenta(String cbu, double saldo, Cliente cliente) {

		this.cbu = cbu;
		this.saldo = saldo;
		this.cliente = cliente;
	}

	public abstract void extraer(Double saldo) throws Exception;

	public abstract void depositar(Double saldo);

	public String getCbu() {
		return cbu;
	}

	public double getSaldo() {
		return saldo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	@Override
	public String toString() {
		return "Cuenta [cbu=" + cbu + ", saldo=" + saldo + ", cliente=" + cliente + "]";
	}

}
