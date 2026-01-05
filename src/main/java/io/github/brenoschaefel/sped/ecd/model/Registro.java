package io.github.brenoschaefel.sped.ecd.model;

/**
 * Interface base para todos os registros do SPED ECD.
 * Cada registro deve ser capaz de gerar sua representação em String
 * seguindo o layout do SPED.
 */
public interface Registro {
    
    /**
     * Retorna o código do registro (ex: "0000", "I200", "J100")
     */
    String getCodigo();
    
    /**
     * Gera a linha do registro no formato SPED (campos separados por pipe |)
     */
    String gerarLinha();
    
    /**
     * Valida se o registro possui todos os campos obrigatórios preenchidos
     * @throws IllegalStateException se houver campos inválidos
     */
    void validar();
}
