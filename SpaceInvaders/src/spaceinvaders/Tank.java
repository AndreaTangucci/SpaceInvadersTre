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
            if (getX() >= NewJFrame.TANK_XMAX) {
                setStepX(-1);
            } else {
                setStepX(1);
            }
            // ... imposto step a +1

        } else {
            if (getX() <= NewJFrame.TANK_XMIN) {
                setStepX(1);
            } else {
                setStepX(-1);
            }
            // ... altrimenti a -1 (i.e. vado a sinistra)

        }
        // mi muovo
        setX(getX() + getStepX());
        setY(getY() + getStepY());

    }

}
