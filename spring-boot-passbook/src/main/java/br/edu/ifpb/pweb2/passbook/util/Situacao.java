package br.edu.ifpb.pweb2.passbook.util;

public enum Situacao {
    APROVADO("AP", "aprovado"),
    REPROVADO_FINAL("RP", "reprovado por final"),
    FINAL("FN", "Na final"),
    MATRICULADO("MT", "Matriculado"),
    REPROVADO_FALTA("RF", "Reprovado por falta");

    public String sigla;
    public String descricao;

    Situacao(String sigla, String descricao) {
        this.sigla = sigla;
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getSigla() {
        return sigla;
    }
}
