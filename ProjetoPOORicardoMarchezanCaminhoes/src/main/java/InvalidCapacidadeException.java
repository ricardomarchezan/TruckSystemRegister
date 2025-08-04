//RICARDO SAMPAIO MARCHEZAN

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * Exceção para valores numéricos inválidos (<= 0 ou fora de faixa).
 */
public class InvalidCapacidadeException extends Exception {
    public InvalidCapacidadeException(String msg) {
        super(msg);
    }
}

