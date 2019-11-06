package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedList;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import paquete.Cliente;
import paquete.Cuenta;
import paquete.CuentaCorriente;
import paquete.ErrorDeCuenta;
import paquete.ErrorDeExtraccion;
import paquete.Banco;
import paquete.CajaDeAhorro;

public class CuentaTest {
	Cuenta cuenta1, cuenta2, cuenta3, cuenta4, cuenta5;
	Cliente cliente1, cliente2;

	@Test
	public void metodosDeCuenta() throws Exception{
		 cliente1 = new Cliente("123", "laguna", "lang");
		 cliente2 = new Cliente("13323", "laura", "mun");
		 cuenta1 = new CuentaCorriente("234aaa", 5000d, cliente1, 1000d);
		 cuenta2 = new CuentaCorriente("25534aaa", 1000d, cliente2, 1000d);
		 cuenta3 = new CajaDeAhorro("234aaadsfs", 5000d, cliente1);
		 cuenta4 = new CajaDeAhorro("234zxzzaaa", 50020d, cliente2);
		 cuenta5 = new CajaDeAhorro("aaaaaa234aaa", 556000d, cliente1);
		 Banco b = new Banco();
		 
		 b.agregar_cuenta(cuenta1);
		 b.agregar_cuenta(cuenta2);
		 b.agregar_cuenta(cuenta3);
		 b.agregar_cuenta(cuenta4);
		 b.agregar_cuenta(cuenta5);
		 
		 //PARTE VERDADERA:
		 try {

			 b.transferencia("234aaa", "25534aaa", 500d);
		} catch (Exception e) {
			System.out.println(e);
		}
		 
		
		 int pos =  b.getListaDeCuentas().indexOf(cuenta2);
		 
		assertEquals(1500d, b.getListaDeCuentas().get(pos).getSaldo());
	
		//PARTE FALSA:
		/*
		 	 try {

			 b.transferencia("234aaa", "25534aaa", 5500d);
		} catch (Exception e) {
			System.out.println(e);
		}
		 
		
		 int pos =  b.getListaDeCuentas().indexOf(cuenta2);
		 
		assertEquals(1500d, b.getListaDeCuentas().get(pos).getSaldo());
	
		 */
		
		//Polimorfismo con listas:
		
		LinkedList<CuentaCorriente> c;
		LinkedList<CajaDeAhorro> a;
		c = b.listaDeCuentasCorriente();
		a = b.listaDeCajaDeAhorro();
		
		System.out.println("Cajas De Ahorro:");
		for (CajaDeAhorro cajaDeAhorro : a) {
			System.out.println(cajaDeAhorro.toString());
		}
		System.out.println("Cuentas corrientes:");
		for (CuentaCorriente cuentaC : c) {
			System.out.println(cuentaC.toString());
		}
	}

}
