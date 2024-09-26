package Clases;

import ClasesAbstractas.ContenidoMultimedia;

public class Visualizacion {
    private Perfil perfil;
    private ContenidoMultimedia contenido;


    public Visualizacion(Perfil perfil, ContenidoMultimedia contenido) {
        this.perfil = perfil;
        this.contenido = contenido;
    }

    public void ver(Perfil perfil, ContenidoMultimedia contenido) {
        System.out.println("El perfil " + perfil.getNombre() + " está viendo " + contenido.getTitulo());
    }
} 


