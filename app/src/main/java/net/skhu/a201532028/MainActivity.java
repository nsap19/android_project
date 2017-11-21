package net.skhu.a201532028;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b1 = (Button) findViewById(R.id.openExam1btn);
        Button b2 = (Button) findViewById(R.id.openExam2btn);
        View.OnClickListener listenerObj = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = v.getId();
                if (id == R.id.openExam1btn) {
                    Intent intent = new Intent(MainActivity.this, Exam1Activity.class);
                    startActivity(intent);
                } else if (id == R.id.openExam2btn) {
                    Intent intent = new Intent(MainActivity.this, Exam2Activity.class);
                    startActivity(intent);
                }
            }
        };
        b1.setOnClickListener(listenerObj);
        b2.setOnClickListener(listenerObj);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.action_exam1){
            Intent intent = new Intent(this, Exam1Activity.class);
            startActivity(intent);
            return true;
        }else if(id == R.id.action_exam2){
            Intent intent = new Intent(this, Exam2Activity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
