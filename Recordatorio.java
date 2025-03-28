package aed;

public class Recordatorio {
    private String mensaje;
    private Fecha fecha;
    private Horario horario;

    public Recordatorio(String mensaje, Fecha fecha, Horario horario) {
        this.mensaje = mensaje;
        this.fecha = new Fecha (fecha);
        this.horario = horario;
    }

    public Horario horario() {
        return this.horario;
    }

    public Fecha fecha() {
        Fecha fecha2 = new Fecha (fecha);
        return fecha2;
    }

    public String mensaje() {
        return this.mensaje;
    }

    @Override
    public String toString() {
        String res = mensaje + "@" + fecha.toString() + horario.toString();
        return res;
    }

    @Override
    public boolean equals(Object otro) {
        boolean res = true;
        if (otro == null || this.getClass() != otro.getClass()) {
            res = false;
        }
        else {
            Recordatorio otroRecordatorio = (Recordatorio) otro;
            res = (otroRecordatorio.fecha == this.fecha && otroRecordatorio.horario == this.horario && otroRecordatorio.mensaje == this.mensaje);
        }
        return res;
    }
}