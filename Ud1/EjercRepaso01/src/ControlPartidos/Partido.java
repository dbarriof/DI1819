package ControlPartidos;

import java.util.Objects;

/**
 *
 * @author Guile
 */
enum Division {primera,segunda,tercera}
public class Partido {
    private String equipoLocal;
    private String equipoVisitante;
    private Division division;
    private String resultado;
    private String fecha;

    public Partido(String equipoLocal, String equipoVisitante, Division division, String resultado, String fecha) {
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.division = division;
        this.resultado = resultado;
        this.fecha = fecha;
    }
    
    public Partido(String equipoLocal, String equipoVisitante) {
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
    }

    public String getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(String equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public String getEquipoVisitante() {
        return equipoVisitante;
    }

    public void setEquipoVisitante(String equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Partido{" + "equipoLocal=" + equipoLocal + ", equipoVisitante=" + equipoVisitante + ", division=" + division + ", resultado=" + resultado + ", fecha=" + fecha + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.equipoLocal);
        hash = 79 * hash + Objects.hashCode(this.equipoVisitante);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Partido other = (Partido) obj;
        if (!Objects.equals(this.equipoLocal, other.equipoLocal)) {
            return false;
        }
        if (!Objects.equals(this.equipoVisitante, other.equipoVisitante)) {
            return false;
        }
        return true;
    }
    
    
}
