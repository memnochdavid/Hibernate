package org.david;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "departamentos")
public class Departamento {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nombre", length = 20)
    private String nombre;

    @Column(name = "localizacion", length = 50)
    private String localizacion;

    @OneToMany(mappedBy = "departamento")
    private Set<org.david.Empleado> empleados = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public Set<org.david.Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Set<org.david.Empleado> empleados) {
        this.empleados = empleados;
    }

}