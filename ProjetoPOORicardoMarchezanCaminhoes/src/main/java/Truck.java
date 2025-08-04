//RICARDO SAMPAIO MARCHEZAN

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * TRUCK é um caminhão de grande porte.
 */
public class Truck extends Caminhao {
    private int qtdEixosTraseiros;
    private String tipoSuspensao;

    public Truck() {
        super();
        this.qtdEixosTraseiros = 2;
        this.tipoSuspensao      = "";
    }

    public Truck(String placa, String marca, String ano,
                 int qtdEixosTraseiros, String tipoSuspensao)
                 throws InvalidAnoException, InvalidCapacidadeException {
        super(placa, marca, ano);
        setQtdEixosTraseiros(qtdEixosTraseiros);
        this.tipoSuspensao = tipoSuspensao;
    }

    public int getQtdEixosTraseiros() {
        return qtdEixosTraseiros;
    }
    public void setQtdEixosTraseiros(int qtdEixosTraseiros)
            throws InvalidCapacidadeException {
        // regra de negócio: eixos entre 2 e 10
        if (qtdEixosTraseiros < 2 || qtdEixosTraseiros > 10) {
            throw new InvalidCapacidadeException(
                "Eixos traseiros devem ser 2–10.");
        }
        this.qtdEixosTraseiros = qtdEixosTraseiros;
    }

    public String getTipoSuspensao() {
        return tipoSuspensao;
    }
    public void setTipoSuspensao(String tipoSuspensao) {
        this.tipoSuspensao = tipoSuspensao;
    }

    @Override
    public String toString() {
        return "Truck[" + super.toString()
             + ", qtdEixosTraseiros=" + qtdEixosTraseiros
             + ", tipoSuspensao="     + tipoSuspensao + "]";
    }
}

