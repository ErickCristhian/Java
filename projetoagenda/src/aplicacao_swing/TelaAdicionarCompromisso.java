package aplicacao_swing;


import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import fachada.Fachada;
import modelo.Compromissos;
import modelo.Contato;
import repositorio.Agenda;


public class TelaAdicionarCompromisso extends JFrame{
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField2;
	private JTextField textField3;
	private JTextField textField4;
	private JTextField textField5;
	private JTextField textField6;
	private JFormattedTextField textField7;
	private JFormattedTextField textField8;
	private JComboBox comboBox_tipo;
	private String[] tipos = Fachada.tiposComp();
	private JLabel lblTitulo;
	private JLabel lblDia;
	private JLabel lblMes;
	private JLabel lblAno;
	private JLabel lblHora;
	private JLabel lblMinuto;
	private JLabel lblTipo;
	private JButton btnCriar;
	private JLabel lblmsg;
	

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
	public TelaAdicionarCompromisso() {
		setTitle("Cadastrar Compromisso");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 359, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(72, 11, 180, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		lblTitulo = new JLabel("Titulo");
		lblTitulo.setBounds(10, 14, 62, 14);
		contentPane.add(lblTitulo);
		
		textField2 = new JTextField();
		textField2.setBounds(72, 46, 180, 20);
		contentPane.add(textField2);
		textField2.setColumns(10);

		lblDia = new JLabel("Dia");
		lblDia.setBounds(10, 46, 62, 14);
		contentPane.add(lblDia);
		
		textField3 = new JTextField();
		textField3.setBounds(72, 81, 180, 20);
		contentPane.add(textField3);
		textField3.setColumns(10);

		lblMes = new JLabel("Mês");
		lblMes.setBounds(10, 81, 62, 14);
		contentPane.add(lblMes);

		textField4 = new JTextField();
		textField4.setBounds(72, 106, 180, 20);
		contentPane.add(textField4);
		textField4.setColumns(10);

		lblAno = new JLabel("Ano");
		lblAno.setBounds(10, 106, 62, 14);
		contentPane.add(lblAno);

		textField5 = new JTextField();
		textField5.setBounds(72, 141, 180, 20);
		contentPane.add(textField5);
		textField5.setColumns(10);

		lblHora = new JLabel("Hora");
		lblHora.setBounds(10, 141, 62, 14);
		contentPane.add(lblHora);
		
		textField6 = new JTextField();
		textField6.setBounds(72, 176, 180, 20);
		contentPane.add(textField6);
		textField6.setColumns(10);

		lblMinuto = new JLabel("Minuto");
		lblMinuto.setBounds(10, 176, 62, 14);
		contentPane.add(lblMinuto);
		
		comboBox_tipo = new JComboBox();
		comboBox_tipo.setBounds(72, 211, 180, 20);
		for(int i = 0; i < tipos.length; i++) {
			comboBox_tipo.addItem(tipos[i]);
		}
		contentPane.add(comboBox_tipo);
		
		lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(10, 211, 62, 14);
		contentPane.add(lblTipo);
		System.out.println(tipos);
		
		

		btnCriar = new JButton("Cadastrar");
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						Pattern padraoEmail = Pattern.compile(
								"^([0-9a-zA-Z]+([_.-]?[0-9a-zA-Z]+)*@[0-9a-zA-Z]+[0-9a-zA-Z,.,-]*(.){1}[a-zA-Z]{2,4})+$"
						);
						Matcher alvo = padraoEmail.matcher(textField2.getText());
						if(!alvo.matches()) {
							lblmsg.setText("Email Inválido");
						}
						else {
							try{
								String nome = textField.getText();
								String email = textField2.getText();
								String cep = textField3.getText();
								String numero = textField4.getText();
								String link = textField5.getText();
								int grau = Integer.parseInt(textField6.getText());
								int dia = Integer.parseInt(textField7.getText());
								int mes = Integer.parseInt(textField8.getText());
								
								
								Contato pt = Fachada.cadastrarContato(nome, email, cep, numero, link, grau, dia, mes);
								
								lblmsg.setText("cadastrado ");
								textField.setText("");
								textField2.setText("");
								textField3.setText("");
								textField4.setText("");
								textField5.setText("");
								textField6.setText("");
								textField7.setText("");
								textField8.setText("");
								
								textField.requestFocus();
							}
							catch(Exception erro){
								lblmsg.setText(erro.getMessage());
			
							}
			}
			}
		});
		btnCriar.setBounds(72, 350, 115, 23);
		contentPane.add(btnCriar);
		
		lblmsg = new JLabel("");
		lblmsg.setBounds(10, 294, 233, 14);
		contentPane.add(lblmsg);
	}


}
