package aplicacao_swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class TelaAutor extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JLabel lblCadFinalizado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAutor frame = new TelaAutor();
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
	public TelaAutor() {
		setTitle("Cadastro Autor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNomeDoAutor = new JLabel("Nome do Autor:");
		lblNomeDoAutor.setFont(new Font("Lucida Console", Font.BOLD, 15));
		lblNomeDoAutor.setBounds(12, 64, 176, 32);
		contentPane.add(lblNomeDoAutor);
		
		txtNome = new JTextField();
		txtNome.setFont(new Font("Comic Sans MS", Font.ITALIC, 16));
		txtNome.setBounds(175, 63, 210, 32);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setForeground(Color.BLUE);
		btnCadastrar.setFont(new Font("Lucida Console", Font.BOLD, 15));
		btnCadastrar.setBounds(162, 194, 130, 46);
		contentPane.add(btnCadastrar);
		
		lblCadFinalizado = new JLabel("Cadastrado com sucesso!");
		lblCadFinalizado.setBounds(144, 132, 201, 16);
		contentPane.add(lblCadFinalizado);
	}
}
