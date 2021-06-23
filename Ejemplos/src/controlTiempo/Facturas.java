package controlTiempo;

import java.sql.Date;

public class Facturas 
{
	int id_fac;
	int idcli_fac;
	float mon_fac;
	Date fec_fac;
	public Facturas(int id_fac, int idcli_fac, float mon_fac, Date fec_fac) 
	{
		this.id_fac = id_fac;
		this.idcli_fac = idcli_fac;
		this.mon_fac = mon_fac;
		this.fec_fac = fec_fac;
	}
}
