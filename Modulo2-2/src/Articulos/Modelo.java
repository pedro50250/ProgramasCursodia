package Articulos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JOptionPane;

public class Modelo {
	ArrayList<Articulo> articulos;

	public String leerArchivo() {
		articulos = new ArrayList<>();
		String lineas = "";
		String p = "Files/articulos.txt";
		Path ruta = Paths.get(p);
		if (Files.exists(ruta)) {
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(p), "utf-8"));
				String linea = null;
				// System.out.println("Clave Nombre Precio Clave");
				while ((linea = br.readLine()) != null) {
					String[] Lactual = linea.split(",");
					articulos.add(new Articulo(Integer.parseInt(Lactual[0]), Lactual[1], Float.parseFloat(Lactual[2]),
							Integer.parseInt(Lactual[3])));
				}
				br.close();
				Collections.sort(articulos);
				for (Articulo art : articulos) {
					lineas += art.toString();
				}
			} catch (UnsupportedEncodingException | FileNotFoundException e) {
				e.printStackTrace();
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		} else {
			JOptionPane.showMessageDialog(null, "El archivo no existe");
		}
		return lineas;
	}

	public boolean escribirArchivo(int cve_art, String nom_art, float precio_art, int cat_art) {
		boolean existe = verificarArticulo("" + cve_art, nom_art);
		if (existe == false) {
			String p = "Files/articulos.txt";
			Path ruta = Paths.get(p);
			if (Files.exists(ruta)) {
				try {
					FileWriter flwriter = new FileWriter(p, true);
					BufferedWriter bfwriter = new BufferedWriter(flwriter);
					String linea = null;
					linea = "\n"+cve_art + "," + nom_art + "," + precio_art + "," + cat_art;
					bfwriter.write(linea);
					bfwriter.close();
					flwriter.close();
					System.out.println("Despues se escribio");
				} catch (UnsupportedEncodingException | FileNotFoundException e) {
					e.printStackTrace();
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(null, "El archivo no existe");
			}

		} else {
			JOptionPane.showMessageDialog(null, "Un articulo ya esta registrado con esa clave");
		}
		return existe;
	}

	public boolean verificarArticulo(String cve_art, String nom_art) {
		boolean existe = false;
		String p = "Files/articulos.txt";
		Path ruta = Paths.get(p);
		if (Files.exists(ruta)) {
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(p), "utf-8"));
				String linea = null;
				// System.out.println("Clave Nombre Precio Clave");
				System.out.println("Antes de verificar");
				while ((linea = br.readLine()) != null) {
					String[] Lactual = linea.split(",");
					System.out.println("en el while");
					if (Lactual[0].equals(cve_art)||Lactual[2].equals(nom_art)) {
						existe = true;
						System.out.println("Paso por verificacion");
					}
				}
				br.close();
			} catch (UnsupportedEncodingException | FileNotFoundException e) {
				e.printStackTrace();
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			JOptionPane.showMessageDialog(null, "El archivo no existe");
		}
		return existe;
	}

	public ArrayList<Articulo> obtenerArrays() {
		String a = leerArchivo();
		return articulos;
	}

	public boolean editarArchivo(ArrayList<Articulo> articulos, int cve_art, String nom_art, float pre_art,int cat_art) {
		boolean existe = verificarArticulo("" + cve_art, nom_art);
		if (existe == true) {
			String p = "Files/articulos.txt";
			Path ruta = Paths.get(p);
			if (Files.exists(ruta)) {
				try {
					Writer writer = new BufferedWriter(new OutputStreamWriter( new FileOutputStream(p),"utf-8"));
					String linea = null;
					for (int i = 0; i < articulos.size(); i++) {
						if (articulos.get(i).cve_art == cve_art) {
							linea = "" + cve_art + "," + nom_art + "," + pre_art + "," + cat_art + "\n";
						} else {
							if(i==articulos.size()-1)
							{
								linea = ""+ articulos.get(i).cve_art + "," + articulos.get(i).nom_art + ","
										+ articulos.get(i).pre_art + "," + articulos.get(i).cat_art;
							}
							linea = ""+ articulos.get(i).cve_art + "," + articulos.get(i).nom_art + ","
									+ articulos.get(i).pre_art + "," + articulos.get(i).cat_art + "\n";
							
						}
						writer.write(linea);
					}
					writer.close();
				} catch (UnsupportedEncodingException | FileNotFoundException e) {
					e.printStackTrace();
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(null, "El archivo no existe");
			}
		}
		else {
			JOptionPane.showMessageDialog(null, "La clave o el nombre del articulo no existen");
		}
		return existe;
	}
}
