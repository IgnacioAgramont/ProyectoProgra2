package Proyecto;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import BD.SqlUsuarios;
import Clases.HidePass;
import Clases.Usuario;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class PassUpd extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField AntPass;
	private JPasswordField NewPass;
	private JPasswordField ConNewPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PassUpd frame = new PassUpd();
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
	public PassUpd() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 555, 548);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(50, 205, 50));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\ignac\\OneDrive\\Desktop\\Universidad\\Programacion 2\\Proyecto\\123.png"));
		lblNewLabel_1.setBounds(45, 34, 98, 113);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblGestionDeInventarios = new JLabel("Actualizar Contrase\u00F1a");
		lblGestionDeInventarios.setFont(new Font("Times New Roman", Font.BOLD, 27));
		lblGestionDeInventarios.setBounds(209, 111, 269, 41);
		contentPane.add(lblGestionDeInventarios);
		
		JLabel lblNewLabel = new JLabel("Marca & Mercadeo");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 27));
		lblNewLabel.setBounds(223, 57, 248, 41);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Actualizar Contrase\u00F1a");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					SqlUsuarios mod = new SqlUsuarios();
					Usuario usr = new Usuario();
					BufferedReader w = new BufferedReader(new FileReader("user.txt"));
					int usuario = Integer.parseInt(w.readLine());
					
					usr.setIdUsuario(usuario);
					String pass = new String(AntPass.getPassword());
					String nuevoPass = HidePass.sha1(pass);
					usr.setPassword(nuevoPass);
					String newpass = new String(NewPass.getPassword());
					String connewpass = new String(ConNewPass.getPassword());
					if(mod.ConsultaPass(usr)) {
						if(newpass.equals(connewpass)) {
							String npass = HidePass.sha1(newpass);
							usr.setPassword(npass);
							usr.setIdUsuario(usuario);
							//Envio la password nueva y el usuario
							if(mod.UpdatePass(usr)) {
								JOptionPane.showMessageDialog(null, "La contraseña ha sido actualizada con exito","Done",JOptionPane.INFORMATION_MESSAGE);
								AntPass.setText("");
								ConNewPass.setText("");
								NewPass.setText("");
							}else {
								JOptionPane.showMessageDialog(null, "Error al actualizar la contraseña","Error",JOptionPane.ERROR_MESSAGE);
							}
						}else {
							JOptionPane.showMessageDialog(null, "Las contraseñas ingresadas no son iguales","Error",JOptionPane.ERROR_MESSAGE);
						}
						
					}else {
						JOptionPane.showMessageDialog(null, "La contraseña ingresada no es correcta","Error",JOptionPane.ERROR_MESSAGE);
					}				
					w.close();
				} catch (HeadlessException | IOException e ) {
					e.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(172, 448, 178, 25);
		contentPane.add(btnNewButton);
		
		AntPass = new JPasswordField();
		AntPass.setBounds(145, 236, 242, 22);
		contentPane.add(AntPass);
		
		NewPass = new JPasswordField();
		NewPass.setBounds(145, 318, 242, 22);
		contentPane.add(NewPass);
		
		JLabel lblNewLabel_2 = new JLabel("Antigua Contrase\u00F1a");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_2.setBounds(181, 198, 169, 25);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Nueva Contrase\u00F1a");
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_2_1.setBounds(181, 272, 169, 25);
		contentPane.add(lblNewLabel_2_1);
		
		ConNewPass = new JPasswordField();
		ConNewPass.setBounds(145, 399, 242, 22);
		contentPane.add(ConNewPass);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Repetir Nueva Contrase\u00F1a");
		lblNewLabel_2_1_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_2_1_1.setBounds(155, 353, 205, 25);
		contentPane.add(lblNewLabel_2_1_1);
	}
}
