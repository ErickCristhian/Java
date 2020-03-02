package aplicacao_swing;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import fachada.Fachada;

public class TelaPrincipal {

	private JFrame frame;
	private JMenu mnPessoa;
	private JMenu mnAutor;
	private JMenu mnLivro;
	private JMenu mnEmprestimo;
	//private JMenuItem mntmListar;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fachada.inicializar();
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
		frame.setTitle("Sistema de Emprestimo");

		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				try{	
					System.out.println("Inicialização completa!");

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

//		JLabel label = new JLabel("");
//		label.setBounds(0, 0, 378, 221);
//		ImageIcon imagem = new ImageIcon(TelaPrincipal.class.getResource("/imagens/imagem1.jpg"));
//		imagem = new ImageIcon(imagem.getImage().getScaledInstance(label.getWidth(),label.getHeight(), Image.SCALE_DEFAULT
//				));
//
//		label.setIcon(imagem);
	
//		frame.getContentPane().add(label);

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		mnAutor = new JMenu("Autores");
		mnEmprestimo = new JMenu("Emprestimos");
		mnLivro = new JMenu("Livros");
		mnPessoa = new JMenu("Pessoa");
		menuBar.add(mnPessoa);
		//Pessoa
		
		JMenuItem mntmListar = new JMenuItem("Listar Pessoas");
		mntmListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaListagem j = new TelaListagem(true, false, false, false, false);
				j.setVisible(true);
			}
		});
		JMenuItem mntmApagar = new JMenuItem("Apagar Pessoa");
		mntmApagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		mnPessoa.add(mntmApagar);
		mnPessoa.add(mntmListar);
		
		JMenuItem mntmCadastrar = new JMenuItem("Cadastrar Pessoa");
		mntmCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				TelaCadastroPessoa p = new TelaCadastroPessoa();
				p.setVisible(true);
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
		});
		mnPessoa.add(mntmCadastrar);
		
		//Autor
		JMenuItem mntmListarAutor = new JMenuItem("Listar Autores");
		mntmListarAutor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaListagem j = new TelaListagem(true, false, false, false, false);
				j.setVisible(true);
			}
		});
		mnAutor.add(mntmListarAutor);
		
		JMenuItem mntmCadastrarAutor = new JMenuItem("Cadastrar Autor");
		mntmCadastrarAutor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				//TelaCadastroAutor a = new TelaCadastroAutor();
				//a.setVisible(true);
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
		});
		mnAutor.add(mntmCadastrarAutor);
		
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
