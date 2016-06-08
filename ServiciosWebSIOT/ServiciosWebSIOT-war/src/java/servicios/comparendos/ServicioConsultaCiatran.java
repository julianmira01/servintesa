package servicios.comparendos;

import javax.jws.WebService;

import modelo.datos.objetos.comparendos.ciatran.ViewComparendoCiatran;

import modelo.logica.comparendos.ciatran.GestionConsultaCiatran;


@WebService
public class ServicioConsultaCiatran {
    GestionConsultaCiatran gestionConsultaCiatran;

    public ServicioConsultaCiatran() {
        super();
        gestionConsultaCiatran = new GestionConsultaCiatran();
    }

    public ViewComparendoCiatran consultaComparendo(String nroComparendo) {
        return gestionConsultaCiatran.consultarComparendo(nroComparendo);
    }

    public ViewComparendoCiatran consulta(ViewComparendoCiatran tmp) {
        return null;
    }
}
