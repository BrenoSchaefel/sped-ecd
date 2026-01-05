package io.github.brenoschaefel.sped.ecd.model.blocoi;

import io.github.brenoschaefel.sped.ecd.model.RegistroBase;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * Registro I155: Detalhe dos Saldos Periódicos
 */
@Data
@Builder
@EqualsAndHashCode(callSuper = false)
public class RegistroI155 extends RegistroBase {
    
    // Campos serão adicionados conforme especificação
    
    @Override
    public String getCodigo() {
        return "I155";
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
