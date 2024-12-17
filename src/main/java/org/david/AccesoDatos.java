package org.david;

import org.hibernate.Query;
import org.hibernate.Session;
import java.util.Collection;
import java.util.List;

public class AccesoDatos {
    //1. Buscar los datos del departamento localizado en Dallas.
    static public String DepartamentoInfo(String dep) {//Ejercicio01
        String res = "";
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        String consulta = "from Departamento d where d.localizacion='" + dep + "'";

        Query sentencia = sesion.createQuery(consulta);
        Departamento objeto_departamento = (Departamento) sentencia.uniqueResult();
        res+="Nombre Dpto.: "+objeto_departamento.getNombre()+"\n";
        res+="Localizacion: "+objeto_departamento.getLocalizacion()+"\n";
        sesion.close();
        return res;
    }

    //2. Mostrar los empleados que trabajan en el departamento anterior.
    static public String DepartamentoInfoEmpleados(String dep) {//Ejercicio02
        String res = "";
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        String consulta = "from Departamento d where d.localizacion='" + dep + "'";
        Query sentencia = sesion.createQuery(consulta);
        Departamento objeto_departamento = (Departamento) sentencia.uniqueResult();
        res+="Nombre Dpto.: "+objeto_departamento.getNombre()+"\n";
        res+="Localizacion: "+objeto_departamento.getLocalizacion()+"\n";
        res+="Empleados de "+dep+":\n";
        Collection<Empleado> empleados = objeto_departamento.getEmpleados();
        for (Empleado objeto_empleado : empleados) {
            res += "Apellido: "+objeto_empleado.getApellido() + ", Cargo: "
                    + objeto_empleado.getCargo() + ", Salario: "
                    + objeto_empleado.getSalario() + "\n";
        }
        sesion.close();
        return res;
    }

