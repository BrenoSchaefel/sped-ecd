package io.github.brenoschaefel.sped.ecd.model.bloco0;

import io.github.brenoschaefel.sped.ecd.model.RegistroBase;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * Registro 0020: Escrituração Contábil Descentralizada
 */
@Data
@Builder
@EqualsAndHashCode(callSuper = false)
public class Registro0020 extends RegistroBase {
    
    // Campo 02: Indicador de descentralização (0=Matriz, 1=Filial)
    private String indDec;
    
    // Campo 03: CNPJ (14 dígitos)
    private String cnpj;
    
    // Campo 04: UF (2 caracteres)
    private String uf;
    
    // Campo 05: Inscrição estadual
    private String ie;
    
    // Campo 06: Código do município
    private String codMun;
    
    // Campo 07: Inscrição Municipal
    private String im;
    
    // Campo 08: NIRE (11 dígitos)
    private String nire;
    
    @Override
    public String getCodigo() {
        return "0020";
    }
    
    @Override
    protected void adicionarCampos(List<String> campos) {
        campos.add(valorOuVazio(indDec));
        campos.add(valorOuVazio(cnpj));
        campos.add(valorOuVazio(uf));
        campos.add(valorOuVazio(ie));
        campos.add(valorOuVazio(codMun));
        campos.add(valorOuVazio(im));
        campos.add(valorOuVazio(nire));
    }
    
    @Override
    public void validar() {
        if (indDec == null || indDec.trim().isEmpty()) {
            throw new IllegalStateException("Indicador de descentralização (IND_DEC) é obrigatório");
        }
        if (!indDec.equals("0") && !indDec.equals("1")) {
            throw new IllegalStateException("IND_DEC deve ser 0 ou 1");
        }
        if (cnpj == null || cnpj.trim().isEmpty()) {
            throw new IllegalStateException("CNPJ é obrigatório");
        }
        if (cnpj.length() != 14) {
            throw new IllegalStateException("CNPJ deve ter 14 dígitos");
        }
        if (uf == null || uf.trim().isEmpty()) {
            throw new IllegalStateException("UF é obrigatória");
        }
        if (uf.length() != 2) {
            throw new IllegalStateException("UF deve ter 2 caracteres");
        }
        if (nire != null && !nire.trim().isEmpty() && nire.length() != 11) {
            throw new IllegalStateException("NIRE deve ter 11 dígitos");
        }
    }
}
