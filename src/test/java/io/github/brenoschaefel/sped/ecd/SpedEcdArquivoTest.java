package io.github.brenoschaefel.sped.ecd;

import io.github.brenoschaefel.sped.ecd.model.bloco0.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SpedEcdArquivoTest {

    @Test
    void deveGerarArquivoCompletoCorretamente() {
        SpedEcdArquivo arquivo = new SpedEcdArquivo();
        
        // 1. Preencher Bloco 0
        arquivo.getBloco0().setRegistro0000(criarRegistro0000());
        arquivo.getBloco0().setRegistro0001(Registro0001.builder().indDad("0").build());
        
        // Adicionando outros registros implementados
        arquivo.getBloco0().getRegistros0007().add(Registro0007.builder()
                .codEntRef("01") // Exemplo
                .codInscr("123456")
                .build());
                
        // Participante (0150)
        arquivo.getBloco0().getRegistros0150().add(Registro0150.builder()
                .codPart("PART001")
                .nome("PARTICIPANTE TESTE LTDA")
                .codPais("1058") // Brasil
                .cnpj("12345678000199")
                .uf("SP")
                .build());
        
        // Gerar o arquivo
        String conteudoArquivo = arquivo.gerarArquivo();
        
        System.out.println("----------- INÍCIO DO ARQUIVO GERADO -----------");
        System.out.println(conteudoArquivo);
        System.out.println("----------- FIM DO ARQUIVO GERADO -----------");
        
        assertNotNull(conteudoArquivo);
        assertTrue(conteudoArquivo.contains("|0000|"));
        assertTrue(conteudoArquivo.contains("|0001|"));
        assertTrue(conteudoArquivo.contains("|0150|"));
    }

    private Registro0000 criarRegistro0000() {
        return Registro0000.builder()
                .dtIni(LocalDate.of(2023, Month.JANUARY, 1))
                .dtFin(LocalDate.of(2023, Month.DECEMBER, 31))
                .nome("FUNDACAO ESTADUAL DE INOVACAO EM SAUDE - INOVA CAPIXABA")
                .cnpj("36901264000163")
                .uf("ES")
                .codMun("3205200")
                .indSitIniPer("0") 
                .indNire("0")
                .indFinEsc("0") 
                .indGrandePorte("0")
                .tipEcd("0") 
                .identMf("N")
                .indEscCons("N")
                .indCentralizada("0") 
                .indMudancPc("0")
                .codPlanRef("5")
                .build();
    }
}
