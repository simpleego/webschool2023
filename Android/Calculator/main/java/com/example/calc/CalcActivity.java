package com.example.calc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CalcActivity extends AppCompatActivity implements View.OnClickListener {
    // 필요한 재료준비(멤버구성) 구성요소
    EditText edit1, edit2; // 입력값을 위한 객체
    Button btn_mul, btn_div;// 버튼 처리를 위한 객체
    TextView text_Result;  // 결과출력 객체

    // 내부적인 처리를 위한 변수
    Double result;
    String num1, num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        // 입력 컴포넌트를 변수로 연결(바인딩)
        edit1 = findViewById(R.id.Edit1);
        edit2 = findViewById(R.id.Edit2);

        text_Result = findViewById(R.id.txtResult);

        btn_mul = (Button) findViewById(R.id.btn_mul);
        btn_div = (Button) findViewById(R.id.btn_div);

        // 이 클래스에서 이벤트 처리하도록 설정
        btn_mul.setOnClickListener(this);
        btn_div.setOnClickListener(this);
    }

    public void onClick(View v) {
        // 이벤트 등록,  이벤트 처리(+)
        getNum();  // get input numbers;

        if(v.getId() == btn_div.getId()){
            div();
        } else if (v.getId() == btn_mul.getId()) {
            int result = Integer.parseInt(num1) * Integer.parseInt(num2);
            text_Result.setText(String.format("결과 : " + result, "%6d"));
        }
    }

    private void div(){
        // 정수로 변환 후 덧셈
        if(Integer.parseInt(num2) != 0){
            result = (double)Integer.parseInt(num1) / Integer.parseInt(num2);
        }else {
            Toast message = Toast.makeText(getApplicationContext(),"0으로 나눌 수 없습니다.",Toast.LENGTH_SHORT);
            message.show();
            result = 0.0;
        }
        text_Result.setText(String.format("결과 : " + result, "%6.2f"));
    }
    private void getNum() {
        // 이벤트 등록,  이벤트 처리(+)
        num1 = edit1.getText().toString();
        num2 = edit2.getText().toString();
    }
}
