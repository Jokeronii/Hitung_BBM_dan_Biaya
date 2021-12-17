package com.example.hitungbbmbiaya;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText edtTujuan,edtJarak;
    Spinner spnBbm;
    TextView txtJarak,txtTujuan,txtBiaya;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponent();
    }

    private void initComponent(){
        edtTujuan = findViewById(R.id.edtTujuan);
        edtJarak = findViewById(R.id.edtJarak);
        spnBbm = findViewById(R.id.spnBbm);
        txtTujuan = findViewById(R.id.txtTujuan);
        txtJarak = findViewById(R.id.txtJarak);
        txtBiaya = findViewById(R.id.txtBiaya);

        ArrayList<BBM> list_bbm = new ArrayList<>();
        list_bbm.add(new BBM("pertalite",7500));
        list_bbm.add(new BBM("pertamax",10000));
        list_bbm.add(new BBM("solar",5500));
        list_bbm.add(new BBM("dex-lite",6000));

        ArrayAdapter<BBM> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,list_bbm);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnBbm.setAdapter(arrayAdapter);
    }

    public void hitungBBM(View view){
        double liter = Double.parseDouble(edtJarak.getText().toString()) / 2.5;
        int harga = ((BBM)spnBbm.getSelectedItem()).getHarga();
        int biaya = (int)liter * harga;

        txtTujuan.setText("Tujuannya:"+edtTujuan.getText());
        txtJarak.setText("jaraknya:"+edtJarak.getText()+" memerlukan"+liter+"ltr BBM");
        txtBiaya.setText("sehingga biaya yang diperlukan"+ biaya);
    }
}