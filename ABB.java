package aed;

import java.util.*;
import java.util.ArrayList;
import java.util.List;

// Todos los tipos de datos "Comparables" tienen el método compareTo()
// elem1.compareTo(elem2) devuelve un entero. Si es mayor a 0, entonces elem1 > elem2
public class ABB<T extends Comparable<T>> implements Conjunto<T> {
    // Agregar atributos privados del Conjunto
    public Nodo raiz;
    private int cardinal;

    private class Nodo {
        // Agregar atributos privados del Nodo
        public Nodo padre;
        public Nodo izquierdo;
        public Nodo derecho;
        public T valor;
        // Crear Constructor del nodo
        public Nodo (T data) {
            this.valor = data;
            this.izquierdo = null;
            this.derecho = null;
            this.padre = null;
        }
    }

    public ABB() {
        this.raiz = null;
        this.cardinal = 0;
    }

    public int cardinal() {
        return (this.cardinal);
    }

    public T minimoAuxiliar(Nodo actual) {
        if (actual.izquierdo == null){ // si no tiene un mínimo...
            return actual.valor; // devuelvo ese valor ya que entonces ES el mínimo
        }
        return minimoAuxiliar(actual.izquierdo); // sino, sigo buscando y me voy por la rama izquierda 
    }

    public T minimo() {
        if (this.raiz == null) { // me saco el caso donde no tengo raíz (árbol vacío)
            return null;
        }
        Nodo aux = this.raiz;
        return minimoAuxiliar(aux);
    }

    public T maximoAuxiliar(Nodo actual) { // igual que mínimo pero con máximo, me voy por la derecha
        if (actual.derecho == null){
            return actual.valor;
        }
        return maximoAuxiliar(actual.derecho);
    }

    public T maximo(){
        if (this.raiz == null) {
            return null;
        }
        Nodo aux = this.raiz;
        return maximoAuxiliar(aux);
    }

    public void insertar (T elem){
        if (this.raiz == null) {
            this.raiz = new Nodo(elem);
            this.cardinal++;
            return;
        }
        insertarAuxiliar(raiz, elem);
    }

    private Nodo insertarAuxiliar (Nodo nodo, T elem){
        if (nodo == null) {
            nodo = new Nodo(elem);
            cardinal++;
            return nodo;
        }

        if (elem.compareTo(nodo.valor) != 0) {
            Nodo nodoTemp;
            if (elem.compareTo(nodo.valor) < 0) {
                if (nodo.izquierdo == null) {
                    nodoTemp = insertarAuxiliar(nodo.izquierdo, elem);
                    nodoTemp.padre = nodo;
                    nodo.izquierdo = nodoTemp;
                } else {
                    insertarAuxiliar(nodo.derecho, elem);
                }                
            }
            else{
                if (nodo.derecho == null) {
                    nodoTemp = insertarAuxiliar(nodo.derecho, elem);
                    nodoTemp.padre = nodo;
                    nodo.derecho = nodoTemp;
                } else {
                    insertarAuxiliar(nodo.derecho, elem);
                }
            }
        } else{
            return nodo;
        }
        return nodo;
    }
/* 
    private Nodo insertarAuxiliar (Nodo nodo, T elem){
        T data = elem;
        if (nodo == null){
            nodo = new Nodo(data);
            cardinal++;
            return nodo;
        }
        if (nodo.valor.compareTo(data) != 0){
            if (nodo.valor.compareTo(data) < 0){
                insertarAuxiliar(nodo.derecho, data);
            }
            else{
                insertarAuxiliar(nodo.izquierdo, data);
            }
        } else {
            return nodo;
        }
        return nodo;
    }
    
    public void insertar(T elem){
        Nodo actual = this.raiz;
        if (raiz == null) { // si mi árbol está vacío, lo pongo como raíz
            this.raiz = new Nodo(elem);
            this.cardinal++;
            return;
        }

        Nodo nodo;
        if (actual.valor.compareTo(elem) != 0){
            if (actual.valor.compareTo(elem) < 0){
                nodo = insertarAuxiliar(actual.derecho, elem);
            }
            else{
                nodo = insertarAuxiliar(actual.izquierdo, elem);
            }


        }
        else{
            return;
        }
    }

    public void insertar(T elem){
        Nodo actual = this.raiz;
        if (raiz == null) { // si mi árbol está vacío, lo pongo como raíz
            this.raiz = new Nodo(elem);
            this.cardinal++;
            return;
        } else {
            while (true) { // voy a usar breaks 
                if (actual.valor.compareTo(elem) == 0) {
                    break; // si quiero insertar uno que ya está, no hago nada
                } else if (actual.valor.compareTo(elem) > 0) { // si el que quiero agregar es menor...
                    if (actual.izquierdo == null) { // y está el lugar libre
                        actual.izquierdo = new Nodo(elem);
                        actual.izquierdo.padre = actual; // lo agrego y le indico cuál es su padre
                        this.cardinal++;
                        break;
                    } else {
                        actual = actual.izquierdo; // sino, sigo buscando el lugar donde tiene que ir 
                    }
                } else if (actual.valor.compareTo(elem) < 0) { // lo mismo pero si el que quiero agregar es mayor 
                    if (actual.derecho == null) {
                        actual.derecho = new Nodo(elem);
                        actual.derecho.padre = actual;
                        this.cardinal++;
                        break;
                    } else {
                        actual = actual.derecho;
                    }
                }
            }
        }
    }
*/
    public Nodo dondeTieneQueEstar (T elem){ // devuelvo el nodo donde tiene que estar ese elemento 
        Nodo actual = this.raiz; 
        if (actual == null){
            return null;
        } else {
            while (actual != null) {
                if (actual.valor.compareTo(elem) == 0) { // si son iguales, devuelvo ese nodo y dejo de buscar, significa que está ahí
                    return actual;
                } else if (actual.valor.compareTo(elem) > 0) { // si es mayor, me voy por el lado izquierdo ya que tendría que estar con los menores
                        actual = actual.izquierdo; // voy buscando yendome por la rama que corresponde
                } else if (actual.valor.compareTo(elem) < 0) { // caso contrario al anterior
                        actual = actual.derecho;
                }
            }
            return null;
        }
    }

