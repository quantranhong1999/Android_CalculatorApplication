package com.example.calculatorapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import nguyenvanquan7826.com.Balan;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvMath;
    private TextView tvResult;
    private Button btnCE;
    private Button btnC;
    private Button btnBS;
    private Button btnDiv;
    private Button btn0;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;
    private Button btnMulti;
    private Button btnSub;
    private Button btnPlus;
    private Button btnEqual;
    private Button btnCham;
    private Button btnDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.linearlayout);
        initWidget();
        setEventClickView();
    }

    public void initWidget(){
        tvMath =  findViewById(R.id.tvMath);
        tvResult =  findViewById(R.id.tvResult);
        btnCE = findViewById(R.id.btnCE);
        btnC = findViewById(R.id.btnC);
        btnBS = findViewById(R.id.btnBS);
        btnDiv = findViewById(R.id.btnDiv);
        btn0 = (Button) findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnMulti = findViewById(R.id.btnMulti);
        btnSub = findViewById(R.id.btnSub);
        btnPlus = findViewById(R.id.btnPlus);
        btnCham = findViewById(R.id.btnCham);
        btnDao = findViewById(R.id.btnDao);
        btnEqual = findViewById(R.id.btnEqual);
    }

    public void setEventClickView(){
        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnCE.setOnClickListener(this);
        btnC.setOnClickListener(this);
        btnBS.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        btnMulti.setOnClickListener(this);
        btnPlus.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnEqual.setOnClickListener(this);
        btnCham.setOnClickListener(this);
        btnDao.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btn0:
                tvResult.append("0");
                break;
            case R.id.btn1:
                tvResult.append("1");
                break;
            case R.id.btn2:
                tvResult.append("2");
                break;
            case R.id.btn3:
                tvResult.append("3");
                break;
            case R.id.btn4:
                tvResult.append("4");
                break;
            case R.id.btn5:
                tvResult.append("5");
                break;
            case R.id.btn6:
                tvResult.append("6");
                break;
            case R.id.btn7:
                tvResult.append("7");
                break;
            case R.id.btn8:
                tvResult.append("8");
                break;
            case R.id.btn9:
                tvResult.append("9");
                break;
            case R.id.btnCE: // Xóa số hạng hiện tại
                //nếu tvMath có giá trị
                if(tvMath.getText().length()!=0) {
                    char ce = tvMath.getText().toString().charAt(tvMath.getText().toString().length() - 1);
                    //Nếu đã thực hiện xong phép tính thì xóa cả 2 trường
                    if (Character.toString(ce).equals("=")) {
                        tvResult.setText("");
                        tvMath.setText("");
                        break;
                    }
                }
                //Lúc này tvMath trống, tiến hành xóa tvResult
                tvResult.setText("");
                break;
            case R.id.btnC: // Xóa cả
                tvMath.setText("");
                tvResult.setText("");
                break;
            case R.id.btnBS: // Xóa hàng đơn vị
                String temp = tvResult.getText().toString();
                StringBuilder tempBuilder = new StringBuilder(temp);
                if(tempBuilder.length()!=0) tempBuilder.deleteCharAt(tempBuilder.length()-1);
                tvResult.setText(tempBuilder.toString());

                break;
            case R.id.btnDiv:
                //Nếu tvMath không trống
                if(tvMath.getText().length()!=0){ //Xét ký tự cuối cùng của tvmath
                    char div = tvMath.getText().toString().charAt(tvMath.getText().toString().length()-1);
                    //Hoặc có dấu = tức thực hiện xong phép trước
                    if(Character.toString(div).equals("=")){
                        //Thì đưa giá trị đã tính lên tvMath, set tvResult về empty
                        tvMath.setText(tvResult.getText());
                        tvMath.append("/");
                        tvResult.setText("");
                        break;
                    }

                }
                //Nếu tvMath trống
                if(tvMath.getText().length()==0 && tvResult.getText().length()!=0 && !tvResult.getText().toString().endsWith(".")){ //và tvResult đã nhập rồi, kết thúc khác.
                    //Thì thêm dấu /
                    tvMath.append(tvResult.getText());
                    tvMath.append("/");
                    tvResult.setText("");
                    break;
                }
                //nếu tvMath trống và tvResult chưa nhập gì thì không thêm gì
                break;
            case R.id.btnMulti:
                if(tvMath.getText().length()!=0){
                    char multi = tvMath.getText().toString().charAt(tvMath.getText().toString().length()-1);
                    if(Character.toString(multi).equals("=")){
                        tvMath.setText(tvResult.getText());
                        tvMath.append("*");
                        tvResult.setText("");
                        break;
                    }

                }
                if(tvMath.getText().length()==0&& tvResult.getText().length()!=0 && !tvResult.getText().toString().endsWith(".")){
                    tvMath.append(tvResult.getText());
                    tvMath.append("*");
                    tvResult.setText("");
                    break;
                }
                break;
            case R.id.btnSub:
                if(tvMath.getText().length()!=0){
                    char sub = tvMath.getText().toString().charAt(tvMath.getText().toString().length()-1);
                    if(Character.toString(sub).equals("=")){
                        tvMath.setText(tvResult.getText());
                        tvMath.append("-");
                        tvResult.setText("");
                        break;
                    }

                }
                if(tvMath.getText().length()==0 && tvResult.getText().length()!=0 && !tvResult.getText().toString().endsWith(".")){
                    tvMath.append(tvResult.getText());
                    tvMath.append("-");
                    tvResult.setText("");
                    break;
                }
                break;
            case R.id.btnPlus:
                if(tvMath.getText().length()!=0){
                    char plus = tvMath.getText().toString().charAt(tvMath.getText().toString().length()-1);
                    if(Character.toString(plus).equals("=")){
                        tvMath.setText(tvResult.getText());
                        tvMath.append("+");
                        tvResult.setText("");
                        break;
                    }

                }
                if(tvMath.getText().length()==0 && tvResult.getText().length()!=0 && !tvResult.getText().toString().endsWith(".")){
                    tvMath.append(tvResult.getText());
                    tvMath.append("+");
                    tvResult.setText("");
                    break;
                }

                break;
            case R.id.btnEqual:
                if(tvResult.getText().length()==0 && tvMath.getText().length() ==0) break; // Nếu chưa có gì trên màn hình thì ấn bằng không làm gì
                if(tvMath.getText().length()!=0) {
                    char equal = tvMath.getText().toString().charAt(tvMath.getText().toString().length() - 1);
                    if(Character.toString(equal).matches("=")) break;
                    if (Character.toString(equal).matches("[^0-9]") && (tvResult.getText().length() == 0))
                        break;
                }
                //Nếu tvResult nhập ví dụ 6. thì không làm gì
                if(tvResult.getText().toString().endsWith(".")) break;
                tvMath.append(tvResult.getText());
                cal();
                tvMath.append("=");

                break;
            case R.id.btnCham:
                if(tvResult.getText().toString().contains(".")) break;
                tvResult.append(".");
                break;
            case R.id.btnDao:
                daoDau(tvResult);
                break;
        }
    }
    private void cal(){
        Balan balan = new Balan();
        String math = tvMath.getText().toString().trim();

        String result = balan.valueMath(math)+"";
        tvResult.setText(result);
    }
    private void daoDau(TextView v){
        int vLength = v.getText().length();
        //Nếu đã có dấu trừ đằng trước tvResult thì xóa
        if(v.getText().toString().contains("-")) v.setText(v.getText().toString().substring(1,vLength));
            else{ //Nếu chưa có dấu trừ đằng trước thì thêm
                String vString = new StringBuilder("-").append(v.getText().toString()).toString();
                v.setText(vString);
        }
    }
}
