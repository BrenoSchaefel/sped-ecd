package io.github.brenoschaefel.sped.ecd.model.bloco0;

import io.github.brenoschaefel.sped.ecd.model.RegistroBase;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * Registro 0150: Tabela de Cadastro do Participante
 */
@Data
@Builder
@EqualsAndHashCode(callSuper = false)
public class Registro0150 extends RegistroBase {
    
    // Campo 02: Código de identificação do participante
    private String codPart;
    
    // Campo 03: Nome pessoal ou empresarial
    private String nome;
    
    // Campo 04: Código do país (BACEN)
    private String codPais;
    
    // Campo 05: CNPJ do participante
    private String cnpj;
    
    // Campo 06: CPF do participante
    private String cpf;
    
    // Campo 07: NIT/PIS/PASEP/SUS
    private String nit;
    
    // Campo 08: UF do participante
    private String uf;
    
    // Campo 09: Inscrição Estadual
    private String ie;
    
    // Campo 10: Inscrição Estadual (Substituto Tributário)
    private String ieSt;
    
    // Campo 11: Código do município
    private String codMun;
    
    // Campo 12: Inscrição Municipal
    private String im;
    
    // Campo 13: Inscrição SUFRAMA
    private String suframa;
    
    @Override
    public String getCodigo() {
        return "0150";
    }
    
    @Override
    protected void adicionarCampos(List<String> campos) {
        campos.add(valorOuVazio(codPart));
        campos.add(valorOuVazio(nome));
        campos.add(valorOuVazio(codPais));
        campos.add(valorOuVazio(cnpj));
        campos.add(valorOuVazio(cpf));
        campos.add(valorOuVazio(nit));
        campos.add(valorOuVazio(uf));
        campos.add(valorOuVazio(ie));
        campos.add(valorOuVazio(ieSt));
        campos.add(valorOuVazio(codMun));
        campos.add(valorOuVazio(im));
        campos.add(valorOuVazio(suframa));
    }
    
    @Override
    public void validar() {
        if (codPart == null || codPart.trim().isEmpty()) {
            throw new IllegalStateException("Código do participante (COD_PART) é obrigatório");
        }
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalStateException("Nome do participante (NOME) é obrigatório");
        }
        if (codPais == null || codPais.trim().isEmpty()) {
            throw new IllegalStateException("Código do país (COD_PAIS) é obrigatório");
        }
        
        // Validações de tamanho
        if (cnpj != null && !cnpj.trim().isEmpty() && cnpj.length() != 14) {
             throw new IllegalStateException("CNPJ deve ter 14 dígitos");
        }
        if (cpf != null && !cpf.trim().isEmpty() && cpf.length() != 11) {
             throw new IllegalStateException("CPF deve ter 11 dígitos");
        }
        if (uf != null && !uf.trim().isEmpty() && uf.length() != 2) {
             throw new IllegalStateException("UF deve ter 2 caracteres");
        }
    }
}
