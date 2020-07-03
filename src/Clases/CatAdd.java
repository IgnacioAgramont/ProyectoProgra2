package Clases;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BD.SqlUsuarios;
import Proyecto.ProdAdd;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CatAdd extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField TF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CatAdd frame = new CatAdd();
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
	public CatAdd() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 448, 372);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(123, 104, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Agregar Categor\u00EDa");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 29));
		lblNewLabel.setBounds(94, 38, 229, 46);
		contentPane.add(lblNewLabel);
		
		TF = new JTextField();
		TF.setBounds(94, 174, 221, 22);
		contentPane.add(TF);
		TF.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre de la Categor\u00EDa:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setBounds(94, 127, 210, 34);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Agregar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SqlUsuarios modsql = new SqlUsuarios();
				String categoria = TF.getText();
				if(modsql.AgregarCat(categoria)) {
					JOptionPane.showMessageDialog(null, "Categoria Agregada Exitosamente", "Done",
							JOptionPane.INFORMATION_MESSAGE);
					TF.setText("");
					callProdAdd();
				}else {
					JOptionPane.showMessageDialog(null, "La categoría "+categoria+" ya existe","Error",JOptionPane.ERROR_MESSAGE);
					callProdAdd();
				}
				
			}
		});
		btnNewButton.setBounds(140, 236, 97, 25);
		contentPane.add(btnNewButton);
	}
	void callProdAdd() {
		this.setVisible(false);
	}
}
