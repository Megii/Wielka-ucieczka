package game;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;
public class Zegar extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 356272626311232582L;
	final JLabel label;
    Timer countdownTimer;
    // Initial game time
    int timeRemaining = 12;
    public Zegar() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(200, 200);
        setTitle("Zegar");
        
        label = new JLabel(String.valueOf(timeRemaining), JLabel.CENTER);
        getContentPane().add(label);
        countdownTimer = new Timer(1000, new CountdownTimerListener());
        setVisible(true);
        countdownTimer.start();
    }
    class CountdownTimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (--timeRemaining > 0) {
                label.setText(String.valueOf(timeRemaining));
            } else {
                label.setText("Time's up!");
                countdownTimer.stop();
            }
        }
    }
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
            	new Zegar();
            }
        });
    }
}