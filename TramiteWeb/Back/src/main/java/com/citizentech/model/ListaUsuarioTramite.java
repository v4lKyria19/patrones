package com.citizentech.model;

import java.util.ArrayList;
import java.util.List;

public class ListaUsuarioTramite {
    
    private List<UsuarioTramite> lista;
    
    public ListaUsuarioTramite(){
        lista = new ArrayList<UsuarioTramite>();
    }

    public List<UsuarioTramite> getLista() {
        return lista;
    }

    public void setLista(List<UsuarioTramite> lista) {
        this.lista = lista;
    }

}
