package com.supsim.redditcommentview;


import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CommentLinearLayout extends LinearLayout {

    public CommentLinearLayout(Context context){
        this(context, null);
    }

    public CommentLinearLayout(Context context, AttributeSet attributeSet){
        this(context, attributeSet, 0);
    }

    public CommentLinearLayout(Context context, AttributeSet attributeSet, int defStyle){
        super(context, attributeSet, defStyle);
        setOrientation(VERTICAL);
    }

    public void addComment(String comment){
        addView(createRow(comment));
    }

    public void addComment(String comment, int subcomments){
        addView(createRowWithSubComments(comment, subcomments));
    }

    public void clearAllComments(){
        removeAllViews();
    }

    private View createRow(String comment){
        LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.comment_row, null);
        TextView authorText = (TextView)view.findViewById(R.id.authorTextView);
        TextView commentText = (TextView)view.findViewById(R.id.commentTextView);

        authorText.setText("Author Here");
        commentText.setText(comment);

        return view;
    }

    private View createRowWithSubComments(String comment, int subcomments){
        LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.comment_row_with_replies, null);

        TextView authorText = (TextView)view.findViewById(R.id.authorTextView);
        TextView commentText = (TextView)view.findViewById(R.id.commentTextView);
        LinearLayout replyHolder = (LinearLayout)view.findViewById(R.id.replies_holder);

        authorText.setText("Popular Author");
        commentText.setText(comment + " with " + subcomments + " replies");
        for(int i = 0; i < subcomments; i++){
            replyHolder.addView(createReplyRow(i + 1));
        }
        return view;
    }

    private View createReplyRow(int id){
        TextView textView = new TextView(getContext());
        textView.setText("Reply Number " + id);
        return textView;
    }
}
