package paquete;

import java.util.Iterator;
import java.util.LinkedList;

public class Banco {
 private LinkedList<Cuenta> listaDeCuentas;

public Banco() {
	
	this.listaDeCuentas = new LinkedList();
}

public void agregar_cuenta(Cuenta cuentaNueva) throws ErrorDeCuenta {
	
	//validar si la cuenta existe
	if(listaDeCuentas.contains(cuentaNueva)) {
		throw new ErrorDeCuenta();
	}else {
		listaDeCuentas.add(cuentaNueva);
		
	}
}

public void transferencia(String cbuDeCuentaExtraer, String cbuDeCuentaDepositar, Double monto) throws Exception {

	
	Cuenta cExt = buscarCuenta(cbuDeCuentaExtraer);
	Cuenta cDep = buscarCuenta(cbuDeCuentaDepositar);
	
	int ce = listaDeCuentas.indexOf(cExt);
	int cd = listaDeCuentas.indexOf(cDep);
	listaDeCuentas.get(ce).extraer(monto);
	listaDeCuentas.get(cd).depositar(monto);
	System.out.println("Extraido total:" + listaDeCuentas.get(ce).getSaldo() 
			+ "Depositado total:" + listaDeCuentas.get(cd).getSaldo());
}

private Cuenta buscarCuenta(String cbuDeCuentaExtraer) throws ErrorDeCuenta {
	
	for (Cuenta cuenta : listaDeCuentas) {
		if (cuenta.getCbu().equals(cbuDeCuentaExtraer)) {
			return cuenta;
		}
	}
	throw new ErrorDeCuenta();
	//return null;
}

public LinkedList<Cuenta> getListaDeCuentas() {
	return listaDeCuentas;
}

public LinkedList<CuentaCorriente> listaDeCuentasCorriente() {
	LinkedList<CuentaCorriente> lc = new LinkedList<>();
	for (Cuenta cuenta : listaDeCuentas) {
		if (cuenta instanceof CuentaCorriente) {
			lc.add((CuentaCorriente)cuenta);
		}
	}
	return lc;
}

public LinkedList<CajaDeAhorro> listaDeCajaDeAhorro() {
	LinkedList<CajaDeAhorro> la = new LinkedList<>();
	for (Cuenta cuenta : listaDeCuentas) {
		if (cuenta instanceof CajaDeAhorro) {
			la.add((CajaDeAhorro)cuenta);
		}
	}
	return la;
}
}
