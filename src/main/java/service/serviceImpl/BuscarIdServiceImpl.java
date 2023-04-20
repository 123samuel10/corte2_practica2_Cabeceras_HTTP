package service.serviceImpl;

import model.Producto2;
import service.BuscarIdService;

import java.util.ArrayList;

public class BuscarIdServiceImpl implements BuscarIdService {
ArrayList<Producto2>productoDos=new ArrayList<>();
    @Override
    public void add(String producto, String id) {
        productoDos.add(new Producto2(producto,id));


    }


    public ArrayList<Producto2> getProductoDos() {
        return productoDos;
    }
}
