package aed;

class Funciones {
    int cuadrado(int x) {
        return x*x;
    }

    double distancia(double x, double y) {
        double xx = x*x;
        double yy = y*y;
        return Math.sqrt(xx + yy);
    }

    boolean esPar(int n) {
        return (n%2 == 0);
    }

    boolean esBisiesto(int n) {
        if (n%400 == 0){
            return true;
        }
        else if (n%4 == 0 && n%100 != 0){ 
            return true;
        }
        return false;
    }

    int factorialIterativo(int n) {
        int variable = n;
        int res = 1;
        if (n == 0) {
            return 1;
        }
        else {
            while (variable > 0){
                res *= variable;
                variable -= 1;
            }
        }
        return res;
    }

    int factorialRecursivo(int n) {
        int res = 1;
        if (n == 0) {
            return 1;
        }
        else {
            res = n * factorialRecursivo(n-1);
        }
        return res;
    }

    int cantidadDeDivisores (int n) {
        int res = 1;
        for (int i = 1; i <= Math.sqrt(n); i ++){
            if (n%i == 0) {
                res += 1;
            }
        }
        return res;
    }

    boolean esPrimo(int n) {
        if (n == 1){
            return false;
        }
        else {
            if (cantidadDeDivisores(n) == 2) {
                return true;
            }
        
    }
        return false;
}


    int sumatoria(int[] numeros) {
        int res = 0;
        for (int i = 0; i < numeros.length; i ++) {
            res += numeros [i];
        }
        return res;
    }
 

    int busqueda(int[] numeros, int buscado) {
        for (int i = 0; i < numeros.length; i ++ ){
            if (numeros [i] == buscado){
                return i;
            }
        }
        return 0;
    }

    boolean tienePrimo(int[] numeros) {
        for (int i = 0; i < numeros.length; i++) {
            if (esPrimo(numeros[i]) == true){
                return true;
            }     
            }
        return false;
    }
    

    boolean todosPares(int[] numeros) {
        for (int i = 0; i< numeros.length; i++) {
            if (esPar(numeros[i]) == false){ 
                return false;
            }
            }
            return true;
        }

    boolean esPrefijo(String s1, String s2) {
        if (s1.length() > s2.length()){
            return false;
        }
        else {
            for (int i =0; i < s1.length(); i++){
                if (s1.charAt(i) != s2.charAt(i)){
                    return false;
            }
        }
        }
        return true;
    }

    boolean esSufijo(String s1, String s2) {
        if (s2.length() < s1.length()){
            return false;
        }
        else {
            for (int i = s1.length()-1; i != 0;  i--){
                if (s2.charAt(i) != s1.charAt(i)){
                    return false;
                }

            }
        return true;
        }
        
} 
}
