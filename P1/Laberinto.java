/**
 * @author Camacho Flores Edith Teodocia
 * @fecha elaborada: 12/04/24
 * Ejercicio 1 Laberinto
 * G:2
 */
 

 public class Laberinto {

    public static boolean puedoSalir(int n, String[] maze) {  //funcion principal
        if(maze.length < n){
            return false; //en caso de que Ingrese mal el maze o n.
        }
        char[][] laberinto = new char[n][n];//creando
        for (int i = 0; i < n; i++) {
            laberinto[i] = maze[i].toCharArray(); //pasamos a un char[][], vamos iterando
        }

        // Encontrar la posición inicial (S)
        int startX = -1;
        int startY = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (laberinto[i][j] == 'S') {
                    startX = i;//aqui obtenemos la posicion en X de 'S'
                    startY = j;//aqui obtenemos la posicion en Y de 'S'
                    break;
                }
            }
        }

        // Llamar a la función recursiva para buscar un camino '*'
        return encontrarCamino(laberinto, startX, startY);
    }

    private static boolean encontrarCamino(char[][] laberinto, int x, int y) {
        //Verificar si estamos fuera de los límites del laberinto o si estamos en una pared
        if (x < 0 || x >= laberinto.length || y < 0 || y >= laberinto[0].length || laberinto[x][y] == '?' || laberinto[x][y] == 'X') {
            return false;
        }
        //Si se ha alcanzado la salida E retornamos True
        if (laberinto[x][y] == 'E') {
            return true;
        }
        
        laberinto[x][y] = 'X'; //marcamos con una X a todas las que encontremos como * para evitar ciclos finitos
        //Nos movemos en la 4 direcciones 
        boolean encontrado = encontrarCamino(laberinto, x + 1, y) || //Norte
                encontrarCamino(laberinto, x - 1, y) || //Sur
                encontrarCamino(laberinto, x, y + 1) ||  //Este
                encontrarCamino(laberinto, x, y - 1);    //Oeste
        // Restauramos la marca antes de salir de la función actual
        //laberinto[x][y] = '.';
        return encontrado;
    }

    public static void main(String[] args) {
        int number1 = 5;
        String[] maze1 = {
                "S*???",
                "?***?",
                "??*??",
                "??*??",
                "??**E"};
        @SuppressWarnings("unused") //le indico que ignore 
        Laberinto laberinto = new Laberinto();
        System.out.println(puedoSalir(number1, maze1)); // Salida: true

        int number2 = 5;
        String[] maze2 = {
                "S*???",
                "?*?**",
                "??*?*",
                "??*?*",
                "??**E"};
        System.out.println(puedoSalir(number2, maze2)); // Salida: false
    }
}
