package me.jakir.androidsnackbar;

import android.os.Bundle;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button mSimple, mAction;
    private CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinator_layout);


        mSimple = (Button) findViewById(R.id.simple);
        mSimple.setOnClickListener(this);

        mAction = (Button) findViewById(R.id.action_callback);
        mAction.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {

        if(view.getId()==R.id.simple){

            Snackbar snackbar = Snackbar
                    .make(coordinatorLayout, "Hello There!", Snackbar.LENGTH_INDEFINITE);
            snackbar.show();
        }else if(view.getId()==R.id.action_callback){


            Snackbar snackbar = Snackbar
                    .make(coordinatorLayout, "Snackbar with Action", Snackbar.LENGTH_LONG)
                    .setAction("Button", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Snackbar snackbar1 = Snackbar.make(coordinatorLayout, "Action button clicked!", Snackbar.LENGTH_SHORT);
                            snackbar1.show();
                        }
                    });
            snackbar.show();

        }

    }
}
