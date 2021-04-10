package spaceinvaders;

import javax.swing.JButton;

public class Rocket extends ElementoDiGioco {

    public Rocket(double x, JButton b) {
        setButton(b);
        getButton().setVisible(true);
        setX(x);
        setButton(b);
        setTargetY(NewJFrame.ROCKET_YMAX);
        setTargetX(x);
        setY(NewJFrame.ROCKET_YMIN);
        setStepX(0);
        setStepY(-2);
    }

    @Override
    public void raggiuntoTarget() {
        //System.out.println("Raggiunto target");
        // se sono arrivato alla quota più in alto
        if (getY() == NewJFrame.ROCKET_YMAX) {
            // lo nasconde ...
            getButton().setVisible(false);

            // lo ferma
            setStepX(0);
            setStepY(0);
        } else {
            setTargetX(NewJFrame.ROCKET_YMIN);
        }
    }

    @Override
    public void move() {
        //System.out.println("velocita: " + getY());
        
        if (getY() == NewJFrame.ROCKET_YMAX) {
            //setStepX(-getStepX());
            getButton().setVisible(false);
             // lo ferma
            setStepX(0);
            setStepY(0);
        } else {
            //setTargetY(NewJFrame.ROCKET_YMIN);
            setTargetX(NewJFrame.ROCKET_YMIN);
            setY(getY() + getStepY());
        }
    }

}
