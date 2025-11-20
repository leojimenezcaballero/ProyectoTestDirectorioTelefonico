package com.directoriotelefonico;

public class Cliente {
    private int id;
    private double[] consumo;

    // Constructor
    public Cliente(int id, double[] consumo) {
        this.id = id;
        this.consumo = consumo;

    }

    // Constructor de sobrecarga
    public Cliente(int id) {
        this.id = id;

    }

    // metodos get y set

    public void SetId(int id) {
        this.id = id;
    }

    public int GetId() {
        return id;
    }

    public void SetConsumo(double[] consumo) {
        this.consumo = consumo;
    }

    public double[] GetConsumo() {
        return consumo;
    }

}