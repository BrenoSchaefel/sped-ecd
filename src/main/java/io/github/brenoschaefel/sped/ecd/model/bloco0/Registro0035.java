package io.github.brenoschaefel.sped.ecd.model.bloco0;

import io.github.brenoschaefel.sped.ecd.model.RegistroBase;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * Registro 0035: Identificação das SCP
 */
@Data
@Builder
@EqualsAndHashCode(callSuper = false)
public class Registro0035 extends RegistroBase {
    
    // Campo 02: CNPJ da SCP
    private String codScp;
    
    // Campo 03: Nome da SCP
    private String nomeScp;
    
    @Override
    public String getCodigo() {
        return "0035";
    }
    
    @Override
    protected void adicionarCampos(List<String> campos) {
        campos.add(valorOuVazio(codScp));
        campos.add(valorOuVazio(nomeScp));
    }
    
    @Override
    public void validar() {
        if (codScp == null || codScp.trim().isEmpty()) {
            throw new IllegalStateException("CNPJ da SCP (COD_SCP) é obrigatório");
        }
        if (codScp.length() != 14) {
            throw new IllegalStateException("CNPJ da SCP deve ter 14 dígitos");
        }
    }
}
