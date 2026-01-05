package io.github.brenoschaefel.sped.ecd.model.bloco0;

import io.github.brenoschaefel.sped.ecd.model.RegistroBase;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * Registro 0007: Outras Inscrições Cadastrais da Pessoa Jurídica
 */
@Data
@Builder
@EqualsAndHashCode(callSuper = false)
public class Registro0007 extends RegistroBase {
    
    // Campo 02: Código da instituição responsável pela administração do cadastro
    private String codEntRef;
    
    // Campo 03: Código cadastral da pessoa jurídica na instituição
    private String codInscr;
    
    @Override
    public String getCodigo() {
        return "0007";
    }
    
    @Override
    protected void adicionarCampos(List<String> campos) {
        campos.add(valorOuVazio(codEntRef));
        campos.add(valorOuVazio(codInscr));
    }
    
    @Override
    public void validar() {
        if (codEntRef == null || codEntRef.trim().isEmpty()) {
            throw new IllegalStateException("Código da instituição (COD_ENT_REF) é obrigatório");
        }
    }
}
