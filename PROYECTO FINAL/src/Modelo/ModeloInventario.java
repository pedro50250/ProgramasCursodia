package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DBManager.Conexion;

public class ModeloInventario {

	public static Connection conect = null;
	
	public ArrayList<articulo>Inventario= new ArrayList<articulo>();
	public ArrayList<proveedor>Proveedores= new ArrayList<proveedor>();
	
	public ArrayList<articulo>InventarioFiltros= new ArrayList<articulo>();
	public ArrayList<articulo>InventarioTabla= new ArrayList<articulo>();
	
	
	
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
	
	public void llenarListas() {
		llenarInventario();
		llenarProveedores();
	}
	
	private void llenarInventario() {
		PreparedStatement pstm = null;
		ResultSet rs= null;
		
		String query = "SELECT * FROM articulos";
		
		try {
			pstm = conect.prepareStatement(query);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("cve_art");
				String nom = rs.getString("nom_art");
				float pre= rs.getFloat("pre_art");
				int cat = rs.getInt("cat_art");
				int prov = rs.getInt("idProv_art");
				int inv= rs.getInt("inv_art");
				
				Inventario.add(new articulo(id,nom,pre,cat,prov,inv));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				if(rs!=null) rs.close();
				if(pstm!=null) pstm.close();
				
				
				} catch (SQLException e) 
				{
					e.printStackTrace();
					throw new RuntimeException(e);
				}	
		}
		
	}
	
	private void llenarProveedores() {
		PreparedStatement pstm = null;
		ResultSet rs= null;
		
		String query = "SELECT * FROM proveedor";
		
		try {
			pstm = conect.prepareStatement(query);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id_prov");
				String nom = rs.getString("nom_prov");
				String tel = rs.getString("tel_prov");
				String dir = rs.getString("dir_prov");
				String mail = rs.getString("email_prov");
				
				Proveedores.add(new proveedor(id, nom, tel, dir, mail));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				if(rs!=null) rs.close();
				if(pstm!=null) pstm.close();
				
				
				} catch (SQLException e) 
				{
					e.printStackTrace();
					throw new RuntimeException(e);
				}	
		}
	}
	
	public String[] comboProveedores(){
		int i=1;
		String[] emps =new String[Proveedores.size()+1];
		emps[0]="Todos";
		for(proveedor p: Proveedores) {
			emps[i]=p.getNom_prov();
			i++;
		}
		return emps;
		
	}	
	
	public void llenarFiltros(String prov, int exis) {
		filtroProveedor(prov);
		filtroExistencias(exis);
	}
	
	private void filtroProveedor(String prov) {
		int id=0;
		InventarioFiltros.clear();
		
		if(prov.equals("Todos")) {
			for(articulo a: Inventario) {
				InventarioFiltros.add(a);
			}
		}
		
		else {
			for(proveedor p: Proveedores) {
				if(prov.equals(p.getNom_prov())) {
					id=p.getId_prov();
				}
			}
			
			for(articulo a: Inventario) {
				if(id==a.getIdprov_art()) {
					InventarioFiltros.add(a);
				}
			}
		}
	}
	
	private void filtroExistencias(int exis) {
		InventarioTabla.clear();
		if(exis==0) {
			for(articulo a: InventarioFiltros) {
				InventarioTabla.add(a);
			}
		}else
		if(exis==1) {
			for(articulo a: InventarioFiltros) {
				if(a.getInv_art()!=0) {
					InventarioTabla.add(a);
				}
			}
		}else 
		if(exis==2){
			for(articulo a: InventarioFiltros) {
				if(a.getInv_art()==0) {
					InventarioTabla.add(a);
				}
			}
		}
		
	}
}
