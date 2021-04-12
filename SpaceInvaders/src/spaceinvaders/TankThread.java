package spaceinvaders;

import javax.swing.JButton;

public class TankThread implements Runnable{
    
    private final JButton tankButton;
    private boolean buttonPress = false;
    private Tank tank;
    
    public TankThread(JButton tankButton) {
        this.tankButton = tankButton;
    }

    public boolean isButtonPress() {
        return buttonPress;
    }

    public void setButtonPress(boolean buttonPress) {
        this.buttonPress = buttonPress;
    }

    public Tank getTank() {
        return tank;
    }

    public void setTank(Tank tank) {
        this.tank = tank;
    }
    

    @Override
    public void run() {
        //creo tank
        tank = new Tank(tankButton);
        while (true){
            //muovo tank
            tank.move();
            
            try {
                //aspetto 200ms
                Thread.sleep(20);
            } catch (InterruptedException ex) {
            }
        }
    }

}
