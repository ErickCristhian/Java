package aplicacaoConsole;
 
import fachada.Fachada;
 
 
public class Atualizar {
    public Atualizar(){
        Fachada.inicializar();
        atualizar();
        Fachada.finalizar();
        System.out.println("\n\naviso: feche sempre o plugin eclipse antes de executar aplicação");
    }
 
    public void atualizar(){
        System.out.println("Atualizando...");
        try{
            Fachada.incluirAutorLivro("java", "pedro");
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    //=================================================
    public static void main(String[] args) {
        new Atualizar();
    }
}