    public boolean pertenece(T elem){
        return this.dondeTieneQueEstar (elem) != null; // si donde tiene que estar está vacío entonces no está
    }

    private void intercambiar(Nodo n1, Nodo n2) {
        if (n1.padre == null) { // si es la raíz
            this.raiz = n2; // digo que ahora el n2 es la raíz
        } else if (n1 == n1.padre.izquierdo) { 
            n1.padre.izquierdo = n2;
        } else {
            n1.padre.derecho = n2;
        }
    
        if (n2 != null) {
            n2.padre = n1.padre;
        }
    }

    public void eliminar(T elem){
        Nodo actual = dondeTieneQueEstar (elem); // voy al lugar donde tendría que estar el que quiero eliminar
        if (this.pertenece(elem)){
            if (actual.derecho == null){ // si no tiene hijo derecho
                intercambiar(actual, actual.izquierdo);; // le cambio de lugar con su hijo izquierdo, es decir reacomodo el árbol 
            } else if (actual.izquierdo == null) { // igual pero si no tiene hijo izquierdo
                intercambiar(actual, actual.derecho);;
            } else { // caso donde tiene ambas ramas 
                Nodo sucesor = dondeTieneQueEstar (minimoAuxiliar(actual.derecho)); // reacomodo con el sucesor directo: menor de los mayores = minimo de la rama derecha
                if (sucesor.padre != actual) { 
                    intercambiar(sucesor, sucesor.derecho); // reacomodo todo en la rama derecha  
                    sucesor.derecho = actual.derecho;
                    sucesor.derecho.padre = sucesor; 
                }
                intercambiar(actual, sucesor); // reacomodo todo en la rama izquierda
                sucesor.izquierdo = actual.izquierdo;
                sucesor.izquierdo.padre = sucesor;
            }
        }
            cardinal--; // haga lo que haga, al cardinal le bajo uno 
    }

    public String toString(){
        Iterador iterador = iterador();
        String res = "{";
        if (this.cardinal == 0){
            return ("{}");
        }
        else{
           while (iterador.haySiguiente()) { // Con el iterador voy recorriendo y mientras siga teniendo elems...
            res = res + iterador.siguiente() + ","; // a lo que ya tenía le voy agregando el siguiente
        }
        res = res + iterador.siguiente() + "}"; // pongo el último (ya que no llega a ponerlo el ciclo, solo se fijó si habia un sig) y cierro
        return res; 
        }
    }

    private class ABB_Iterador implements Iterador<T> {
        public T actual = minimo();
        public int indice = 0;

        public boolean haySiguiente() {            
            List<T> lista = armarLista(raiz); 
            if (indice == lista.size() - 1) { 
                return false;
            } else {
                return true;
            }
        }
    
        public T siguiente() {
            List<T> lista = armarLista(raiz); 
            T res = null;
            if (haySiguiente()) { 
                res = actual;  
                actual = lista.get(indice + 1); 
                indice++; 
            } else {
                res = actual;
            }
            return res;
        }
    }

    public Iterador<T> iterador() {
        return new ABB_Iterador();
    }

    void inorder(Nodo raiz, List<T> lista){ 
        if (raiz != null){
            inorder(raiz.izquierdo, lista);
            lista.add(raiz.valor);
            inorder(raiz.derecho, lista);
        }
    }

    public List<T> armarLista(Nodo raiz) {
        List<T> res = new ArrayList<T>();
        this.inorder(raiz, res);
        return res;
    }
}