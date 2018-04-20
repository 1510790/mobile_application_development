package com.example.currencyconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    //money format (12 digits, 2 decimals)
    DecimalFormat orgDf = new DecimalFormat("###,###,###,###.##");

    private final double VND2USD = 0.0000439074;

    // GUI widgets
    Button btnConvert;
    Button btnClear;
    Button btnExchange;
    EditText txtOrgCurrency;
    EditText txtDesCurrency;
    TextView txtvOrg;
    TextView txtvDes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // bind local controls to GUI widgets
        txtOrgCurrency = (  EditText)findViewById(R.id.txtOrgCurrency);
        // make ‘DesCurrency’ box not-editable (no user input)
        txtDesCurrency = (EditText)findViewById(R.id.txtDesCurrency);
        txtDesCurrency.setInputType(EditorInfo.TYPE_NULL);
        // No user input. See layout: android:editable=“false”
        txtvOrg = (TextView) findViewById(R.id.textView2);
        txtvDes = (TextView) findViewById(R.id.textView3);
        // attach click behavior to buttons
        btnClear = (Button) findViewById(R.id.btnClear);
        btnClear.setOnClickListener(new  OnClickListener() {
                            // clear the text boxes
                            @Override
                            public void onClick(View v) {
                                txtOrgCurrency.setText("");
                                txtDesCurrency.setText("" ); }});
        // do the conversion
        btnConvert = (Button) findViewById(R.id.btnConvert);
        btnConvert.setOnClickListener(new  OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                try
                                {
                                    String orgStr = txtOrgCurrency.getText(). toString();
                                    double org = Double.parseDouble(orgStr);
                                    String result;
                                    if(txtvOrg.getText().toString().contains("US Dollars")) {
                                        result = String.valueOf(orgDf.format(org / VND2USD));
                                    }else {
                                        result = String.valueOf(orgDf.format(org  * VND2USD));
                                    }
                                    txtDesCurrency.setText(result);
                                }
                                catch (NumberFormatException e) {
                                    // ignore errors
                                }
                            }
                        });
        btnExchange = (Button) findViewById(R.id.btnReverse);
        btnExchange.setOnClickListener(new  OnClickListener() {
            @Override
            public void onClick(View v) {
                try
                {
                    CharSequence st;

                    st = txtvOrg.getText();
                    txtvOrg.setText(txtvDes.getText());
                    txtvDes.setText(st);

                    if(!txtDesCurrency.getText().toString().isEmpty()) {
                        st = txtOrgCurrency.getText();
                        txtOrgCurrency.setText(txtDesCurrency.getText());
                        txtDesCurrency.setText(st);
                    }


                }
                catch (NumberFormatException e) {
                    // ignore errors
                }
            }
        });
    }
}
