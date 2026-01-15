import java.util.ArrayList;
import java.util.List;

public class MemoryHog {
    public static void main(String[] args) {
        List<Integer[]> hog = new ArrayList<>();
        try {
            while (true) {
                // Cada array tendrá 1,000,000 de elementos (mucho más grande)
                hog.add(new Integer[1_000_000]);

                // Opcional: imprimir progreso cada 10 arrays
                if (hog.size() % 10 == 0) {
                    System.out.println("Arrays creados: " + hog.size());
                }
            }
        } catch (OutOfMemoryError e) {
            System.out.println("Se alcanzó el límite de memoria!");
            e.printStackTrace();
        }
    }
}
