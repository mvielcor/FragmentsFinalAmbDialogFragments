package prueba.prueba.crgomez.activitatdinamicfragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

public class DialogAfegirCicle extends DialogFragment {

    // Creem la interfície de comunicació d'aquest diàleg amb el fragment/activity que el llance
    public interface ComunicaDialegAmbFragment{
        void afegirCicle(CicleFlorida cicleNou); //Rebrem un objecte CicleFlorida i l'afegirem
    }


    DialogAfegirCicle.ComunicaDialegAmbFragment comunicador;  //Objecte per a notificar al fragment que ha llençat
    // este diàleg, quina opció ha polsat l'usuari

    String titol; //Títol que li posarem al dialeg
    private TextView tipusCicle, tipus, titol_new, descip_new; //Dades del layout per afegir un cicle
    View v;

    public DialogAfegirCicle(){}  //Constructor del fragment. Ha d'estar buit obligatòriament!!

    public static DialogAfegirCicle newInstance(String titol_dialeg) {

        Bundle args = new Bundle();

        DialogAfegirCicle fragment = new DialogAfegirCicle();
        args.putString("TitolDialeg",titol_dialeg);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getArguments()!=null){
            titol = getArguments().getString("TitolDialeg");

        }
        //enllacem la interficie de comunicació amb el Fragment/Activity que crea aquest diàleg.
        comunicador = (ComunicaDialegAmbFragment)getTargetFragment();
    }

    public Dialog onCreateDialog(Bundle savedInstance) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        //Unflem el layout amb els camps a mostrar en el diàleg
        LayoutInflater inflater = getActivity().getLayoutInflater();
        v =inflater.inflate(R.layout.activity_agregar,null);

        //Associem els element del layout amb objectes Java.
        tipusCicle = (TextView) v.findViewById(R.id.tipusCicle);
        tipus = (TextView) v.findViewById(R.id.tipus);
        titol_new = (TextView) v.findViewById(R.id.titol_new);
        descip_new = (TextView)v.findViewById(R.id.descripcio_new);

        builder.setTitle(titol) // Posem títol a Diàleg
                .setView(v)     // Posem el contingut del diàleg
                .setPositiveButton(R.string.afegir_cicle, new DialogInterface.OnClickListener() { //Posem el botó positiu
                    public void onClick(DialogInterface dialog, int id) {
                        CicleFlorida nouCicle =comprovaDadesCicle();
                        if(nouCicle!=null) {
                            // Notifiquem al fragment que ha llençat este diàleg (mitjançant la interficie de comunicació)
                            // Que l'usuari ha polsat el botó positiu (afegir cicle)
                            comunicador.afegirCicle(nouCicle);
                        }
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                        //No cal fer res!!
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();

    }

    public CicleFlorida comprovaDadesCicle(){

        // Mètode per a comprovar que els camps d'informació del nou cicle ténen la informació necessaria
        // Caldria acabar d'implementar la comprovació per a tots els camps ...
        String mTipusCicle, mTipus, mTitol, mDescripcio;
        mTipusCicle = tipusCicle.getText().toString();
        mTipus = titol_new.getText().toString();
        mTitol = tipus.getText().toString();
        mDescripcio = descip_new.getText().toString();


        if(mTitol.isEmpty()){
            View.OnClickListener corregirDades = new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    titol_new.requestFocus();
                }
            };
            Snackbar.make(v.getRootView(),"Cal omplir el Títol del cicle",Snackbar.LENGTH_INDEFINITE)
                    .setAction("Corregir",corregirDades)
                    .show();
            return null;  //tornem null ja que les dades no son correctes
        }
        CicleFlorida c1 = new CicleFlorida(mTipusCicle, mTipus, mTitol, mDescripcio);

        return c1;
    }

}
