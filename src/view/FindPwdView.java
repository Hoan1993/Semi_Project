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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.FindPwdController;

public class FindPwdView extends JFrame {
	//private static FindPwdView view = new FindPwdView();
	
    private static final long serialVersionUID = 3566038652320101414L;
    private JTextField txtUserid;
    private JTextField txtPwdAnswer;
    private JButton btnLogin;
    
    private String text = "로그인 화면으로 이동";
    private JLabel hyperlink = new JLabel(text);

    public FindPwdView() {
        setTitle("비밀번호 찾기");
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH); 
        setUndecorated(false);
        //setBounds(100, 100, 400, 250);
        Container contentPane = this.getContentPane();
        contentPane.setLayout(null);

        JLabel lblUsername = new JLabel("Userid : ");
        lblUsername.setHorizontalAlignment(SwingConstants.RIGHT);
        lblUsername.setBounds(10, 11, 120, 25);
        contentPane.add(lblUsername);

        txtUserid = new JTextField();
        txtUserid.setBounds(140, 11, 200, 25);
        contentPane.add(txtUserid);
        
     // 비밀번호 확인 질문.
        JLabel lblPwdQ = new JLabel("비밀번호 확인 질문 :");
        lblPwdQ.setHorizontalAlignment(SwingConstants.RIGHT);
        lblPwdQ.setBounds(10, 52, 120, 25);
        contentPane.add(lblPwdQ);
        
        // 콤보 박스
        String [] job = {"기억에 남는 추억의 장소는?", 
        		"자신의 인생 좌우명은?", "자신의 보물 제1호는?", 
        		"가장 기억에 남는 선생님 성함은?", "타인이 모르는 자신만의 신체비밀이 있다면?",
        		"추억하고 싶은 날짜가 있다면?", "받았던 선물 중 기억에 남는 독특한 선물은?",
        		"유년시설 가장 생각나는 친구 이름은?", "인상 깊게 읽은 책 이름은?"};
        
		JComboBox<String> jcb = new JComboBox<>(job);
        //pwdCombo = new JComboBox();
		jcb.setBounds(140, 52, 200, 25);
		contentPane.add(jcb);

		jcb.setSelectedIndex(1);
		
		// 비밀번호 확인 답변
		JLabel lblPwdAnswer = new JLabel("비밀번호 확인 답변 :");
		lblPwdAnswer.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPwdAnswer.setBounds(10, 93, 120, 25);
        contentPane.add(lblPwdAnswer);
        txtPwdAnswer = new JTextField();
        txtPwdAnswer.setBounds(140, 93, 200, 25);
        contentPane.add(txtPwdAnswer);
        
       
        // 비밀번호 찾기
        FindPwdController controller = new FindPwdController(this);
        btnLogin = new JButton("비밀번호찾기");
        btnLogin.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
               controller.findPwd(txtUserid.getText(), jcb.getSelectedIndex(), txtPwdAnswer.getText());
            }
        });
        btnLogin.setBounds(251, 125, 89, 25);
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
        
        hyperlink.setBounds(220, 150, 330, 25);
        contentPane.add(hyperlink);
        
        
        
    }
    
}