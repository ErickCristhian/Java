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

public class TelaRemoverContato extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblNome;
	private JButton btnCriar;
	private JLabel lblmsg;

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
	public TelaRemoverContato() {
		setTitle("Remover contato");
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

		btnCriar = new JButton("Remover");
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					if(textField.getText().isEmpty())
						lblmsg.setText("campo vazio");
					else {
						String nome = textField.getText();
						
						Fachada.removerContato(nome);
						
						lblmsg.setText("Contato removido!");
						textField.setText("");
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
		lblmsg.setBounds(10, 80, 273, 14);
		contentPane.add(lblmsg);
		
	}
}
