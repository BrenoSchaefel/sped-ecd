package io.github.brenoschaefel.sped.ecd.model;

import io.github.brenoschaefel.sped.ecd.model.bloco0.Registro0000;
import io.github.brenoschaefel.sped.ecd.model.bloco0.Registro0001;
import io.github.brenoschaefel.sped.ecd.model.bloco0.Registro0007;
import io.github.brenoschaefel.sped.ecd.model.bloco0.Registro0020;
import io.github.brenoschaefel.sped.ecd.model.bloco0.Registro0035;
import io.github.brenoschaefel.sped.ecd.model.bloco0.Registro0150;
import io.github.brenoschaefel.sped.ecd.model.bloco0.Registro0180;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Bloco0 {
    
    private Registro0000 registro0000;
    private Registro0001 registro0001;
    private List<Registro0007> registros0007 = new ArrayList<>();
    private List<Registro0020> registros0020 = new ArrayList<>();
    private List<Registro0035> registros0035 = new ArrayList<>();
    private List<Registro0150> registros0150 = new ArrayList<>();
    private List<Registro0180> registros0180 = new ArrayList<>();
    
    // Método para calcular a quantidade de registros no bloco
    public long getQuantidadeRegistros() {
        long count = 0;
        if (registro0000 != null) count++;
        if (registro0001 != null) count++;
        count += registros0007.size();
        count += registros0020.size();
        count += registros0035.size();
        count += registros0150.size();
        count += registros0180.size();
        
        // Inclui o próprio registro 0990 na contagem
        count++;
        
        return count;
    }
}
