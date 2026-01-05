package io.github.brenoschaefel.sped.ecd;

import io.github.brenoschaefel.sped.ecd.model.Bloco0;
import io.github.brenoschaefel.sped.ecd.model.bloco0.Registro0000;
import io.github.brenoschaefel.sped.ecd.model.bloco0.Registro0001;
import io.github.brenoschaefel.sped.ecd.model.bloco0.Registro0990;
import lombok.Data;

@Data
public class SpedEcdArquivo {
    
    private Bloco0 bloco0;
    
    public SpedEcdArquivo() {
        this.bloco0 = new Bloco0();
    }
    
    public String gerarArquivo() {
        StringBuilder sb = new StringBuilder();
        
        // --- Geração do Bloco 0 ---
        if (bloco0.getRegistro0000() != null) {
            sb.append(bloco0.getRegistro0000().gerarLinha()).append(System.lineSeparator());
        }
        
        if (bloco0.getRegistro0001() != null) {
            sb.append(bloco0.getRegistro0001().gerarLinha()).append(System.lineSeparator());
        }
        
        bloco0.getRegistros0007().forEach(reg -> sb.append(reg.gerarLinha()).append(System.lineSeparator()));
        bloco0.getRegistros0020().forEach(reg -> sb.append(reg.gerarLinha()).append(System.lineSeparator()));
        bloco0.getRegistros0035().forEach(reg -> sb.append(reg.gerarLinha()).append(System.lineSeparator()));
        bloco0.getRegistros0150().forEach(reg -> sb.append(reg.gerarLinha()).append(System.lineSeparator()));
        bloco0.getRegistros0180().forEach(reg -> sb.append(reg.gerarLinha()).append(System.lineSeparator()));
        
        // Gerar Registro de Encerramento (0990)
        Registro0990 reg0990 = Registro0990.builder()
                .qtdLin0(bloco0.getQuantidadeRegistros())
                .build();
        sb.append(reg0990.gerarLinha()).append(System.lineSeparator());
        
        // ... Lógica para os demais blocos virá aqui
        
        return sb.toString();
    }
}
