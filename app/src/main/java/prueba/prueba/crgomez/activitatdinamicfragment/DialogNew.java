package prueba.prueba.crgomez.activitatdinamicfragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;

public class DialogNew extends DialogFragment {
    comunicaDialegAmbFragment comunicador;
    String titol,msg;
    int posicioAEliminar;
    public DialogNew (){}

    public static DialogNew newInstance(String titol_dialeg, String missatge_dialeg, int pos) {

        Bundle args = new Bundle();

        DialogNew fragment = new DialogNew();
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
            titol = getArguments().getString("TitolDialeg");
            msg = getArguments().get("MissatgeDialeg").toString();
            posicioAEliminar = getArguments().getInt("Posicio");
        }
        Log.d("MANEL","On Create FragmenDialog- abans crear");
        onCreateDialog().show();

        Log.d("MANEL","On Create FragmenDialog- despres crear");
    }
    public Dialog onCreateDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setMessage(msg)
                .setTitle(titol)
                .setPositiveButton(R.string.fire, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // FIRE ZE MISSILES!
                    comunicador.eliminarCicle(posicioAEliminar);

                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();

    }
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        // Verify that the host activity implements the callback interface
        try {
            // Instantiate the NoticeDialogListener so we can send events to the host
            comunicador = (comunicaDialegAmbFragment) activity;
        } catch (ClassCastException e) {
            // The activity doesn't implement the interface, throw exception
            throw new ClassCastException(activity.toString()
                    + " must implement comunicaDialegAmbFragment");
        }
    }
    public interface comunicaDialegAmbFragment {

        void eliminarCicle(int posicioAEliminar);
        //falta un mètode per afegir cicles
    }
}
