import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.TimerTask;

public class Input {

    public void press() {
        TimerTask task = new TimerTask() {

            public void run() {

                try {
                    Robot robot = new Robot();

                    robot.keyPress(KeyEvent.VK_D);
                    robot.keyRelease((KeyEvent.VK_D));
                } catch (AWTException e) {
                    e.printStackTrace();
                }
            }
        };
    }
}
