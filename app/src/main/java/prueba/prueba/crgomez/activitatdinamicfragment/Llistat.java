package prueba.prueba.crgomez.activitatdinamicfragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import static android.app.Activity.RESULT_OK;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Llistat.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Llistat#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Llistat extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";


    // TODO: Rename and change types of parameters

    // mPARAM1 metemos el ARRAYLIST
    private ArrayList<CicleFlorida> mParam1;
    private TextView muestraCiclos;
    RecyclerView rv;
    RecyclerView.LayoutManager rvLM;
    AdaptadoRecycler adapRe;
    private OnFragmentInteractionListener mListener;

    public Llistat() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.

     * @return A new instance of fragment Llistat.
     */

    // TODO: Rename and change types and number of parameters
    public static Llistat newInstance(ArrayList<CicleFlorida> param1) {
        Llistat fragment = new Llistat();
        Bundle args = new Bundle();
        args.putParcelableArrayList(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getParcelableArrayList(ARG_PARAM1);

        }
    }
// UTILIZAMOS EL RECLYCLER CON MPARAM1 QUE ES DONDE TENEMOS ALAMCENADO EL ARRAYLIST!
    //CREAMOS LA CLASE ADAPTADORECYCLER POR UNA PARTE Y DESPUÉS EL XML UN_ELEMENT_LLISTA, VER LA CLASE ADAPTADOR.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_llistat, container, false);
        Log.d("entro","entroLlistat " + mParam1.get(0));
        rv = (RecyclerView)v.findViewById (R.id.recycler1);
// getAPLICATTIONCONTEXT no sirve porque TENEMOS QUE UTILIZAR V.GETCONTEXT() QUE ES LA PANTALLA QUE ESTAMOS UTILIZANDO EN EL MOMENTO
        rvLM = new LinearLayoutManager(v.getContext(),1,false);
        rv.setLayoutManager(rvLM);
        adapRe = new AdaptadoRecycler(mParam1, getContext());

        rv.setAdapter(adapRe);
       // muestraCiclos = (TextView) v.findViewById(R.id.voreLlistat);
       // mostrar();
        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (resultCode) {
            case RESULT_OK:
                Log.d("array", "He vuelto al fragment");
                mParam1 = data.getParcelableArrayListExtra("arrayList");
                break;
        }
    }
// NOS CARGAMOS ESTE MÉTODO PARA INCORPORAR EL RECYCLERVIEW
    public void mostrar(){
        Log.d("entro", "entroMostrar");
        for (CicleFlorida aux: mParam1){
            Log.d("entro",aux.toString());
            muestraCiclos.setText(aux.toString()+"\n"+muestraCiclos.getText());

        }

    }



    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
