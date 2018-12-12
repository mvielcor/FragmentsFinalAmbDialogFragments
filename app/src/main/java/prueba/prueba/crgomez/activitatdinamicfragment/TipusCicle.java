package prueba.prueba.crgomez.activitatdinamicfragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TipusCicle.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TipusCicle#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TipusCicle extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private Boolean mParam1;
    private Button mitja;
    private Button superior;
    private boolean mParam2;

    private OnFragmentInteractionListener mListener;

    public TipusCicle() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TipusCicle.
     */
    // TODO: Rename and change types and number of parameters
    public static TipusCicle newInstance(Boolean param1, Boolean param2) {

        TipusCicle fragment = new TipusCicle();
        Bundle args = new Bundle();
        args.putBoolean(ARG_PARAM1, param1);
        args.putBoolean(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getBoolean(ARG_PARAM1);
            mParam2 = getArguments().getBoolean(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
       View v= inflater.inflate(R.layout.fragment_tipus_cicle, container, false);

       mitja = (Button) v.findViewById(R.id.btn_mitja);
       superior = (Button) v.findViewById(R.id.btn_superior);

       mitja.setOnClickListener(this);
       superior.setOnClickListener(this);

        mitja.setEnabled(mParam1);
        superior.setEnabled(mParam2);

       return  v;

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
    public void onClick(View v) {

        if (v.getId()==mitja.getId()){

            mListener.tipoPulsacion(1);

        }else{

            mListener.tipoPulsacion(2);
        }


    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void tipoPulsacion(int id);

    }
}
