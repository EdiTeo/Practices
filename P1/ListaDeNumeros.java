package P1;
/**
 * @author Edith Teodocia Camacho Flores
 * @fecha elaborada 13-04-24
 * Ejercicio 2 
 * Ejercutar --> java P1.ListaDeNumeros
 * G:2
 */
public class ListaDeNumeros{ 

    public boolean puedoGenerar(String[] a, String x){
        return puedoGenerar(a, x, 0, "");
    }     
    private boolean puedoGenerar(String[] a, String x, int j, String concatenar){
        if(j == a.length){
            return concatenar.equals(x); //si a == x True SINO false;
        }
        //hay que ir iterando y concatenando
        return puedoGenerar(a, x,j + 1, concatenar + a[j]) || puedoGenerar(a, x, j + 1, concatenar);
    }
    public static void main(String[] args) {
        ListaDeNumeros creando = new ListaDeNumeros();
        String[] a = {"1","2","5"}; //input
        String buscar = "15"; 
        System.out.println(creando.puedoGenerar(a, buscar));//true

        String[] a1 = {"3","3","4","5","4","5"};//input
        String buscar1 = "544";
        System.out.println(creando.puedoGenerar(a1, buscar1));//false

        String[] a2 = {"1","1","2"}; //input
        String buscar2 = "5"; 
        System.out.println(creando.puedoGenerar(a2, buscar2));//false

        String[] a3 = {"1","1","2"}; //input
        String buscar3 = "112"; 
        System.out.println(creando.puedoGenerar(a3, buscar3));//true
    }

}