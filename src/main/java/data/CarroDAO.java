/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.util.List;
import models.Carro;

/**
 *
 * @author USUARIO
 */
public interface CarroDAO {
    
    public List<Carro> findAllCarro();
    
    public void  addCarro(Carro carro);
    
}
