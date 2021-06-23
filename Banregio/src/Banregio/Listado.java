package Banregio;

public class Listado implements Comparable<Listado>{
	String Cliente;
	int Plazo;
	float Taza_interes;
	float Monto;
	float Interes;
	float IVA;
	float Pago;
	
	public Listado()
	{
		
	}
	public Listado(String cliente, int plazo, float taza_interes, float monto, float interes, float iVA,
			float pago) {
		super();
		Cliente = cliente;
		Plazo = plazo;
		Taza_interes = taza_interes;
		Monto = monto;
		Interes = interes;
		IVA = iVA;
		Pago = pago;
	}
	public String getCliente() {
		return Cliente;
	}
	public void setCliente(String cliente) {
		Cliente = cliente;
	}
	public int getPlazo() {
		return Plazo;
	}
	public void setPlazo(int plazo) {
		Plazo = plazo;
	}
	public float getTaza_interes() {
		return Taza_interes;
	}
	public void setTaza_interes(float taza_interes) {
		Taza_interes = taza_interes;
	}
	public float getMonto() {
		return Monto;
	}
	public void setMonto(float monto) {
		Monto = monto;
	}
	public float getInteres() {
		return Interes;
	}
	public void setInteres(float interes) {
		Interes = interes;
	}
	public float getIVA() {
		return IVA;
	}
	public void setIVA(float iVA) {
		IVA = iVA;
	}
	public float getPago() {
		return Pago;
	}
	public void setPago(float pago) {
		Pago = pago;
	
	}
	@Override
    public int compareTo(Listado o) {
        if (this.getPlazo() < o.getPlazo()) {
            return -1;
        }
        if (this.getPlazo() >  o.getPlazo()) {
            return 1;
        }
        return 0;
    }
	
	

}
