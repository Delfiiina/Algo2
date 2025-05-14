package aed;

import java.util.*;

public class ListaEnlazada<T> implements Secuencia<T> {
    // Completar atributos privados
    private Nodo primero;
    private Nodo ultimo;
    private int largo;

    private class Nodo {
        // Completar
        T valor;
        Nodo siguiente;
        Nodo anterior;

        public Nodo (T v){
            valor = v;
            siguiente = null;
            anterior = null;
        }
    }

    public ListaEnlazada() {
        this.primero = new Nodo (null);
        this.ultimo = new Nodo (null);
        this.largo = 0;
    }

    public int longitud() {
        return this.largo;
    }

    public void agregarAdelante(T elem) {
    Nodo nuevoNodo = new Nodo (elem);
    if (this.largo == 0){
        this.primero = nuevoNodo;
        this.ultimo = nuevoNodo;
    }
    else {
        this.primero.anterior = nuevoNodo;
        nuevoNodo.siguiente = this.primero;
        this.primero = nuevoNodo;

    }
    this.largo = this.largo + 1;
    }

    public void agregarAtras(T elem) {
    Nodo nuevoNodo = new Nodo (elem);
    if (this.largo == 0){
        this.ultimo = nuevoNodo;
        this.primero = nuevoNodo;
    }
    else {
        this.ultimo.siguiente = nuevoNodo;
        nuevoNodo.anterior = this.ultimo;
        this.ultimo = nuevoNodo;
        nuevoNodo.siguiente = new Nodo (null);
    }
    this.largo = this.largo + 1;
    }

    public T obtener(int i) {
        Nodo actual = this.primero;
        for (int n = 0; n < i; n ++){
            actual = actual.siguiente;
        }
        return actual.valor;
    }

    public void eliminar(int i) {
        int indice = 0;
        Nodo actual = this.primero;
        if (i == 0){
            this.primero = actual.siguiente;
        }
        else if (i == this.largo){
            this.ultimo = this.ultimo.anterior;
            this.ultimo.siguiente = new Nodo (null);
        }
        else{
            while (indice != i){
            actual = actual.siguiente;
            indice = indice + 1;
            }
        actual.anterior.siguiente = actual.siguiente;
        actual.siguiente.anterior = actual.anterior;    
        }
        this.largo = this.largo - 1;
    }

    public void modificarPosicion(int indice, T elem) {
        Nodo actual = primero;
        Nodo NodoConValor = new Nodo(elem);
        for (int n = 0; n < indice; n++){
                actual = actual.siguiente;
        }
        actual.valor = NodoConValor.valor;
        }
    
    public ListaEnlazada<T> copiar() {
        ListaEnlazada<T> copia = new ListaEnlazada<T>();
        if (this.largo == 0) {
            return copia;
        } else {
            for (int n = 0; n < this.largo ; n++){
                copia.agregarAtras(this.obtener(n));
            }
            return copia;
        }
        }

    public ListaEnlazada(ListaEnlazada<T> lista) {
        for (int n = 0; n < lista.largo ; n++){
            this.agregarAtras(lista.obtener(n));
        }
    }
    
    @Override
    public String toString() {
        String lista = "[";
        for (int n = 0; n < this.largo - 1; n++){
            lista = lista + this.obtener(n) + ", ";
        };
        return lista + this.ultimo.valor + "]";
    }

    private class ListaIterador implements Iterador<T> {
    	// Completar atributos privados
        int aca;
        ListaEnlazada<T> nueva;

        public ListaIterador(ListaEnlazada<T> lista){
            aca = 0;
            nueva = lista;
        }

        public boolean haySiguiente() {
	        return aca != nueva.largo;
        }
        
        public boolean hayAnterior() {
	        return aca != 0;
        }

        public T siguiente() {
	        aca ++;
            return nueva.obtener(aca - 1);
        }

        public T anterior() {
	        aca --;
            return nueva.obtener(aca);
        }
    }

    public Iterador<T> iterador() {
	    return new ListaIterador(this);
    }

}