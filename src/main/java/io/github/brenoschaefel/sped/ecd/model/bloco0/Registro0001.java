package io.github.brenoschaefel.sped.ecd.model.bloco0;

import io.github.brenoschaefel.sped.ecd.model.RegistroBase;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * Registro 0001: Abertura do Bloco 0
 */
@Data
@Builder
@EqualsAndHashCode(callSuper = false)
public class Registro0001 extends RegistroBase {
    
    // Campo 02: Indicador de movimento
    // 0 - Bloco com dados informados
    // 1 - Bloco sem dados informados
    private String indDad;
    
    @Override
    public String getCodigo() {
        return "0001";
    }
    
    @Override
    protected void adicionarCampos(List<String> campos) {
        campos.add(valorOuVazio(indDad));
    }
    
    @Override
    public void validar() {
        if (indDad == null || indDad.trim().isEmpty()) {
            throw new IllegalStateException("Indicador de movimento (IND_DAD) é obrigatório");
        }
        if (!indDad.equals("0") && !indDad.equals("1")) {
            throw new IllegalStateException("IND_DAD deve ser 0 ou 1");
        }
    }
}
