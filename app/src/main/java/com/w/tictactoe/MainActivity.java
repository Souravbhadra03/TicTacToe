package com.w.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.support.v7.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int player=1;
    int[] arr={3,3,3,3,3,3,3,3,3};
    int[][] winPosn={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    boolean flag=true;
    public void fade(View view) {
        ImageView img = (ImageView) view;
        int tag = Integer.parseInt(img.getTag().toString());
        tag--;
        if (arr[tag] == 3 && flag)
        {
            img.setTranslationY(-1000f);
            arr[tag] = player;
            if (player == 1)
            {
                img.setImageResource(R.drawable.cross);

                player = 2;
            }
            else
            {
                img.setImageResource(R.drawable.red);

                player = 1;
            }
            img.animate().translationYBy(1000f).setDuration(300);

            for(int[] win:winPosn)
            {
                if(arr[win[0]]==arr[win[1]] && arr[win[1]]==arr[win[2]] && arr[win[0]]!=3)
                {
                    flag=false;
                    String s="Circle Won!";
                    if(arr[win[0]]==1)
                        s="Cross Won!";
                    TextView tv = findViewById(R.id.newGame);
                    LinearLayout ly = findViewById(R.id.lin);
                    tv.setText(s);
                    ly.setVisibility(View.VISIBLE);

                }
                else
                {
                    boolean gameOver=true;
                    for(int x:arr) {
                        if (x == 3)
                            gameOver = false;
                    }
                    if(gameOver) {
                        TextView tv = findViewById(R.id.newGame);
                        LinearLayout ly = findViewById(R.id.lin);
                        tv.setText("Its Draw!");
                        ly.setVisibility(View.VISIBLE);

                    }
                }

            }

        }
    }
    public void nGame(View view)
    {
        LinearLayout ly = findViewById(R.id.lin);
        ly.setVisibility(View.INVISIBLE);
        player=1;
        for(int i=0;i<arr.length;i++)
            arr[i]=3;
        GridLayout gridl= findViewById(R.id.grd);
        for(int i=0;i<gridl.getChildCount();i++)
        {
            ((ImageView) gridl.getChildAt(i)).setImageResource(0);
        }
        flag=true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
