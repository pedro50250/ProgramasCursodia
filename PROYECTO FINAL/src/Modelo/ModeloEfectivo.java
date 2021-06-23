package Modelo;

import java.sql.Connection;
import java.util.ArrayList;

import DBManager.Conexion;
import DBManager.PagoArticulos;
import DBManager.CompraArticulos;

public class ModeloEfectivo {

	public static Connection conect = null;
	public ArrayList<articulo> articulos;
	public float total;
	public int prov;
	//Variable para saber cuantos articulos distintos se vendieron
	public int cantArt;
	//Variable para saber cuantos articulos en total se vendieron
	public int cantidadArticulos;
	
	public void conectar() 
	{
		conect =Conexion.conectar();
	}
	public void cerrarConexion()
	{
		if(conect!=null)
		{
			Conexion.desconectar(conect);
		}
	}
	public void recibirArticulos(ArrayList<articulo> articulos)
	{
		this.articulos = articulos;
		total = 0;
		this.cantArt = 0;
		this.cantidadArticulos = 0;
		for(articulo art: this.articulos)
		{
			total = (art.getPre_art() * art.getInv_art()) + total;
			cantArt++;
			cantidadArticulos = cantidadArticulos + art.getInv_art();
		}
		prov=articulos.get(0).getIdprov_art();
	}
	
	public void insertarVenta(usuario usuario)
	{
		int idUsuario = usuario.getIdUsuario();
		int idVenta = PagoArticulos.insertarVenta(conect, idUsuario, cantidadArticulos, total);
		this.insertarDetalleVenta(idVenta);
		this.actualizarUsuarioVenta(usuario);
	}
	
	public void insertarCompra(usuario usuario) {
		int idUsuario = usuario.getIdUsuario();
		
		int idCompra = CompraArticulos.insertarCompra(conect, prov, idUsuario,  total);
		this.insertarDetalleCompra(idCompra);
		this.actualizarUsuarioCompra(usuario);
	}
	
	private void insertarDetalleVenta(int idVenta)
	{
		for (int i = 0; i < this.cantArt; i++) {
			int cve_art = this.articulos.get(i).getCve_art();
			int inv_art = this.articulos.get(i).getInv_art();
			PagoArticulos.insertarDetalleVenta(idVenta, conect, cve_art, inv_art);
		}
	}
	
	private void insertarDetalleCompra(int idCompra)
	{
		for (int i = 0; i < this.cantArt; i++) {
			int cve_art = this.articulos.get(i).getCve_art();
			int inv_art = this.articulos.get(i).getInv_art();
			CompraArticulos.insertarDetalleVenta(idCompra, conect, cve_art, inv_art);
		}
	}
	
	public void actualizarUsuarioVenta(usuario usuario)
	{
		int idUsuario =  usuario.getIdUsuario();
		PagoArticulos.actualizarUsuario(conect, idUsuario);
	}
	
	public void actualizarUsuarioCompra(usuario usuario) {
		int idUsuario =  usuario.getIdUsuario();
		CompraArticulos.actualizarUsuario(conect, idUsuario);
	}
	
}
