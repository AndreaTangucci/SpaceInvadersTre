package spaceinvaders;

import java.util.ArrayList;
import java.util.Iterator;

public class CollezioneElementi {
    
    private ArrayList<ElementoDiGioco> lista = new ArrayList<>();

    public synchronized ElementoDiGioco get(int i) {
        return lista.get(i);
    }

    public synchronized void add(ElementoDiGioco e) {
        lista.add(e);
    }
    
    public synchronized void remove(ElementoDiGioco e) {
        lista.remove(e);
    }

    /**
     * Elimina i missili ormai usciti dallo schermo.
     * Chiamato dal thread di housekeeping
     */
    public synchronized void removeRockets() {
        Iterator<ElementoDiGioco> iter = lista.iterator();
        while (iter.hasNext()) {
            ElementoDiGioco p = iter.next();
            if (p instanceof Rocket && !p.getButton().isVisible()) {
                System.out.println("p = " + p);
                // si noti l'uso del remove di iterator invece che della lista
                iter.remove();
                System.out.println("Rimosso " + p);
            }
        }
    }
    
    public synchronized void manageElement() {
        lista.stream().forEach(e -> {
            if (e.hasToMove()) {
                e.move();
            } else {
                e.raggiuntoTarget();
                if (e.hasToMove()) {
                    e.move();
                }
            }
        });
    }
}
