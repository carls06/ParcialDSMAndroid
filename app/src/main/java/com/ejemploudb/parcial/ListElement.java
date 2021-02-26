package com.ejemploudb.parcial;

public class ListElement {
    public  String nombre;
    public  String cargo;
    public  String horast;
    public  String pagoBase;
    public  String descuentos;
    public  String pagoliquido;
    public  boolean bono;
    public  String liquidomasbono;

    public ListElement() {
        this.nombre = nombre;
        this.cargo = cargo;
        this.horast = horast;
        this.pagoBase = pagoBase;
        this.descuentos = descuentos;
        this.pagoliquido = pagoliquido;
        this.bono = bono;
        this.liquidomasbono = liquidomasbono;
    }

    public ListElement(String nombre, String cargo, String horast, String pagoBase, String descuentos, String pagoliquido,boolean bono,String liquidomasbono ) {
        this.nombre = nombre;
        this.cargo = cargo;
        this.horast = horast;
        this.pagoBase = pagoBase;
        this.descuentos = descuentos;
        this.pagoliquido = pagoliquido;
        this.bono = bono;
        this.liquidomasbono = liquidomasbono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getHorast() {
        return horast;
    }

    public void setHorast(String horast) {
        this.horast = horast;
    }

    public String getPagoBase() {
        return pagoBase;
    }

    public void setPagoBase(String pagoBase) {
        this.pagoBase = pagoBase;
    }

    public String getDescuentos() {
        return descuentos;
    }

    public void setDescuentos(String descuentos) {
        this.descuentos = descuentos;
    }

    public String getPagoliquido() {
        return pagoliquido;
    }

    public void setPagoliquido(String pagoliquido) {
        this.pagoliquido = pagoliquido;
    }

    public boolean isBono() {
        return bono;
    }

    public void setBono(boolean bono) {
        this.bono = bono;
    }

    public String getLiquidomasbono() {
        return liquidomasbono;
    }

    public void setLiquidomasbono(String liquidomasbono) {
        this.liquidomasbono = liquidomasbono;
    }
}
