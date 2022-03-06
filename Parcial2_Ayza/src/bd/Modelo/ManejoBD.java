package bd.Modelo;

import com.mysql.cj.jdbc.Driver;
import java.sql.Statement;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author beto
 */
public class ManejoBD {

    //CONSTRUCTOR
    public ManejoBD() {}  
    
    //****************************************FUNCIONES******    
    
    //ALTAS & BAJAS
    public void altaAlumno(String nombreAlumno, String apellidoAlumno) throws SQLException, ClassNotFoundException{                
        // Registramos el driver de MySQL (MariaDB)
        Class.forName("com.mysql.cj.jdbc.Driver");
        try{
            // Obtener conexión
            //Chequear root y clave correcta
            Connection conexion = (Connection) DriverManager.getConnection ("jdbc:mysql://127.0.0.1:3306/instituto","root", "");
            //Generar Statement para la consulta
            Statement stmnt = (Statement) conexion.createStatement();
            //A) Consulto si ya existe Registro. 
            //B) Si existe, mandar mensaje error
            //C) Si no, realizar el alta
            ResultSet rs = stmnt.executeQuery("SELECT * FROM Alumnos WHERE nombre = '"+nombreAlumno+"' AND apellido = '"+apellidoAlumno+"'");
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Error: alumno ya existente!");
            }else{
                //intentar el INSERT       
                stmnt.executeUpdate("INSERT INTO Alumnos VALUES (null, '" + nombreAlumno + "', '" + apellidoAlumno + "')");
                JOptionPane.showMessageDialog(null, "Alta exitosa!");
            }
            //Cerrar Statement
            stmnt.close();
            // Cerrar conexión
            conexion.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Alta erronea! " + e);
        }
    }
    
    public void bajaAlumno(String id_alumno) throws ClassNotFoundException, SQLException{
        // Registramos el driver de MySQL (MariaDB)
        Class.forName("com.mysql.cj.jdbc.Driver");
        try{
            // Obtener conexión
            //Chequear root y clave correcta
            Connection conexion = (Connection) DriverManager.getConnection ("jdbc:mysql://127.0.0.1:3310/instituto","root", "");
            //Generar Statement para la consulta
            Statement stmnt = (Statement) conexion.createStatement(); 
            //A) Consulto si ya existe Registro. 
            //B) Si existe, mandar mensaje error
            //C) Si no, realizar el alta
            ResultSet rs = stmnt.executeQuery("SELECT * FROM Alumnos WHERE id_alumno = '"+id_alumno+"'");
            if(rs.next()){                
                //intentar el INSERT
                int cantReg = stmnt.executeUpdate("DELETE FROM Alumnos WHERE id_alumno = '" + id_alumno + "'");
                if(cantReg > 0){
                    JOptionPane.showMessageDialog(null, "Baja exitosa!");
                    //Tmb bajo alumno de AlumnosMateria
                    cantReg = stmnt.executeUpdate("DELETE FROM AlumnosMaterias WHERE id_alumno = '" + id_alumno + "'");
                }
            }else{
                     JOptionPane.showMessageDialog(null, "Error: no se ha encontrado alumno!");
            }
            //Cerrar Statement
            stmnt.close();
            // Cerrar conexión
            conexion.close(); 
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Un error ha ocurrido! " + e);
        }           
    }
    
    public void altaMateria(String nombreMateria) throws SQLException, ClassNotFoundException{
        // Registramos el driver de MySQL (MariaDB)
        Class.forName("com.mysql.cj.jdbc.Driver");
         try{
            // Obtener conexión
            //Chequear root y clave correcta
            Connection conexion = (Connection) DriverManager.getConnection ("jdbc:mysql://127.0.0.1:3306/instituto","root", "");
            //Generar Statement para la consulta
            Statement stmnt = (Statement) conexion.createStatement();
            //A) Consulto si ya existe Registro. 
            //B) Si existe, mandar mensaje error
            //C) Si no, realizar el alta
            ResultSet rs = stmnt.executeQuery("SELECT * FROM Materias WHERE nombre = '"+nombreMateria+"'");
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Error: materia ya existente!");
            }else{
                //intentar el INSERT
                int cantReg = stmnt.executeUpdate("INSERT INTO Materias VALUES (null, '" + nombreMateria + "')");
                JOptionPane.showMessageDialog(null, "Alta exitosa!");
            }
            //Cerrar Statement
            stmnt.close();
            // Cerrar conexión
            conexion.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Alta erronea! " + e);
        }            
    }
    
    public void bajaMateria(String id_materia) throws ClassNotFoundException, SQLException{
        // Registramos el driver de MySQL (MariaDB)
        Class.forName("com.mysql.cj.jdbc.Driver");
        try{
            // Obtener conexión
            //Chequear root y clave correcta
            Connection conexion = (Connection) DriverManager.getConnection ("jdbc:mysql://127.0.0.1:3306/instituto","root", "");
            //Generar Statement para la consulta
            Statement stmnt = (Statement) conexion.createStatement(); 
            ResultSet rs = stmnt.executeQuery("SELECT * FROM Materias WHERE id_materia = '" + id_materia + "'");
            if(rs.next()){ 
                //intentar el INSERT        
                int cantReg = stmnt.executeUpdate("DELETE FROM Materias WHERE id_materia = '" + id_materia + "'");
                if (cantReg > 0) {
                    JOptionPane.showMessageDialog(null, "Baja exitosa!");
                    //Tmb hago baja de MateriasCorrelativas
                    cantReg = stmnt.executeUpdate("DELETE FROM MateriasCorrelativas WHERE id_materia = '" + id_materia + "'");
                }
            }else {
                 JOptionPane.showMessageDialog(null, "Error: No se ha encontrado materia!");
            }
            //Cerrar Statement
            stmnt.close();
            // Cerrar conexión
            conexion.close(); 
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Un error ha ocurrido! " + e);
        }           
    }
    
    public void altaProfesor(String nombreYapellido) throws ClassNotFoundException, SQLException{
        // Registramos el driver de MySQL (MariaDB)
        Class.forName("com.mysql.cj.jdbc.Driver");
        try{
            // Obtener conexión
            //Chequear root y clave correcta
            Connection conexion = (Connection) DriverManager.getConnection ("jdbc:mysql://127.0.0.1:3306/instituto","root", "");
            //Generar Statement para la consulta
            Statement stmnt = (Statement) conexion.createStatement();  
            //A) Consulto si ya existe Registro. 
            //B) Si existe, mandar mensaje error
            //C) Si no, realizar el alta
            ResultSet rs = stmnt.executeQuery("SELECT * FROM Profesores WHERE nombre_apellido = '"+nombreYapellido+"'");
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Error: Profesor ya existente!");
            }else{
                //intentar el INSERT        
                stmnt.executeUpdate("INSERT INTO Profesores VALUES (null, '" + nombreYapellido + "')");
                JOptionPane.showMessageDialog(null, "Alta exitosa!");
            }
            //Cerrar Statement
            stmnt.close();
            // Cerrar conexión
            conexion.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Alta erronea! " + e);
        }        
    }
    
    public void bajaProfesor(String id_profesor) throws ClassNotFoundException, SQLException{
        // Registramos el driver de MySQL (MariaDB)
        Class.forName("com.mysql.cj.jdbc.Driver");
        try{
            // Obtener conexión
            //Chequear root y clave correcta
            Connection conexion = (Connection) DriverManager.getConnection ("jdbc:mysql://127.0.0.1:3306/instituto","root", "");
            //Generar Statement para la consulta
            Statement stmnt = (Statement) conexion.createStatement(); 
            ResultSet rs = stmnt.executeQuery("SELECT * FROM Profesores WHERE id_profesor = '" + id_profesor + "'");            
            if(rs.next()){ 
                //intentar el INSERT
                int cantReg = stmnt.executeUpdate("DELETE FROM Profesores WHERE id_profesor = '" + id_profesor + "'");
                if(cantReg > 0){
                    JOptionPane.showMessageDialog(null, "Baja exitosa!");
                    cantReg = stmnt.executeUpdate("DELETE FROM ProfeMaterias WHERE id_profesor = '" + id_profesor + "'");
                }
            }else{
                    JOptionPane.showMessageDialog(null, "Error: No se ha encontrado profesor!");
            }
            //Cerrar Statement
            stmnt.close();
            // Cerrar conexión
            conexion.close(); 
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Un error ha ocurrido! " + e);
        }           
    }
    
    //ALTA PROFE A MATERIA
    public void altaProfeAMateria(String id_profe, String nombreMateria) throws ClassNotFoundException, SQLException{
        // Registramos el driver de MySQL (MariaDB)
        Class.forName("com.mysql.cj.jdbc.Driver");               
        try{
            // Obtener conexión
            //Chequear root y clave correcta
            Connection conexion = (Connection) DriverManager.getConnection ("jdbc:mysql://127.0.0.1:3306/instituto","root", "");
            //Generar Statement para la consulta
            Statement stmnt = (Statement) conexion.createStatement();
            //1) Conseguir id_materia partiendo de nombreMateria
            ResultSet rs = stmnt.executeQuery("SELECT id_materia FROM Materias WHERE nombre = '" + nombreMateria + "'");
            String id_materia = "";
            if(rs.next()){
                JOptionPane.showMessageDialog(null, rs.getString(1));
                //guardo id_materia
                id_materia = rs.getString(1);
            }
            //A) Consulto si ya existe Registro. 
            //B) Si existe, mandar mensaje error
            //C) Si no, realizar el alta
            rs = stmnt.executeQuery("SELECT * FROM ProfeMaterias WHERE id_profesor = '"+id_profe+"' AND id_materia = '"+id_materia+"'" );
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Error: Profesor ya asignado a esta materia!");
            }else{
                //2) dar de alta con id_profe e id_materia 
                stmnt.executeUpdate("INSERT INTO ProfeMaterias VALUES('" + id_profe + "', '" + id_materia + "')" );
                JOptionPane.showMessageDialog(null, "Alta exitosa!");
            }
            //Cerrar Statement
            stmnt.close();
            // Cerrar conexión
            conexion.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Alta erronea!: " + e);
        }        
    }
    
    //ALTA ALUMNO A MATERIA DE PROFESOR
    public void altaAlumnoAMateriaAProfesor(String id_alumno, String id_materia, String id_profesor) throws ClassNotFoundException, SQLException {
        // Registramos el driver de MySQL (MariaDB)
        Class.forName("com.mysql.cj.jdbc.Driver");        
        //intentar el INSERT
        try{ 
            // Obtener conexión
            //Chequear root y clave correcta
            Connection conexion = (Connection) DriverManager.getConnection ("jdbc:mysql://127.0.0.1:3306/instituto","root", "");
            //Generar Statement para la consulta
            Statement stmnt = (Statement) conexion.createStatement();  
            //A) Verificar que no exista el id_alumno
            ResultSet rs = stmnt.executeQuery("SELECT * FROM Alumnos WHERE id_alumno = '"+id_alumno+"'");
            if(rs.next() == false){
                JOptionPane.showMessageDialog(null, "Error: alumno inexistente!");
            }else{                
                //1ero) Consultar si ya esta inscripto a la materia (con ese profe u otro)
                //2ndo) Consultar si alumno esta cursando alguna correlativa
                //3ero) Si no, realizar el alta
                //----
                //1)
                rs = stmnt.executeQuery("SELECT * FROM AlumnosMaterias WHERE id_alumno = '"+id_alumno+"' AND id_materia = '"+id_materia+"'");
                if(rs.next()){
                    JOptionPane.showMessageDialog(null, "Error: alumno ya estaba inscripto a esta materia!");
                }else{
                    //2) Si la materia tiene una correlativa que cursa el alumno
                    
                    rs = stmnt.executeQuery("SELECT * FROM AlumnosMaterias INNER JOIN MateriasCorrelativas ON AlumnosMaterias.id_materia = MateriasCorrelativas.id_materia WHERE AlumnosMaterias.id_alumno = '" + id_alumno + "'");
                    if(rs.next()){
                        JOptionPane.showMessageDialog(null, "Error: este alumno está cursando una materia correlativa a la seleccionada!");
                    }else{
                        //3) Realizar el alta
                        int cantReg = stmnt.executeUpdate("INSERT INTO AlumnosMaterias VALUES('" + id_alumno + "', '" + id_materia + "', '" + id_profesor + "')");
                        if(cantReg > 0){           
                            JOptionPane.showMessageDialog(null, "Inscripción exitosa!");
                        }
                    }
                }
            }
            //Cerrar Statement
            stmnt.close();
            // Cerrar conexión
            conexion.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Alta erronea! " + e);
        }        
    }
    
    public void agregarMateriaAlumno(){}
    public void agregarCorrelatividadMateria(){}    
    public void consultarProfesor(){}
    public void consultarCorrelatividadMateria(){}
    public void consultarMateriasProfesor(){}
    public void consultarMateriasAlumno(){}
    
    //CONSULTAS
    public ArrayList<String> consultarMaterias() throws SQLException, ClassNotFoundException{
        // Registramos el driver de MySQL (MariaDB)
        Class.forName("com.mysql.cj.jdbc.Driver");            
        // Obtener conexión
        //Chequear root y clave correcta
        ResultSet rs = null;
        ArrayList<String>arraylito = new ArrayList<>();
        try{
            // Obtener conexión
        //Chequear root y clave correcta
        Connection conexion = (Connection) DriverManager.getConnection ("jdbc:mysql://127.0.0.1:3306/instituto","root", "");
            // Generar Statement para consulta
            Statement stmnt = (Statement) conexion.createStatement();            
            //Ejecutar consulta. Resultados almacenados en ResultSet 
            rs = stmnt.executeQuery ("SELECT nombre FROM Materias ORDER BY nombre ASC");            
            // Emitir resultados
            while (rs.next()){
                //JOptionPane.showMessageDialog(null, rs.getString("nombre"));
                arraylito.add(rs.getString(1));
            }           
//            //Cerrar Statement
            stmnt.close();
//            // Cerrar conexión
            conexion.close();
        }catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(null, "Un error ha ocurrido!: " + e);
        }
        //Devolver AL
        return arraylito;
    }
    
    public ArrayList<String> consultarProfesoresQueDictanUnaMateria(String nombreMateria) throws ClassNotFoundException{
        // Registramos el driver de MySQL (MariaDB)
        Class.forName("com.mysql.cj.jdbc.Driver");     
        ArrayList<String> al_nombresApellidosDeProfes = new ArrayList<>();
        try{
            // Obtener conexión
            //Chequear root y clave correcta
            Connection conexion = (Connection) DriverManager.getConnection ("jdbc:mysql://127.0.0.1:3306/instituto","root", "");
            // Generar Statement para consulta
            Statement stmnt = (Statement) conexion.createStatement(); 
            //1) Conseguir ID materia segun 'nombreMateria'
            ResultSet rs = stmnt.executeQuery("SELECT id_materia FROM Materias WHERE nombre = '" + nombreMateria + "'");
            String id_materia = "";
            if(rs.next()){
                id_materia = rs.getString(1);
            }
            //2) Conseguir ID Profesores que dictan ID_materia
            rs = stmnt.executeQuery("SELECT id_profesor FROM ProfeMaterias WHERE id_materia = '" + id_materia + "' ORDER BY id_profesor ASC");
            ArrayList<String> al_id_profes = new ArrayList<>();
            while(rs.next()){
                al_id_profes.add(rs.getString(1));
            }
            //imprimir 'al_id_profes' correspondientes a la materia en cuestion
            //JOptionPane.showMessageDialog(null, "ID Profes que dictan " + nombreMateria + ":\n" + al_id_profes.toString());
            //3) Conseguir "nombre_apellidos" correspondientes a los ID_Profes que dictan la ID_materia 
            int i=0;
            while(i < al_id_profes.size()){
                rs = stmnt.executeQuery ("SELECT nombre_apellido FROM Profesores WHERE id_profesor = '" + al_id_profes.get(i) + "' ORDER BY nombre_apellido ASC");            
                while(rs.next()){    
                    al_nombresApellidosDeProfes.add(rs.getString(1));                
                }
                i++;
            }            
            // Emitir resultados            
            //JOptionPane.showMessageDialog(null, "Profe/s que dictan " + nombreMateria + " :\n" + al_nombresApellidosDeProfes.toString());                
            //Cerrar Statement
            stmnt.close();
//            // Cerrar conexión
            conexion.close();
        }catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(null, "Un error ha ocurrido!: " + e);
        }
        //Devolver AL
        return al_nombresApellidosDeProfes;        
    }
    
    //CONSULTA ID_MATERIA SEGUN NOMBRE
    public String consultarIDMateriaSegunNombre(String nombreMateria) throws ClassNotFoundException{
        String id_materia = "";
        // Registramos el driver de MySQL (MariaDB)
        Class.forName("com.mysql.cj.jdbc.Driver"); 
        try{
            // Obtener conexión
            //Chequear root y clave correcta
            Connection conexion = (Connection) DriverManager.getConnection ("jdbc:mysql://127.0.0.1:3306/instituto","root", "");
            // Generar Statement para consulta
            Statement stmnt = (Statement) conexion.createStatement();            
            //Ejecutar consulta. Resultados almacenados en ResultSet 
            ResultSet rs = stmnt.executeQuery ("SELECT id_materia FROM Materias WHERE nombre = '" + nombreMateria + "'");            
            while(rs.next()){
                id_materia = rs.getString(1);
            }
            //Cerrar Statement
            stmnt.close();
            // Cerrar conexión
            conexion.close();
        }catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(null, "Un error ha ocurrido!: " + e);
        }      
        return id_materia;
    } 
    
    //CONSULTA ID_PROFE SEGUN NOMBRE
    public String consultarIDProfeSegunNombreAprellido(String nombreApellidoProfe) throws ClassNotFoundException {
        String id_profesor = "";
        // Registramos el driver de MySQL (MariaDB)
        Class.forName("com.mysql.cj.jdbc.Driver");  
        try{
            // Obtener conexión
            //Chequear root y clave correcta
            Connection conexion = (Connection) DriverManager.getConnection ("jdbc:mysql://127.0.0.1:3306/instituto","root", "");
            // Generar Statement para consulta
            Statement stmnt = (Statement) conexion.createStatement();            
            //Ejecutar consulta. Resultados almacenados en ResultSet 
            ResultSet rs = stmnt.executeQuery ("SELECT id_profesor FROM Profesores WHERE nombre_apellido = '" + nombreApellidoProfe + "'");            
            while(rs.next()){
                id_profesor = rs.getString(1);          
            }
            //Cerrar Statement
            stmnt.close();
            // Cerrar conexión
            conexion.close();
        }catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(null, "Un error ha ocurrido!: " + e);
        }      
        return id_profesor;
    }

    public ArrayList<Alumno> consultarListadoAlumnosPorMateriaDeUnProfesor(String materiaSeleccionada, String profesorSeleccionado) throws ClassNotFoundException {
        // Registramos el driver de MySQL (MariaDB)
        Class.forName("com.mysql.cj.jdbc.Driver");     
        ArrayList<Alumno> al_listadoAlumnosCursanDichaMateria = new ArrayList<>();
        try{
            // Obtener conexión
            //Chequear root y clave correcta
            Connection conexion = (Connection) DriverManager.getConnection ("jdbc:mysql://127.0.0.1:3306/instituto","root", "");
            // Generar Statement para consulta
            Statement stmnt = (Statement) conexion.createStatement(); 
            //Conseguir ID_ProfeSeleccionado
            String id_profe_seleccionado = "";
            ResultSet rs = stmnt.executeQuery("SELECT id_profesor FROM Profesores WHERE nombre_apellido = '" + profesorSeleccionado + "'");
            if(rs.next()){
                id_profe_seleccionado = rs.getString(1);
            }
            //1) Conseguir ID materia segun 'nombreMateria'
            rs = stmnt.executeQuery("SELECT id_materia FROM Materias WHERE nombre = '" + materiaSeleccionada + "'");
            String id_materia = "";
            if(rs.next()){
                id_materia = rs.getString(1); // id_materia=2 --> [Funciona]
            }
            //2) Con ID_Materia e ID_Profe_seleccionado --> consigo ID_Alumno de tabla AlumnosMaterias
            rs = stmnt.executeQuery("SELECT id_alumno FROM AlumnosMaterias WHERE id_materia = '" + id_materia + "' AND id_profesor = '" + id_profe_seleccionado + "' ORDER BY id_alumno ASC");
            ArrayList<String> al_id_alumnos_que_cursan_dicha_materia = new ArrayList<>();
            while(rs.next()){
                al_id_alumnos_que_cursan_dicha_materia.add(rs.getString(1)); //IDs: 1y3 [Funciona]
            } //IDS OK
            
            //3) En base a los ids_alumnos guardados extraigo nombres y apellidos
            for(int i=0; i<al_id_alumnos_que_cursan_dicha_materia.size(); i++){
                rs = stmnt.executeQuery("SELECT * FROM Alumnos WHERE id_alumno = '" + al_id_alumnos_que_cursan_dicha_materia.get(i) + "'");
                if(rs.next()){
                    Alumno alu = new Alumno(rs.getString(1), rs.getString(2), rs.getString(3));
                    al_listadoAlumnosCursanDichaMateria.add(alu); //Alumnos: Mongopicho y Beto [Funciona]
                }
            }                        
            // Emitir resultados            
            JOptionPane.showMessageDialog(null, "Resultado:\n" + al_listadoAlumnosCursanDichaMateria);            
            //Cerrar Statement
            stmnt.close();
            // Cerrar conexión
            conexion.close();
        }catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(null, "Un error ha ocurrido!: " + e);
        }
        //Devolver AL
        return al_listadoAlumnosCursanDichaMateria; //Devuelve Correctamente
    }
    
    
    
    
    

    
}
