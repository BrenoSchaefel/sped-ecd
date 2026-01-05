package io.github.brenoschaefel.sped.ecd.model.blocok;

import io.github.brenoschaefel.sped.ecd.model.RegistroBase;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * Registro K315: Empresas Contrapartes das Parcelas do Valor Eliminado Total
 */
@Data
@Builder
@EqualsAndHashCode(callSuper = false)
public class RegistroK315 extends RegistroBase {
    
    // Campos serão adicionados conforme especificação
    
    @Override
    public String getCodigo() {
        return "K315";
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
