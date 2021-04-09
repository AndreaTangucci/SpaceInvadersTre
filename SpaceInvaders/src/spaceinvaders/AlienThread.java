package spaceinvaders;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;

public class AlienThread implements Runnable {

    Collection<Alien> alieni = new ArrayList<>();
    private JButton alien1;
    private JButton alien2;
    private JButton alien3;
    
    public AlienThread() {
    }

    public AlienThread(JButton alien1, JButton alien2, JButton alien3) {
        this.alien1 = alien1;
        this.alien2 = alien2;
        this.alien3 = alien3;
    }

    @Override
    public void run() {
        //creare collezione alieni
        alieni.add(new Alien(50, alien1));
        alieni.add(new Alien(100, alien2));
        alieni.add(new Alien(150, alien3));
        while (true) {
            //muove alieni 
            alieni.forEach(r -> r.move());
            try {
                //aspetto 200ms
                Thread.sleep(2);
            } catch (InterruptedException ex) {
                Logger.getLogger(AlienThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
