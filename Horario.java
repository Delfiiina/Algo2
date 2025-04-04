package aed;

public class Horario {
    private int hora; 
    private int minutos;

    public Horario(int hora, int minutos) {
        this.hora = hora;
        this.minutos = minutos;
    }
    public Horario (Horario horario){
        hora = horario.hora;
        minutos = horario.minutos;
    }
    public int hora() {
        return this.hora;
    }

    public int minutos() {
        return this.minutos;
    }

    @Override
    public String toString() {
        String hora_string = Integer.toString(hora);
        String minutos_string = Integer.toString(minutos);
        String res = hora_string + ":" + minutos_string;
        return res;
    }

    @Override
    public boolean equals(Object otro) {
        boolean res = true;
        if (otro == null || this.getClass() != otro.getClass()){
            res = false;
        }
        else {
            Horario otroHorario = (Horario) otro;
            res = (otroHorario.hora == this.hora && otroHorario.minutos == this.minutos);
        }
        return res;
    }

}
