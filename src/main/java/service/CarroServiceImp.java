/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import data.CarroDAO;
import java.util.List;
import javax.inject.Inject;
import models.Carro;

/**
 *
 * @author USUARIO
 */
public class CarroServiceImp implements CarroService{

    @Inject
    private CarroDAO cDAO;
    @Override
    public List<Carro> findAllCarro() {
         return cDAO.findAllCarro();
        }

    @Override
    public void addCarro(Carro carro) {
        cDAO.addCarro(carro);
    }
    
    
}
