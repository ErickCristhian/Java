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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class TelaLivro extends JFrame {

	private JPanel contentPane;
	private JTextField txtTitulo;
	private JTextField txtExemplares;
	private JLabel lblFinalizado;
	private JLabel lblAutorDinmico;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLivro frame = new TelaLivro();
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
	public TelaLivro() {
		setTitle("Cadastrar Livro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 434);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("T\u00EDtulo:");
		lblTitulo.setFont(new Font("Lucida Console", Font.BOLD, 15));
		lblTitulo.setBounds(22, 35, 89, 40);
		contentPane.add(lblTitulo);
		
		JLabel lblExemplares = new JLabel("Exemplares:");
		lblExemplares.setFont(new Font("Lucida Console", Font.BOLD, 15));
		lblExemplares.setBounds(22, 107, 110, 40);
		contentPane.add(lblExemplares);
		
		txtTitulo = new JTextField();
		txtTitulo.setFont(new Font("Comic Sans MS", Font.ITALIC, 16));
		txtTitulo.setBounds(179, 35, 180, 40);
		contentPane.add(txtTitulo);
		txtTitulo.setColumns(10);
		
		txtExemplares = new JTextField();
		txtExemplares.setFont(new Font("Comic Sans MS", Font.ITALIC, 16));
		txtExemplares.setColumns(10);
		txtExemplares.setBounds(179, 107, 180, 40);
		contentPane.add(txtExemplares);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setForeground(Color.BLUE);
		btnCadastrar.setFont(new Font("Lucida Console", Font.BOLD, 15));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCadastrar.setBounds(152, 325, 143, 49);
		contentPane.add(btnCadastrar);
		
		lblFinalizado = new JLabel("Finalizado");
		lblFinalizado.setBounds(189, 160, 89, 16);
		contentPane.add(lblFinalizado);
		
		lblAutorDinmico = new JLabel("Autor din\u00E2mico");
		lblAutorDinmico.setBounds(179, 203, 119, 16);
		contentPane.add(lblAutorDinmico);
	}

}
