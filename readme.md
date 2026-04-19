# Montador MIPS (MIPS Assembler)

## 📌 Descrição do Projeto
Este projeto consiste no desenvolvimento de um **Montador (Assembler)** para a arquitetura MIPS. O objetivo principal é ler arquivos contendo instruções em mnemônicos MIPS e gerar arquivos de saída correspondentes com seus códigos binários de 32 bits.

O software foi desenvolvido como parte do **Trabalho 1** da disciplina de **Arquitetura de Computadores** do curso de Sistemas de Informação no IFMG.

## 🚀 Funcionalidades
- **Processamento em Lote:** O programa processa sequencialmente 10 arquivos de teste (`TESTE-01.txt` a `TESTE-10.txt`).
- **Tradução Multi-formato:** Suporte para instruções dos tipos **R**, **I** e **J**.
- **Geração de Resultados:** Produz arquivos de saída nomeados como `TESTE-XX-RESULTADO.txt` no mesmo diretório de entrada.

## Exemplo:
| Instrução MIPS (Entrada) | Resultado (Saída) |
| :--- | :--- |
| `lw $t0, 1200($t1)` | `10001101001010000000010010110000` |
| `add $t0, $s2, $t0` | `00000010010010000100000000100000` |
| `sw $t0, 1200($t1)` | `10101101001010000000010010110000` |

## 🛠️ Instruções Suportadas
O montador é capaz de traduzir as seguintes instruções contidas no Anexo I do trabalho:
- **Aritméticas/Lógicas:** ADD, SUB, AND, OR, XOR, ADDI, ANDI, ORI, XORI, LUI.
- **Acesso à Memória:** LB, LH, LW, SB, SH, SW.
- **Deslocamento:** SLL, SRL.
- **Desvios e Saltos:** J, JR, BEQ, BNE, BLEZ, BGTZ.

## 💻 Tecnologias Utilizadas
- **Linguagem:** Java 21.
- **Paradigma:** Orientação a Objetos.

## 📖 Como Executar
1. Certifique-se de que os arquivos de entrada (`TESTE-01.txt`, etc.) estejam na raiz do diretório de execução ou no pendrive conforme especificado.
2. Compile o código fonte:
   ```bash
   javac ConversorMips.java
   ```
3. Execute o programa:
   ```bash
   java ConversorMips
   ```

## 👥 Integrantes
- [@JonathanGOSantos](https://github.com/JonathanGOSantos)
- [@enzotheodg](https://github.com/enzotheodg)
