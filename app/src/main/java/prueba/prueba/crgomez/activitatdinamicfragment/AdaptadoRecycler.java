package prueba.prueba.crgomez.activitatdinamicfragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdaptadoRecycler extends RecyclerView.Adapter<AdaptadoRecycler.elViewHolder> {

    public static ArrayList<CicleFlorida> llistatCicles;
    public static Context context;
    public NotificaAccions comunicador;

    public interface NotificaAccions{
        void mostraDialegEsborrarElement(int pos);
        void mostraDialegAfegirCicle();

    }
    public static class elViewHolder extends RecyclerView.ViewHolder  {
        TextView tvTitol,tvDescripcio;
        ImageView icAnyadir,icDelete;

        public elViewHolder(@NonNull View itemView) {
            super(itemView);

            tvDescripcio = (TextView) itemView.findViewById(R.id.tvDescripcio);
            tvTitol = (TextView) itemView.findViewById(R.id.tv_titol);
            icAnyadir = (ImageView) itemView.findViewById(R.id.addRowBtn);
            icDelete = (ImageView) itemView.findViewById(R.id.delRowBtn);
            //context = itemView.getContext();
        }

    }

    @NonNull
    @Override
    public elViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.un_element_de_de_la_llista,viewGroup,false);
         context = v.getContext();
        return new elViewHolder(v);
    }


    public AdaptadoRecycler(ArrayList<CicleFlorida> llista, Context cont, NotificaAccions na){
         context = cont;
        llistatCicles = llista;
        comunicador = na;
    }
    @Override
    public void onBindViewHolder(@NonNull final elViewHolder elViewHolder,  final int i) {

        elViewHolder.tvTitol.setText(llistatCicles.get(i).getTitol());
        elViewHolder.tvDescripcio.setText(llistatCicles.get(i).getDescripcio());
        // al hacer this estamos diciendo que está clase es la que va a ser quien implemente el onclick

        ///Afegim un listener a la icona +
        elViewHolder.icAnyadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             comunicador.mostraDialegAfegirCicle(); //Notifiquem al fragment que conté el recyclerview que volem mostrar el dialeg afegir
            }
        });

        //Afegim un listener a la icona +
       elViewHolder.icDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              comunicador.mostraDialegEsborrarElement(i);  //Notifiquem al fragment que té el recyclerView que mostre el dialeg
            }
        });

    }



    @Override
    public int getItemCount() {
        return llistatCicles.size();
    }




}//de la classe


