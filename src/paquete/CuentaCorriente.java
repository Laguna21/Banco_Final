package paquete;

public class CuentaCorriente extends Cuenta {
	
	private Double montoEnDescubierto;
	
	
	public CuentaCorriente(String cbu, double saldo, Cliente cliente, Double montoEnDescubierto) {
		super(cbu, saldo, cliente);
		this.montoEnDescubierto = montoEnDescubierto;
		
	}

	
	public void extraer(Double saldo) throws ErrorDeExtraccion {
		if (validarExtraccion(saldo)) {
			extraerSaldo(saldo);
		} else {
			throw new ErrorDeExtraccion();
		}
		
	}

	private void extraerSaldo(Double saldoEvaluado) {
		if (this.saldo >= saldoEvaluado) {
			this.saldo -= saldoEvaluado;
		} else {
			
			this.saldo -= saldoEvaluado;
		}
	}

	private boolean validarExtraccion(Double saldoEvaluado) {
		return (this.saldo + this.montoEnDescubierto) >= saldoEvaluado || this.saldo >= saldoEvaluado;
	}

	@Override
	public void depositar(Double saldo) {
		this.saldo += saldo;
		
	}

	public Double getMontoEnDescubierto() {
		return montoEnDescubierto;
	}

	
}
