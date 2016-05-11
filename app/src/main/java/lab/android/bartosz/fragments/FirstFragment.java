package lab.android.bartosz.fragments;


import android.app.Activity;

import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {

    private FirstFragmentListener listener;


    public interface FirstFragmentListener {
        public void sendMessage(String msg);
    }

    public FirstFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        listener = (FirstFragmentListener) activity;
    }


    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = (EditText) getView().findViewById(R.id.editTextFirstFragment);
                updateText(String.valueOf(editText.getText()));

            }
        };
        Button button = (Button) view.findViewById(R.id.sendBtnFirstFragment);
        button.setOnClickListener(clickListener);
        return view;
    }
    public void updateText(String msg) {
        listener.sendMessage(msg);
    }




}
