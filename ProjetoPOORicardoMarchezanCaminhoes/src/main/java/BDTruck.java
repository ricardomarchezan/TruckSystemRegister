//RICARDO SAMPAIO MARCHEZAN

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.*;
import java.util.Iterator;

public class BDTruck {
    //MÉTODO SINGLETON
    private static BDTruck instance;
    private List<Truck> lista;

    private BDTruck() {
        lista = new ArrayList<>();
    }

    public static BDTruck getInstance() {
        if (instance == null) {
            instance = new BDTruck();
        }
        return instance;
    }

    public void inserir(Truck t) {
        lista.add(t);
    }

    public Truck consultar(String placa) {
        for (Truck t : lista) {
            if (t.getPlaca().equalsIgnoreCase(placa)) {
                return t;
            }
        }
        return null;
    }

    public boolean atualizar(Truck t) {
        Truck old = consultar(t.getPlaca());
        if (old != null) {
            old.setMarca(t.getMarca());
            try {
                old.setAno(t.getAno());
            } catch (InvalidAnoException e) {
                // não deve ocorrer aqui se já validamos antes
            }
            try {
                old.setQtdEixosTraseiros(t.getQtdEixosTraseiros());
            } catch (InvalidCapacidadeException e) {
                // não deve ocorrer aqui se já validamos antes
            }
            old.setTipoSuspensao(t.getTipoSuspensao());
            return true;
        }
        return false;
    }

    public boolean excluir(String placa) {
        Iterator<Truck> it = lista.iterator();
        while (it.hasNext()) {
            if (it.next().getPlaca().equalsIgnoreCase(placa)) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    public List<Truck> listarTodos() {
        return new ArrayList<>(lista);
    }
}

