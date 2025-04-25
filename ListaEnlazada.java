package aed;

import java.util.*;

public class ListaEnlazada<T> implements Secuencia<T> {
    private Nodo primero;
    private Nodo ultimo;
    private int tamaño;

    private class Nodo {
        public T valor;
        public Nodo siguiente;
        public Nodo anterior;

        public Nodo (int v){
            valor = v;
            siguiente = null;
            anterior = null;
         }
    }

    public ListaEnlazada() {
        primero = null;
        ultimo = null;
        tamaño = 0;
    }

    public int longitud() {
        return this.tamaño;
    }

    public void agregarAdelante(T elem) {
        nuevo = new Nodo(elem);
        nuevo.siguiente = primero;
        nuevo.anterior = null;
        primero = nuevo; 
    }

    public void agregarAtras(T elem) {
        nuevo = new Nodo(elem);
        if (primero == null){
            primero = nuevo;
            nuevo.anterior = null;
            nuevo.siguiente = null;
        } else{
            nuevo.siguiente = null; 
            nuevo.anterior = ultimo;
            ultimo = nuevo;  
        }
    }

    public T obtener(int i) {
        if (this.tamaño == 1){
            return this.primero.valor;
        } else if 

    public void eliminar(int i) {
        throw new UnsupportedOperationException("No implementada aun");
    }

    public void modificarPosicion(int indice, T elem) {
        throw new UnsupportedOperationException("No implementada aun");
    }

    public ListaEnlazada(ListaEnlazada<T> lista) {
        Nodo actual_primero = new Nodo(otra.primero);
        Nodo actual_ultimo = new Nodo (otra.ultimo);
        int actual_tamaño = otra.tamaño;
        while (actual_primero != null){
            agregarAtras(actual_primero.valor);
            actual = actual_primero.siguiente;
        }
    }
    
    @Override
    public String toString() {
        throw new UnsupportedOperationException("No implementada aun");
    }

    private class ListaIterador implements Iterador<T> {
    	// Completar atributos privados

        public boolean haySiguiente() {
	        throw new UnsupportedOperationException("No implementada aun");
        }
        
        public boolean hayAnterior() {
	        throw new UnsupportedOperationException("No implementada aun");
        }

        public T siguiente() {
	        throw new UnsupportedOperationException("No implementada aun");
        }
        

        public T anterior() {
	        throw new UnsupportedOperationException("No implementada aun");
        }
    }

    public Iterador<T> iterador() {
	    throw new UnsupportedOperationException("No implementada aun");
    }

    }
