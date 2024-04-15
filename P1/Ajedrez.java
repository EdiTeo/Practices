package P1;

public class Ajedrez {

    public String simular(int n, int m, int cx, int cy, int tx, int ty) { //funcion principal
        // Verificar si el oponente puede ganar desde su posición actual
        boolean oponenteGana = puedesGanar(n, m, cx, cy, tx, ty, false);
        // Verificar si es posible ganar desde la posición actual
        boolean jugadorGana = puedesGanar(n, m, cx, cy, tx, ty, true);
        // Si el oponente gana, retorna "Second"
        if (oponenteGana) {
            return "Second";
        }
        // Si el jugador gana, retorna "First"
        if (jugadorGana) {
            return "First";
        }
        // Si ninguno gana y no hay empate, retorna "Draw"
        return "Draw";
    }

     private boolean puedesGanar(int n, int m, int cx, int cy, int tx, int ty, boolean esTurnoJugador) {
        //Si es turno del jugador y el caballo está en la misma posición que la torre el jugador gana
        if (esTurnoJugador && cx == tx && cy == ty) {
            return true;
        }

        //Si es turno del oponente y la torre está en la misma fila o columna que el caballo el oponente gana
        if (!esTurnoJugador && (cx == tx || cy == ty)) {
            return false;
        }

        // Movimiento del caballo en la tabla de ajedrez
        int[][] movimientosCaballo = {{1, 2}, {1, -2}, {-1, 2}, {-1, -2}, {2, 1}, {2, -1}, {-2, 1}, {-2, -1}};

        // Para cada movimiento del caballo
        for (int[] movimiento : movimientosCaballo) {
            int nx = cx + movimiento[0];
            int ny = cy + movimiento[1];

            //Es para saber si el caballo esta en el tablero
            if (nx >= 1 && nx <= n && ny >= 1 && ny <= m) {
                // Si es el turno del jugador, realiza el movimiento del caballo
                // Si es el turno del oponente, verifica si el movimiento del caballo lleva a una posición donde puede ganar
                if (esTurnoJugador || puedesGanar(n, m, nx, ny, tx, ty, !esTurnoJugador)) {
                    return true;
                }
            }
        }
            //Es para saber si el torre esta en el tablero
            if (tx >= 1 && tx <= n && ty >= 1 && ty <= m) {
                return false;
            }

        return false;
    }

    public static void main(String[] args) {
        Ajedrez ajedrez = new Ajedrez();
        System.out.println(ajedrez.simular(8, 8, 1, 1, 1, 6)); //Salida: First
        System.out.println(ajedrez.simular(8, 8, 2, 9, 1, 8)); //Salida: Second
         
    }
}
