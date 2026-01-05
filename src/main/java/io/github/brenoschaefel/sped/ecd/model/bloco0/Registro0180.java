package io.github.brenoschaefel.sped.ecd.model.bloco0;

import io.github.brenoschaefel.sped.ecd.model.RegistroBase;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * Registro 0180: Identificação do Relacionamento com o Participante
 */
@Data
@Builder
@EqualsAndHashCode(callSuper = false)
public class Registro0180 extends RegistroBase {
    
    // Campos serão adicionados conforme especificação
    
    @Override
    public String getCodigo() {
        return "0180";
    }
    
    @Override
    protected void adicionarCampos(List<String> campos) {
        // Implementação será adicionada após definição dos campos
    }
    
    @Override
    public void validar() {
        // Validações serão adicionadas após definição dos campos
    }
}
