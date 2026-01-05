package io.github.brenoschaefel.sped.ecd.model.bloco0;

import io.github.brenoschaefel.sped.ecd.model.RegistroBase;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.List;

/**
 * Registro 0000: Abertura do Arquivo Digital e Identificação do Empresário 
 * ou da Sociedade Empresária
 */
@Data
@Builder
@EqualsAndHashCode(callSuper = false)
public class Registro0000 extends RegistroBase {
    
    // Campo 02: Texto fixo "LECD"
    @Builder.Default
    private String lecd = "LECD";
    
    // Campo 03: Data inicial das informações
    private LocalDate dtIni;
    
    // Campo 04: Data final das informações
    private LocalDate dtFin;
    
    // Campo 05: Nome empresarial
    private String nome;
    
    // Campo 06: CNPJ (14 dígitos)
    private String cnpj;
    
    // Campo 07: UF (2 caracteres)
    private String uf;
    
    // Campo 08: Inscrição Estadual (opcional)
    private String ie;
    
    // Campo 09: Código do município (7 dígitos, opcional)
    private String codMun;
    
    // Campo 10: Inscrição Municipal (opcional)
    private String im;
    
    // Campo 11: Indicador de situação especial (1 dígito, opcional)
    private String indSitEsp;
    
    // Campo 12: Indicador de situação no início do período (1 dígito)
    private String indSitIniPer;
    
    // Campo 13: Indicador de NIRE (0 ou 1)
    private String indNire;
    
    // Campo 14: Indicador de finalidade (0=Original, 1=Substituta)
    private String indFinEsc;
    
    // Campo 15: Hash da escrituração substituída (40 caracteres, opcional)
    private String codHashSub;
    
    // Campo 16: Indicador de grande porte (0 ou 1)
    private String indGrandePorte;
    
    // Campo 17: Tipo de ECD (0, 1 ou 2)
    private String tipEcd;
    
    // Campo 18: CNPJ da SCP (14 dígitos, opcional)
    private String codScp;
    
    // Campo 19: Identificação de moeda funcional (S ou N)
    private String identMf;
    
    // Campo 20: Escriturações consolidadas (S ou N)
    private String indEscCons;
    
    // Campo 21: Escrituração centralizada/descentralizada (0 ou 1)
    private String indCentralizada;
    
    // Campo 22: Mudança de plano de contas (0 ou 1)
    private String indMudancPc;
    
    // Campo 23: Código do plano referencial (opcional, 1-10)
    private String codPlanRef;
    
    @Override
    public String getCodigo() {
        return "0000";
    }
    
    @Override
    protected void adicionarCampos(List<String> campos) {
        campos.add(valorOuVazio(lecd));
        campos.add(formatarData(dtIni));
        campos.add(formatarData(dtFin));
        campos.add(valorOuVazio(nome));
        campos.add(valorOuVazio(cnpj));
        campos.add(valorOuVazio(uf));
        campos.add(valorOuVazio(ie));
        campos.add(valorOuVazio(codMun));
        campos.add(valorOuVazio(im));
        campos.add(valorOuVazio(indSitEsp));
        campos.add(valorOuVazio(indSitIniPer));
        campos.add(valorOuVazio(indNire));
        campos.add(valorOuVazio(indFinEsc));
        campos.add(valorOuVazio(codHashSub));
        campos.add(valorOuVazio(indGrandePorte));
        campos.add(valorOuVazio(tipEcd));
        campos.add(valorOuVazio(codScp));
        campos.add(valorOuVazio(identMf));
        campos.add(valorOuVazio(indEscCons));
        campos.add(valorOuVazio(indCentralizada));
        campos.add(valorOuVazio(indMudancPc));
        campos.add(valorOuVazio(codPlanRef));
    }
    
