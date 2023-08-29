package utn.estudiante.datos;

import utn.estudiante.dominio.Estudiante;
import static utn.estudiante.conexion.Conexion.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EstudianteDAO {

    // METODO LISTAR
    public List<Estudiante> listarEstudiantes() {
        List<Estudiante> estudiantes = new ArrayList<>();
        //creamos objetos necesarios para comunicarnos con la base de datos
        PreparedStatement ps; // preparamos sentencia sql
        ResultSet rs;// Nos permite almacenar el resultado entendido de la sentencia

        //creamos un objeto del tipo conexion

        Connection con = getConnection();
        String sql = "SELECT * FROM estudiantes2022  ORDER BY idestudiantes2022 ";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery(); // recibo por el resultset
            while (rs.next()) {
                var estudiante = new Estudiante();
                estudiante.setIdEstudiante(rs.getInt("idestudiantes2022"));
                estudiante.setNombre(rs.getString("nombre"));
                estudiante.setApellido(rs.getString("apellido"));
                estudiante.setTelefono(rs.getString("telefono"));
                estudiante.setEmail(rs.getString("email"));
                //agregamos a la lista el elemento creado
                estudiantes.add(estudiante);
            }
        } catch (Exception e) {
            System.out.println("Ocurrio un error al seleccionar datos:" + e.getMessage());
        } finally {
            try {
                con.close(); // cerramos la conexión
            } catch (Exception e) {
                System.out.println(" Ocurrió un error al cerrar la conexión : " + e.getMessage());
            }
        }// fin finally
            return estudiantes; // retornamos la lista estudiante

        }// fin metodo listar

    //metodo por id -> find by id

    public boolean buscarEstudiantePorId(Estudiante estudiante){
        PreparedStatement ps;
        ResultSet rs;
        Connection con= getConnection();
        String sql = "SELECT * FROM estudiantes2022 WHERE idestudiantes2022=?"; // ingresar id deseado
        try{
             ps = con.prepareStatement(sql);
             ps.setInt(1,estudiante.getIdEstudiante());
             rs=ps.executeQuery();

             if (rs.next()){
                 estudiante.setNombre(rs.getString("nombre"));
                 estudiante.setApellido(rs.getString("apellido"));
                 estudiante.setTelefono(rs.getString("telefono"));
                 estudiante.setEmail(rs.getString("email"));
                 return true;// se encontro un registro
             }//fin if
        } catch (Exception e){
            System.out.println("Ocurrió un error al buscar un estudiante: "+ e.getMessage());
        } // fin catch
        finally {
            try{
                con.close();
            }catch (Exception e){
                System.out.println("Ocurrió un error al cerrar la conexión: "+ e.getMessage());
            }//fin catch
        }//fin finally
        return false;
    }
    // metodo agregar un nuevo estudiante
     public boolean agregarEstudiante(Estudiante estudiante){
         PreparedStatement ps;
         Connection con= getConnection();
         String sql = "INSERT INTO  estudiantes2022 (nombre, apellido,telefono,email) VALUES (?,?,?,?)"; // ingresamos datos
         try{
             ps= con.prepareStatement(sql);
             ps.setString(1,estudiante.getNombre());
             ps.setString(2,estudiante.getApellido());
             ps.setString(3,estudiante.getTelefono());
             ps.setString(4,estudiante.getEmail());
             ps.execute(); //solo ejecutar
             return true;
         }catch (Exception e){
             System.out.println("Ocurrió un erro al agregar estudiante: "+ e.getMessage());
         }//fin catch
         finally {
             try {
                 con.close();
             } catch (Exception e){
                 System.out.println("Ocurrió un error al cerrar nuestra conexión: "+ e.getMessage());
             }
         }//fin finally
         return false;
     }//fin del metodo agregar estudiante

    // metodo para modificar un estudiante

    public boolean modificarEstudiante( Estudiante estudiante){

        PreparedStatement ps;
        Connection con= getConnection();
        String sql = "UPDATE estudiantes2022 SET nombre=?, apellido=?,telefono=?,email=? WHERE idestudiantes2022=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, estudiante.getNombre());
            ps.setString(2, estudiante.getApellido());
            ps.setString(3, estudiante.getTelefono());
            ps.setString(4, estudiante.getEmail());
            ps.setInt(5,estudiante.getIdEstudiante());
            ps.execute(); // modificar
            return true;

        } catch (Exception e){
            System.out.println("Error al modificar estudiante" + e.getMessage());
        }//fin catch
        finally {
            try{
                con.close();
            }catch (Exception e){
                System.out.println("Error al cerrar la conexión "+ e.getMessage());
            }//fin catch
        }// fin finally
        return false;
    }// fin metodo modificar estudiante


    public static void main(String[] args) {
        var estudianteDao= new EstudianteDAO();

        //modificar estudiante

        var estudianteModificado= new Estudiante(1, "José Ramón", "Duppre","2525454545","juanpimodificado@gmail.com");
        var modificado = estudianteDao.modificarEstudiante(estudianteModificado);

        if(modificado)
            System.out.println("Estudiante modificado: "+ estudianteModificado);
        else
            System.out.println("No se modificó el estudiante: "+ estudianteModificado);
        // agregar estudiante nuevo
        // var nuevoEstudiante = new Estudiante("Melina", "Nazar", "26548652665", "naty@ejemplo.com");
        // var agregado= estudianteDao.agregarEstudiante(nuevoEstudiante);
        // if(agregado)
        //     System.out.println("Estudiante agregado: "+ nuevoEstudiante);
        // else
        //     System.out.println("No se ha agregado estudiante:" + nuevoEstudiante);
        //listar los estudiantes
        System.out.println("Listado de estudiante:");
        List<Estudiante> estudiantes = estudianteDao.listarEstudiantes();
        estudiantes.forEach(System.out::println);// función lambda para imprimir


        //buscar por id
        //var estudiante1= new Estudiante(1);
        //System.out.println("ESTUDIANTES ANTES DE LA BUSQUEDA: " + estudiante1);
        //var encontrado = estudianteDao.buscarEstudiantePorId(estudiante1);
        //if (encontrado){
       //    System.out.println("Estudiante encontrado: " + estudiante1);
        //}else {
        //    System.out.println("No se encontro estudiante: "+ estudiante1.getIdEstudiante());
       // }
    }
    }