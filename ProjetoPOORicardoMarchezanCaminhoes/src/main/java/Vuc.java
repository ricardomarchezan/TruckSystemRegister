//RICARDO SAMPAIO MARCHEZAN

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * VUC (Veículo Urbano de Carga) é um tipo de caminhão leve.
 */
public class Vuc extends Caminhao {
    private boolean circulaCentro;
    private boolean refrigerado;

    public Vuc() {
        super();
        this.circulaCentro = false;
        this.refrigerado   = false;
    }

    public Vuc(String placa, String marca, String ano,
               boolean circulaCentro, boolean refrigerado)
               throws InvalidAnoException {
        super(placa, marca, ano);
        // regra de negócio exemplo:
        if (circulaCentro && refrigerado) {
            // um VUC refrigerado não pode ter livre circulação
            this.circulaCentro = false;
        } else {
            this.circulaCentro = circulaCentro;
        }
        this.refrigerado = refrigerado;
    }

    public boolean isCirculaCentro() {
        return circulaCentro;
    }
    public void setCirculaCentro(boolean circulaCentro) {
        this.circulaCentro = circulaCentro;
    }

    public boolean isRefrigerado() {
        return refrigerado;
    }
    public void setRefrigerado(boolean refrigerado) {
        this.refrigerado = refrigerado;
    }

    @Override
    public String toString() {
        return "VUC[" + super.toString()
             + ", circulaCentro=" + circulaCentro
             + ", refrigerado="   + refrigerado + "]";
    }
}

