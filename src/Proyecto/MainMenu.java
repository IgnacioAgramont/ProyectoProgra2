package Proyecto;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import BD.SqlUsuarios;
import Clases.HidePass;
import Clases.Usuario;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainMenu extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField UserTF;
	private JPasswordField PassTF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu();
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
	public MainMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 638, 482);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 191, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Marca & Mercadeo");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 27));
		lblNewLabel.setBounds(244, 62, 248, 41);
		contentPane.add(lblNewLabel);

		JLabel lblIniciarSesin = new JLabel("Iniciar Sesi\u00F3n");
		lblIniciarSesin.setFont(new Font("Times New Roman", Font.BOLD, 27));
		lblIniciarSesin.setBounds(244, 116, 216, 41);
		contentPane.add(lblIniciarSesin);

		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		lblUsuario.setBounds(153, 192, 123, 41);
		contentPane.add(lblUsuario);

		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		lblContrasea.setBounds(153, 246, 145, 41);
		contentPane.add(lblContrasea);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(
				new ImageIcon("C:\\Users\\ignac\\OneDrive\\Desktop\\Universidad\\Programacion 2\\Proyecto\\123.png"));
		lblNewLabel_1.setBounds(66, 39, 98, 113);
		contentPane.add(lblNewLabel_1);

		UserTF = new JTextField();
		UserTF.setBounds(324, 205, 216, 28);
		contentPane.add(UserTF);
		UserTF.setColumns(10);

		PassTF = new JPasswordField();
		PassTF.setColumns(10);
		PassTF.setBounds(324, 259, 216, 28);
		contentPane.add(PassTF);

		JButton btnNewButton = new JButton("Ingresar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				SqlUsuarios modSql = new SqlUsuarios();
				Usuario mod = new Usuario();

				String pass = new String(PassTF.getPassword());

				String nuevoPass = HidePass.sha1(pass);

				mod.setUsuario(UserTF.getText());
				mod.setPassword(nuevoPass);

				if (modSql.login(mod)) {
					callmenu();
				} else {
					JOptionPane.showMessageDialog(null, "Datos erroneos");
				}

			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		btnNewButton.setBounds(210, 349, 200, 50);
		contentPane.add(btnNewButton);
	}

	void callmenu() {
		ProdAdd obj = new ProdAdd();
		this.setVisible(false);
		obj.setLocationRelativeTo(null);
		obj.setVisible(true);
	}
}
