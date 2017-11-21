package net.skhu.a201532028;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Exam1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam1);

        Button b1 = (Button)findViewById(R.id.btnSave2);
        Button b2 = (Button)findViewById(R.id.btnDelete);

        View.OnClickListener listenerObj = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText e = (EditText)findViewById(R.id.editText);
                CharSequence s = e.getText();
                TextView t = (TextView)findViewById(R.id.textView);
                t.append(" "+s);


                String str = e.getText().toString();
                if (isEmptyOrWhiteSpace(str))
                    e.setError("내용을 입력하세요");

                e.setText("");
            }
        };
        b1.setOnClickListener(listenerObj);

        View.OnClickListener listenerObj2 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText e = (EditText)findViewById(R.id.editText);
                TextView t = (TextView)findViewById(R.id.textView);
                t.setText(null);
                e.setText("");
            }
        };
        b2.setOnClickListener(listenerObj2);
    }


        static boolean isEmptyOrWhiteSpace(String s) {
        if (s == null) return true;
        return s.trim().length() == 0;
    }
}
