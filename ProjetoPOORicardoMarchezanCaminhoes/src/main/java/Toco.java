//RICARDO SAMPAIO MARCHEZAN

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * TOCO é um caminhão de tamanho médio.
 */
public class Toco extends Caminhao {
    private String tipoCarroceria;
    private int autonomiaKm;

    public Toco() {
        super();
        this.tipoCarroceria = "";
        this.autonomiaKm    = 0;
    }

    public Toco(String placa, String marca, String ano,
                String tipoCarroceria, int autonomiaKm)
                throws InvalidAnoException, InvalidCapacidadeException {
        super(placa, marca, ano);
        this.tipoCarroceria = tipoCarroceria;
        setAutonomiaKm(autonomiaKm);
    }

    public String getTipoCarroceria() {
        return tipoCarroceria;
    }
    public void setTipoCarroceria(String tipoCarroceria) {
        this.tipoCarroceria = tipoCarroceria;
    }

    public int getAutonomiaKm() {
        return autonomiaKm;
    }
    public void setAutonomiaKm(int autonomiaKm)
            throws InvalidCapacidadeException {
        // regra de negócio: autonomia entre 1 e 2000 km
        if (autonomiaKm <= 0 || autonomiaKm > 2000) {
            throw new InvalidCapacidadeException(
                "Autonomia deve ser 1–2000 km.");
        }
        this.autonomiaKm = autonomiaKm;
    }

    @Override
    public String toString() {
        return "Toco[" + super.toString()
             + ", tipoCarroceria=" + tipoCarroceria
             + ", autonomiaKm="     + autonomiaKm + "]";
    }
}

