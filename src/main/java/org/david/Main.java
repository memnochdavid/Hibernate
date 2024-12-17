package org.david;

import org.hibernate.Query;
import org.hibernate.Session;

import java.util.Collection;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int ejercicio=0;
        Scanner sc = new Scanner(System.in);
        boolean stop=false;
        while(!stop){
            System.out.println("Ejercicio a ejecutar:");
            ejercicio=sc.nextInt();
            switch (ejercicio){
                case 0:
                    System.out.println();
                    stop=true;
                case 1:
                    System.out.println("Ejercicio 1:\n");
                    System.out.println(AccesoDatos.DepartamentoInfo("DALLAS"));
                    break;
                case 2:
                    System.out.println("Ejercicio 2:\n");
                    System.out.println(AccesoDatos.DepartamentoInfoEmpleados("DALLAS"));
                    break;
                case 3:
                    System.out.println("Ejercicio 3:\n");
                    System.out.println(AccesoDatos.EmpleadoMillonetis());
                    break;
                case 4:
                    System.out.println("Ejercicio 4:\n");
                    System.out.println(AccesoDatos.DepartamentoDelMasForrado());
                    break;
                case 5:
                    System.out.println("Ejercicio 5:\n");
                    System.out.println(AccesoDatos.TotalSalarioDepartamento());
                    break;
                case 6:
                    System.out.println("Ejercicio 6:\n");
                    System.out.println(AccesoDatos.DepartamentoMasForrado());
                    break;
                case 7:
                    System.out.println("Ejercicio 7:\n");
                    System.out.println(AccesoDatos.JefeMillonetis());
                    break;
                case 8:
                    System.out.println("Ejercicio 8:\n");
                    System.out.println(AccesoDatos.EmpleadosQueTienenComoJefeKing());
                    break;
                case 9:
                    System.out.println("Ejercicio 9:\n");
                    System.out.println(AccesoDatos.Resumen());
                    break;
                case 10:
                    System.out.println("Ejercicio 10:\n");
                    System.out.println(AccesoDatos.EmpleadosQueSonJefesDeOtrosEmpleados());
                    break;
                default:
                    System.out.println("Ejercicio no válido.");
                    break;

            }
        }













    }



}
