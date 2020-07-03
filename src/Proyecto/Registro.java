package Proyecto;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import BD.SqlUsuarios;
import Clases.HidePass;
import Clases.Usuario;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Registro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField NameField;
	private JTextField UserField;
	private JPasswordField PassField;
	private JTextField CelField;
	private JPasswordField ConPassField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registro frame = new Registro();
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
	public Registro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 674, 706);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(
				new ImageIcon("C:\\Users\\ignac\\OneDrive\\Desktop\\Universidad\\Programacion 2\\Proyecto\\123.png"));
		lblNewLabel_1.setBounds(82, 66, 98, 113);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel = new JLabel("Marca & Mercadeo");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 27));
		lblNewLabel.setBounds(260, 89, 248, 41);
		contentPane.add(lblNewLabel);

		JLabel lblRegistroEmpleados = new JLabel("Registro de Empleados");
		lblRegistroEmpleados.setFont(new Font("Times New Roman", Font.BOLD, 27));
		lblRegistroEmpleados.setBounds(246, 143, 269, 41);
		contentPane.add(lblRegistroEmpleados);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		lblNombre.setBounds(169, 219, 123, 41);
		contentPane.add(lblNombre);

		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		lblContrasea.setBounds(169, 356, 145, 41);
		contentPane.add(lblContrasea);

		NameField = new JTextField();
		NameField.setColumns(10);
		NameField.setBounds(340, 232, 216, 28);
		contentPane.add(NameField);

		UserField = new JTextField();
		UserField.setColumns(10);
		UserField.setBounds(340, 312, 216, 28);
		contentPane.add(UserField);

		JLabel lblUsuario_1 = new JLabel("Usuario:");
		lblUsuario_1.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		lblUsuario_1.setBounds(169, 302, 123, 41);
		contentPane.add(lblUsuario_1);

		PassField = new JPasswordField();
		PassField.setColumns(10);
		PassField.setBounds(340, 369, 216, 28);
		contentPane.add(PassField);

		JLabel lblCelular = new JLabel("Celular:");
		lblCelular.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		lblCelular.setBounds(169, 491, 123, 41);
		contentPane.add(lblCelular);

		CelField = new JTextField();
		CelField.setColumns(10);
		CelField.setBounds(340, 504, 216, 28);
		contentPane.add(CelField);

		JButton btnNewButton = new JButton("Finalizar Registro");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SqlUsuarios modsql = new SqlUsuarios();
				Usuario mod = new Usuario();

				String pass = new String(PassField.getPassword());
				String passCon = new String(ConPassField.getPassword());

				if (pass.equals(passCon)) {
					String nuevoPass = HidePass.sha1(pass);
					int celular = Integer.parseInt(CelField.getText());
					int usuario = Integer.parseInt(UserField.getText());
					mod.setIdUsuario(usuario);
					mod.setPassword(nuevoPass);
					mod.setNombre(NameField.getText());
					mod.setCelular(celular);
					if (modsql.registrar(mod)) {
						JOptionPane.showMessageDialog(null, "Registro completado", "Done",
								JOptionPane.INFORMATION_MESSAGE);
						NameField.setText("");
						UserField.setText("");
						PassField.setText("");
						ConPassField.setText("");
						CelField.setText("");
					} else {
						JOptionPane.showMessageDialog(null, "Error al guardar", "Verifique", JOptionPane.ERROR_MESSAGE);
					}

				} else {
					JOptionPane.showMessageDialog(null, "Las Contraseñas no coinciden", "Verifique las contraseñas",
							JOptionPane.ERROR_MESSAGE);
					PassField.setText("");
					ConPassField.setText("");
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(222, 581, 200, 50);
		contentPane.add(btnNewButton);

		ConPassField = new JPasswordField();
		ConPassField.setColumns(10);
		ConPassField.setBounds(340, 436, 216, 28);
		contentPane.add(ConPassField);

		JLabel lblContrasea_1 = new JLabel("<html>Confirmar <br>Contrase\u00F1a:</html>");
		lblContrasea_1.setFont(new Font("Times New Roman", Font.PLAIN, 27));
		lblContrasea_1.setBounds(169, 410, 145, 68);
		contentPane.add(lblContrasea_1);
		
		JLabel lblNewLabel_2 = new JLabel("El usuario debe ser el CI");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(169, 273, 216, 16);
		contentPane.add(lblNewLabel_2);
	}
}