    @Override
    public void validar() {
        // Campos obrigatórios
        if (dtIni == null) {
            throw new IllegalStateException("Data inicial (DT_INI) é obrigatória");
        }
        if (dtFin == null) {
            throw new IllegalStateException("Data final (DT_FIN) é obrigatória");
        }
        if (dtFin.isBefore(dtIni)) {
            throw new IllegalStateException("Data final deve ser posterior à data inicial");
        }
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalStateException("Nome empresarial (NOME) é obrigatório");
        }
        if (cnpj == null || cnpj.trim().isEmpty()) {
            throw new IllegalStateException("CNPJ é obrigatório");
        }
        if (cnpj.length() != 14) {
            throw new IllegalStateException("CNPJ deve ter 14 dígitos");
        }
        if (uf == null || uf.trim().isEmpty()) {
            throw new IllegalStateException("UF é obrigatória");
        }
        if (uf.length() != 2) {
            throw new IllegalStateException("UF deve ter 2 caracteres");
        }
        if (indSitIniPer == null || indSitIniPer.trim().isEmpty()) {
            throw new IllegalStateException("Indicador de situação inicial (IND_SIT_INI_PER) é obrigatório");
        }
        if (indNire == null || indNire.trim().isEmpty()) {
            throw new IllegalStateException("Indicador de NIRE (IND_NIRE) é obrigatório");
        }
        if (!indNire.equals("0") && !indNire.equals("1")) {
            throw new IllegalStateException("IND_NIRE deve ser 0 ou 1");
        }
        if (indFinEsc == null || indFinEsc.trim().isEmpty()) {
            throw new IllegalStateException("Indicador de finalidade (IND_FIN_ESC) é obrigatório");
        }
        if (!indFinEsc.equals("0") && !indFinEsc.equals("1")) {
            throw new IllegalStateException("IND_FIN_ESC deve ser 0 ou 1");
        }
        if (indGrandePorte == null || indGrandePorte.trim().isEmpty()) {
            throw new IllegalStateException("Indicador de grande porte (IND_GRANDE_PORTE) é obrigatório");
        }
        if (!indGrandePorte.equals("0") && !indGrandePorte.equals("1")) {
            throw new IllegalStateException("IND_GRANDE_PORTE deve ser 0 ou 1");
        }
        if (tipEcd == null || tipEcd.trim().isEmpty()) {
            throw new IllegalStateException("Tipo de ECD (TIP_ECD) é obrigatório");
        }
        if (!tipEcd.equals("0") && !tipEcd.equals("1") && !tipEcd.equals("2")) {
            throw new IllegalStateException("TIP_ECD deve ser 0, 1 ou 2");
        }
        if (identMf == null || identMf.trim().isEmpty()) {
            throw new IllegalStateException("Identificação de moeda funcional (IDENT_MF) é obrigatória");
        }
        if (!identMf.equals("S") && !identMf.equals("N")) {
            throw new IllegalStateException("IDENT_MF deve ser S ou N");
        }
        if (indEscCons == null || indEscCons.trim().isEmpty()) {
            throw new IllegalStateException("Indicador de escrituração consolidada (IND_ESC_CONS) é obrigatório");
        }
        if (!indEscCons.equals("S") && !indEscCons.equals("N")) {
            throw new IllegalStateException("IND_ESC_CONS deve ser S ou N");
        }
        if (indCentralizada == null || indCentralizada.trim().isEmpty()) {
            throw new IllegalStateException("Indicador de centralização (IND_CENTRALIZADA) é obrigatório");
        }
        if (!indCentralizada.equals("0") && !indCentralizada.equals("1")) {
            throw new IllegalStateException("IND_CENTRALIZADA deve ser 0 ou 1");
        }
        if (indMudancPc == null || indMudancPc.trim().isEmpty()) {
            throw new IllegalStateException("Indicador de mudança de plano de contas (IND_MUDANC_PC) é obrigatório");
        }
        if (!indMudancPc.equals("0") && !indMudancPc.equals("1")) {
            throw new IllegalStateException("IND_MUDANC_PC deve ser 0 ou 1");
        }
        
        // Validações condicionais
        if ("1".equals(indFinEsc) && (codHashSub == null || codHashSub.trim().isEmpty())) {
            throw new IllegalStateException("Hash da escrituração substituída é obrigatório quando IND_FIN_ESC = 1");
        }
        if (codHashSub != null && !codHashSub.trim().isEmpty() && codHashSub.length() != 40) {
            throw new IllegalStateException("Hash deve ter 40 caracteres");
        }
        if (codScp != null && !codScp.trim().isEmpty() && codScp.length() != 14) {
            throw new IllegalStateException("CNPJ da SCP deve ter 14 dígitos");
        }
    }
}
