package aed;

import java.util.*;

// Todos los tipos de datos "Comparables" tienen el método compareTo()
// elem1.compareTo(elem2) devuelve un entero. Si es mayor a 0, entonces elem1 > elem2
public class ABB<T extends Comparable<T>> implements Conjunto<T> {
    // Agregar atributos privados del Conjunto
    public int cantidadTotalDeNodos;
    public Nodo raiz;

    private class Nodo {
        // Agregar atributos privados del Nodo
        Nodo padre ;
        Nodo hijoIzquierdo;
        Nodo hijoDerecho;
        T valor;
        // Crear Constructor del nodo
    public Nodo (T elemento){
        valor = elemento;
        padre = null;
        hijoDerecho = null;
        hijoIzquierdo = null;
    }
    }

    public ABB() {
        raiz = null;
        cantidadTotalDeNodos = 0;
    }

    public int cardinal() {
        return (cantidadTotalDeNodos);
    }
    public T minimo(){
        if (this.raiz == null){
            return null;
    }
        else if (this.cantidadTotalDeNodos == 1){
            return (this.raiz.valor);
        }
        else {
            Nodo actual = this.raiz;
            while (actual.hijoIzquierdo != null){
                actual = actual.hijoIzquierdo;
    }
        return actual.valor;
    }
    }

    public T maximo(){
        if (this.raiz == null){
            return null;
    }
        else if (this.cantidadTotalDeNodos == 1){
            return (this.raiz.valor);
        }
        else {
            Nodo actual = this.raiz;
            while (actual.hijoDerecho != null){
                actual = actual.hijoDerecho;
    }
        return actual.valor;
    }
    }
    
    public boolean pertenece(T elem){
        throw new UnsupportedOperationException("No implementada aun");
    }
/* 
    public void insertar(T elem){
        if (this.cantidadTotalDeNodos == 0){
            this.raiz = new Nodo (elem);
            this.cantidadTotalDeNodos = this.cantidadTotalDeNodos + 1;
        }
        else {
            Nodo actual = this.raiz;
            while (this.pertenece(elem) == false){
                if (actual.valor.compareTo(elem) == 0){
                    nada
                }
            }
        }
    }
*/
    

    public void eliminar(T elem){
        throw new UnsupportedOperationException("No implementada aun");
    }

    public String toString(){
        throw new UnsupportedOperationException("No implementada aun");
    }

    private class ABB_Iterador implements Iterador<T> {
        private Nodo _actual;

        public boolean haySiguiente() {            
            throw new UnsupportedOperationException("No implementada aun");
        }
    
        public T siguiente() {
            throw new UnsupportedOperationException("No implementada aun");
        }
    }

    public Iterador<T> iterador() {
        return new ABB_Iterador();
    }

}
