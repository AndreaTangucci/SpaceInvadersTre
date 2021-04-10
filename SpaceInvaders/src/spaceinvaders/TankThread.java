package spaceinvaders;

import javax.swing.JButton;

public class TankThread implements Runnable{
    
    private final JButton tankButton;
    private int step;
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

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
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
            if (buttonPress == true){
                tank.setTargetX(tank.getTargetX() + step * NewJFrame.STEP);
                //System.out.println("valore targetX: " + tank.getTargetX());
                buttonPress = false;
            }
        }
    }

}
