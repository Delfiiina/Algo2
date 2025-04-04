package aed;

public class Fecha { 
    private int dia; //atributos privados 
    private int mes;

    public Fecha(int dia, int mes) {
        this.dia = dia;
        this.mes = mes;
    }

    public Fecha(Fecha fecha) { // constructor por copia. Por si me quiero guardar la fecha nada más
        dia = fecha.dia;
        mes = fecha.mes;
    }

    public Integer dia() { // Una vez creada la fecha con sus valores (día y mes) si llamo a dia devuelve eso y lo mismo con mes
        return this.dia;
    }

    public Integer mes() {
        return this.mes;
    }

    public String toString() {
        String dia_string = Integer.toString(dia); // Casting, primero a Integer (era int) y después a string
        String mes_string = Integer.toString(mes);
        String res = dia_string + "/" + mes_string;
        return res;
    }

    public void incrementarDia() {
        if (this.dia == 31 && this.mes == 12){
            this.dia = 1;
            this.mes = 1;
        }
        else {
            if (this.dia == diasEnMes(this.mes)){
              this.dia = 1;
             this.mes += 1;
          }

            else {
              this.dia += 1; 
        }
    }
    }

    @Override 
    public boolean equals(Object otra) {
        boolean res = true;
        if (otra == null || this.getClass() != otra.getClass()){
            res = false;
        }
        else {
            Fecha otraFecha = (Fecha) otra;
            res = (otraFecha.dia == this.dia && otraFecha.mes == this.mes);
        }
        return res;
    }

    private int diasEnMes(int mes) {
        int dias[] = {
                // ene, feb, mar, abr, may, jun
                31, 28, 31, 30, 31, 30,
                // jul, ago, sep, oct, nov, dic
                31, 31, 30, 31, 30, 31
        };
        return dias[mes - 1];
    }

}