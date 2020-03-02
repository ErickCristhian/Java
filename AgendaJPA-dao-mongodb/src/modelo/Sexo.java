package modelo;

import javax.persistence.Embeddable;

import org.eclipse.persistence.nosql.annotations.DataFormatType;
import org.eclipse.persistence.nosql.annotations.NoSql;

public enum Sexo {
	MASCULINO, FEMININO, OUTRO;
}
