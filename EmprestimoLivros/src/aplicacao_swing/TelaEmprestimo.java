package aplicacao_swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Color;

public class TelaEmprestimo extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaEmprestimo frame = new TelaEmprestimo();
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
	public TelaEmprestimo() {
		setTitle("Cadastro de Emprestimo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 471, 373);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPessoa = new JLabel("Pessoa:");
		lblPessoa.setFont(new Font("Lucida Console", Font.BOLD, 15));
		lblPessoa.setBounds(37, 54, 106, 16);
		contentPane.add(lblPessoa);
		
		JLabel lblLivros = new JLabel("Livro(s):");
		lblLivros.setFont(new Font("Lucida Console", Font.BOLD, 15));
		lblLivros.setBounds(37, 100, 106, 16);
		contentPane.add(lblLivros);
		
		JLabel lblDataDeEntrega = new JLabel("Data de Entrega:");
		lblDataDeEntrega.setFont(new Font("Lucida Console", Font.BOLD, 15));
		lblDataDeEntrega.setBounds(37, 147, 181, 16);
		contentPane.add(lblDataDeEntrega);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setForeground(Color.BLUE);
		btnCadastrar.setFont(new Font("Lucida Console", Font.BOLD, 15));
		btnCadastrar.setBounds(154, 267, 148, 46);
		contentPane.add(btnCadastrar);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Comic Sans MS", Font.ITALIC, 15));
		comboBox.setBounds(245, 50, 161, 28);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Comic Sans MS", Font.ITALIC, 15));
		comboBox_1.setBounds(245, 96, 161, 28);
		contentPane.add(comboBox_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Comic Sans MS", Font.ITALIC, 15));
		textField.setBounds(245, 143, 161, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblFinalizado = new JLabel("Finalizado");
		lblFinalizado.setBounds(197, 204, 56, 16);
		contentPane.add(lblFinalizado);
	}
}
