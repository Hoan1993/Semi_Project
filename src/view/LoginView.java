package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.LoginController;

public class LoginView extends JFrame {
	private static LoginView view = new LoginView();
	
    private static final long serialVersionUID = 3566038652320101414L;
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton btnLogin;
    private JLabel lblErrorMessage;
    
    private String text1 = "아이디 찾기";
    private JLabel hyperlink1 = new JLabel(text1);
    
    private String text2 = "암호 찾기";
    private JLabel hyperlink2 = new JLabel(text2);

    public LoginView() {
        setTitle("로그인 페이지");
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH); 
        setUndecorated(false);
        //setBounds(100, 100, 400, 250);
        Container contentPane = this.getContentPane();
        contentPane.setLayout(null);

        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setHorizontalAlignment(SwingConstants.RIGHT);
        lblUsername.setBounds(10, 11, 120, 25);
        contentPane.add(lblUsername);

        txtUsername = new JTextField();
        txtUsername.setBounds(140, 11, 200, 25);
        contentPane.add(txtUsername);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
        lblPassword.setBounds(10, 52, 120, 25);
        contentPane.add(lblPassword);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(140, 52, 200, 25);
        contentPane.add(txtPassword);

        // 로그인 버튼
        LoginController controller = new LoginController(this);
        btnLogin = new JButton("로그인");
        btnLogin.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                controller.checkCredentials(txtUsername.getText(), new String(txtPassword.getPassword()));
            }
        });
        btnLogin.setBounds(251, 93, 89, 25);
        contentPane.add(btnLogin);
        
        JButton btnJoin = new JButton("회원가입");
        btnJoin.addActionListener(new JoinListener());
        btnJoin.setBounds(150, 93, 89, 25);
        contentPane.add(btnJoin);
        
        
        // 암호 찾기 하이퍼링크
        Font f1 = new Font("바탕", Font.ITALIC, 12);
		hyperlink1.setForeground(Color.BLUE.darker());
		hyperlink1.setFont(f1);
        hyperlink1.setCursor(new Cursor(Cursor.HAND_CURSOR));
 
        hyperlink1.addMouseListener(new MouseAdapter() {
 
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                	
                   /* Desktop.getDesktop().browse(new URI("http://www.codejava.net"));*/
                	hyperlink1.setText(text1);
                	FindIdView view = new FindIdView();
                    view.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    view.setUndecorated(false);
                    dispose();
                    //view.setVisible(false);            
                    view.setVisible(true);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
 
            @Override
            public void mouseExited(MouseEvent e) {
            	hyperlink1.setText(text1);
            }
 
            @Override
            public void mouseEntered(MouseEvent e) {
                hyperlink1.setText("<html><a href=''>" + text1 + "</a></html>");
            }
 
        });
        
        
        hyperlink1.setBounds(210, 120, 80, 25);
        //setLayout(new FlowLayout());
        contentPane.add(hyperlink1);
        
        
        // 암호 찾기.
        Font f2 = new Font("바탕", Font.ITALIC, 12);
		hyperlink2.setForeground(Color.BLUE.darker());
		hyperlink2.setFont(f2);
        hyperlink2.setCursor(new Cursor(Cursor.HAND_CURSOR));
 
        hyperlink2.addMouseListener(new MouseAdapter() {
 
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                	
                   /* Desktop.getDesktop().browse(new URI("http://www.codejava.net"));*/
                	hyperlink2.setText(text2);
                	FindPwdView view = new FindPwdView();
                    view.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    view.setUndecorated(false);
                    dispose();
                    //view.setVisible(false);            
                    view.setVisible(true);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
 
            @Override
            public void mouseExited(MouseEvent e) {
                hyperlink2.setText(text2);
            }
 
            @Override
            public void mouseEntered(MouseEvent e) {
                hyperlink2.setText("<html><a href=''>" + text2 + "</a></html>");
            }
 
        });
        
        hyperlink2.setBounds(285, 120, 80, 25);
        //setLayout(new FlowLayout());
        contentPane.add(hyperlink2);
        
        lblErrorMessage = new JLabel("");
        lblErrorMessage.setHorizontalAlignment(SwingConstants.RIGHT);
        lblErrorMessage.setForeground(Color.RED);
        lblErrorMessage.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblErrorMessage.setBounds(10, 140, 330, 25);
        contentPane.add(lblErrorMessage);
    }
    
    class JoinListener implements ActionListener {
    	   	
		@Override
		public void actionPerformed(ActionEvent e) {
			
			JoinView join = new JoinView();
			view.setVisible(false);
			join.setVisible(true);		
		}
    }
    
    public void setErrorMessage(String errorMessage) {
        lblErrorMessage.setText(errorMessage);
    }

    public static void main(String args[]){
        view.setVisible(true);
    }
}