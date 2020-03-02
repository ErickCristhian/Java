package aplicacaoDesempenho;

import java.util.Calendar;
import java.util.GregorianCalendar;

import fachada.Fachada;

public class MedirTempo {

	public static void main(String[] args) throws Exception {
		Calendar hinicial, hfinal;

		Fachada.inicializar();
		//------ gravar dados no banco
		hinicial = new GregorianCalendar();
		System.out.println("\ninicio da gravacao " + hinicial.getTime());
		try{
			for (int i = 1; i<=1000; i++){
				String nome = "erick"+i;
				String cpf = "0" + i;
				String rua = "Rua aleatória";
				Fachada.cadastrarPessoa(nome, cpf, rua);
			}
		}
		catch(Exception e){
			System.out.println("erro:"+ e.getMessage());
		}
		System.out.println("fim da gravacao    " + new GregorianCalendar().getTime());			


		//----ler dados do banco
		System.out.println("\n\ninicio da consulta =  " + new GregorianCalendar().getTime());	
		System.out.println(Fachada.listarPessoas());
		System.out.println("fim da consulta =     " + new GregorianCalendar().getTime());
		hfinal = new GregorianCalendar();

		//---- Calculo do Tempo Total----------
		System.out.println( 
				"\n\n Hora inicial= " +hinicial.getTime() +
				"\n Hora final=   "+ hfinal.getTime() +
				"\n Total (seg)=  "+(hfinal.getTimeInMillis()-hinicial.getTimeInMillis())/1000.0
				);

		Fachada.finalizar();

	}

}


