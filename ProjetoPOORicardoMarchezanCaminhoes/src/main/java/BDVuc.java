//RICARDO SAMPAIO MARCHEZAN

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.*;
//MÉTODO SINGLETON
public class BDVuc {
    private static BDVuc instance;
    private List<Vuc> lista;
    private BDVuc() {
        lista = new ArrayList<>();
    }
    public static BDVuc getInstance() {
        if (instance == null) {
            instance = new BDVuc();
        }
        return instance;
    }
    public void inserir(Vuc v) {
        lista.add(v);
    }
    public Vuc consultar(String placa) {
        for (Vuc v : lista) {
            if (v.getPlaca().equalsIgnoreCase(placa))
                return v;
        }
        return null;
    }
    public boolean atualizar(Vuc v) {
        Vuc old = consultar(v.getPlaca());
        if (old != null) {
            old.setMarca(v.getMarca());
            try { old.setAno(v.getAno()); } catch(Exception e){}
            old.setCirculaCentro(v.isCirculaCentro());
            old.setRefrigerado(v.isRefrigerado());
            return true;
        }
        return false;
    }
    public boolean excluir(String placa) {
        Iterator<Vuc> it = lista.iterator();
        while (it.hasNext()) {
            if (it.next().getPlaca().equalsIgnoreCase(placa)) {
                it.remove();
                return true;
            }
        }
        return false;
    }
    public List<Vuc> listarTodos() {
        return new ArrayList<>(lista);
    }
}

