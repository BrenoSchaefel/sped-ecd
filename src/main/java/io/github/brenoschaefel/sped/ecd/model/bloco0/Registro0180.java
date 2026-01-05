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
    
    // Campo 02: Código do relacionamento (Tabela SPED)
    private String codRel;
    
    // Campo 03: Data do início do relacionamento
    private java.time.LocalDate dtIniRel;
    
    // Campo 04: Data do término do relacionamento
    private java.time.LocalDate dtFinRel;
    
    @Override
    public String getCodigo() {
        return "0180";
    }
    
    @Override
    protected void adicionarCampos(List<String> campos) {
        campos.add(valorOuVazio(codRel));
        campos.add(formatarData(dtIniRel));
        campos.add(formatarData(dtFinRel));
    }
    
    @Override
    public void validar() {
        if (codRel == null || codRel.trim().isEmpty()) {
            throw new IllegalStateException("Código do relacionamento (COD_REL) é obrigatório");
        }
        if (dtIniRel == null) {
            throw new IllegalStateException("Data de início do relacionamento (DT_INI_REL) é obrigatória");
        }
        if (dtFinRel != null && dtIniRel.isAfter(dtFinRel)) {
            throw new IllegalStateException("Data inicial não pode ser superior à data final");
        }
    }
}
