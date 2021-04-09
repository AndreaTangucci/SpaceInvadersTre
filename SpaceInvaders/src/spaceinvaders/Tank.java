package spaceinvaders;

import javax.swing.JButton;

public class Tank extends ElementoDiGioco {

    public Tank(JButton b) {
        setButton(b);
        setX(NewJFrame.TANK_XMIN);
        setY(NewJFrame.ROCKET_YMIN);
        setTargetX(getX());
        setTargetY(getY());
        setStepX(2);
        setStepY(0);
    }

    @Override
    public void move() {
        // se devo andare a destra ...
        if (getTargetX() > getX()) {
            // ... imposto step a +1
            setStepX(1);
        } else {
            // ... altrimenti a -1 (i.e. vado a sinistra)
            setStepX(-1);
        }
        // mi muovo
        setX(getX() + getStepX());
        setY(getY() + getStepY());
    }

}
