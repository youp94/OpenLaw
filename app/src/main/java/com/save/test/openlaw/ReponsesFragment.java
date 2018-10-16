package com.save.test.openlaw;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ReponsesFragment extends Fragment {

    ListView list;
    ArrayList<Reponse> reponses = new ArrayList<>();
    ReponseAdapter reponseAdapter;

    Button button;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_reponses, container, false);

        if(getArguments() != null){
            reponses = (ArrayList<Reponse>) getArguments().getSerializable("reponse");
        }

        Toast.makeText(getActivity(),reponses.get(0).getCorps(), Toast.LENGTH_LONG).show();

        list = rootView.findViewById(R.id.reponses_list);

        reponseAdapter = new ReponseAdapter(reponses, getContext());
        list.setAdapter(reponseAdapter);

        final android.support.v4.app.FragmentManager fm = getActivity().getSupportFragmentManager();
        button = rootView.findViewById(R.id.retour);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AccueilFragment reponsesFragment = new AccueilFragment();
                fm.beginTransaction().replace(R.id.content_frame, reponsesFragment).commit();
            }
        });

        return rootView;
    }

    class ReponseAdapter extends BaseAdapter {

        ArrayList<Reponse> questions;
        Context context;

        public ReponseAdapter(ArrayList<Reponse> questions, Context context) {
            this.questions = questions;
            this.context = context;
        }

        @Override
        public int getCount() {
            return questions.size();
        }

        @Override
        public Object getItem(int position) {
            return questions.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            Reponse question = questions.get(position);
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.reponse_item,null);

            TextView titre = view.findViewById(R.id.auteur);
            titre.setText(question.getAuteur());

            TextView domaine = view.findViewById(R.id.reponse_body);
            domaine.setText(question.getCorps());

            return view;
        }
    }

}
