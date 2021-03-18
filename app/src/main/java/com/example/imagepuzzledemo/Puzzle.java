package com.example.imagepuzzledemo;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.security.Policy;
import java.util.ArrayList;
import java.util.Random;

public class Puzzle extends AppCompatActivity implements View.OnClickListener {
    //All Image
    //img_no<----| |-------->Tile no
    int Allimg[][][] = {{{R.drawable.pic1_3_1, R.drawable.pic1_3_2, R.drawable.pic1_3_3, R.drawable.pic1_3_4, R.drawable.pic1_3_5, R.drawable.pic1_3_6, R.drawable.pic1_3_7, R.drawable.pic1_3_8, 0},
                {R.drawable.pic1_4_1,R.drawable.pic1_4_2,R.drawable.pic1_4_3,R.drawable.pic1_4_4,R.drawable.pic1_4_5,R.drawable.pic1_4_6,R.drawable.pic1_4_7,R.drawable.pic1_4_8,R.drawable.pic1_4_9,R.drawable.pic1_4_10, R.drawable.pic1_4_11, R.drawable.pic1_4_12, R.drawable.pic1_4_13, R.drawable.pic1_4_14, R.drawable.pic1_4_15, 0}},
            {{R.drawable.pic2_3_1, R.drawable.pic2_3_2, R.drawable.pic2_3_3, R.drawable.pic2_3_4, R.drawable.pic2_3_5, R.drawable.pic2_3_6, R.drawable.pic2_3_7, R.drawable.pic2_3_8, 0},
                    {R.drawable.pic2_4_1,R.drawable.pic2_4_2,R.drawable.pic2_4_3, R.drawable.pic2_4_4, R.drawable.pic2_4_5, R.drawable.pic2_4_6, R.drawable.pic2_4_7, R.drawable.pic2_4_8, R.drawable.pic2_4_9, R.drawable.pic2_4_10, R.drawable.pic2_4_11, R.drawable.pic2_4_12, R.drawable.pic2_4_13, R.drawable.pic2_4_14, R.drawable.pic2_4_15,0}},
            {{R.drawable.pic3_3_1, R.drawable.pic3_3_2, R.drawable.pic3_3_3, R.drawable.pic3_3_4, R.drawable.pic3_3_5, R.drawable.pic3_3_6, R.drawable.pic3_3_7, R.drawable.pic3_3_8, 0},
                    {R.drawable.pic3_4_1, R.drawable.pic3_4_2, R.drawable.pic3_4_3, R.drawable.pic3_4_4, R.drawable.pic3_4_5, R.drawable.pic3_4_6, R.drawable.pic3_4_7, R.drawable.pic3_4_8, R.drawable.pic3_4_9, R.drawable.pic3_4_10, R.drawable.pic3_4_11, R.drawable.pic3_4_12, R.drawable.pic3_4_13, R.drawable.pic3_4_14, R.drawable.pic3_4_15, 0}},
            {{R.drawable.pic4_3_1,R.drawable.pic4_3_2,R.drawable.pic4_3_3,R.drawable.pic4_3_4,R.drawable.pic4_3_5,R.drawable.pic4_3_6,R.drawable.pic4_3_7,R.drawable.pic4_3_8,0},
                    {R.drawable.pic4_4_1,R.drawable.pic4_4_2,R.drawable.pic4_4_3,R.drawable.pic4_4_4,R.drawable.pic4_4_5,R.drawable.pic4_4_6,R.drawable.pic4_4_7,R.drawable.pic4_4_8,R.drawable.pic4_4_9,R.drawable.pic4_4_10,R.drawable.pic4_4_11,R.drawable.pic4_4_12,R.drawable.pic4_4_13,R.drawable.pic4_4_14,R.drawable.pic4_4_15,0}},
            {{R.drawable.pic5_3_1,R.drawable.pic5_3_2,R.drawable.pic5_3_3,R.drawable.pic5_3_4,R.drawable.pic5_3_5,R.drawable.pic5_3_6,R.drawable.pic5_3_7,R.drawable.pic5_3_8,0},
                    {R.drawable.pic5_4_1,R.drawable.pic5_4_2,R.drawable.pic5_4_3,R.drawable.pic5_4_4,R.drawable.pic5_4_5,R.drawable.pic5_4_6,R.drawable.pic5_4_7,R.drawable.pic5_4_8,R.drawable.pic5_4_9,R.drawable.pic5_4_10,R.drawable.pic5_4_11,R.drawable.pic5_4_12,R.drawable.pic5_4_13,R.drawable.pic5_4_14,R.drawable.pic5_4_15,0}},
            {{R.drawable.pic6_3_1,R.drawable.pic6_3_2,R.drawable.pic6_3_3,R.drawable.pic6_3_4,R.drawable.pic6_3_5,R.drawable.pic6_3_6,R.drawable.pic6_3_7,R.drawable.pic6_3_8,0},
                    {R.drawable.pic6_4_1,R.drawable.pic6_4_2,R.drawable.pic6_4_3,R.drawable.pic6_4_4,R.drawable.pic6_4_5,R.drawable.pic6_4_6,R.drawable.pic6_4_7,R.drawable.pic6_4_8,R.drawable.pic6_4_9,R.drawable.pic6_4_10,R.drawable.pic6_4_11,R.drawable.pic6_4_12,R.drawable.pic6_4_13,R.drawable.pic6_4_14,R.drawable.pic6_4_15,0}},
            {{R.drawable.pic7_3_1,R.drawable.pic7_3_2,R.drawable.pic7_3_3,R.drawable.pic7_3_4,R.drawable.pic7_3_5,R.drawable.pic7_3_6,R.drawable.pic7_3_7,R.drawable.pic7_3_8,0},
                    {R.drawable.pic7_4_1,R.drawable.pic7_4_2,R.drawable.pic7_4_3,R.drawable.pic7_4_4,R.drawable.pic7_4_5,R.drawable.pic7_4_6,R.drawable.pic7_4_7,R.drawable.pic7_4_8,R.drawable.pic7_4_9,R.drawable.pic7_4_10,R.drawable.pic7_4_11,R.drawable.pic7_4_12,R.drawable.pic7_4_13,R.drawable.pic7_4_14,R.drawable.pic7_4_15,0}},
            {{R.drawable.pic8_3_1,R.drawable.pic8_3_2,R.drawable.pic8_3_3,R.drawable.pic8_3_4,R.drawable.pic8_3_5,R.drawable.pic8_3_6,R.drawable.pic8_3_7,R.drawable.pic8_3_8,0},
                    {R.drawable.pic8_4_1,R.drawable.pic8_4_2,R.drawable.pic8_4_3,R.drawable.pic8_4_4,R.drawable.pic8_4_5,R.drawable.pic8_4_6,R.drawable.pic8_4_7,R.drawable.pic8_4_8,R.drawable.pic8_4_9,R.drawable.pic8_4_10,R.drawable.pic8_4_11,R.drawable.pic8_4_12,R.drawable.pic8_4_13,R.drawable.pic8_4_14,R.drawable.pic8_4_15,0}},
            {{R.drawable.pic9_3_1,R.drawable.pic9_3_2,R.drawable.pic9_3_3,R.drawable.pic9_3_4,R.drawable.pic9_3_5,R.drawable.pic9_3_6,R.drawable.pic9_3_7,R.drawable.pic9_3_8,0},
                    {R.drawable.pic9_4_1,R.drawable.pic9_4_2,R.drawable.pic9_4_3,R.drawable.pic9_4_4,R.drawable.pic9_4_5,R.drawable.pic9_4_6,R.drawable.pic9_4_7,R.drawable.pic9_4_8,R.drawable.pic9_4_9,R.drawable.pic9_4_10,R.drawable.pic9_4_11,R.drawable.pic9_4_12,R.drawable.pic9_4_13,R.drawable.pic9_4_14,R.drawable.pic9_4_15,0}},
            {{R.drawable.pic10_3_1,R.drawable.pic10_3_2,R.drawable.pic10_3_3,R.drawable.pic10_3_4,R.drawable.pic10_3_5,R.drawable.pic10_3_6,R.drawable.pic10_3_7,R.drawable.pic10_3_8,0},
                    {R.drawable.pic10_4_1,R.drawable.pic10_4_2,R.drawable.pic10_4_3,R.drawable.pic10_4_4,R.drawable.pic10_4_5,R.drawable.pic10_4_6,R.drawable.pic10_4_7,R.drawable.pic10_4_8,R.drawable.pic10_4_9,R.drawable.pic10_4_10,R.drawable.pic10_4_11,R.drawable.pic10_4_12,R.drawable.pic10_4_13,R.drawable.pic10_4_14,R.drawable.pic10_4_15,0}},
            {{R.drawable.pic11_3_1,R.drawable.pic11_3_2,R.drawable.pic11_3_3,R.drawable.pic11_3_4,R.drawable.pic11_3_5,R.drawable.pic11_3_6,R.drawable.pic11_3_7,R.drawable.pic11_3_8,0},
                    {R.drawable.pic11_4_1,R.drawable.pic11_4_2,R.drawable.pic11_4_3,R.drawable.pic11_4_4,R.drawable.pic11_4_5,R.drawable.pic11_4_6,R.drawable.pic11_4_7,R.drawable.pic11_4_8,R.drawable.pic11_4_9,R.drawable.pic11_4_10,R.drawable.pic11_4_11,R.drawable.pic11_4_12,R.drawable.pic11_4_13,R.drawable.pic11_4_14,R.drawable.pic11_4_15,0}},
            {{R.drawable.pic12_3_1,R.drawable.pic12_3_2,R.drawable.pic12_3_3,R.drawable.pic12_3_4,R.drawable.pic12_3_5,R.drawable.pic12_3_6,R.drawable.pic12_3_7,R.drawable.pic12_3_8,0},
                    {R.drawable.pic12_4_1,R.drawable.pic12_4_2,R.drawable.pic12_4_3,R.drawable.pic12_4_4,R.drawable.pic12_4_5,R.drawable.pic12_4_6,R.drawable.pic12_4_7,R.drawable.pic12_4_8,R.drawable.pic12_4_9,R.drawable.pic12_4_10,R.drawable.pic12_4_11,R.drawable.pic12_4_12,R.drawable.pic12_4_13,R.drawable.pic12_4_14,R.drawable.pic12_4_15,0}},
            {{R.drawable.pic13_3_1,R.drawable.pic13_3_2,R.drawable.pic13_3_3,R.drawable.pic13_3_4,R.drawable.pic13_3_5,R.drawable.pic13_3_6,R.drawable.pic13_3_7,R.drawable.pic13_3_8,0},
                    {R.drawable.pic13_4_1,R.drawable.pic13_4_2,R.drawable.pic13_4_3,R.drawable.pic13_4_4,R.drawable.pic13_4_5,R.drawable.pic13_4_6,R.drawable.pic13_4_7,R.drawable.pic13_4_8,R.drawable.pic13_4_9,R.drawable.pic13_4_10,R.drawable.pic13_4_11,R.drawable.pic13_4_12,R.drawable.pic13_4_13,R.drawable.pic13_4_14,R.drawable.pic13_4_15,0}},
            {{R.drawable.pic14_3_1,R.drawable.pic14_3_2,R.drawable.pic14_3_3,R.drawable.pic14_3_4,R.drawable.pic14_3_5,R.drawable.pic14_3_6,R.drawable.pic14_3_7,R.drawable.pic14_3_8,0},
                    {R.drawable.pic14_4_1,R.drawable.pic14_4_2,R.drawable.pic14_4_3,R.drawable.pic14_4_4,R.drawable.pic14_4_5,R.drawable.pic14_4_6,R.drawable.pic14_4_7,R.drawable.pic14_4_8,R.drawable.pic14_4_9,R.drawable.pic14_4_10,R.drawable.pic14_4_11,R.drawable.pic14_4_12,R.drawable.pic14_4_13,R.drawable.pic14_4_14,R.drawable.pic14_4_15,0}}};
    ChooseImage choose_img;         //For which activity button
    MyAdapter adpt;                  //For which image
    Point ptSize = new Point();
    private Toolbar toolbar; ImageView backpress, Tile, Tiles[][] = new ImageView[5][5]; //For the Tile
    // MenuInflater inflater;
    ImageButton PreviousImg, Suffle, NextImg;
    TextView move, CongraDiaWinText;
    MenuInflater inflater;
    int TileWidth, TileHeight, COLUMN=3, ROW=3, IMG_NO=0, LEVEL=0;
    GridLayout grid;                //For GridLayout
    RelativeLayout.LayoutParams Params; //For Layoutparams of ImageView
    RelativeLayout relativeLayout;
    //Images for tile
    int lastTile[][] = {{R.drawable.pic1_3_9,R.drawable.pic2_3_9,R.drawable.pic3_3_9,R.drawable.pic4_3_9,R.drawable.pic5_3_9,R.drawable.pic6_3_9,R.drawable.pic7_3_9,R.drawable.pic8_3_9,R.drawable.pic9_3_9,R.drawable.pic10_3_9,R.drawable.pic11_3_9,R.drawable.pic12_3_9,R.drawable.pic13_3_9,R.drawable.pic14_3_9},
            {R.drawable.pic1_4_16,R.drawable.pic2_4_16,R.drawable.pic3_4_16,R.drawable.pic4_4_16,R.drawable.pic5_4_16,R.drawable.pic6_4_16,R.drawable.pic7_4_16,R.drawable.pic8_4_16,R.drawable.pic9_4_16,R.drawable.pic10_4_16,R.drawable.pic11_4_16,R.drawable.pic12_4_16,R.drawable.pic13_4_16,R.drawable.pic14_4_16}}, ImageResources[][] = new int[5][5];
    int ID[][] = new int[5][5];
    int Img[]={R.drawable.pic1,R.drawable.pic2,R.drawable.pic3,R.drawable.pic4,R.drawable.pic5,R.drawable.pic6,R.drawable.pic7,R.drawable.pic8,R.drawable.pic9,R.drawable.pic10,R.drawable.pic11,R.drawable.pic12,R.drawable.pic13,R.drawable.pic14};
    int moves;
    //For Sound
    MediaPlayer player;
    //For Full image
    ImageView heart, congraClose, helpClose, CongraDiaImg, HelpDiaImg;
    Button congraOK, HelpOK, Helpbtn;
    //Dialog
    Dialog congrat, help;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle);
        toolbar = findViewById(R.id.appbar);/*
        //Adding heart to toolbar
        heart = new ImageView(this);
        heart.setImageResource(R.drawable.ic_heart_border);
        Params = new RelativeLayout.LayoutParams(50,RelativeLayout.LayoutParams.MATCH_PARENT);
        Params.rightMargin = 60;
        heart.setLayoutParams(Params);
        toolbar.addView(heart);*/
        RelativeLayout relativeLayout = findViewById(R.id.puzzle);
        AnimationDrawable animationDrawable = (AnimationDrawable) relativeLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(null);
        //Initialize Image
        backpress = findViewById(R.id.backpress);
        PreviousImg = findViewById(R.id.Previous);
        Suffle = findViewById(R.id.Suffle);
        NextImg = findViewById(R.id.Next);
        move = findViewById(R.id.move);
        Helpbtn = findViewById(R.id.help);
        //Measuring the window height and width
        getWindowManager().getDefaultDisplay().getSize(ptSize);
        IMG_NO = getIntent().getIntExtra("IMG_NO", 0);
        LEVEL = getIntent().getIntExtra("LEVEL", 0);
        //initialize ROW, COLUMN, LEVEL, IMG_NO
        SetAllMainValue();
        //Winning Sound
        player = MediaPlayer.create(this, R.raw.clappingsound);
        player.setVolume((float) 0.4, (float) 0.4);
        //Set OnClickListener
        PreviousImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(IMG_NO-1>=0){
                    IMG_NO--;
                    Suffle();
                }else finish();
            }
        });
        Suffle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Suffle();               //For Suffle all image
            }
        });
        NextImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(IMG_NO+1< Allimg.length)
                {IMG_NO++;Suffle();}
                else
                    finish();
            }
        });
        //Help Button
        Helpbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowHelpDialog();
            }
        });
        backpress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();               //Return Previous activity
            }
        });
    }
    public void SetAllMainValue(){
        if(LEVEL==0){
            ROW = 3;COLUMN = 3;
            TileWidth = (ptSize.x-40)/COLUMN;
            TileHeight = (ptSize.y-380)/ROW;
        }else{
            ROW = 4;COLUMN = 4;
            TileWidth = (ptSize.x-40)/COLUMN;
            TileHeight = (ptSize.y-380)/ROW;
        }
        //Initialize Everything
        Initialize();
    }
    private void Initialize(){
        grid = findViewById(R.id.grid);
        Params = new RelativeLayout.LayoutParams(TileWidth, TileHeight);
        grid.removeAllViews();
        grid.setColumnCount(COLUMN);
        grid.setRowCount(ROW);
        Params.setMargins(1,1,1,1);
        //Fill up ImageResources array with image
        //Start From here <--------------------------------------------------------------
        //Loading ImageResource[][] with images for tiles
        for(int i=0;i<ROW*COLUMN;i++)
                ImageResources[i/ROW][i%COLUMN] = Allimg[IMG_NO][LEVEL][i];
        //Loading ID[][] with id
        for(int i=0;i<ROW*COLUMN;i++){
            ID[i/ROW][i%COLUMN] = i+1;
        }
        ID[ROW-1][COLUMN-1] = 0;
        //Creating Tile and adding to gridview
        for(int i=0;i<COLUMN*ROW;i++)
        {
            Tile = new ImageView(this);
            Tile.setLayoutParams(Params);
            Tile.setScaleType(ImageView.ScaleType.FIT_XY);
            Tile.setId(ID[i/ROW][i%COLUMN]);
            Tile.setOnClickListener(this);
            Tiles[i/ROW][i%COLUMN] = Tile; //
            grid.addView(Tile);
        }
        Suffle();
    }
    private void Suffle(){
        int k = 0;
        for(int i=0;i<ROW;i++){
            for(int j=0;j<COLUMN;j++){
                Tiles[i][j].setImageResource(Allimg[IMG_NO][LEVEL][k]);
                ImageResources[i][j] = Allimg[IMG_NO][LEVEL][k++];
                Tiles[i][j].setTag(ID[i][j]);
            }
        }
        int r = ROW-1, c = COLUMN-1, index = 0;
        ArrayList<Integer> rowList = new ArrayList<Integer>();
        ArrayList<Integer> colList = new ArrayList<Integer>();
        Random rand = new Random();
        //Suffle by 400 moves
        for(int i=0;i<400;i++) {
            if (r - 1 >= 0) {
                rowList.add(r - 1);
                colList.add(c);
            }
            if (r + 1 < ROW) {
                rowList.add(r + 1);
                colList.add(c);
            }
            if (c - 1 >= 0) {
                rowList.add(r);
                colList.add(c - 1);
            }
            if (c + 1 < COLUMN) {
                rowList.add(r);
                colList.add(c + 1);
            }
            index = rand.nextInt(rowList.size());
            Tiles[r][c].setImageResource(ImageResources[rowList.get(index)][colList.get(index)]);
            ImageResources[r][c] = ImageResources[rowList.get(index)][colList.get(index)];

            Tiles[rowList.get(index)][colList.get(index)].setImageResource(0);
            ImageResources[rowList.get(index)][colList.get(index)] = 0;

            Tiles[r][c].setTag(Tiles[rowList.get(index)][colList.get(index)].getTag());
            Tiles[rowList.get(index)][colList.get(index)].setTag(0);

            r = rowList.get(index);
            c = colList.get(index);

            rowList.clear();
            colList.clear();
        }
            moves = 0;
            move.setText("Move " + moves);
    }


    @Override
    public void onClick(View v) {
        for(int i=0;i<ROW;i++){
            for(int j=0;j<COLUMN;j++){
                if(v.getId()==Tiles[i][j].getId()){
                    Swap(i,j);
                    move.setText("Move "+moves);
                    if(Tiles[ROW-1][COLUMN-1].getTag()==(Integer) 0)
                    {
                        if(isSolved()){
                            //Winning Dialog
                            ShowCongratDialog();
                            //Winning Sound and Change Image
                            player.start();
                        }
                    }
                }
            }
        }
    }

    private boolean isSolved() {
        //Check if game is solved or not
        int k = 0;
        boolean cond = true;
        for(int i=0;i<ROW;i++){
            for(int j=0;j<COLUMN;j++)
                if(Tiles[i][j].getTag()!=(Integer)ID[i][j])
                    cond = cond & false;
        }
        if(cond){
            Tiles[ROW-1][COLUMN-1].setImageResource(lastTile[LEVEL][IMG_NO]);
            Tiles[ROW-1][COLUMN-1].setTag(lastTile[LEVEL][IMG_NO]);
            //Toast.makeText(this, "true", Toast.LENGTH_SHORT).show();
            return true;
        }
        else{
            //Toast.makeText(this, "false", Toast.LENGTH_SHORT).show();
            return false;
        }
    }
    //For Congratulation Dialog
    private void ShowCongratDialog() {
        //For Dialog
        congrat = new Dialog(this);
        congrat.setContentView(R.layout.congratulation_dialog);
        congraClose = congrat.findViewById(R.id.close);
        congraOK = congrat.findViewById(R.id.OK);
        CongraDiaWinText = congrat.findViewById(R.id.moveNum);
        CongraDiaWinText.setText("You used "+moves+" moves to complete");
        //Dialog Button
        congraClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                congrat.dismiss();
            }
        });
        congraOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                congrat.dismiss();
            }
        });
        congrat.show();
    }
    public void ShowHelpDialog(){
        //For Dialog
        help = new Dialog(this);
        help.setContentView(R.layout.help_dialog);
        helpClose = help.findViewById(R.id.close);
        HelpOK = help.findViewById(R.id.OK);
        help.findViewById(R.id.img).setBackgroundResource(Img[IMG_NO]);
        //Dialog Button
        helpClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                help.dismiss();
            }
        });
        HelpOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                help.dismiss();
            }
        });
        help.show();
        help.setCancelable(false);
    }
    //For Swapping with clicked image with empty image
    private void Swap(int r,int c){
        //For Swapping with clicked image with empty image along row
        for(int i=0;i<COLUMN;i++){
            if(Tiles[r][i].getDrawable()==null){
                if(i>c){
                    for(int j=i;j>c;j--){
                        Tiles[r][j].setImageResource(ImageResources[r][j-1]);
                        ImageResources[r][j] = ImageResources[r][j-1];
                        Tiles[r][j].setTag((Integer) Tiles[r][j-1].getTag());
                    }
                    Tiles[r][c].setImageResource(0);
                    ImageResources[r][c] = 0;
                    Tiles[r][c].setTag(0);
                    moves++;
                    return;
                }else if(i<c){
                    for(int j=i;j<c;j++){
                        Tiles[r][j].setImageResource(ImageResources[r][j+1]);
                        ImageResources[r][j] = ImageResources[r][j+1];
                        Tiles[r][j].setTag(Tiles[r][j+1].getTag());
                    }
                    Tiles[r][c].setImageResource(0);
                    ImageResources[r][c] = 0;
                    Tiles[r][c].setTag(0);
                    moves++;
                    return;
                }
            }
        }
        //For Swapping with clicked image with empty image along column
        for(int i=0;i<ROW;i++){
            if(Tiles[i][c].getDrawable()==null){
                if(i>r){
                    for(int j=i;j>r;j--){
                        Tiles[j][c].setImageResource(ImageResources[j-1][c]);
                        ImageResources[j][c] = ImageResources[j-1][c];
                        Tiles[j][c].setTag(Tiles[j-1][c].getTag());
                    }
                    Tiles[r][c].setImageResource(0);
                    ImageResources[r][c] = 0;
                    Tiles[r][c].setTag(0);
                    moves++;
                    return;
                }else if(i<r){
                    for(int j=i;j<r;j++){
                        Tiles[j][c].setImageResource(ImageResources[j+1][c]);
                        ImageResources[j][c] = ImageResources[j+1][c];
                        Tiles[j][c].setTag((Integer) Tiles[j+1][c].getTag());
                    }
                    Tiles[r][c].setImageResource(0);
                    ImageResources[r][c] = 0;
                    Tiles[r][c].setTag(0);
                    moves++;
                    return;
                }
            }
        }
    }
    //More Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        inflater = getMenuInflater();
        inflater.inflate(R.menu.more, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.item1){
            LEVEL = 0;
            SetAllMainValue();
            return true;
        }else if(item.getItemId()==R.id.item2){
            LEVEL = 1;
            SetAllMainValue();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}