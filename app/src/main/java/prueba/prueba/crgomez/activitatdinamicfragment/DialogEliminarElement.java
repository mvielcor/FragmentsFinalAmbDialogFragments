package prueba.prueba.crgomez.activitatdinamicfragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;

public class DialogEliminarElement extends DialogFragment {
    ComunicaDialegAmbFragment comunicador;
    String titol,msg;
    int posicioAEliminar;
    public DialogEliminarElement(){}

    /*Aques diàleg rebrà tres paràmetres:
    el títol que mostrarà el diàleg
    El missatge que mostrarà el diàleg
    la posició de l'element a eliminar
     */
    public static DialogEliminarElement newInstance(String titol_dialeg, String missatge_dialeg, int pos) {

        Bundle args = new Bundle();
        // REcollim els paràmetres que reb el diàleg
        DialogEliminarElement fragment = new DialogEliminarElement();
        args.putString("TitolDialeg",titol_dialeg);
        args.putString("MissatgeDialeg",missatge_dialeg);
        args.putInt("Posicio",pos);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getArguments()!=null){
            //Si el diàleg té paràmetres, els assignem als atributs de la classe
            titol = getArguments().getString("TitolDialeg");
            msg = getArguments().get("MissatgeDialeg").toString();
            posicioAEliminar = getArguments().getInt("Posicio");
        }
        //enllacem la interficie de comunicació amb el FRagment LListat, que és el fragment que crea aquest diàleg.
        comunicador = (ComunicaDialegAmbFragment)getTargetFragment();
    }

    public Dialog onCreateDialog(Bundle savedInstance) {
        // Creem el contingut del diàleg
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setMessage(msg)
                .setTitle(titol)
                .setPositiveButton(R.string.eliminar, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    // Notifiquem al fragment que ha llençat este diàleg (mitjançant la interficie de comunicació)
                        // Que l'usuari ha polsat el botó positiu (Eliminar)
                    comunicador.eliminarCicle(posicioAEliminar);

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


    public interface ComunicaDialegAmbFragment {

        void eliminarCicle(int posicioAEliminar);
    }
}
