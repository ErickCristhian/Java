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

public class TelaPessoa extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCPF;
	private JTextField txtEnd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPessoa frame = new TelaPessoa();
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
	public TelaPessoa() {
		setTitle("Cadastrar Pessoa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Lucida Console", Font.BOLD, 15));
		lblNome.setBounds(42, 58, 134, 26);
		contentPane.add(lblNome);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Lucida Console", Font.BOLD, 15));
		lblCpf.setBounds(42, 109, 134, 26);
		contentPane.add(lblCpf);
		
		JLabel lblEndereco = new JLabel("Endere\u00E7o:");
		lblEndereco.setFont(new Font("Lucida Console", Font.BOLD, 15));
		lblEndereco.setBounds(42, 160, 134, 26);
		contentPane.add(lblEndereco);
		
		txtNome = new JTextField();
		txtNome.setFont(new Font("Comic Sans MS", Font.ITALIC, 15));
		txtNome.setBounds(189, 51, 195, 36);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtCPF = new JTextField();
		txtCPF.setFont(new Font("Comic Sans MS", Font.ITALIC, 15));
		txtCPF.setColumns(10);
		txtCPF.setBounds(188, 102, 195, 36);
		contentPane.add(txtCPF);
		
		txtEnd = new JTextField();
		txtEnd.setFont(new Font("Comic Sans MS", Font.ITALIC, 15));
		txtEnd.setColumns(10);
		txtEnd.setBounds(188, 153, 195, 36);
		contentPane.add(txtEnd);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setForeground(Color.BLUE);
		btnCadastrar.setFont(new Font("Lucida Console", Font.BOLD, 15));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCadastrar.setBounds(151, 238, 134, 52);
		contentPane.add(btnCadastrar);
		
		JLabel lblFinalizado = new JLabel("Finalizado");
		lblFinalizado.setBounds(185, 202, 56, 16);
		contentPane.add(lblFinalizado);
	}

}
