package modelo;

import javax.persistence.Entity;

import org.eclipse.persistence.nosql.annotations.DataFormatType;
import org.eclipse.persistence.nosql.annotations.NoSql;

@Entity
@NoSql(dataFormat=DataFormatType.MAPPED)
public class Professor extends Pessoa {
	private double salario;

	public Professor() {}
	
	public Professor(String nome, Sexo sex, double sal){ 
		super(nome,sex);
		this.salario = sal;
	}

	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	@Override
	public String toString() {
		return super.toString() + "  salario=  "+ salario;
	}

	

	

	
}
