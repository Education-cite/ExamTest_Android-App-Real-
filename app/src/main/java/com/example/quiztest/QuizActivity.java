package com.example.quiztest;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quiztest.databinding.ActivityQuizBinding;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Random;
public class QuizActivity extends AppCompatActivity {

    ActivityQuizBinding binding;
    ArrayList<Question> questions;
    int index = 0;

    //    Question question;
//    CountDownTimer timer;
//    FirebaseFirestore database;
//    int correctAnswers = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityQuizBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        questions = new ArrayList<>();
        questions.add(new Question("What is java?", "Programming Language", "normal Language", "Hypertext Language", "none", "Programming Language"));
        questions.add(new Question("What is Android?", "Programming Language", "normal Language", "Mobile AppLication ", "none", "Programming Language"));
        questions.add(new Question("What is Flutter?", "Programming Language", "normal Language", "Mobile AppLication", "none", "Programming Language"));

        setNextQuestion();
    }



    void setNextQuestion(){
        if(index < questions.size()){
          Question  question = questions.get(index);
            binding.question.setText(question.getQuestion());
            binding.option1.setText(question.getOption1());
            binding.option2.setText(question.getOption2());
            binding.option3.setText(question.getOption3());
            binding.option4.setText(question.getOption4());
        }

    }


    public void onClick(View view){
        switch (view.getId()){
            case R.id.nextBtn:
                if(index < questions.size()) {
                    index++;
                    setNextQuestion();
                }else{
                    Toast.makeText(this, "Finish Question", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }




    
}