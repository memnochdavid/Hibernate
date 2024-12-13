package org.david;

import org.hibernate.Query;
import org.hibernate.Session;
import java.util.Collection;

public class AccesoDatos {
    static public String DepartamentoInfo(String dep) {//Ejercicio01
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


}
