package com.EmpleadosNomina.Nomina;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;



public class Nomina {


		public static String leer(String mensaje) {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String s = null;
			try {
				System.out.print(mensaje);
				s = br.readLine();
			} catch (IOException ex) {
				System.out.println("Hubo un error de lectura, vuelva a intentarlo");
			}
			if (s == null) {
				s = leer(mensaje);
			}
			return s;
		}

		public static Integer leerInt(String mensaje) {
			Integer i = null;
			try {
				i = Integer.parseInt(leer(mensaje));
			} catch (NumberFormatException ex) {
				System.out.println("Hubo un error de formato, vuelva a intentarlo");
			}
			if (i == null) {
				i = leerInt(mensaje);
			}
			return i;
		}

		public static Long leerLong(String mensaje) {
			Long l = null;
			try {
				l = Long.parseLong(leer(mensaje));
			} catch (NumberFormatException ex) {
				System.out.println("Hubo un error de formato, vuelva a intentarlo");
			}
			if (l == null) {
				l = leerLong(mensaje);
			}
			return l;
		}

		public static Double leerDouble(String mensaje) {
			Double d = null;
			try {
				d = Double.parseDouble(leer(mensaje));
			} catch (NumberFormatException ex) {
				System.out.println("Hubo un error de formato, vuelva a intentarlo");
			}
			if (d == null) {
				d = leerDouble(mensaje);
			}
			return d;
		}

		public static void main(String[] args) {
			/*
			 * int n = leerInt("1. Ingrese la cantidad de empleados: "); double salario =
			 * leerDouble("2. Ingrese el salario del primer empleado");
			 */

			int n = 1;
			double sueldoB = 1440 * 4;/* $30 x 8horas X 6dias X 4semanas*/
			String rol = leer("Ingrese el roll ");
			double BonoPuesto;
			int Entrega = leerInt("ingrese numero de entregas ");
			double Impuesto;
			double ImpuestoExtra;
			double SueldoTotal;

			Empleado[] empleados = new Empleado[n];
			empleados[0] = new Empleado(sueldoB, Entrega, rol);
			for (int i = 1; i < empleados.length; i++) {
				sueldoB *= 1.10;
				empleados[i] = new Empleado(sueldoB, i, rol);
				

			}
		       double salariosBrutos = 0;
		        double retenciones = 0;
		        double salariosNetos = 0;
		        for (int i = 0; i < empleados.length; i++) {
		            salariosBrutos += empleados[i].getSalarioNeto();
		            retenciones += empleados[i].getImpuesto();
		            salariosNetos += empleados[i].getSalarioNeto();
		            *System.out.println("Empleado #" + (i + 1) + ":\n" + empleados[i]);*/
		        }
			 


		}
	}

	class Empleado {

		

		

		private double sueldoB;
		private String rol;
		private double BonoPuesto;
		private int Entrega;
		private double Entregas;
		private double Impuesto;
		private double ImpuestoExtra;
		private double SueldoTotal;

		public Empleado(double sueldoB, int	 Entrega, String rol) {
	        this.sueldoB = sueldoB;
	        
	        Impuesto = (sueldoB * 9)/100;
	        this.Entrega = Entrega;
	        setEntregas(Entrega * 5);
	        this.rol =rol;
	         
	     
	       
	       if ( rol.equals("Chofer")) {
	    	   BonoPuesto=10*8*6*4; 
	    	    
	    	} else if ( rol.equals("Cargador")) {
	    		BonoPuesto=5*8*6*4; 
	    	    
	    	} else {
	    		BonoPuesto = 0;
	    	}
	        SueldoTotal = sueldoB + BonoPuesto - Impuesto + Entregas;
	         
	        
	    }

		public double getSalarioNeto() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public String toString() {
			return "SueldoBase: " + sueldoB 
					+ "\nrol: " + rol
					+ "\nBonoPuesto: " + BonoPuesto 
					+ "\nTotal de entregas: " + Entregas 
					+ "\nImpuestos y retenciones: " + Impuesto 
					+ "\nImpuestos Extra: " + ImpuestoExtra 
					+ "\nSueldo Total: " + SueldoTotal;

		}

		public static Double round2Decimals(Double val) {
			return new BigDecimal(val.toString()).setScale(2, RoundingMode.HALF_EVEN).doubleValue();
		}
		
		/**
		 * @return the sueldoB
		 */
		public double getSueldoB() {
			return sueldoB;
		}

		/**
		 * @param sueldoB the sueldoB to set
		 */
		public void setSueldoB(double sueldoB) {
			this.sueldoB = sueldoB;
		}

		/**
		 * @return the rol
		 */
		public String getRol() {
			return rol;
		}

		/**
		 * @param rol the rol to set
		 */
		public void setRol(String rol) {
			this.rol = rol;
		}

		/**
		 * @return the bonoPuesto
		 */
		public double getBonoPuesto() {
			return BonoPuesto;
		}

		/**
		 * @param bonoPuesto the bonoPuesto to set
		 */
		public void setBonoPuesto(double bonoPuesto) {
			BonoPuesto = bonoPuesto;
		}

		/**
		 * @return the entrega
		 */
		public int getEntrega() {
			return Entrega;
		}

		/**
		 * @param entrega the entrega to set
		 */
		public void setEntrega(int entrega) {
			Entrega = entrega;
		}

		/**
		 * @return the entregas
		 */
		public double getEntregas() {
			return Entregas;
		}

		/**
		 * @param entregas the entregas to set
		 */
		public void setEntregas(double entregas) {
			Entregas = entregas;
		}

		/**
		 * @return the impuesto
		 */
		public double getImpuesto() {
			return Impuesto;
		}

		/**
		 * @param impuesto the impuesto to set
		 */
		public void setImpuesto(double impuesto) {
			Impuesto = impuesto;
		}

		/**
		 * @return the impuestoExtra
		 */
		public double getImpuestoExtra() {
			return ImpuestoExtra;
		}

		/**
		 * @param impuestoExtra the impuestoExtra to set
		 */
		public void setImpuestoExtra(double impuestoExtra) {
			ImpuestoExtra = impuestoExtra;
		}

		/**
		 * @return the sueldoTotal
		 */
		public double getSueldoTotal() {
			return SueldoTotal;
		}

		/**
		 * @param sueldoTotal the sueldoTotal to set
		 */
		public void setSueldoTotal(double sueldoTotal) {
			SueldoTotal = sueldoTotal;
		}

		
	

}
