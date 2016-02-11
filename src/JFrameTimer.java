import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class JFrameTimer extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameTimer frame = new JFrameTimer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFrameTimer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTimer = new JLabel("12:32:00");
		lblTimer.setBackground(Color.ORANGE);
		lblTimer.setHorizontalAlignment(SwingConstants.CENTER);
		lblTimer.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTimer.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblTimer.setBounds(36, 85, 110, 32);
		contentPane.add(lblTimer);
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				Timer gameClock = new Timer(1000, new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {


						SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
						lblTimer.setText(sdf.format(new Date()));
						
					}
				});
				gameClock.start();
				
			}
		});
		btnStart.setBounds(30, 121, 116, 23);
		contentPane.add(btnStart);
	}
}