package org.david;

import org.hibernate.Query;
import org.hibernate.Session;

import java.util.Collection;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Ejercicio 1:\n");
        System.out.println(AccesoDatos.DepartamentoInfo("DALLAS"));
        System.out.println("Ejercicio 2:\n");
        System.out.println(AccesoDatos.DepartamentoInfoEmpleados("DALLAS"));
        System.out.println("Ejercicio 3:\n");
        System.out.println(AccesoDatos.EmpleadoMillonetis());
        System.out.println("Ejercicio 4:\n");
        System.out.println(AccesoDatos.DepartamentoDelMasForrado());
        System.out.println("Ejercicio 5:\n");
        System.out.println(AccesoDatos.TotalSalarioDepartamento());
        System.out.println("Ejercicio 6:\n");
        System.out.println(AccesoDatos.DepartamentoMasForrado());
        System.out.println("Ejercicio 7:\n");
        System.out.println(AccesoDatos.JefeMillonetis());
        System.out.println("Ejercicio 8:\n");
        System.out.println(AccesoDatos.EmpleadosQueTienenComoJefeKing());

    }



}
