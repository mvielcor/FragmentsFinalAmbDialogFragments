package prueba.prueba.crgomez.activitatdinamicfragment;



import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Titolacions.ComunicaFragmentAmbActivity{



    CicleFlorida c;
    ArrayList<CicleFlorida> llistat_titulacions = new ArrayList<CicleFlorida>();

    private FragmentManager fm;
    private FragmentTransaction ft;
    private Titolacions titu;
    private TipusCicle tc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        creaDades();

        titu = Titolacions.newInstance("","");
        tc = TipusCicle.newInstance("","");


    }


    public void creaDades(){


        c = new CicleFlorida("ESPORT","Superior","Animació d'activitats físiques i esportives","Aquesta formació concertat de nivell superior cicle formes com un Tècnic Superior en activitats físiques i esportives, que està especialitzat en ensenyament i dinamització de jocs i activitats de fitness.");
        llistat_titulacions.add(c);
        c = new CicleFlorida("ESPORT","Mitjà","Conducción de actividades físico deportivas en el medio natural","Este Ciclo Formativo de Grado Medio te forma como Técnico/a en Conducción de actividades físico deportivas en el medio natural, permitiéndote la especialización posterior como Técnico de Actividades físico deportivas.");
        llistat_titulacions.add(c);
        c = new CicleFlorida("EMPRESA","Superior","Gestión de Ventas y Espacios Comerciales","Nuevo ciclo formativo de grado superior concertado por la GVA");
        llistat_titulacions.add(c);
        c = new CicleFlorida("EMPRESA","Superior","Marketing y publicidad","Este ciclo te prepara para definir y efectuar el seguimiento de las políticas de marketing de una empresa.");
        llistat_titulacions.add(c);
        c = new CicleFlorida("EMPRESA","Superior","Administración y Finanzas / FP Dual BANKIA","Dentro de la modalidad de FP Dual, Florida Universitaria, en colaboración con Bankia, pone en marcha el Ciclo de Técnico/a Superior en Administración y Finanzas. Este Ciclo Formativo se desarrolla 100% en modalidad DUAL, con 9 meses de estancia en las sucursales de Bankia, formándote con una alta especialización en el ámbito financiero bancario.");
        llistat_titulacions.add(c);
        c = new CicleFlorida("INFORMÀTICA","Mitjà","Sistemas Microinformáticos y Redes","Este Ciclo Formativo de Grado Medio concertado te forma como Técnico/a en Sistemas Microinformáticos y Redes, permitiéndote la especialización posterior en el desarrollo de aplicaciones o la administración de sistemas informáticos.");
        llistat_titulacions.add(c);
        c = new CicleFlorida("INFORMÀTICA","Superior","Administración de Sistemas Informáticos y en Red","Este Ciclo Formativo de Grado Superior concertado te forma como profesional de la informática y las comunicaciones, especializado en la configuración, administración y mantenimiento de sistemas informáticos en red.");
        llistat_titulacions.add(c);
        c = new CicleFlorida("INFORMÀTICA","Superior","Desarrollo de Aplicaciones Multiplataforma","Este NUEVO Ciclo Formativo de Grado Superior concertado te forma como profesional de la informática y las comunicaciones, especializado en el desarrollo, implantación y mantenimiento de aplicaciones para diferentes plataformas tecnológicas.");
        llistat_titulacions.add(c);
        c = new CicleFlorida("INFORMÀTICA","Superior","Desarrollo de Aplicaciones Web","ste NUEVO Ciclo Formativo de Grado Superior privado te forma como profesional de la informática y las comunicaciones, especializado en el desarrollo, implantación y mantenimiento de aplicaciones web");
        llistat_titulacions.add(c);
    }


    @Override
    public void busca_info_empresa() { //Creamos el segundo ArrayList Auxiliar para después analizarla y sacar el tipo de curso

        ArrayList<CicleFlorida> lista_curso= new ArrayList<CicleFlorida>();
        fm = getFragmentManager();
        ft = fm.beginTransaction();

        for (CicleFlorida aux: llistat_titulacions){

            if (aux.getFamiliaProfessional().compareTo("EMPRESA")==0){

                lista_curso.add(aux);

                if (fm.findFragmentById(R.id.fragmentCicle)==null){

                    /*ft.add(R.id.fragmentCicle,tc);*/

                }



            }



        }


    }

    @Override
    public void busca_info_esports() {

    }

    @Override
    public void busca_info_informatica() {

    }
}
