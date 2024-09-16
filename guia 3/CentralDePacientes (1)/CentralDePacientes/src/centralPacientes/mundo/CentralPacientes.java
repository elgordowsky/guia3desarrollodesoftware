/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogotá - Colombia)
 * Departamento de Tecnologías de la Información y Comunicaciones
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Proyecto Central de Pacientes.
 * Adaptado de CUPI2 (Uniandes)
 * Fecha: Febrero 2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package centralPacientes.mundo;

import java.util.ArrayList;

/**
 * Esta clase representa una central en la que se maneja una lista de pacientes
 */
public class CentralPacientes {
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Lista de pacientes
     */
    private ArrayList<Paciente> pacientes;

    /**
     * Vector de clínicas manejadas por la central
     */
    private ArrayList<String> listaClinicas;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea una nueva central sin pacientes y con una lista predefinida de clínicas
     */
    public CentralPacientes() {
        pacientes = new ArrayList<>();

        listaClinicas = new ArrayList<>();
        listaClinicas.add("Clínica del Country");
        listaClinicas.add("Clínica Palermo");
        listaClinicas.add("Clínica Reina Sofía");
        listaClinicas.add("Clínica El Bosque");
        listaClinicas.add("Clínica San Ignacio");
        listaClinicas.add("Otra");
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna el número de pacientes de la clínica
     *
     * @return El número de pacientes de la clínica
     */
    public int darNumeroPacientes() {
        return pacientes.size();
    }

    /**
     * Adiciona un paciente al principio de la lista
     */

    private boolean existePacienteConCodigo(int codigo) {   //metodo adicional para comprobar si ya existe el paciente
        if (pacientes == null) {
            return false;
        }
        for (Paciente p : pacientes) {
            if (p.darCodigo() == codigo) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param pac El paciente a ser agregado al comienzo de la lista. <br>
     *            pac!=null y no existe un paciente con código igual a pac.codigo
     */

    public void agregarPacienteAlComienzo(Paciente pac) {
        // TODO: Realiar el método que agrega al principio
        if (pac != null && !existePacienteConCodigo(pac.darCodigo())) {
            pacientes.add(0, pac);
        }else {
            // Manejo de error: si pac es nulo o el código del paciente ya existe.
            throw new IllegalArgumentException("El paciente no existe o ya existe un paciente con el mismo código.");
        }

    }

    /**
     * Adiciona un paciente al final de la lista. Si la lista está vacía el paciente queda de primero
     *
     * @param pac El paciente a ser agregado al final la lista. <br>
     *            pac!=null y no existe un paciente con código igual a pac.codigo
     */
    public void agregarPacienteAlFinal(Paciente pac) {
        // TODO: Agragar un paciente al final de la lista
        if (pac != null && !existePacienteConCodigo(pac.darCodigo())) {
            pacientes.add(pac);
        }else {
            // Manejo de error: si pac es nulo o el código del paciente ya existe.
            throw new IllegalArgumentException("El paciente no existe o ya existe un paciente con el mismo código.");
        }

    }

    /**
     * Adiciona un paciente a la lista de pacientes antes del paciente con el código especificado. <br>
     */
    public void agregarPacienteAntesDe(int cod, Paciente pac) throws NoExisteException {
        // TODO: Agrega un paciente después del paciente con el código dado
        if (pac == null) {
            throw new NoExisteException(cod);
        }
        for (int i = 0; i < pacientes.size(); i++) {
            if (pacientes.get(i).darCodigo() == cod) {
                pacientes.add(i, pac);
                return;
            }
        }

        throw new NoExisteException(cod);
    }

    /**
     * Adiciona un paciente a la lista de pacientes después del paciente con el código especificado.
     */
    public void agregarPacienteDespuesDe(int cod, Paciente pac) throws NoExisteException {
        // TODO: Agrega un paciente después del paciente con el código cod
        if (pac == null) {
            throw new NoExisteException(cod);
        }
        for (int i = 0; i < pacientes.size(); i++) {
            if (pacientes.get(i).darCodigo() == cod) {
                pacientes.add(i + 1, pac);
                return;
            }
        }
    }

    /**
     * Busca el paciente con el código dado en la lista de pacientes.
     */
    public Paciente localizar(int codigo) {
        // TODO: Completar el método
        for (Paciente p : pacientes) {
            if (p.darCodigo() == codigo) {
                return p;
            }
        }
        return null;
    }

    /**
     * Elimina el paciente con el código especificado.
     */
    public void eliminarPaciente(int cod) throws NoExisteException {
        // TODO: Si no existe el paciente con el código dado, genera la excepción

        for (int i = 0; i < pacientes.size(); i++) {
            if (pacientes.get(i).darCodigo() == cod) {
                pacientes.remove(i);
                return;
            }else
                throw new NoExisteException(cod);
        }


    }

    /**
     * Devuelve una lista con los pacientes de la central
     */
    public ArrayList<Paciente> darPacientes() {
        return pacientes;
    }

    /**
     * Retorna la lista de clínicas manejadas por la central
     */
    public ArrayList<String> darListaClinicas() {
        return listaClinicas;
    }

    /**
     * Retorna la longitud de la lista
     */
    private int darLongitud() {
        return pacientes.size();
    }

    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------

    /**
     * Retorna la cantidad de hombres que hay en la lista
     */
    public int cantHombres() {
        // TODO: Completar
        int pacHombre = 0;
        for (Paciente p : pacientes) {
            if (p.darSexo() == Paciente.HOMBRE){
                pacHombre++;
            }
        }
        return pacHombre;
    }

    /**
     * Retorna la cantidad de mujeres que hay en la lista
     */
    public int cantMujeres() {
        // TODO: Completar
        int pacMujer = 0;
        for (Paciente p : pacientes) {
            if(p.darSexo()==Paciente.MUJER){
                pacMujer++;
            }
        }
        return pacMujer;
    }

    /**
     * De las 6 opciones de clínicas que tiene la central
     * ¿Cuál es el nombre de la más ocupada, la que tiene más pacientes?
     *
     * @return nombre de la clínica
     */
    public String metodo4() {
        // TODO: Completar
        // Variables para contar pacientes en cada clínica
        int cantCountry = 0;
        int cantPalermo = 0;
        int cantReina = 0;
        int cantElBosque = 0;
        int cantSanIgnacio = 0;
        int cantOtra = 0;

        // Contar pacientes por clínica
        for (Paciente p : pacientes) {
            switch (p.darClinica()) {
                case "Clínica del Country":
                    cantCountry++;
                    break;
                case "Clínica Palermo":
                    cantPalermo++;
                    break;
                case "Clínica Reina Sofía":
                    cantReina++;
                    break;
                case "Clínica El Bosque":
                    cantElBosque++;
                    break;
                case "Clínica San Ignacio":
                    cantSanIgnacio++;
                    break;
                case "Otra":
                    cantOtra++;
                    break;
            }
        }

        // Determinar cuál clínica tiene más pacientes
        String clinicaMasOcupada = "Clínica del Country"; // Suponemos que es la primera
        int maxPacientes = cantCountry;

        if (cantPalermo > maxPacientes) {
            clinicaMasOcupada = "Clínica Palermo";
            maxPacientes = cantPalermo;
        }
        if (cantReina > maxPacientes) {
            clinicaMasOcupada = "Clínica Reina Sofía";
            maxPacientes = cantReina;
        }
        if (cantElBosque > maxPacientes) {
            clinicaMasOcupada = "Clínica El Bosque";
            maxPacientes = cantElBosque;
        }
        if (cantSanIgnacio > maxPacientes) {
            clinicaMasOcupada = "Clínica San Ignacio";
            maxPacientes = cantSanIgnacio;
        }
        if (cantOtra > maxPacientes) {
            clinicaMasOcupada = "Otra";
            maxPacientes = cantOtra;
        }

        // Retorna el nombre de la clínica más ocupada
        return clinicaMasOcupada;
    }



}
