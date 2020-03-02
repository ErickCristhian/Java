package modelo;

import java.util.ArrayList;

/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * Programação Orientada a Objetos
 * Prof. Fausto Maranhão Ayres
 **********************************/

public class Telefone {
		private String ddd;
		private String numero;
		private ArrayList<Contato> contatos = new ArrayList<>() ;
		
		
		
		
		public Telefone(String ddd, String numero) {
			super();
			this.ddd = ddd;
			this.numero = numero;
		}
		
		
		
		public String getDdd() {
			return ddd;
		}



		public void setDdd(String ddd) {
			this.ddd = ddd;
		}



		public String getNumero() {
			return numero;
		}



		public void setNumero(String numero) {
			this.numero = numero;
		}



		public ArrayList<Contato> getContatos() {
			return contatos;
		}



		public void setContatos(ArrayList<Contato> contatos) {
			this.contatos = contatos;
		}



		public void adicionar(Contato p){
			contatos.add(p);
		}
		public void remover(Contato p){
			contatos.remove(p);
		}

		public Contato localizar(String nome){
			for(Contato p : contatos){
				if(p.getNome().equals(nome))
					return p;
			}
			return null;
		}



		@Override
		public String toString() {
			String texto = "Telefone [numero=" + numero ;
			texto += ", contatos:";
			if (contatos.isEmpty())
				texto += " vazia";
			else 	
				for(Contato p: contatos) 
					texto += " " + p.getNome() ;

			return texto + "]";
		}

	
		//---------------------------------------
		
		
	
}
