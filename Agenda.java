package aed;

public class Agenda {

    private Fecha fecha;
    private ArregloRedimensionableDeRecordatorios recordatorios;


    public Agenda(Fecha fechaActual) {
        this.recordatorios = new ArregloRedimensionableDeRecordatorios();
        this.fecha = fechaActual;
    }

    public void agregarRecordatorio(Recordatorio recordatorio) {
        recordatorios.agregarAtras(recordatorio);
    }

    @Override
    public String toString() {
        String string = new String(fechaActual()+ "\n=====\n");
        for (int n=0; n<this.recordatorios.longitud();n++){
            if(fechaActual().equals((this.recordatorios.obtener(n).fecha()))){
                string += this.recordatorios.obtener(n).toString() + "\n";
            }
        }

        return string;
    }

    public void incrementarDia() {
        this.fecha.incrementarDia();
    }

    public Fecha fechaActual() {
        Fecha devolverFecha = new Fecha(this.fecha);
        return devolverFecha;
    }

}
