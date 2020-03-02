package aplicacaoConsole;

import java.time.LocalDateTime;

import fachada.Fachada;


public class Cadastrar {
    public Cadastrar(){
        Fachada.inicializar();
        cadastrar();
        Fachada.finalizar();
        System.out.println("\n\naviso: feche sempre o plugin eclipse antes de executar aplicação");
    }
 
    public void cadastrar(){
        System.out.println("Cadastrando...");
 
        try {
            Fachada.cadastrarLivro("java", 10);
            Fachada.cadastrarLivro("c", 10);
            Fachada.cadastrarLivro("php", 10);
            
            Fachada.incluirAutorLivro("java", "joao");
            Fachada.incluirAutorLivro("java", "maria");
            Fachada.incluirAutorLivro("c", "maria");
            Fachada.incluirAutorLivro("c", "paulo");
            Fachada.incluirAutorLivro("c", "antonio");
            Fachada.incluirAutorLivro("php", "maria");
            
            Fachada.cadastrarPessoa("Erick", "12345644569", "Rua aleatória");
            Fachada.cadastrarPessoa("Jotinha", "15483679548", "Rua aleatória");
            Fachada.cadastrarPessoa("Fernand", "96482357138", "Rua aleatória");
            Fachada.cadastrarPessoa("joao", "68523479158", "Rua aleatória");
            
            Fachada.cadastrarEmprestimo(Fachada.encontrarPessoa("Erick"), Fachada.encontrarLivro("php"), LocalDateTime.of(2015, 12, 10, 00, 00));
            Fachada.cadastrarEmprestimo(Fachada.encontrarPessoa("Jotinha"), Fachada.encontrarLivro("c"), LocalDateTime.of(2019, 06, 19, 00, 00));
            Fachada.cadastrarEmprestimo(Fachada.encontrarPessoa("Fernand"), Fachada.encontrarLivro("java"), LocalDateTime.of(2021, 07, 21, 00, 00));
            
            
            
        }catch (Exception e) {
        	System.out.println("Veio aqui");
            System.out.println(e.getMessage());
        }
    }
     
    //=================================================
    public static void main(String[] args) {
        new Cadastrar();
    }
}