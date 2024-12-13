package org.david;

import org.hibernate.Query;
import org.hibernate.Session;
import java.util.Collection;

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
    static public String DepartamentoInfoEmpleados(String dep) {//Ejercicio01
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
        String consulta = "from Empleado e where salario==max(salario)";

        Query sentencia = sesion.createQuery(consulta);
        Empleado objeto_millonetis = (Empleado) sentencia.uniqueResult();
        res+="Empleado más forrado:\n";
        res+="Apellido: "+objeto_millonetis.getApellido()+", Cargo: "+objeto_millonetis.getCargo()+", Salario: "+objeto_millonetis.getSalario()+"\n";

        return res;
    }

}
