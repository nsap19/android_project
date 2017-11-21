package net.skhu.a201532028;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class Exam2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam2);

        CompoundButton.OnCheckedChangeListener listener1 = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(buttonView.isChecked()==true) {
                    String s = String.format("%s 선택되었습니다.", buttonView.getText());
                    Toast.makeText(Exam2Activity.this, s, Toast.LENGTH_SHORT).show();
                }else{
                    String s = String.format("%s 선택이 취소되었습니다.", buttonView.getText());
                    Toast.makeText(Exam2Activity.this, s, Toast.LENGTH_SHORT).show();
                }
            }
        };
        final CheckBox checkBox1 = (CheckBox) findViewById(R.id.checkBox_cat);
        final CheckBox checkBox2 = (CheckBox) findViewById(R.id.checkBox_dog);
        checkBox1.setOnCheckedChangeListener(listener1);
        checkBox2.setOnCheckedChangeListener(listener1);


        RadioGroup.OnCheckedChangeListener listener2 = new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = (RadioButton) findViewById(checkedId);
                String s = String.format("%s 선택되었습니다.", radioButton.getText().toString());
                Toast.makeText(Exam2Activity.this, s, Toast.LENGTH_SHORT).show();
            }
        };
        final RadioGroup radioGroup1 = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup1.setOnCheckedChangeListener(listener2);

        Button button = (Button)findViewById(R.id.btnSave2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s="";
                if(checkBox1.isChecked()){
                    s+=checkBox1.getText().toString()+"선택되었습니다. ";
                }
                if(checkBox2.isChecked()){
                    s+=checkBox2.getText().toString()+"선택되었습니다. ";
                }

                switch (radioGroup1.getCheckedRadioButtonId()) {
                    case R.id.radioButton_metro: s += "지하철 선택되었습니다 "; break;
                    case R.id.radioButton_bus: s += "버스 선택되었습니다. "; break;

                }
                TextView t = (TextView)findViewById(R.id.textView2);
                t.setText(s);
            }
        });

    }
}
