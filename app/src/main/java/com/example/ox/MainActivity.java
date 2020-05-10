package com.example.ox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn,nprt,rjr;
    TextView role_de,sc1,sc2;
    int cpt = 0;
    int pl1 = 0;
    int pl2 = 0;
    int tour = 1;
    int m=0;
    int jeu[][] = {{-1,-1,-1},{-1,-1,-1},{-1,-1,-1}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nprt = (Button) findViewById(R.id.new_part);
        rjr = (Button) findViewById(R.id.rejouer);
        role_de = (TextView) findViewById(R.id.tour_de);
        sc1 = (TextView) findViewById(R.id.pl1sc);
        sc2 = (TextView) findViewById(R.id.pl2sc);
        sc1.setText("player01 : \n"+pl1);
        sc2.setText("player02 : \n"+pl2);
        role_de.setText("role de : player"+tour);
        rjr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replay();
            }
        });
        //replay();
    }

    public void play(View view) {
        btn =(Button)view;

        switch (btn.getId()){
            case R.id.btn00:
                if (jeu[0][0]== -1){
                    jeu[0][0]=tour;
                    if (tour==1){
                        btn.setText("X");
                    }
                    else {
                        btn.setText("O");
                    }
                    cpt ++;
                }
                break;
            case R.id.btn01:
                if (jeu[0][1]== -1){
                    jeu[0][1]=tour;
                    if (tour==1){
                        btn.setText("X");

                    }
                    else {
                        btn.setText("O");
                    }
                    cpt ++;
                }
                break;
            case R.id.btn02:
                if (jeu[0][2]== -1){
                    jeu[0][2]=tour;
                    if (tour==1){
                        btn.setText("X");

                    }
                    else {
                        btn.setText("O");
                    }
                    cpt ++;
                }
                break;
            case R.id.btn10:
                if (jeu[1][0]== -1){
                    jeu[1][0]=tour;
                    if (tour==1){
                        btn.setText("X");

                    }
                    else {
                        btn.setText("O");
                    }
                    cpt ++;
                }
                break;
            case R.id.btn11:
                if (jeu[1][1]== -1){
                    jeu[1][1]=tour;
                    if (tour==1){
                        btn.setText("X");

                    }
                    else {
                        btn.setText("O");
                    }
                    cpt ++;
                }
                break;
            case R.id.btn12:
                if (jeu[1][2]== -1){
                    jeu[1][2]=tour;
                    if (tour==1){
                        btn.setText("X");

                    }
                    else {
                        btn.setText("O");
                    }
                    cpt ++;
                }
                break;
            case R.id.btn20:
                if (jeu[2][0]== -1){
                    jeu[2][0]=tour;
                    if (tour==1){
                        btn.setText("X");

                    }
                    else {
                        btn.setText("O");
                    }
                    cpt ++;
                }
                break;
            case R.id.btn21:
                if (jeu[2][1]== -1){
                    jeu[2][1]=tour;
                    if (tour==1){
                        btn.setText("X");

                    }
                    else {
                        btn.setText("O");
                    }
                    cpt ++;
                }

                break;
            case R.id.btn22:
                if (jeu[2][2]== -1){
                    jeu[2][2]=tour;
                    if (tour==1){
                        btn.setText("X");

                    }
                    else {
                        btn.setText("O");
                    }
                    cpt ++;
                }

                break;
        }
        verifie();
        if(m<cpt){
            if(tour == 1){tour=2;} else{tour=1;}
            role_de.setText("player"+tour);
            m = cpt;
        }
        if (cpt==9)
            replay();
    }

    public void verifie(){
        for (int i=0; i<3; i++){
            int j=0;
            if ((jeu[i][j]==jeu[i][j+1])&&(jeu[i][j+1]==jeu[i][j+2])&&(jeu[i][j]!=-1)){
                Toast.makeText(MainActivity.this, "Player "+tour+" win this one",Toast.LENGTH_LONG).show();
                if (tour==1){
                    pl1=pl1+1;
                    String sc=""+pl1;
                    sc1.setText("player01 : \n"+sc);
                    replay();
                }
                else if (tour==2){
                    pl2=pl2+1;
                    String sc=""+pl2;
                    sc2.setText("player02 : \n"+sc);
                    replay();
                }

            }
        }

        for (int j=0; j<3; j++){
            int i=0;
            if ((jeu[i][j]==jeu[i+1][j])&&(jeu[i+1][j]==jeu[i+2][j])&&(jeu[i][j]!=-1)){
                Toast.makeText(MainActivity.this, "Player "+tour+" win this one",Toast.LENGTH_LONG).show();
                if (tour==1){
                    pl1=pl1+1;
                    String sc=""+pl1;
                    sc1.setText("player01 : \n"+sc);
                    replay();
                }
                else if (tour==2){
                    pl2=pl2+1;
                    String sc=""+pl2;
                    sc2.setText("player02 : \n"+sc);
                    replay();
                }

            }
        }

        if (((jeu[0][0]==jeu[1][1])&&(jeu[1][1]==jeu[2][2])&&(jeu[0][0]!=-1))||((jeu[0][2]==jeu[1][1])&&(jeu[1][1]==jeu[2][0])&&(jeu[0][2]!=-1))){
            Toast.makeText(MainActivity.this, "Player "+tour+" win this one",Toast.LENGTH_LONG).show();
            if (tour==1){
                pl1=pl1+1;
                String sc=""+pl1;
                sc1.setText("player01 : \n"+sc);
                replay();
            }
            else if (tour==2){
                pl2=pl2+1;
                String sc=""+pl2;
                sc2.setText("player02 : \n"+sc);
                replay();
            }
        }

    }
    public void replay() {
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                jeu[i][j]=-1;
            }
        }
        cpt = 0 ;
        m = 0;
        btn = (Button)findViewById(R.id.btn00); btn.setText("");
        btn = (Button)findViewById(R.id.btn01); btn.setText("");
        btn = (Button)findViewById(R.id.btn02); btn.setText("");
        btn = (Button)findViewById(R.id.btn10); btn.setText("");
        btn = (Button)findViewById(R.id.btn11); btn.setText("");
        btn = (Button)findViewById(R.id.btn12); btn.setText("");
        btn = (Button)findViewById(R.id.btn20); btn.setText("");
        btn = (Button)findViewById(R.id.btn21); btn.setText("");
        btn = (Button)findViewById(R.id.btn22); btn.setText("");
        //role_de.setText("player"+tour);
    }

    public void new_part(View view) {
        //cpt = 0 ;
        pl1 = 0;
        pl2 = 0;
        sc1.setText("player01 : "+pl1);
        sc2.setText("player02 : "+pl2);
        //btn = (Button)view;
        replay();
    }
}
