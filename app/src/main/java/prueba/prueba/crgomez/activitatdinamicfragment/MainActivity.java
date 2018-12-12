package prueba.prueba.crgomez.activitatdinamicfragment;





import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Titolacions.ComunicaFragmentAmbActivity,TipusCicle.OnFragmentInteractionListener,Llistat.OnFragmentInteractionListener {


    CicleFlorida c;
    ArrayList<CicleFlorida> llistat_titulacions = new ArrayList<CicleFlorida>();
    ArrayList<CicleFlorida> ciclesFiltrats;

    private FragmentManager fm;
    private FragmentTransaction ft;
    private Titolacions titu;
    private TipusCicle tc;
    private Llistat lt;

    private boolean mit;
    private boolean sup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        creaDades();

        titu = Titolacions.newInstance("", "");
        tc = TipusCicle.newInstance(false, false);



    }


    public void creaDades() {


        c = new CicleFlorida("ESPORT", "Superior", "Animació d'activitats físiques i esportives", "Aquesta formació concertat de nivell superior cicle formes com un Tècnic Superior en activitats físiques i esportives, que està especialitzat en ensenyament i dinamització de jocs i activitats de fitness.");
        llistat_titulacions.add(c);
        c = new CicleFlorida("ESPORT", "Mitjà", "Conducción de actividades físico deportivas en el medio natural", "Este Ciclo Formativo de Grado Medio te forma como Técnico/a en Conducción de actividades físico deportivas en el medio natural, permitiéndote la especialización posterior como Técnico de Actividades físico deportivas.");
        llistat_titulacions.add(c);
        c = new CicleFlorida("EMPRESA", "Superior", "Gestión de Ventas y Espacios Comerciales", "Nuevo ciclo formativo de grado superior concertado por la GVA");
        llistat_titulacions.add(c);
        c = new CicleFlorida("EMPRESA", "Superior", "Marketing y publicidad", "Este ciclo te prepara para definir y efectuar el seguimiento de las políticas de marketing de una empresa.");
        llistat_titulacions.add(c);
        c = new CicleFlorida("EMPRESA", "Superior", "Administración y Finanzas / FP Dual BANKIA", "Dentro de la modalidad de FP Dual, Florida Universitaria, en colaboración con Bankia, pone en marcha el Ciclo de Técnico/a Superior en Administración y Finanzas. Este Ciclo Formativo se desarrolla 100% en modalidad DUAL, con 9 meses de estancia en las sucursales de Bankia, formándote con una alta especialización en el ámbito financiero bancario.");
        llistat_titulacions.add(c);
        c = new CicleFlorida("INFORMÀTICA", "Mitjà", "Sistemas Microinformáticos y Redes", "Este Ciclo Formativo de Grado Medio concertado te forma como Técnico/a en Sistemas Microinformáticos y Redes, permitiéndote la especialización posterior en el desarrollo de aplicaciones o la administración de sistemas informáticos.");
        llistat_titulacions.add(c);
        c = new CicleFlorida("INFORMÀTICA", "Superior", "Administración de Sistemas Informáticos y en Red", "Este Ciclo Formativo de Grado Superior concertado te forma como profesional de la informática y las comunicaciones, especializado en la configuración, administración y mantenimiento de sistemas informáticos en red.");
        llistat_titulacions.add(c);
        c = new CicleFlorida("INFORMÀTICA", "Superior", "Desarrollo de Aplicaciones Multiplataforma", "Este NUEVO Ciclo Formativo de Grado Superior concertado te forma como profesional de la informática y las comunicaciones, especializado en el desarrollo, implantación y mantenimiento de aplicaciones para diferentes plataformas tecnológicas.");
        llistat_titulacions.add(c);
        c = new CicleFlorida("INFORMÀTICA", "Superior", "Desarrollo de Aplicaciones Web", "ste NUEVO Ciclo Formativo de Grado Superior privado te forma como profesional de la informática y las comunicaciones, especializado en el desarrollo, implantación y mantenimiento de aplicaciones web");
        llistat_titulacions.add(c);
    }




    @Override
    public void busca_info_empresa() { //Creamos el segundo ArrayList Auxiliar para después analizarla y sacar el tipo de curso

        ciclesFiltrats = filtraTitulacions("EMPRESA");


        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();


        tc = TipusCicle.newInstance(mit, sup);
        mit=false;
        sup=false;
        ft.replace(R.id.fragmentTitolacions, tc);
        ft.commit();

    }

    @Override
    public void busca_info_esports() {
        ciclesFiltrats = filtraTitulacions("ESPORT");


        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();


        tc = TipusCicle.newInstance(mit, sup);
        mit=false;
        sup=false;

        ft.replace(R.id.fragmentTitolacions, tc);
        ft.commit();
    }

    @Override
    public void busca_info_informatica() {
        ciclesFiltrats = filtraTitulacions("INFORMÀTICA");


        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();

        tc = TipusCicle.newInstance(mit, sup);
        mit=false;
        sup=false;
        ft.replace(R.id.fragmentTitolacions, tc);
        ft.commit();

    }

    //CON ESTE MÉTODO LO QUE HACEMOS ES FILTRAR POR TODOS LOS TIPOS DE TITULACIONES Y
    //CON LOS BOOLEANS DESACTIVAMOS EL BOTÓN, SIEMPRE LO RESETEAMOS A FALSE EN CADA MÉTODO AL FILTRAR POR ESPORT,INFOR,EMPRESA
    public ArrayList<CicleFlorida> filtraTitulacions(String famProf) {

        ArrayList<CicleFlorida> listaCurso = new ArrayList<CicleFlorida>();

        for (CicleFlorida aux : llistat_titulacions) {
            if (aux.getFamiliaProfessional().compareTo(famProf) == 0) {
                listaCurso.add(aux);
                if (aux.getTipus().compareTo("Mitjà") == 0) {
                    mit = true;
                }
                if (aux.getTipus().compareTo("Superior") == 0) {

                    sup = true;

                }

            }
        }
        return listaCurso;
    }


    @Override
    public void tipoPulsacion(int id) {

       ArrayList<CicleFlorida> tipoCurs = botons(id);

       lt = Llistat.newInstance(tipoCurs);

       fm = getSupportFragmentManager();
       ft = fm.beginTransaction();


       ft.replace(R.id.fragmentLlistat,lt);

       ft.commit();





    }

    public ArrayList<CicleFlorida> botons(int id){
        //CON ESTE MÉTODO LO QUE HACEMOS ES QUE DEPENDE DEL ID QUE SEA HARÁ UNA COSA U OTRA QUE DESPUÉS EN EL DE ARRIBA LE DIREMOS
        //QUE BOTÓN HEMOS PULSADO ESTO LO HEMOS HECHO EN EL FRAGMENT DINÁMIC.
        ArrayList<CicleFlorida> listaCurso = new ArrayList<CicleFlorida>();

        for (CicleFlorida aux: ciclesFiltrats){ //cogemos el ArrayList de cicleFiltrats que es el que le estamos diciendo si es EMPRESA, INFORMATICA O ESPORTS

            if (id==1) {

                if (aux.getTipus().compareTo("Mitjà") == 0) {

                    listaCurso.add(aux);

                }

            }
            if (id==2 && aux.getTipus().compareTo("Superior")==0){


                listaCurso.add(aux);

            }

        }
        return listaCurso;
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}

