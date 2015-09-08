package com.example.laghima.persistinternally;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    EditText book_Name, pub_Name, book_Price;
    Button btn_Save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        book_Name = (EditText) findViewById(R.id.bookName);
        pub_Name = (EditText) findViewById(R.id.pubName);
        book_Price = (EditText) findViewById(R.id.bookPrice);
        btn_Save = (Button) findViewById(R.id.btnsave);
        btn_Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String b_name = book_Name.getText().toString();
                String p_name = pub_Name.getText().toString();
                String b_price = book_Price.getText().toString();
                String str = "Book Name" + b_name + "Publisher Name" + p_name + "price of book" + b_price;
                try {
                    FileOutputStream fOut = openFileOutput("bookDetails.txt", MODE_WORLD_READABLE);
                    OutputStreamWriter outstr = new OutputStreamWriter(fOut);
                    outstr.write(str);
                    outstr.flush();
                    outstr.close();
                    fOut.close();
                    Toast.makeText(getBaseContext(), "Book details have been saved" + getFilesDir(), Toast.LENGTH_LONG).show();
                    book_Name.setText("");
                    pub_Name.setText("");
                    book_Price.setText("");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
