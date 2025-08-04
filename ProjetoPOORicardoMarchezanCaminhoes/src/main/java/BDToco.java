//RICARDO SAMPAIO MARCHEZAN

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.*;
import java.util.Iterator;

public class BDToco {
    //MÉTODO SINGLETON
    private static BDToco instance;
    private List<Toco> lista;

    private BDToco() {
        lista = new ArrayList<>();
    }

    public static BDToco getInstance() {
        if (instance == null) {
            instance = new BDToco();
        }
        return instance;
    }

    public void inserir(Toco t) {
        lista.add(t);
    }

    public Toco consultar(String placa) {
        for (Toco t : lista) {
            if (t.getPlaca().equalsIgnoreCase(placa)) {
                return t;
            }
        }
        return null;
    }

    public boolean atualizar(Toco t) {
        Toco old = consultar(t.getPlaca());
        if (old != null) {
            old.setMarca(t.getMarca());
            try {
                old.setAno(t.getAno());
            } catch (InvalidAnoException e) {
                // não deve ocorrer aqui se já validamos antes
            }
            old.setTipoCarroceria(t.getTipoCarroceria());
            try {
                old.setAutonomiaKm(t.getAutonomiaKm());
            } catch (InvalidCapacidadeException e) {
                // não deve ocorrer aqui se já validamos antes
            }
            return true;
        }
        return false;
    }

    public boolean excluir(String placa) {
        Iterator<Toco> it = lista.iterator();
        while (it.hasNext()) {
            if (it.next().getPlaca().equalsIgnoreCase(placa)) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    public List<Toco> listarTodos() {
        return new ArrayList<>(lista);
    }
}

