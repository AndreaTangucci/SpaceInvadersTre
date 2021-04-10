package spaceinvaders;

import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;

public class AlienThread implements Runnable {
    
    private Collection<Alien> alieni = new ArrayList<>();
    private Collection<JButton> alieniJButton = new ArrayList<>();

    public AlienThread() {
    }
    
    public AlienThread(JButton... alieniJButton) {
        for (JButton jButton : alieniJButton) {
            this.alieniJButton.add(jButton);
        }
    }
    
    @Override
    public void run() {
        //creare collezione alieni
        int y = 50;
        for (JButton ajButton : alieniJButton) {
            alieni.add(new Alien(y, ajButton));
            y += 50;
        }
        
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
