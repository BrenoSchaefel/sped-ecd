package io.github.brenoschaefel.sped.ecd.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe base abstrata que fornece métodos auxiliares para construção
 * dos registros no formato SPED.
 */
public abstract class RegistroBase implements Registro {
    
    protected static final String SEPARADOR = "|";
    protected static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("ddMMyyyy");
    
    @Override
    public String gerarLinha() {
        List<String> campos = new ArrayList<>();
        campos.add(getCodigo());
        adicionarCampos(campos);
        
        // Adiciona pipe inicial e final
        return SEPARADOR + String.join(SEPARADOR, campos) + SEPARADOR;
    }
    
    /**
     * Método abstrato onde cada registro específico adiciona seus campos
     */
    protected abstract void adicionarCampos(List<String> campos);
    
    /**
     * Formata um campo de data para o padrão do SPED (ddMMyyyy)
     */
    protected String formatarData(LocalDate data) {
        return data != null ? data.format(DATE_FORMATTER) : "";
    }
    
    /**
     * Formata um campo numérico decimal
     */
    protected String formatarDecimal(Double valor, int casasDecimais) {
        if (valor == null) return "";
        String formato = "%." + casasDecimais + "f";
        return String.format(formato, valor).replace(".", ",");
    }
    
    /**
     * Retorna o valor ou string vazia se for null
     */
    protected String valorOuVazio(Object valor) {
        return valor != null ? valor.toString() : "";
    }
}
