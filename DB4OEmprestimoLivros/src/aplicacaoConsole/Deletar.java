package aplicacaoConsole;

import fachada.Fachada;


public class Deletar {
    public Deletar(){
        Fachada.inicializar();
        deletar();
        Fachada.finalizar();
        System.out.println("\n\naviso: feche sempre o plugin eclipse antes de executar aplicação");
    }
 
    public void deletar(){
        System.out.println("Excluindo...");
        try {
            Fachada.excluirLivro("java");
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
 
    //=================================================
    public static void main(String[] args) {
        new Deletar();
    }
}