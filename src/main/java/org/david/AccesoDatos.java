package org.david;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Collection;
import java.util.List;

public class AccesoDatos {

    public String empleadosDepartamento(String dep) {
        String res = "";
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        String consulta = "from Departamento d where d.nombre='" + dep + "'";

        Query sentencia = sesion.createQuery(consulta);
        Departamento objeto_departamento = (Departamento) sentencia.uniqueResult();

        Collection<Empleado> empleados = objeto_departamento.getEmpleadosById();

        for (Empleado objeto_empleado : empleados) {
            res += objeto_empleado.getApellido() + "\n"
                    + objeto_empleado.getCargo() + "\n"
                    + objeto_empleado.getSalario() + "\n";
        }
        sesion.close();

        return res;
    }

}
