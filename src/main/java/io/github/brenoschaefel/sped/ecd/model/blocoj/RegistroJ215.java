package io.github.brenoschaefel.sped.ecd.model.blocoj;

import io.github.brenoschaefel.sped.ecd.model.RegistroBase;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * Registro J215: Fato Contábil que Altera a Conta Lucros/Prejuízos ou Patrimônio Líquido
 */
@Data
@Builder
@EqualsAndHashCode(callSuper = false)
public class RegistroJ215 extends RegistroBase {
    
    // Campos serão adicionados conforme especificação
    
    @Override
    public String getCodigo() {
        return "J215";
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
