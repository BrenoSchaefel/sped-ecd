package io.github.brenoschaefel.sped.ecd.model.blocok;

import io.github.brenoschaefel.sped.ecd.model.RegistroBase;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * Registro K001: Abertura do Bloco K
 */
@Data
@Builder
@EqualsAndHashCode(callSuper = false)
public class RegistroK001 extends RegistroBase {
    
    // Campos serão adicionados conforme especificação
    
    @Override
    public String getCodigo() {
        return "K001";
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
