package aplicacaoConsole;

import fachada.Fachada;


public class Listar {
    public Listar(){
        Fachada.inicializar();
        listar();
        Fachada.finalizar();
        System.out.println("\n\naviso: feche sempre o plugin eclipse antes de executar aplicação");
    }
 
    public void listar(){
        System.out.println(Fachada.listarLivros());
        System.out.println(Fachada.listarAutores());
        System.out.println(Fachada.listarEmprestimos());
        System.out.println(Fachada.listarPessoas());
    }
 
    //=================================================
    public static void main(String[] args) {
        new Listar();
    }
}