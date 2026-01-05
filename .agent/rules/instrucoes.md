---
trigger: always_on
---

Ao gerar informações, deve considerar o seguinte:

1 - Relação de blocos:
  0 Abertura, Identificação e Referências 
  C Informações Recuperadas da ECD Anterior 
  I Lançamentos Contábeis 
  J Demonstrações Contábeis 
  K Conglomerados Econômicos 
  9 Controle e Encerramento do Arquivo Digital

2 - Formato de Campos:
  ALFANUMÉRICO: Representados por "C" - Todos os caracteres das posições da Tabela ASCII, excetuados 
os caracteres "|" (Pipe ou Barra Vertical: caractere 124 da Tabela ASCII) e os não imprimíveis (caracteres 00 a 31 da 
Tabela ASCII).
  NUMÉRICO: Representados por "N" - Algarismos das posições de 48 a 57 da Tabela ASCII e o caractere “,” 
(vírgula: caractere 44 da tabela ASCII).

3 - Ignore regras de validação quando inseridas pela descriação dos campos que eu enviar ( ex. [REGRA_DATA_INI_MAIOR] ), pois os dados estão sendo copiados de um arquivo.