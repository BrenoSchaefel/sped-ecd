package io.github.brenoschaefel.sped.ecd.model.blocoj;

import io.github.brenoschaefel.sped.ecd.model.RegistroBase;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * Registro J005: Demonstrações Contábeis
 */
@Data
@Builder
@EqualsAndHashCode(callSuper = false)
public class RegistroJ005 extends RegistroBase {
    
    // Campos serão adicionados conforme especificação
    
    @Override
    public String getCodigo() {
        return "J005";
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
