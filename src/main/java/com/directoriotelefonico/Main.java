package com.directoriotelefonico;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Cliente> arreglocliente = new ArrayList<>();
        double[] ganaciamensual = new double[12];

        // Primer requerimiento - Adicionar clientes

        /*
         * int idcliente= 95480796; //id de cliente
         * double[] consumocliente= {25.7,30.5,56.8,100.5,78.3}; //el consumo del
         * cliente
         * 
         * Cliente cliente1= new Cliente(idcliente,consumocliente); //creando del objeto
         * Cliente
         * 
         * cliente.add(cliente1);
         * 
         */
        /* Registrar la cantidad de clientes */
       
        /* Solucion Leo */
        System.out.println("Cuantos clientes de telefonia se registraran?");
        int cantidadcliente = sc.nextInt(); // 5

        for (int i = 0; i < cantidadcliente; i++) {

            System.out.println("Intrduzca el ID del cliente " + (i + 1));
            int idcliente = sc.nextInt();

            Cliente cliente1 = new Cliente(idcliente);
            arreglocliente.add(cliente1);
        }

        // Segundo requerimiento - adicionar consumo de cada mes de cada cliente

        for (Cliente c : arreglocliente) {
            double[] consumocliente = new double[12]; //Array de consumo para cada cliente
            for (int i = 0; i < consumocliente.length; i++) { // se registra el consumo de los 12 meses

                System.out.println("Escriba el consumo del cliente " + c.GetId() + "en el mes" + (i + 1));
                consumocliente[i] = sc.nextInt();
            }
            c.SetConsumo(consumocliente);

        }

        

        // Cuarto requerimiento -- Determinar el cliente que mas consumo
        // y menos consumo reportó para la empresa, dado un mes definido

        double mayor = 0;
        double menor = Double.MAX_VALUE;
        int clientemayorconsumo = 0;
        int clientemenorconsumo = 0;

        System.out.println("Diga el mes que se va a evaluar el consumo (del 1 al 12)");
        int mes = sc.nextInt() - 1; // mes definido por el usuario


        for (Cliente cliente : arreglocliente) { // {c1, c2, c3, c4}
                                                 // {id:1 - [12], id:2 - [12], .....}

            double[] arr = cliente.GetConsumo(); // {[50,2,3,4,.....]}

            // aqui vamos a evaluar el cliente de menor consumo
            if (menor > arr[mes]) {
                menor = arr[mes];
                clientemenorconsumo = cliente.GetId();
                
            }

            // aqui vamos a evaluar el cliente de mayor consumo
            if (mayor < arr[mes]) {
                mayor = arr[mes]; // 100
                clientemayorconsumo = cliente.GetId(); // 1
                
            }

        }

        System.out.println("El cliente de mayor consumo es " + clientemayorconsumo);
        System.out.println("El cliente de menor consumo es " + clientemenorconsumo);

        // Quinto requerimiento - Recaudación total de un mes en la empresa

        System.out.println("Diga el mes que se va a evaluar el consumo (del 1 al 12)");
        int mes_recaudado = sc.nextInt() - 1; // mes definido por el usuario
        double recaudaciontotal = 0;

        

        for (Cliente t : arreglocliente) { // {c1, c2, c3, c4, ...}
            double[] c = t.GetConsumo();
            recaudaciontotal += c[mes_recaudado];
            
        }

        System.out
                .println("La recaudacion de la empresa en el mes " + (mes_recaudado + 1) + "es de " + recaudaciontotal);

        // Tercer requerimiento - Eliminar un abonado y
        // guardar total que ha pagado a la empresa

        System.out.println("¿Cuál abonado será eliminado?");
        int id_abonado = sc.nextInt();
        double consumodeabonadoeliminado = 0;
        boolean bandera = false;

        for (Cliente r : arreglocliente) {

            if (id_abonado == r.GetId()) { // i=12
                double[] c = r.GetConsumo(); // {2500,35,36, 37, ......, 56} //array de longitud 12, el maximo indice es
                                             // 11
                for (int i = 0; i < 12; i++) {
                    consumodeabonadoeliminado += c[i]; // garantice guardar el consumo total del abonado que voy a
                                                       // eliminar
                }

                arreglocliente.remove(r);
                System.out.println("Abonado eliminado satisfactoriamente");
                bandera = true;
                break;
            }
        }

        if (bandera == false) {
            System.out.println("No se encontro el abonado");
        }

        // Sexto requerimiento - la cantidad de clientes que cancelaron sus servicios
        // con
        // CLARO,y la cantidad que se mantienen como abonados de la empresa

        if (bandera == true) {
            System.out.println("Un cliente cancelo sus servicios");
        } else {
            System.out.println("Ningun cliente cancelo sus sercicios");
        }

        System.out.println("La empresa tiene un total de " + arreglocliente.size() + "clientes");

        // Septimo requerimiento - el promedio de ingresos que se obtuvo por día

        for (Cliente s : arreglocliente) {
            double[] c = s.GetConsumo();
            
            System.out.println(
                    "El promedio de ingresos diarios del cliente " + s.GetId() + " es de: " + (c[mes_recaudado] / 30));
        }

        sc.close();

    }

}
