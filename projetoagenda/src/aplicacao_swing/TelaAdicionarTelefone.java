package aplicacao_swing;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import fachada.Fachada;
import modelo.Telefone;

public class TelaAdicionarTelefone extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblNome;
	private JLabel lblPreco;
	private JButton btnCriar;
	private JLabel lblmsg;
	private JLabel label;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	//	public static void main(String[] args) {
	//		EventQueue.invokeLater(new Runnable() {
	//			public void run() {
	//				try {
	//					TelaAdicionarTelefone frame = new TelaAdicionarTelefone();
	//					frame.setVisible(true);
	//				} catch (Exception e) {
	//					e.printStackTrace();
	//				}
	//			}
	//		});
	//	}

	/**
	 * Create the frame.
	 */
	public TelaAdicionarTelefone() {
		setTitle("Cadastrar Telefone");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 311, 147);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(72, 11, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 14, 46, 14);
		contentPane.add(lblNome);

		lblPreco = new JLabel("ddd");
		lblPreco.setBounds(10, 39, 46, 14);
		contentPane.add(lblPreco);

		textField_1 = new JTextField();
		textField_1.setBounds(72, 42, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		btnCriar = new JButton("Cadastrar");
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					if(textField.getText().isEmpty() || textField_1.getText().isEmpty())
						lblmsg.setText("campo vazio");
					else {
						String nome = textField.getText();
						String ddd = textField_1.getText();
						String numero = textField_2.getText();
						
						Fachada.adicionarTelefone(nome, ddd, numero);
						
						lblmsg.setText("cadastrado ok=");
						textField.setText("");
						textField_1.setText("");
						textField.requestFocus();
					}
				}
				catch(Exception erro){
					lblmsg.setText(erro.getMessage());
				}
			}
		});
		btnCriar.setBounds(168, 48, 115, 23);
		contentPane.add(btnCriar);

		lblmsg = new JLabel("");
		lblmsg.setBounds(10, 104, 273, 14);
		contentPane.add(lblmsg);
		
		label = new JLabel("numero");
		label.setBounds(10, 79, 46, 14);
		contentPane.add(label);
		
		textField_2 = new JTextField();
		textField_2.setBounds(72, 73, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
	}
}
