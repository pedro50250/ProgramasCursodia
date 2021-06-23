package Sesion4;

import java.util.*;
import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class Mongo {

	MongoClient mongo = null;
	MongoDatabase db = null;
	String tabla= "Alumnos";
	
	public static void main(String[]args)
	{
		Mongo mi = new Mongo();
		System.out.println("Prueba conexion MongoDB");
		mi.mongo = new MongoClient("localhost",27017);
		Scanner sc = new Scanner(System.in);
		if(mi.mongo != null)
		{
			mi.db = mi.mongo.getDatabase("Cursodia");
			/*System.out.println("Nombre: ");
			String nom = sc.nextLine();
			System.out.println("Apellidos");
			String aps = sc.nextLine();
			System.out.println("Edad: ");
			int ed = Integer.parseInt(sc.nextLine());*/
			
			//insert
			//mi.insertarDocumento(nom, aps, ed);
			
			//Select
			mi.listarDocumentos();
			//Select Where
			/*System.out.println("Ingrese el nombre a buscar");
			String nombre = sc.nextLine();
			mi.listarFiltrado(nombre);*/
			
			//Update
			/*System.out.println("Actualizar el nombre del alumno a modificar");
			String nombre = sc.nextLine();
			System.out.println("Nueva edad: ");
			int edad = Integer.parseInt(sc.nextLine());
			mi.updateEdadByName(nombre,edad);*/
			
			
			//Delete
			System.out.println("Edad Maxima: ");
			int edMax = Integer.parseInt(sc.nextLine());
			mi.deleteTrabMayor(edMax);
			
			//Delete lista
			/*List listaBorrar = new List();
			System.out.println("Primera persona a borrar (apellidos)");
			listaBorrar.add(sc.nextLine());
			System.out.println("Segunda persona a borrar (apellidos)");
			listaBorrar.add(sc.nextLine());
			mi.deleteLista(listaBorrar);*/
			
		}
		
	}
	
	private void insertarDocumento(String nombre, String apellidos, int edad)
	{
		MongoCollection<Document> table = db.getCollection(tabla);
		//Crea una tabla si no existe y agregar datos
		
		//CRea un onjeto basico y le añade elementos
		Document document = new Document();
		document.put("Nombre", nombre);
		document.put("Apellido", apellidos);
		document.put("Edad",edad);
		
		//inserta la tabla 
		table.insertOne(document);
	}
	
	private void listarDocumentos()
	{
		System.out.println("Listando los docuemntos");
		//Recoge los datos de la tabla
		MongoCollection<Document> table = db.getCollection(tabla);
		
		//Busca y muestra todos los datos de la tabla
		MongoCursor<Document> cursor = table.find().iterator();
		while(cursor.hasNext())
		{
			Document doc = cursor.next();
			System.out.println(doc.get("Nombre") + "\t" + doc.get("Apellido") + "\t" + doc.get("Edad"));
		}
	}
	
	private void listarFiltrado(String nombre)
	{
		System.out.println("Resultado de filtrado: ");
		//Recoge datos de la tabla
		MongoCollection<Document> table = db.getCollection(tabla);
		
		//Creando el filtro en el campo nombre
		BasicDBObject query = new BasicDBObject();
		query.put("Nombre", nombre);
		
		//Busca y muestra todos los datos de la tabla "nombre" sea el indicado
		MongoCursor<Document> cursor = table.find(query).iterator();
		while(cursor.hasNext())
		{
			Document doc = cursor.next();
			
			System.out.println(doc.get("Nombre") + "\t" + doc.get("Apellido") + "\t" + doc.get("Edad"));
		}
	}
	
	private void updateEdadByName(String nombre,int nuevaEdad)
	{
		//Recoge datos de la tabla 
		MongoCollection<Document> table = db.getCollection(tabla);
		
		//Prepara para insertar un nuevo campo
		BasicDBObject updateAnyos = new BasicDBObject();
		updateAnyos.append("$set", new BasicDBObject().append("Edad", nuevaEdad));
		
		//Busca el o los registros con el nombre indicado
		BasicDBObject searchByID = new BasicDBObject();
		searchByID.append("Nombre", nombre);
		
		table.updateMany(searchByID, updateAnyos);
		listarDocumentos();
	}
	
	private void deleteTrabMayor(int edad)
	{
		MongoCollection<Document> table = db.getCollection(tabla);
		
		BasicDBObject query = new BasicDBObject();
		query.put("Edad", new BasicDBObject("$lte",edad));
		table.deleteMany(query);
		listarDocumentos();
	}
	
	private void deleteLista(List lista)
	{
		MongoCollection<Document> table = db.getCollection(tabla);
		
		//indica la lista de nombres que quiere eliminr
		BasicDBObject query = new BasicDBObject();
		query.put("Apellido", new BasicDBObject("$in",lista));
		table.deleteMany(query);
		
	}
	
	
	
	
}
