package br.edu.ifpb.pweb2.passbook.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import br.edu.ifpb.pweb2.passbook.util.Situacao;

@Entity
@Table(name = "alunos")
public class Aluno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name = "data_nascimento")
	private Date dataNascimento;

	private Integer faltas = 0;
	
	@Column(name = "nota_1")
	private BigDecimal nota1;
	
	@Column(name = "nota_2")
	private BigDecimal nota2;
	
	@Column(name = "nota_3")
	private BigDecimal nota3;
	
	@Column(name = "nota_final")
	private BigDecimal notaFinal;
	
	private Situacao situacao = Situacao.MATRICULADO;

	public Aluno() { }
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getFaltas() {
		return faltas;
	}

	public void setFaltas(Integer faltas) { this.faltas = faltas; }

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public BigDecimal getNota1() {
		return nota1;
	}

	public void setNota1(BigDecimal nota1) {
		this.nota1 = nota1;
	}

	public BigDecimal getNota2() {
		return nota2;
	}

	public void setNota2(BigDecimal nota2) {
		this.nota2 = nota2;
	}

	public BigDecimal getNota3() {
		return nota3;
	}

	public void setNota3(BigDecimal nota3) {
		this.nota3 = nota3;
	}

	public BigDecimal getNotaFinal() {
		return notaFinal;
	}

	public void setNotaFinal(BigDecimal notaFinal) {
		this.notaFinal = notaFinal;
	}

	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}
	
	
	public Situacao calculaSituacao() {
		if(this.getNota1() != null && this.getNota2() != null && this.getNota3() != null) {
			
			if(getMedia() >= 7.0 && this.faltas < 25) {
				return Situacao.APROVADO;
				
			} else if(getMedia() >= 4.0 && this.faltas < 25) {
				return Situacao.FINAL;
				
			} else if(this.faltas >= 25) {
				return Situacao.REPROVADO_FALTA;
				
			} else {
				return Situacao.REPROVADO_FINAL;
			}
		}
		
		return null;
	}
	
	public Situacao calculaSituacaoFinal() {
		if(this.getNota1() != null && this.getNota2() != null && this.getNota3() != null && this.notaFinal != null) {
			if(((getMedia() * 6.0) + (this.notaFinal.doubleValue() * 4.0)) / 10.0 >= 5.0) {
				return Situacao.APROVADO;
			} else {
				return Situacao.REPROVADO_FINAL;
			}
		}
		
		return null;
	}

	public Boolean toFinal() {
		return getMedia() >= 4.0 && getMedia() < 7.0 && getFaltas() <= 25;
	}

	public Double getMedia() {
		Double n1 = 0.0;
		Double n2 = 0.0;
		Double n3 = 0.0;
		if (this.nota1 != null) n1 = nota1.doubleValue();
		if (this.nota2 != null) n2 = nota2.doubleValue();
		if (this.nota3 != null) n3 = nota3.doubleValue();

		return (n1 + n2 + n3)/3.0;
	}
	
	@Override
	public String toString() {
		return "Aluno{" +
				"id=" + id +
				", nome='" + nome + '\'' +
				", dataNascimento=" + dataNascimento +
				", faltas=" + faltas +
				", nota1=" + nota1 +
				", nota2=" + nota2 +
				", nota3=" + nota3 +
				", notaFinal=" + notaFinal +
				", situacao=" + situacao +
				'}';
	}
}
