package com.sgallard.icook;

public class Ingredient {

    private String Name, Cantidad;

    public Ingredient(String name, String cantidad) {
        Name = name;
        Cantidad = cantidad;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCantidad() {
        return Cantidad;
    }

    public void setCantidad(String cantidad) {
        Cantidad = cantidad;
    }
}
