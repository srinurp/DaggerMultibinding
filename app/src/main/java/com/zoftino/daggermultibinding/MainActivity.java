package com.zoftino.daggermultibinding;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.zoftino.daggermultibinding.business.DataProvider;
import com.zoftino.daggermultibinding.di.DaggerOrderComponent;
import com.zoftino.daggermultibinding.viewmodel.PaymentTaxViewModel;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    PaymentTaxViewModel ptvm;

    @Inject
    DataProvider dataProviderp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DaggerOrderComponent.create().inject(this);


        final Spinner tax = (Spinner)findViewById(R.id.tax);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, dataProviderp.getTaxZones());
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tax.setAdapter(arrayAdapter);


        tax.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                String taxZone = tax.getSelectedItem().toString();
               double finalPrice = ptvm.calculateTax(dataProviderp.getOrderPrice(), taxZone);
                Toast.makeText(MainActivity.this, "Final price after tax "+finalPrice,Toast.LENGTH_LONG).show();

            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });



        final Spinner payment = (Spinner)findViewById(R.id.payment);
        ArrayAdapter<String> arrayAdapterPayment = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, dataProviderp.getPaymentModes());
        arrayAdapterPayment.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        payment.setAdapter(arrayAdapterPayment);


        payment.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
               String payStatus =  ptvm.payOrderAmount(dataProviderp.getOrderId(), pos);
                Toast.makeText(MainActivity.this, "order status "+payStatus,Toast.LENGTH_LONG).show();
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
}
