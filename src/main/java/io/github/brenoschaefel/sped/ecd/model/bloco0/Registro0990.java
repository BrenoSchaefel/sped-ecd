package io.github.brenoschaefel.sped.ecd.model.bloco0;

import io.github.brenoschaefel.sped.ecd.model.RegistroBase;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * Registro 0990: Encerramento do Bloco 0
 */
@Data
@Builder
@EqualsAndHashCode(callSuper = false)
public class Registro0990 extends RegistroBase {
    
    // Campo 02: Quantidade total de linhas do Bloco 0
    private Long qtdLin0;
    
    @Override
    public String getCodigo() {
        return "0990";
    }
    
    @Override
    protected void adicionarCampos(List<String> campos) {
        campos.add(String.valueOf(qtdLin0));
    }
    
    @Override
    public void validar() {
        if (qtdLin0 == null) {
            throw new IllegalStateException("Quantidade total de linhas (QTD_LIN_0) é obrigatória");
        }
    }
}
