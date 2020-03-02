package modelo;

import java.time.LocalDate;
import java.time.Period;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;

public class Trigger {

	@PostLoad @PostPersist @PostUpdate
	public void calcularTempoEmprestimo(Object obj) {
		if(obj instanceof Emprestimo) {
			LocalDate hoje = LocalDate.now();
			Emprestimo e =  (Emprestimo) obj;
			Period x = Period.between(e.getDataemp().toLocalDate(), hoje);
			e.setDiasEmprestimo(x.getDays());
		
		}
		}
}
