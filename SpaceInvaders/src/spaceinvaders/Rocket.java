package spaceinvaders;

import javax.swing.JButton;

public class Rocket extends ElementoDiGioco {

    private boolean buttonPressed;
    
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

    public boolean isButtonPressed() {
        return buttonPressed;
    }

    public void setButtonPressed(boolean buttonPressed) {
        this.buttonPressed = buttonPressed;
        if (buttonPressed){
            setY(NewJFrame.ROCKET_YMIN);
        }
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
            buttonPressed = false;
             // lo ferma
            setStepX(0);
            setStepY(0);
        } else {
            //setTargetY(NewJFrame.ROCKET_YMIN);
            setStepY(-2);
            getButton().setVisible(true);
            setTargetX(NewJFrame.ROCKET_YMIN);
            setY(getY() + getStepY());
        }
        System.out.println("getY in Rocket.move: " + getY());
    }

}
