package spaceinvaders;

import javax.swing.JButton;

public class RocketThread implements Runnable{
    
    private final JButton jButtonRocket;
    private Rocket rocket;
    private double x;
    private double y;
    private boolean buttonPress = false;
    
    public RocketThread(JButton jButtonRocket) {
        this.jButtonRocket = jButtonRocket;
    }

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
        if (rocket != null){
            rocket.setX(x);
        }
    }

    @Override
    public void run() {
        //creo rocket invisibile
        System.out.println("x in Run RocketThread: " + x);
        rocket = new Rocket(x, jButtonRocket);
        rocket.getButton().setVisible(false);
        //rocket.setY(y);
        while(true){
            //muovo rocket
            //rocket.move();
            if (buttonPress == true){
                rocket.getButton().setVisible(true);
                //rocket.setTargetY(rocket.getTargetY() - NewJFrame.STEP);
                rocket.move();
            }
            try {
                //aspetto 200ms
                Thread.sleep(2);
            } catch (InterruptedException ex) {
            }
        }
    }

}
