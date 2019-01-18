package prueba.prueba.crgomez.activitatdinamicfragment;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdaptadoRecycler extends RecyclerView.Adapter<AdaptadoRecycler.elViewHolder> {

    ArrayList<CicleFlorida> llistatCicles;


    @NonNull
    @Override
    public elViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.un_element_de_de_la_llista,viewGroup,false);
        return new elViewHolder(v);
    }


    public AdaptadoRecycler(ArrayList<CicleFlorida> llista){

        llistatCicles = llista;
    }
    @Override
    public void onBindViewHolder(@NonNull elViewHolder elViewHolder, final int i) {

        elViewHolder.tvTitol.setText(llistatCicles.get(i).getTitol());
        elViewHolder.tvDescripcio.setText(llistatCicles.get(i).getDescripcio());

        //AQUÍ AÑADIMOS EL IC_DELETE CON SU LISTENER, "I" INDICAMOS LA POSICIÓN DEL ARRAY.
        elViewHolder.icDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                llistatCicles.remove(i);
                notifyItemRemoved(i);



            }
        });

    }

    @Override
    public int getItemCount() {
        return llistatCicles.size();
    }

    public static class elViewHolder extends RecyclerView.ViewHolder{
        TextView tvTitol,tvDescripcio;
        ImageView icAnyadir,icDelete;
        public elViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDescripcio = (TextView) itemView.findViewById(R.id.tvDescripcio);
            tvTitol = (TextView) itemView.findViewById(R.id.tv_titol);
            icAnyadir = (ImageView) itemView.findViewById(R.id.delRowBtn);
            icDelete = (ImageView) itemView.findViewById(R.id.addRowBtn);

        }
    }

}
