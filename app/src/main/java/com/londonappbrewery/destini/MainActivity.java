package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    Button mButtonTop;
    Button mButtonBottom;
    TextView mStoryTextView;
    int mStoryIndex=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mStoryTextView = findViewById(R.id.storyTextView);
        mButtonTop = findViewById(R.id.buttonTop);
        mButtonBottom = findViewById(R.id.buttonBottom);

        //default screen view
        mStoryTextView.setText(R.string.T1_Story);
        mButtonTop.setText(R.string.T1_Ans1);
        mButtonBottom.setText(R.string.T1_Ans2);

        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        if(mStoryIndex == 1){
            buttonPressed();
        }else if(mStoryIndex == 2){
            buttonPressed();
        }else if(mStoryIndex == 3 || mStoryIndex == 4){
            buttonPressed();
        }

        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:


    }

    private void buttonPressed() {
        //button one pressed
        mButtonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String buttonTop = "buttonTop";
                updateFateAsPerChoice(buttonTop, mStoryIndex);
            }
        });
        //button two pressed
        mButtonBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String buttonDown = "buttonDown";
                updateFateAsPerChoice(buttonDown, mStoryIndex);
            }
        });
    }

    private void updateFateAsPerChoice(String buttonPressed,int storyIndex){
            if(storyIndex == 1){
                if(buttonPressed.equalsIgnoreCase("buttonDown")){
                    fetchT2Story();
                    mStoryIndex++;
                }else{
                    fetchT3Story();
                    mStoryIndex = mStoryIndex+3;
                }
            }else if(storyIndex == 2){
                if(buttonPressed.equalsIgnoreCase("buttonDown")){
                    fetchT4EndStory();

                }else{
                    fetchT3Story();
                    mStoryIndex++;
                }
            } else if(storyIndex == 4 || storyIndex == 3){
                if(buttonPressed.equalsIgnoreCase("buttonDown")){
                    fetchT5EndStory();
                }else{
                    fetchT6EndStory();
                }

            }

    }
    private void fetchT3Story(){
        mStoryTextView.setText(R.string.T3_Story);
        mButtonTop.setText(R.string.T3_Ans1);
        mButtonBottom.setText(R.string.T3_Ans2);
    }
    private void fetchT2Story(){
        mStoryTextView.setText(R.string.T2_Story);
        mButtonTop.setText(R.string.T2_Ans1);
        mButtonBottom.setText(R.string.T2_Ans2);
    }
    private void fetchT5EndStory(){
        mStoryTextView.setText(R.string.T5_End);
        mButtonTop.setVisibility(View.GONE);
        mButtonBottom.setVisibility(View.GONE);
    }
    private void fetchT6EndStory(){
        mStoryTextView.setText(R.string.T6_End);
        mButtonTop.setVisibility(View.GONE);
        mButtonBottom.setVisibility(View.GONE);
    }
    private void fetchT4EndStory(){
        mStoryTextView.setText(R.string.T4_End);
        mButtonTop.setVisibility(View.GONE);
        mButtonBottom.setVisibility(View.GONE);
    }
}
