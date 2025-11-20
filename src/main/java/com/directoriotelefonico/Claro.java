package com.directoriotelefonico;
import java.util.ArrayList;

public class Claro {

   private ArrayList<Cliente> cliente;
   private double[] ganaciamensual;

   //Constructor
   public Claro(ArrayList<Cliente> cliente, double[] ganaciamensual){
    this.cliente= cliente;
    this.ganaciamensual=ganaciamensual;
   }
  /*Metodos Get y Set */

  public void SetCliente (ArrayList<Cliente> client){
    cliente=client;
  }

  public ArrayList<Cliente> GetCliente(){
    return cliente;
  }

  public void SetGanaciaMensual(double[] ganacia){
    ganaciamensual=ganacia;
  }

  public double[] GetGanaciaMensual(){
    return ganaciamensual;
  }


    
}
