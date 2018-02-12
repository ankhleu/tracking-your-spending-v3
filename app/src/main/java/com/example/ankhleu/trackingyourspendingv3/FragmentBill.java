package com.example.ankhleu.trackingyourspendingv3;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.TextView;

import com.example.ankhleu.trackingyourspendingv3.tripdata.tripDetail;
import com.example.ankhleu.trackingyourspendingv3.tripdata.tripadd;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentBill.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentBill#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentBill extends Fragment implements View.OnClickListener
{

    TextView tv3;
    FloatingActionButton fb1,fb2,fb3;
    ListView lv;
    public static String time ;
    public int money;
    public String note;
    public String subject;
    public String[][] data={{"1","time","subject","money","note"}};
    public SQLiteDatabase DB;




    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    public String mParam1;
    public String mParam2;

    private OnFragmentInteractionListener mListener;
    private ViewGroup rootView;


    public FragmentBill() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentBill.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentBill newInstance(String param1, String param2) {
        FragmentBill fragment = new FragmentBill();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //    fb1=(FloatingActionButton)getActivity().findViewById(R.id.floatingActionButton3) ;
        // 要用getactivity,fragment生命週期在onActivityCreated之後


        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }





    }


    @Override
    public void onResume() {  //增加onResume然後下方設定lv.setAdapter
        super.onResume();

        lv=(ListView)getActivity().findViewById(R.id.listview);
        final ViewAdapter viewAdapter=new ViewAdapter(data,getLayoutInflater());
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                viewAdapter.notifyDataSetChanged();
//                DB.execSQL();
            }
        });
        lv.setAdapter(viewAdapter);

//        final ArrayAdapter<String>arrayAdapter=new ArrayAdapter<String>
//                (getActivity(),android.R.layout.simple_list_item_1,getData());
//        getActivity().runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//                arrayAdapter.notifyDataSetChanged();
//            }
//        });
//        lv.setAdapter(arrayAdapter);
 //       SELECT FROM tripDetail where money BETWEEN startdate and enddate


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
/*
       View view=inflater.inflate(R.layout.activity_newstart,container,false);
       lv=(ListView)getActivity().findViewById(R.id.listview);
       ArrayAdapter<String>arrayAdapter=new ArrayAdapter<String>
               (getActivity(),android.R.layout.simple_list_item_1,getData());
       lv.setAdapter(arrayAdapter);
       return view;    //測試抓data


*/




        return inflater.inflate(R.layout.fragment_bill, container, false);
        // Inflate the layout for this fragment




    }


    public List<String>getData()
    {
        List<String>data=new ArrayList<String>();

        for (int i=0;i <20;i++)
        {
            data.add(i+"");
        }
        return data;  //測試抓data

    }



    @Override
    public void onActivityCreated( Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
       fb1 = (FloatingActionButton) getActivity().findViewById(R.id.floatingActionButton3);
        fb2 = (FloatingActionButton) getActivity().findViewById(R.id.floatingActionButton2);
        fb3 = (FloatingActionButton) getActivity().findViewById(R.id.floatingActionButton);




        fb1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent it = new Intent(getActivity(), Newstart.class);
                        //new Intent(getActivity(),StartactActivity.class);
                        startActivity(it);
                    }
                });
        fb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it2 = new Intent(getActivity(), Tripadddetail.class);
                startActivity(it2);
            }
        });

 /*       fb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
*/

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
//           throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");

        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View view) {

    }



/*
    private void startActivity(FloatingActionButton fb1) {

    }
*/

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
