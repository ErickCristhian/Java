package aplicacaoPerformance;

import java.util.Calendar;
import java.util.GregorianCalendar;

import fachada.Fachada;
import modelo.Sexo;

public class MedirTempo {

	public static void main(String[] args) {
		Calendar hinicial, hfinal;

		Fachada.inicializar();
		//------ gravar dados no banco
		hinicial = new GregorianCalendar();
		System.out.println("\ninicio da gravação " + hinicial.getTime());
		try{
			for (int i = 1; i<=1000; i++){
				String nome = "fausto"+i;
				Fachada.cadastrarPessoa(nome, Sexo.MASCULINO);
				Fachada.adicionarTelefonePessoa(nome, "8888-"+i);
				Fachada.adicionarTelefonePessoa(nome, "9999-"+i);
			}
		}
		catch(Exception e){
			System.out.println("erro:"+ e.getMessage());
		}
		System.out.println("fim da gravação    " + new GregorianCalendar().getTime());			


		//----ler dados do banco
		System.out.println("\n\ninicio da consulta =  " + new GregorianCalendar().getTime());	
		String s = Fachada.listarPessoas();
		System.out.println(s);
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


