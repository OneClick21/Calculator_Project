package edu.ewubd.calculatorproject;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity {

    private TextView tvExpression, tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvExpression = findViewById(R.id.tvExpression);
        tvResult = findViewById(R.id.tvResult);

        Button button0 = findViewById(R.id.btn0);
        Button button1 = findViewById(R.id.btn1);
        Button button2 = findViewById(R.id.btn2);
        Button button3 = findViewById(R.id.btn3);
        Button button4 = findViewById(R.id.btn4);
        Button button5 = findViewById(R.id.btn5);
        Button button6 = findViewById(R.id.btn6);
        Button button7 = findViewById(R.id.btn7);
        Button button8 = findViewById(R.id.btn8);
        Button button9 = findViewById(R.id.btn9);
        Button buttonAdd = findViewById(R.id.btnAdd);
        Button buttonSubtract = findViewById(R.id.btnSubtract);
        Button buttonMultiply = findViewById(R.id.btnMultiply);
        Button buttonDivide = findViewById(R.id.btnDivide);
        Button buttonEquals = findViewById(R.id.btnEqual);
        Button buttonDot = findViewById(R.id.btnDot);
        Button buttonDelete = findViewById(R.id.btnDelete);
        Button buttonClear = findViewById(R.id.btnClear);

        View.OnClickListener listener = v -> {
            Button b = (Button) v;
            tvExpression.append(b.getText().toString());
        };

        button0.setOnClickListener(listener);
        button1.setOnClickListener(listener);
        button2.setOnClickListener(listener);
        button3.setOnClickListener(listener);
        button4.setOnClickListener(listener);
        button5.setOnClickListener(listener);
        button6.setOnClickListener(listener);
        button7.setOnClickListener(listener);
        button8.setOnClickListener(listener);
        button9.setOnClickListener(listener);
        buttonDot.setOnClickListener(listener);

        buttonAdd.setOnClickListener(v -> tvExpression.append("+"));
        buttonSubtract.setOnClickListener(v -> tvExpression.append("-"));
        buttonMultiply.setOnClickListener(v -> tvExpression.append("*"));
        buttonDivide.setOnClickListener(v -> tvExpression.append("/"));

        buttonEquals.setOnClickListener(v -> {
            String expression = tvExpression.getText().toString();
            try {
                Expression e = new ExpressionBuilder(expression).build();
                double result = e.evaluate();
                tvResult.setText(String.valueOf(result));
            } catch (Exception ex) {
                tvResult.setText("Error");
            }
        });

        buttonDelete.setOnClickListener(v -> {
            String text = tvExpression.getText().toString();
            if (!text.isEmpty()) {
                tvExpression.setText(text.substring(0, text.length() - 1));
            }
        });

        buttonClear.setOnClickListener(v -> {
            String text = tvExpression.getText().toString();
            if (!text.isEmpty()) {
                tvExpression.setText(null);
                tvResult.setText(null);
            }
        });
    }
}
