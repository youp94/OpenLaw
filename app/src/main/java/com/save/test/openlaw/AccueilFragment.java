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
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AccueilFragment extends Fragment {

    ListView list;
    ArrayList<Question> questions = new ArrayList<>();
    QuestionAdapter questionAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_accueil, container, false);

        list = rootView.findViewById(R.id.questions_list);


        Question question1 = new Question("Titre de la question", "Un client qui pose une question ?\nCorps de la question",
                "Droit constitutionnel");
        ArrayList<Reponse> reponses1 = new ArrayList<>();
        reponses1.add(new Reponse("Avocat1", "Voila ma réponse a la question monsieur"));
        question1.setReponses(reponses1);

        Question question2 = new Question("Titre de la question", "Un client qui pose une question ?\nCorps de la question",
                "Droit administratif");
        ArrayList<Reponse> reponses21 = new ArrayList<>();
        reponses21.add(new Reponse("Avocat1", "Voila ma réponse a la question monsieur"));
        question2.setReponses(reponses21);

        Question question3 = new Question("Titre de la question", "Un client qui pose une question ?\nCorps de la question",
                "Droit des personnes");
        ArrayList<Reponse> reponses31 = new ArrayList<>();
        reponses31.add(new Reponse("Avocat1", "Voila ma réponse a la question monsieur"));
        question3.setReponses(reponses31);

        Question question4 = new Question("Titre de la question", "Un client qui pose une question ?\nCorps de la question",
                "Droit des affaires");
        ArrayList<Reponse> reponses41 = new ArrayList<>();
        reponses41.add(new Reponse("Avocat1", "Voila ma réponse a la question monsieur"));
        question4.setReponses(reponses41);

        questions.add(question1);
        questions.add(question2);
        questions.add(question3);
        questions.add(question4);

        questionAdapter = new QuestionAdapter(questions, getContext());
        list.setAdapter(questionAdapter);

        return rootView;
    }

    class QuestionAdapter extends BaseAdapter{

        ArrayList<Question> questions;
        Context context;

        final android.support.v4.app.FragmentManager fm = getActivity().getSupportFragmentManager();
        final Bundle b = new Bundle();

        public QuestionAdapter(ArrayList<Question> questions, Context context) {
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

            final Question question = questions.get(position);
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.question_item,null);

            TextView titre = view.findViewById(R.id.question_title);
            titre.setText(question.getTitre());

            TextView domaine = view.findViewById(R.id.question_domaine);
            domaine.setText(question.getDomaine());

            TextView corps = view.findViewById(R.id.question_body);
            corps.setText(question.getCorps());

            TextView reponses = view.findViewById(R.id.question_answer);
            reponses.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    b.putSerializable("reponse",question.getReponses());
                    ReponsesFragment reponsesFragment = new ReponsesFragment();
                    reponsesFragment.setArguments(b);
                    fm.beginTransaction().replace(R.id.content_frame, reponsesFragment).commit();

                    Toast.makeText(getActivity(),"Les réposnes!", Toast.LENGTH_LONG).show();
                }
            });

            return view;
        }
    }
}
