package com.example.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // 필요한 재료준비(멤버구성) 구성요소
    EditText edit1, edit2; // 입력값을 위한 객체
    Button btn_add, btn_sub, btn_mul, btn_div;// 버튼 처리를 위한 객체

    TextView text_Result;  // 결과출력 객체

    // 내부적인 처리를 위한 변수
    Integer result;
    String num1, num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 입력 컴포넌트를 변수로 연결(바인딩)
        edit1 = findViewById(R.id.Edit1);
        edit2 = findViewById(R.id.Edit2);
        btn_add = (Button) findViewById(R.id.btn_add);
        btn_sub = (Button) findViewById(R.id.btn_sub);
        btn_sub = (Button) findViewById(R.id.btn_mul);

        text_Result = findViewById(R.id.txtResult);

        btn_add.setOnClickListener(View -> add());
        btn_sub.setOnClickListener(view -> sub());
        btn_sub.setOnClickListener(view -> mul());

    }

    private void getNum() {
        // 이벤트 등록,  이벤트 처리(+)
        num1 = edit1.getText().toString();
        num2 = edit2.getText().toString();
    }

    private void add() {
        // 이벤트 등록,  이벤트 처리(+)
        getNum();
        // 정수로 변환 후 덧셈
        result = Integer.parseInt(num1) + Integer.parseInt(num2);
        text_Result.setText("결과 : "+ result.toString());
    }

    private void sub() {
        // 이벤트 등록,  이벤트 처리(+)
        getNum();
        // 정수로 변환 후 덧셈
        result = Integer.parseInt(num1) - Integer.parseInt(num2);
        text_Result.setText("결과 : "+ result.toString());
    }

    private void mul() {
        // 이벤트 등록,  이벤트 처리(+)
        getNum();
        // 정수로 변환 후 덧셈
        result = Integer.parseInt(num1) * Integer.parseInt(num2);
        text_Result.setText("결과 : "+ result.toString());
    }

    private void div() {
        // 이벤트 등록,  이벤트 처리(+)
        getNum();
        // 정수로 변환 후 덧셈
        if(Integer.parseInt(num2) != 0){
            result = Integer.parseInt(num1) / Integer.parseInt(num2);
        }else {
            Toast message = Toast.makeText(getApplicationContext(),"0으로 나눌 수 없습니다.",Toast.LENGTH_SHORT);
            message.show();
            result = 0;
        }
        text_Result.setText("결과 : "+ result.toString());
    }
}