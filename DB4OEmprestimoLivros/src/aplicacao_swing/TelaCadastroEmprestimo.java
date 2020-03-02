package aplicacao_swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import dao.DAOdb4o;
import fachada.Fachada;
import modelo.Livro;
import modelo.Pessoa;



@SuppressWarnings("serial")
public class TelaCadastroEmprestimo extends JFrame{

	private JPanel contentPane;
	private JLabel lblPessoa;
	private JLabel lblmsg;
	private JLabel lblData;
	private JTextField textField2;
	private JTextField textField3;
	private JTextField textField4;
	private JTextField textField5;
	private JLabel lblDia;
	private JLabel lblMes;
	private JLabel lblAno;
	private JLabel lblLivro;
	private JComboBox comboBox_Pessoa;
	private JComboBox comboBox_Livro;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TelaCadastroContato frame = new TelaCadastroContato();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public TelaCadastroEmprestimo() throws ParseException {
		setTitle("Cadastrar Emprestimo");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 359, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		comboBox_Pessoa = new JComboBox();
		comboBox_Pessoa.setBounds(72, 14, 62, 14);
		DAOdb4o.begin();
    	ArrayList<Pessoa> pessoa = Fachada.listarPessoas();
		for(Pessoa p : pessoa) {
			comboBox_Pessoa.addItem(p.getNome());
		}
		comboBox_Pessoa.setSelectedIndex(0);
		contentPane.add(comboBox_Pessoa);

		lblPessoa = new JLabel("Pessoa");
		lblPessoa.setBounds(10, 14, 62, 14);
		contentPane.add(lblPessoa);
		
		comboBox_Livro = new JComboBox();
		comboBox_Livro.setBounds(72, 14, 62, 14);
		DAOdb4o.begin();
    	ArrayList<Livro> Livro = Fachada.listarLivros();
		for(Livro p : Livro) {
			comboBox_Livro.addItem(p.getTitulo());
		}
		comboBox_Livro.setSelectedIndex(0);
		contentPane.add(comboBox_Livro);

		lblLivro = new JLabel("Livro");
		lblLivro.setBounds(10, 14, 62, 14);
		contentPane.add(lblLivro);
		
		textField2 = new JTextField();
		textField2.setBounds(72, 46, 180, 20);
		contentPane.add(textField2);
		textField2.setColumns(10);

		lblData = new JLabel("Data de devolução");
		lblData.setBounds(72, 81, 180, 20);
		contentPane.add(lblData);
		

		textField3 = new JTextField();
		textField3.setBounds(72, 81, 180, 20);
		contentPane.add(textField3);
		textField3.setColumns(10);
		
		lblDia = new JLabel("Dia");
		lblDia.setBounds(10, 46, 62, 14);
		contentPane.add(lblDia);
		
		textField4 = new JTextField();
		textField4.setBounds(72, 81, 180, 20);
		contentPane.add(textField4);
		textField4.setColumns(10);

		lblMes = new JLabel("Mês");
		lblMes.setBounds(10, 81, 62, 14);
		contentPane.add(lblMes);

		textField5 = new JTextField();
		textField5.setBounds(72, 106, 180, 20);
		contentPane.add(textField5);
		textField5.setColumns(10);

		lblAno = new JLabel("Ano");
		lblAno.setBounds(10, 106, 62, 14);
		contentPane.add(lblAno);

		
		JButton btnCriar = new JButton("Cadastrar");
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						try{
								Pessoa pessoa = Fachada.encontrarPessoa(comboBox_Pessoa.getSelectedItem().toString());
								Livro livro = Fachada.encontrarLivro(comboBox_Livro.getSelectedItem().toString());
								Fachada.cadastrarEmprestimo(pessoa, livro, LocalDateTime.of(Integer.parseInt(textField3.getText()), Integer.parseInt(textField4.getText()), Integer.parseInt(textField5.getText()), 0, 0));
								DAOdb4o.close();
								
								lblmsg.setText("cadastrado ");
								
								textField2.setText("");
								textField3.setText("");
								textField4.setText("");
								textField5.setText("");
								textField2.requestFocus();
							}
							catch(Exception erro){
								lblmsg.setText(erro.getMessage());
			
							}
			}
		});
		btnCriar.setBounds(72, 250, 115, 23);
		contentPane.add(btnCriar);
		
		lblmsg = new JLabel("");
		lblmsg.setBounds(10, 294, 233, 14);
		contentPane.add(lblmsg);
	}

}
