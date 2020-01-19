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
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.FindIdController;


public class FindIdView extends JFrame{

	
    private static final long serialVersionUID = 3566038652320101414L;
    private JTextField txtUsername;
    private JTextField txtUserEmail;
    private JButton btnLogin;
    
    private String text = "로그인 화면으로 이동";
    private JLabel hyperlink = new JLabel(text);

    public FindIdView() {
        setTitle("아이디 찾기");
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH); 
        setUndecorated(false);
        Container contentPane = this.getContentPane();
        contentPane.setLayout(null);

        JLabel lblUsername = new JLabel("Username: ");
        lblUsername.setHorizontalAlignment(SwingConstants.RIGHT);
        lblUsername.setBounds(10, 11, 120, 25);
        contentPane.add(lblUsername);

        txtUsername = new JTextField();
        txtUsername.setBounds(140, 11, 200, 25);
        contentPane.add(txtUsername);

        JLabel lblUserEmail = new JLabel("Email:");
        lblUserEmail.setHorizontalAlignment(SwingConstants.RIGHT);
        lblUserEmail.setBounds(10, 52, 120, 25);
        contentPane.add(lblUserEmail);

        txtUserEmail = new JTextField();
        txtUserEmail.setBounds(140, 52, 200, 25);
        contentPane.add(txtUserEmail);

        // 아이디 찾기
        FindIdController controller = new FindIdController(this);
        btnLogin = new JButton("아이디찾기");
        btnLogin.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
               controller.findId(txtUsername.getText(), txtUserEmail.getText());
            }
        });
        btnLogin.setBounds(251, 93, 89, 25);
        contentPane.add(btnLogin);
        
        Font f2 = new Font("바탕", Font.ITALIC, 12);
		hyperlink.setForeground(Color.BLUE.darker());
		hyperlink.setFont(f2);
        hyperlink.setCursor(new Cursor(Cursor.HAND_CURSOR));
 
        hyperlink.addMouseListener(new MouseAdapter() {
 
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                	hyperlink.setText(text);
                	LoginView view = new LoginView();
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
            	hyperlink.setText(text);
            }
 
            @Override
            public void mouseEntered(MouseEvent e) {
                hyperlink.setText("<html><a href=''>" + text + "</a></html>");
            }
 
        });
        
        hyperlink.setBounds(220, 120, 330, 25);
        contentPane.add(hyperlink);
      
    }
    
}
    
