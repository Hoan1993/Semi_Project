package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Main_View extends JFrame {

	BufferedImage img = null;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_View frame = new Main_View();
				/*	frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
			        frame.setUndecorated(false);*/
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
	public Main_View() {
		getContentPane().setBackground(Color.GRAY);
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 956, 631);
		
        setExtendedState(JFrame.MAXIMIZED_BOTH); 
        setUndecorated(false);
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(530, 29, 96, 27);
		getContentPane().add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(12, 31, 506, 24);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel(" 오늘 뭐 먹지?");
		lblNewLabel.setBackground(Color.BLUE);
		lblNewLabel.setBounds(12, 10, 410, 15);
		getContentPane().add(lblNewLabel);
		
		
		// 배경화면 넣는 부분
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setSize(1920, 1080);
		layeredPane.setLayout(null);
		
		try {
			//String back_image1 = "C:\\Users\\sist\\Desktop\\image\\test.png";
			String back_image2 = "C:\\Users\\sist\\Desktop\\image\\back_ground_image2.png";
			img = ImageIO.read(new File(back_image2));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "이미지 불러오기 실패");
			System.exit(0);
		}
		myPanel panel = new myPanel();
		//getContentPane().setSize(getWidth(), getHeight());
		panel.setSize(1920, 1080);
		//panel.setMaximumSize(getMaximumSize());
		layeredPane.add(panel);
		
		setLayout(null);
		
		add(layeredPane);
	}
	
	class myPanel extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public void paint(Graphics g) {
	
			g.drawImage(img, 0, 0, 1920, 1080, null);
					
		}
	}

}
