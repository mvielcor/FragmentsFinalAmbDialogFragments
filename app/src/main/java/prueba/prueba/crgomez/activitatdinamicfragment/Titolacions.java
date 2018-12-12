package prueba.prueba.crgomez.activitatdinamicfragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class Titolacions extends Fragment implements View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Button btn_empresa;
    private Button btn_informacio;
    private Button btn_esports;

    private ComunicaFragmentAmbActivity mListener;

    public Titolacions() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static Titolacions newInstance(String param1, String param2) {
        Titolacions fragment = new Titolacions();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_titolacions, container, false);

        btn_empresa = (Button) v.findViewById(R.id.btn_Empresa);
        btn_esports = (Button) v.findViewById(R.id.btn_Esports);
        btn_informacio = (Button) v.findViewById(R.id.btn_Informartica);

        btn_informacio.setOnClickListener(this);
        btn_esports.setOnClickListener(this);
        btn_empresa.setOnClickListener(this);

        return v;

    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ComunicaFragmentAmbActivity) {
            mListener = (ComunicaFragmentAmbActivity) context;
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

        if (v.getId()==R.id.btn_Empresa){

            mListener.busca_info_empresa();
        }
            if (v.getId()==R.id.btn_Esports){

                mListener.busca_info_esports();

            }else{

                mListener.busca_info_informatica();
            }



    }


    public interface ComunicaFragmentAmbActivity {
        // TODO: Update argument type and name
        void busca_info_empresa();
        void busca_info_esports();
        void busca_info_informatica();
    }
}
