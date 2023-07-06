//Metodo por id -> fin by id
public boolean buscarEstudiantePorId(Estudiante estudiante){
    PreparedStatement ps;
    ResultSet rs;
    Connection con = getConnection();
    String sql ="SELECT * FROM estudiantes2022 WHERE idestudaintes2022=?";
    try`{
        ps = con.PreparedStatement(sql);
        ps.setInt(1,estudiante.getIdEstudiante());
        res = ps.executeQuery();
        if(rs.next()){
            estudainte.setNombre(rs.getString("nombre"));
            estudainte.setApellido(rs.getString("apellido"));
            estudainte.setTelefono(rs.getString("telefono"));
            estudiante.setEmail(rs.getString("email"));
            return true;// SE encontro registro 

     
       }//Fin if
     catch (Exception r) {
        System.out.println("Ocurrio un erro al buscar estudiante:" +e.getMessage()));

     }
    }// Fin catch
    finally {
        try{
            con.close();

         } catch (Exception e) {
            System.out.println("ocurriio un error al cerrar la conexion": +e.getMessage)

         } //Fin catch
    
    }  //Fin finally 
}   return false; 


//Buscar por id
var estudiante1 = new Estudiante(1);
System.out.println("Estudiantes antes de la busqueda: ")+estudiante1);
var encontrado = estudainteDao.buscarEstudiantePorId(estudiante1);
if(encontrado){
    System.out.println("Estudiante encontrado:"+estudiante1);
else 
System.out.println("No se encontro el estudiante:" +estudiante1.getIdEstudiante());


}

//Metodo agregar un nuevo estudiante 
public boolean agregarEstudainte(Estudiante estudainte){
    PreparedStatement ps;
    Connection con = getConnection();
    String sql = "INSERT INTO estudiantes2022 (nombre,apellido,telefono,email) VALUES (?,?,?,?)";
    TRY{
        ps= con.prepareStatement(sql);
        ps.setString(1,estudiante.getNombre());
        ps.setString(2,estudainte.getApellido());
        ps.setString(3,estudiante.getTelefono());
        ps.setString(4,estudiante.getEmail());
        

    }catch(Exception e){
        System.out.println("Ocurrio un error al agregar estudiante "+e.getMessage())
    }
}