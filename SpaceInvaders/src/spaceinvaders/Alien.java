package spaceinvaders;

import javax.swing.JButton;

public class Alien extends ElementoDiGioco{
    
    public Alien(double y, JButton b) {
        setButton(b);
        setY(y);
        setTargetX(NewJFrame.ALIEN_XMAX);
        setTargetY(y);
        setX(NewJFrame.ALIEN_XMIN);
        setStepX(1);
        setStepY(0);
    }

    /** 
     * Questo metodo indica all'alieno di compiere
     * le azioni necessarie una volta raggiunta la posizione
     * target.
     * Nel caso in questione rimbalza e cambia target.
     */
    @Override
    public void raggiuntoTarget() {
        System.out.println("Raggiunto target");
        // se ho raggiunto il target lato dx
        if (getX() == NewJFrame.ALIEN_XMAX) {
            // cambio il target a sx
            setTargetX(NewJFrame.ALIEN_XMIN);
        } else {
            // ... viceversa
            setTargetX(NewJFrame.ALIEN_XMAX);
        }
        // inverto lo step (i.e. rimbalzo)
        setStepX(-getStepX());
    }
}