    //3. Buscar el empleado con mayor sueldo de toda la empresa.
    static public String EmpleadoMillonetis(){
        String res="";
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        String consulta = "from Empleado e where e.salario = (select max(e2.salario) from Empleado e2)";

        Query sentencia = sesion.createQuery(consulta);
        Empleado objeto_millonetis = (Empleado) sentencia.uniqueResult();
        res+="Empleado más forrado:\n";
        res+="Apellido: "+objeto_millonetis.getApellido()+", Cargo: "+objeto_millonetis.getCargo()+", Salario: "+objeto_millonetis.getSalario()+"\n";
        sesion.close();
        return res;
    }
    //4. Mostrar en qué departamento trabaja el empleado anterior.
    static public String DepartamentoDelMasForrado(){
        String res="";
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        String consulta = "from Departamento d where d.id = (select max(e.departamento.id) from Empleado e)";
        Query sentencia = sesion.createQuery(consulta);
        Departamento objeto_departamento = (Departamento) sentencia.uniqueResult();
        res+="Nombre: "+objeto_departamento.getNombre()+"\n";
        res+="Localizacion: "+objeto_departamento.getLocalizacion()+"\n";
        sesion.close();
        return res;
    }
    //5. Sumar los sueldos del departamento anterior.
    static public String TotalSalarioDepartamento(){
        String res="";
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        //suma de los salarios del los trabajadores del departamento donde trabaja el que más cobra de todos los empleados
        String consulta="SELECT SUM(e.salario) FROM Empleado e WHERE e.departamento = ( SELECT e2.departamento FROM Empleado e2 WHERE e2.salario = (SELECT MAX(e3.salario) FROM Empleado e3) )";
        Query sentencia = sesion.createQuery(consulta);
        Double salario = (Double) sentencia.uniqueResult();
        res+="Total salario: "+salario+"\n";
        sesion.close();
        return res;
    }
    //6. Encontrar el departamento cuya suma de sueldos es la mayor de la empresa
    static public String DepartamentoMasForrado(){
        String res="";
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        String consulta="SELECT SUM(e.salario) FROM Empleado e WHERE e.salario = (SELECT MAX(e2.salario) FROM Empleado e2)";
        Query sentencia = sesion.createQuery(consulta);
        Double salario = (Double) sentencia.uniqueResult();
        String consulta2="SELECT d.nombre FROM Departamento d WHERE d.id = (SELECT max(e.departamento.id) FROM Empleado e WHERE e.salario = "+salario+")";
        Query sentencia2 = sesion.createQuery(consulta2);
        String nombre_departamento = (String) sentencia2.uniqueResult();
        res+="Nombre: "+nombre_departamento+"\n";
        sesion.close();
        return res;
    }
    //7. Quien es el jefe de MILLER.
    static public String JefeMillonetis(){
        String res="";
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        String consulta = "FROM Empleado e WHERE e.id = ( SELECT sub.jefe FROM Empleado sub WHERE sub.apellido = 'MILLER' )";
        Query sentencia = sesion.createQuery(consulta);
        Empleado objeto_millonetis = (Empleado) sentencia.uniqueResult();
        res+="Jefe de MILLER:\n";
        res+="Apellido: "+objeto_millonetis.getApellido()+", Cargo: "+objeto_millonetis.getCargo()+", Salario: "+objeto_millonetis.getSalario()+"\n";
        sesion.close();
        return res;
    }
    //8. Que empleados tienen como jefe a KING.
    static public String EmpleadosQueTienenComoJefeKing(){
        String res="";
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        String consulta = "FROM Empleado e WHERE e.jefe.apellido = 'KING'";
        Query sentencia = sesion.createQuery(consulta);
        Collection<Empleado> empleados = (Collection<Empleado>) sentencia.list();
        res+="Empleados que tienen como jefe a KING:\n";
        for (Empleado objeto_empleado : empleados) {
            res += "Apellido: "+objeto_empleado.getApellido() + ", Cargo: "
                    + objeto_empleado.getCargo() + ", Salario: "
                    + objeto_empleado.getSalario() + "\n";
        }
        sesion.close();
        return res;
    }
    //9. Mostrar un resumen con cada departamento con sus datos y los datos de todos
    // los trabajadores incluyendo quien su jefe, si lo tienen, y de que empleados son jefes.
    static public String Resumen() {
        String res = "";
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        String consulta1 = "from Departamento";

        Query sentencia1 = sesion.createQuery(consulta1);
        Collection<Departamento> departamentos = (Collection<Departamento>) sentencia1.list();
        res+="Empleados del departamento: \n";
        for(Departamento dpto : departamentos){
            res+="Nombre: "+dpto.getNombre()+"\n";
            res+="Localizacion: "+dpto.getLocalizacion()+"\n";

            String consulta2 = "from Empleado e where e.departamento.id = "+dpto.getId();
            Query sentencia2 = sesion.createQuery(consulta2);
            Collection<Empleado> empleados = (Collection<Empleado>) sentencia2.list();
            for (Empleado objeto_empleado : empleados) {
                res += "Apellido: "+objeto_empleado.getApellido() + ", Cargo: "
                        + objeto_empleado.getCargo() + ", Salario: "
                        + objeto_empleado.getSalario() + "\n";

                String consulta3 = "from Empleado e where e.jefe.id = "+objeto_empleado.getId();
                Query sentencia3 = sesion.createQuery(consulta3);
                Collection<Empleado> empleados_jefe = (Collection<Empleado>) sentencia3.list();
                if(empleados_jefe.size()>0){
                    res+="Jefe: ";
                    for (Empleado objeto_empleado_jefe : empleados_jefe) {
                        res += objeto_empleado_jefe.getApellido() + ", ";
                    }
                    res+="\n";
                }
            }
        }
        sesion.close();
        return res;
    }
    //10. Que empleados son jefes de algún empleado y cuáles no.
    static public String EmpleadosQueSonJefesDeOtrosEmpleados(){
        String res="Empleados sin jefe:\n";
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        String consulta1="from Empleado e where e.jefe.id is null";
        Query sentencia1=sesion.createQuery(consulta1);
        Collection<Empleado> empleados_sin_jefe = (Collection<Empleado>) sentencia1.list();
        for (Empleado objeto_empleado : empleados_sin_jefe) {
            res += "Apellido: "+objeto_empleado.getApellido() + ", Cargo: "
                    + objeto_empleado.getCargo() + ", Salario: "
                    + objeto_empleado.getSalario() + "\n\n";
        }

        String consulta2="from Empleado e where e.jefe.id is not null order by e.jefe.id";
        Query sentencia2=sesion.createQuery(consulta2);
        Collection<Empleado> empleados_con_jefe = (Collection<Empleado>) sentencia2.list();
        res+="Empleados con jefe:\n";
        for (Empleado objeto_empleado : empleados_con_jefe) {
            res+="Apellido: "+objeto_empleado.getApellido() + ", Jefe: "+objeto_empleado.getJefe().getApellido()+"\n";
        }

        sesion.close();
        return res;
    }


}
