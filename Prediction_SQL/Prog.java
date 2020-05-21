package mainpack;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

public class Prog extends JFrame {

	private Panel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Prog frame = new Prog();
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
	public Prog() {
		setTitle("\u041F\u0440\u0435\u0434\u0441\u043A\u0430\u0437\u0430\u043D\u0438\u0435 \u0431\u0443\u0434\u0443\u0449\u0435\u0433\u043E");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 434, 569);
		contentPane = new Panel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u041F\u043E\u0441\u043C\u043E\u0442\u0440\u0438\u0442\u0435 \u043D\u0430 \u043C\u0430\u0433\u0438\u0447\u0435\u0441\u043A\u0438\u0439 \u043A\u0432\u0430\u0434\u0440\u0430\u0442...");
		label.setForeground(Color.BLUE);
		label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label.setBounds(10, 11, 375, 39);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u0412\u0433\u043B\u044F\u0434\u0438\u0442\u0435\u0441\u044C \u0432 \u0431\u0443\u0434\u0443\u0449\u0435\u0435...");
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_1.setBounds(10, 61, 195, 21);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u041F\u043E\u0434\u0443\u043C\u0430\u0439\u0442\u0435 \u043E \u0442\u043E\u043C, \u0447\u0442\u043E \u0432\u044B \u0445\u043E\u0442\u0438\u0442\u0435...");
		label_2.setForeground(Color.MAGENTA);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_2.setBounds(10, 372, 289, 35);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("... \u0438 \u043D\u0430\u0436\u043C\u0438\u0442\u0435 \u0447\u0442\u043E\u0431\u044B");
		label_3.setForeground(Color.ORANGE);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_3.setBounds(10, 418, 174, 26);
		contentPane.add(label_3);
		
		JButton button = new JButton("\u0423\u0437\u043D\u0430\u0442\u044C");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ex) {
				Connection connect;
				try{
					String driverName = "com.mysql.cj.jdbc.Driver";
					Class.forName(driverName);
					
					String serverName = "localhost";
					String mybase = "game";
					String url_ = "jdbc:mysql://"+serverName+"/"+mybase+"?serverTimezone=Europe/Moscow&useSSL=false";
					String username = "root";
					String password = ""; 	
					
					connect = DriverManager.getConnection(url_,username,password);
					
					int rez = (int)(1 + Math.random()*21) + 1;
					System.out.println(rez);
					String query = "SELECT * FROM tabl_var WHERE (id="+rez+")";
					Statement stmt = connect.createStatement();
					ResultSet rs = stmt.executeQuery(query);
					
					String temp;
					while (rs.next())
					{
						temp = rs.getString("text");
						textField.setText(temp);
					}
					connect.close();
				}
				catch(SQLException e){
					System.out.println("lost");
					System.out.println("SQLException: " + e.getMessage());
				    System.out.println("SQLState: " + e.getSQLState());
				    System.out.println("VendorError: " + e.getErrorCode());
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		});
		button.setForeground(new Color(0, 0, 128));
		button.setFont(new Font("Tahoma", Font.PLAIN, 20));
		button.setBounds(184, 422, 115, 32);
		contentPane.add(button);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setBounds(10, 465, 289, 39);
		contentPane.add(textField);
		textField.setColumns(10);
	}
}
