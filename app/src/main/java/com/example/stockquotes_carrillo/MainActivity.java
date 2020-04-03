package com.example.stockquotes_carrillo;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import java.io.IOException;

import edu.cofc.stock.Stock;

public class MainActivity extends AppCompatActivity {

    TextInputEditText searchBarInputTxt;
    TextView symbolTxt, nameTxt, lastTradePriceTxt, lastTradeTimeTxt, changeTxt, weekRangeTxt;
    Thread thread;
    String stockNameFromUser;
    Boolean hasThreadRan = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchBarInputTxt = findViewById(R.id.textInputEditText);
        symbolTxt = findViewById(R.id.symbolNameTxtId);
        nameTxt = findViewById(R.id.nameTxtId);
        lastTradePriceTxt = findViewById(R.id.lastTradePriceTxtId);
        lastTradeTimeTxt = findViewById(R.id.lastTradeTimeTxtId);
        changeTxt = findViewById(R.id.changeTxtId);
        weekRangeTxt = findViewById(R.id.weekRangeTxtId);

        searchBarInputTxt.setOnKeyListener(new View.OnKeyListener() {

            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(searchBarInputTxt.getText() != null && stockNameFromUser != null && !(searchBarInputTxt.getText().toString().trim().equals(stockNameFromUser))) {
                    hasThreadRan = false;
                }

                // added this check to prevent thread from running twice.
                if(keyCode == KeyEvent.KEYCODE_ENTER && !hasThreadRan) {
                    runThread();
                }

                return false;
            }
        });
    }

    // this function creates Thread instance and checks for valid inputs
    // otherwise it calls inputError function to display error message.
    private void runThread(){
            thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    hasThreadRan = true;
                    try{
                        if(searchBarInputTxt.getText() != null){
                            stockNameFromUser = searchBarInputTxt.getText().toString().trim();
                            // reset input text field to an
                            searchBarInputTxt.setText(stockNameFromUser);
                        }
                        if (stockNameFromUser != null && !stockNameFromUser.isEmpty()) {
                            getStockValuesSetUp(stockNameFromUser);
                        } else {
                            inputError(stockNameFromUser);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });

        thread.start();
    }

    // creates Stock instance and loads stock data,
    // if not found it calls inputError function to display error message.
    private void getStockValuesSetUp(String stockNameFromUser) {
        Stock stockCalled = new Stock(stockNameFromUser);
        try {
            stockCalled.load();

            symbolTxt.setText((!stockCalled.getSymbol().equals("null") ? stockCalled.getSymbol() : "N/A"));
            nameTxt.setText((!stockCalled.getName().equals("null") ? stockCalled.getName() : "N/A") );
            lastTradePriceTxt.setText((!stockCalled.getLastTradePrice().equals("null") ? stockCalled.getLastTradePrice() : "N/A") );
            lastTradeTimeTxt.setText((!stockCalled.getLastTradeTime().equals("null") ? stockCalled.getLastTradeTime() : "N/A"));
            changeTxt.setText((!stockCalled.getChange().equals("null") ? stockCalled.getChange() : "N/A") );
            weekRangeTxt.setText((!stockCalled.getRange().equals("null") ? stockCalled.getRange() : "N/A"));

        } catch (IOException e) {
            e.printStackTrace();
            inputError(stockNameFromUser);
        }
    }

    public void inputError(final String stockNameFromUser) {
        MainActivity.this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // reset values if entry is not found
                symbolTxt.setText("");
                nameTxt.setText("");
                lastTradePriceTxt.setText("");
                lastTradeTimeTxt.setText("");
                changeTxt.setText("");
                weekRangeTxt.setText("");
                // display error message.
                Toast errorToast = Toast.makeText(MainActivity.this, stockNameFromUser + " is an invalid entry, please try again! ", Toast.LENGTH_SHORT);
                errorToast.show();
            }
        });
    }

    // saves current values for rotation
    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);

        String searchBarInputTxtTemp = searchBarInputTxt.getText().toString();
        outState.putString("searchBarInputTxt", searchBarInputTxtTemp);

        String symbolTxtTemp = symbolTxt.getText().toString();
        outState.putString("symbolTxt", symbolTxtTemp);

        String nameTxtTemp = nameTxt.getText().toString();
        outState.putString("nameTxt", nameTxtTemp);

        String lastTradePriceTxtTemp = lastTradePriceTxt.getText().toString();
        outState.putString("lastTradePriceTxt", lastTradePriceTxtTemp);

        String lastTradeTimeTxtTemp = lastTradeTimeTxt.getText().toString();
        outState.putString("lastTradeTimeTxt", lastTradeTimeTxtTemp);

        String weekRangeTxtTemp = weekRangeTxt.getText().toString();
        outState.putString("weekRangeTxt", weekRangeTxtTemp);
    }

    // retrieves values after rotations sets the values.
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedState){
        super.onRestoreInstanceState(savedState);

        String searchBarInputTxtTemp = savedState.getString( "searchBarInputTxt");
        searchBarInputTxt.setText(searchBarInputTxtTemp);

        String symbolTxtTemp = savedState.getString( "symbolTxt");
        symbolTxt.setText(symbolTxtTemp);

        String nameTxtTemp = savedState.getString( "nameTxt");
        nameTxt.setText(nameTxtTemp);

        String lastTradePriceTxtTemp = savedState.getString( "lastTradePriceTxt");
        lastTradePriceTxt.setText(lastTradePriceTxtTemp);

        String lastTradeTimeTxtTemp = savedState.getString( "lastTradeTimeTxt");
        lastTradeTimeTxt.setText(lastTradeTimeTxtTemp);

        String weekRangeTxtTemp = savedState.getString( "weekRangeTxt");
        weekRangeTxt.setText(weekRangeTxtTemp);
    }
}
