package paquete;

public class CajaDeAhorro extends Cuenta {
	private int contExt;
	public CajaDeAhorro(String cbu, double saldo, Cliente cliente) {
		super(cbu, saldo, cliente);
		this.contExt = 0;
	}

	
	@Override
	public void extraer(Double saldo) throws Exception {
		if (puedoExtraer(saldo)) {
			this.contExt ++;
			aplicarAumento(saldo);
			
			
		} else {

		}
		
	}

	private void aplicarAumento(Double monto) {
		if (this.contExt > 5) {
			this.saldo -= monto;
			this.saldo -= monto*0.06d;
		}else {
			this.saldo -= monto;
		}
			
		
	}


	private boolean puedoExtraer(Double monto) {
		return this.saldo >= monto && this.contExt < 10;
	}


	@Override
	public void depositar(Double saldo) {
		
		this.saldo += saldo;
	}

}
