package client.components.inicio;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import services.ObjGraficosService;
import services.RecursosService;

public class InicioTemplate extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private InicioComponent inicioComponent;

    // Declaracion de servicios
    private ObjGraficosService sObjGraficos;
    private RecursosService sRecursos;

    private JLabel lFondo;
    private JButton bVistaGeneral, bNoticias, bNotasVersion;
    private JPanel pPestanas;

    private ImageIcon iFondo;
    private Font fuente;

    public InicioTemplate(InicioComponent inicioComponent){

        this.inicioComponent = inicioComponent;
        sObjGraficos = ObjGraficosService.getService();
        sRecursos = RecursosService.getService();

        crearObjetosDecoradores();
        crearMenu();        
        pPestanas = sObjGraficos.construirJPanel(0, 60, 1055, 578, null, null, null);
        pPestanas.setOpaque(false);
        this.add(pPestanas);


        lFondo = sObjGraficos.construirJLabel(null, 0, 0, 1055, 638, iFondo, null, null, null, null, "c");
        this.add(lFondo);

        this.setBounds(0, 0, 1055, 638);
        this.setLayout(null);
        this.setBackground(null);
    }

    private void crearObjetosDecoradores() {
        fuente = new Font("Cambria", Font.BOLD, 12);
        iFondo = new ImageIcon("resources/img/inicio/fondoInicio.png");
    }

    private void crearMenu() {

        bVistaGeneral = sObjGraficos.crearJButton(
            "VISTA GENERAL", 35, 5, 129, 20, sRecursos.getcMano(), null, fuente, null, sRecursos.getColorHerramietas(),null, "c", false, false
            );
        bVistaGeneral.addActionListener(inicioComponent);
        this.add(bVistaGeneral);

        bNoticias = sObjGraficos.crearJButton(
            "NOTICIAS", 165, 5, 90, 20, sRecursos.getcMano(), null, fuente, null, sRecursos.getColorHerramietas(),null, "c", false, false
            );
        this.add(bNoticias);
        
        bNotasVersion = sObjGraficos.crearJButton(
            "NOTAS DE VERSIÓN", 255, 5, 156, 20, sRecursos.getcMano(), null, fuente, null, sRecursos.getColorHerramietas(),null, "c", false, false
            );
        this.add(bNotasVersion);
    }

    public JPanel gPPestanas() {
        return pPestanas;
    }
}
