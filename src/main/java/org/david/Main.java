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
    }



}
