package spaceinvaders;

import javax.swing.JButton;

public class RocketThread implements Runnable{
    
    private JButton jButtonRocket;
    private Rocket rocket;
    private double x;
    private double y;
    private boolean buttonPress = false;

    public boolean isButtonPress() {
        return buttonPress;
    }

    public void setButtonPress(boolean buttonPress) {
        this.buttonPress = buttonPress;
    }

    public Rocket getRocket() {
        return rocket;
    }

    public void setRocket(Rocket rocket) {
        this.rocket = rocket;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public RocketThread(JButton jButtonRocket) {
        this.jButtonRocket = jButtonRocket;
    }

    @Override
    public void run() {
        //creo rocket
        rocket = new Rocket(x, jButtonRocket);
        rocket.setY(y);
        while(true){
            //muovo rocket
            if (buttonPress == true){
                rocket.move();
                buttonPress = false;
            }
        }
    }

}
