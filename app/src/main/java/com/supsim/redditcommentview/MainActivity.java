package com.supsim.redditcommentview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    CommentLinearLayout commentLinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        commentLinearLayout = (CommentLinearLayout)findViewById(R.id.commentHolderLayout);
        fillViewUp(12);
    }

    private void fillViewUp(int repetitions){
        commentLinearLayout.clearAllComments();
        for(int i = 0; i < repetitions; i++){
            if(isEven(i)){
                commentLinearLayout.addComment(generateCommentText(i));
            } else {
                commentLinearLayout.addComment(generateCommentText(i), getNumberOfSubComments());
            }
        }
    }

    private String generateCommentText(int id){
        return "Row number " + (id + 1);
    }

    private int getNumberOfSubComments(){
        final int min = 1;
        final int max = 12;
        return new Random().nextInt((max - min) + 1);
    }

    private boolean isEven(int n){
        return ((n % 2) == 0);
    }
}
