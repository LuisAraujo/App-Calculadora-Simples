package com.example.clculoimc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Tela1 extends AppCompatActivity {

    private Button bt_p;
    private EditText peso, altura;
    private TextView result1, result2, cla_g, cla_y, cla_r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela1);

        peso = (EditText) findViewById(R.id.edt_p);
        altura = (EditText) findViewById(R.id.edt_a);
        result1 = (TextView) findViewById(R.id.result);
        result2 = (TextView) findViewById(R.id.result2);
        cla_g = (TextView) findViewById(R.id.classif);
        cla_y = (TextView) findViewById(R.id.classify);
        cla_r = (TextView) findViewById(R.id.classifr);
        bt_p = (Button) findViewById(R.id.btn_calc);

        bt_p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String vp = peso.getText().toString();
                String va = altura.getText().toString();

                if (vp.isEmpty() || va.isEmpty()) {

                    alert("Existem campos vazios, por favor preencha todos os campos");

                } else {

                    double imc = Double.parseDouble(vp) * Math.pow(Double.parseDouble(va), 2);

                    if (imc < 17) {

                        result1.setText("IMC = " + imc);
                        result2.setText("Nossa! Se cuide, seu IMC está MUITO ABAIXO DO NORMAL!");
                        cla_r.setText("Cuidado!");


                    } else {

                        if (imc >= 17 && imc < 18.49) {

                            result1.setText("IMC = " + imc);
                            result2.setText("Hey! Se cuide, seu IMC está ABAIXO DO NORMAL!");
                            cla_y.setText("Razoável!");

                        } else {

                            if (imc >= 18.49 && imc < 24.99) {

                                result1.setText("IMC = " + imc);
                                result2.setText("Parabéns! Seu IMC está NORMAL!");
                                cla_g.setText("Muito bem!");

                            } else {

                                if (imc >= 25 && imc < 29.99) {

                                    result1.setText("IMC = " + imc);
                                    result2.setText("Ops! Seu IMC está ACIMA DO NORMAL!");
                                    cla_y.setText("Excesso!");

                                } else {

                                    if (imc >= 30 && imc < 34.99) {

                                        result1.setText("IMC = " + imc);
                                        result2.setText("Psiu! Seu IMC está em nível de OBESIDADE I!");
                                        cla_y.setText("Cuidado!");

                                    } else {

                                        if (imc >= 35 && imc < 39.99) {

                                            result1.setText("IMC = " + imc);
                                            result2.setText("Atenção! Seu IMC está em nível de OBESIDADE II (severa)!");
                                            cla_y.setText("Crítico!");
                                        } else {

                                            if (imc >= 40) {

                                                result1.setText("IMC = " + imc);
                                                result2.setText("Cuide-se urgentemente! Seu IMC está em nível de OBESIDADE III (móbida)!");
                                                cla_r.setText("Alerta vermelho!");
                                            }

                                        }
                                    }
                                }
                            }
                        }
                    }

                }
            }
        });

    }

    private void alert(String s) {

        Toast.makeText(this, s, Toast.LENGTH_LONG).show();

    }
}