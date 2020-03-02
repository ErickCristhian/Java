package aplicacao_swing;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * Programação Orientada a Objetos
 * Prof. Fausto Maranhão Ayres
 **********************************/

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import fachada.Fachada;
import modelo.Contato;
import modelo.Telefone;

public class TelaPrincipal {

	private JFrame frame;
	private JMenuItem mntmCadastrar;
	private JMenuItem mntmListar;
	private JMenu mnProduto;
	private JLabel label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal window = new TelaPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setTitle("Agenda Bem Muito Mais");

		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				try{
					//  pre-cadastro
//					Telefone p;
//					p = Fachada.cadastrarProduto("arroz", 3.0);
//					p = Fachada.cadastrarProduto("feijao", 5.0);
//					p = Fachada.cadastrarProduto("leite", 2.0);
//					p = Fachada.cadastrarProduto("carne", 30.0);
//					p = Fachada.cadastrarProduto("oleo", 10.0);
//					Contato pt;
//					pt = Fachada.cadastrarPrateleira(200);
//					pt = Fachada.cadastrarPrateleira(300);
//					pt = Fachada.cadastrarPrateleira(400);	
					System.out.println("pre-cadastro concluido");

				}catch(Exception e){
					System.out.println(e.getMessage());
				}
			}
			@Override
			public void windowClosing(WindowEvent e) {
				JOptionPane.showMessageDialog(null, "até breve !");
			}
		});

		frame.setBounds(100, 100, 384, 271);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		label = new JLabel("");
		label.setBounds(0, 0, 378, 221);
		ImageIcon imagem = new ImageIcon(TelaPrincipal.class.getResource("/imagens/imagem1.jpg"));
		imagem = new ImageIcon(imagem.getImage().getScaledInstance(label.getWidth(),label.getHeight(), Image.SCALE_DEFAULT
				));

		label.setIcon(imagem);
	
		frame.getContentPane().add(label);

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		mnProduto = new JMenu("Telefone");
		menuBar.add(mnProduto);

		mntmListar = new JMenuItem("Listar");
		mntmListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaListagem j = new TelaListagem(false, true, false, false, false);
				j.setVisible(true);
			}
		});

		JMenuItem mntmApagar = new JMenuItem("Apagar");
		mntmApagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		mnProduto.add(mntmApagar);
		mnProduto.add(mntmListar);
		
		JMenu mnPrateleira = new JMenu("Contato");
		menuBar.add(mnPrateleira);

		JMenuItem mntmCriar = new JMenuItem("Criar");
		mntmCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastroContato j;
				try {
					j = new TelaCadastroContato();
					j.setVisible(true);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		mnPrateleira.add(mntmCriar);
		
		JMenuItem mntmRemoveCont = new JMenuItem("Remover Contato");
		mntmRemoveCont.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaRemoverContato j;
				j = new TelaRemoverContato();
				j.setVisible(true);
			}
		});
		mnPrateleira.add(mntmRemoveCont);

		JMenuItem mntmListar_1 = new JMenuItem("Listar");
		mntmListar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListagem j = new TelaListagem(true, false, false, false, false);
				j.setVisible(true);
			}
		});
		mnPrateleira.add(mntmListar_1);

		JMenuItem mntmInserirProduto = new JMenuItem("Inserir telefone");
		mntmInserirProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaAdicionarTelefone j = new TelaAdicionarTelefone();
				j.setVisible(true);
			}
		});
		mnPrateleira.add(mntmInserirProduto);

		JMenuItem mntmRemoverProduto = new JMenuItem("Remover telefone");
		mntmRemoverProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		mnPrateleira.add(mntmRemoverProduto);
		
		JMenu mnCompromisso = new JMenu("Compromisso");
		menuBar.add(mnCompromisso);
		
		JMenuItem mntmListar = new JMenuItem("Listar Compromissos");
		mntmListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListagem j = new TelaListagem(false, false, true, false, false);
				j.setVisible(true);
			}
		});
		mnCompromisso.add(mntmListar);
		
		JMenuItem mntmCadastrar = new JMenuItem("Cadastrar Compromissos");
		mntmCadastrar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				TelaAdicionarCompromisso t = new TelaAdicionarCompromisso();
				t.setVisible(true);
			}
			
		});
		JMenuItem mntmRemoverCompromisso = new JMenuItem("Remover Compromisso");
		mntmRemoverCompromisso.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				TelaRemoverCompromisso t = new TelaRemoverCompromisso();
				t.setVisible(true);
			}
			
		});
		mnCompromisso.add(mntmCadastrar);
		mnCompromisso.add(mntmListar);
		mnCompromisso.add(mntmRemoverCompromisso);

		JMenu mnConsulta = new JMenu("Consulta");
		JMenuItem mnConsulta1 = new JMenuItem("Consulta 1");
		mnConsulta1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaListagem j = new TelaListagem(false, false, false, true, false);
				j.setVisible(true);
			}
		});
		JMenuItem mnConsulta2 = new JMenuItem("Consulta 2");
		mnConsulta2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaListagem j = new TelaListagem(false, false, false, false, true);
				j.setVisible(true);
			}
		});
		mnConsulta.add(mnConsulta1);
		mnConsulta.add(mnConsulta2);
		menuBar.add(mnConsulta);
		
	}
}
