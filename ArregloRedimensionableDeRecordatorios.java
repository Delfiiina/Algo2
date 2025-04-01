package aed;

class ArregloRedimensionableDeRecordatorios {
    private Recordatorio[] recordatorio;
    private int longitud;

    public ArregloRedimensionableDeRecordatorios() {
        this.recordatorio = new Recordatorio[0];
        this.longitud = 0;
    }

    public int longitud() {
        return this.longitud;
    }

    public Recordatorio obtener(int i) {
        return this.recordatorio[i];
    }

    public void agregarAtras(Recordatorio i) {
        Recordatorio[] nuevo_recordatorio = new Recordatorio[this.longitud+1]; 
        for (int j = 0; j < this.longitud; j++){
            nuevo_recordatorio[j] = this.recordatorio[j];
        }
        nuevo_recordatorio[this.longitud] = i;
        this.recordatorio = nuevo_recordatorio;
        this.longitud = this.longitud +1;
    }

    public void quitarAtras() {
        Recordatorio[] nuevo_recordatorio = new Recordatorio[this.longitud-1]; 
        for (int i = 0; i < this.longitud-1; i++){
            nuevo_recordatorio[i] = this.recordatorio[i];
        }
        this.recordatorio = nuevo_recordatorio;
        this.longitud = this.longitud-1;
    }

    public void modificarPosicion(int indice, Recordatorio valor) {
        this.recordatorio[indice] = valor;
    }

    public ArregloRedimensionableDeRecordatorios(ArregloRedimensionableDeRecordatorios vector) {
        this.recordatorio = vector.copiar().recordatorio;
        this.longitud = vector.longitud;
    }

    public ArregloRedimensionableDeRecordatorios copiar() {
        ArregloRedimensionableDeRecordatorios nuevo_recordatorio = new ArregloRedimensionableDeRecordatorios(this);
        for(int i=0; i<this.recordatorio.length;i++){
            nuevo_recordatorio.agregarAtras(this.recordatorio[i]);
        }
        return nuevo_recordatorio;
    }
}