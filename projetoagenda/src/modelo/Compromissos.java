package modelo;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

public class Compromissos {
	private int id;
	private String titulo;
	private String tipo;
	private String tipoEscolhido;
	private LocalDateTime datahora;
	private String dataFormatada;
	private DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd.MM.yyyy 'as' HH:mm 'hs'");
	
	
	public Compromissos(int id, String titulo, int Dia, int mes, int ano, int hora, int minuto, String tipo) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.datahora = LocalDateTime.of(ano, mes, Dia, hora, minuto);
		this.dataFormatada = formatador.format(datahora);
		this.tipo = tipo;
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public LocalDateTime getDatahora() {
		return datahora;
	}
	public void setDatahora(LocalDateTime datahora) {
		this.datahora = datahora;
	}
	
	public String getTipoEscolhido() {
		return tipoEscolhido;
	}

	public void setTipoEscolhido(String tipoEscolhido) {
		this.tipoEscolhido = tipoEscolhido;
	}

	public String getTipo() {
		return tipo;
	}

	@Override
	public String toString() {
		return "Compromissos [id=" + id + ", titulo=" + titulo + ", Tipo de compromisso=" + tipoEscolhido + ", Data="
				+ dataFormatada + "]";
	}

	
}
