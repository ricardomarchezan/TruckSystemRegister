//RICARDO SAMPAIO MARCHEZAN

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * Superclasse que representa um caminhão genérico.
 */
public class Caminhao implements Veiculo {
    private String placa;
    private String marca;
    private String ano;

    // Construtor padrão: inicializa todos os atributos
    public Caminhao() {
        this.placa = "";
        this.marca = "";
        this.ano   = "0000";
    }

    // Construtor sobrecarregado: mostra polimorfismo por sobrecarga
    public Caminhao(String placa, String marca, String ano) throws InvalidAnoException {
        this();                            // chama o construtor padrão
        this.placa = placa;
        this.marca = marca;
        setAno(ano);                       // valida ano
        // aqui poderíamos tratar outras regras de negócio
    }

    @Override
    public String getPlaca() {
        return placa;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    @Override
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String getAno() {
        return ano;
    }
    public void setAno(String ano) throws InvalidAnoException {
        // regra de negócio: ano entre 1900 e ano atual
        if (ano == null || !ano.matches("\\d{4}")) {
            throw new InvalidAnoException("Ano deve ter 4 dígitos numéricos.");
        }
        int a = Integer.parseInt(ano);
        int atual = java.time.Year.now().getValue();
        if (a < 1900 || a > atual) {
            throw new InvalidAnoException("Ano fora de faixa (1900–" + atual + ").");
        }
        this.ano = ano;
    }

    @Override
    public String toString() {
        // toString só monta a string, sem imprimir
        return String.format("placa=%s, marca=%s, ano=%s",
                              placa, marca, ano);
    }
}

