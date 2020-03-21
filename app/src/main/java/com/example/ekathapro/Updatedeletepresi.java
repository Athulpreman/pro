package com.example.ekathapro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Updatedeletepresi extends AppCompatActivity {
    EditText uni,plc,mob,user;
    Button btnSer,btnDel,btnUpd;
    DatabaseReference reference;
    Spinner wa,no;
    Unitpres unitpres;
    String war,untno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatedeletepresi);
        btnSer=(Button)findViewById( R.id.search );
        btnDel=(Button)findViewById( R.id.delete );
        btnUpd=(Button)findViewById( R.id.update );
        uni=(EditText)findViewById( R.id.unitnam);
        plc=(EditText)findViewById( R.id.plce );
        mob=(EditText)findViewById( R.id.mob );
        wa=(Spinner) findViewById( R.id.ward);
        no=(Spinner) findViewById( R.id.unitno);

        user=(EditText)findViewById( R.id.usrnam );


        btnSer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                war=wa.getSelectedItem().toString().trim();
             untno=no.getSelectedItem().toString().trim();

                reference= FirebaseDatabase.getInstance().getReference().child(war);
                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot dataSnapshot1:dataSnapshot.getChildren())
                        {
                            Unitpres unitpres=dataSnapshot1.getValue(Unitpres.class);
                            if (unitpres.uno.equals(untno))
                            {
                                uni.setText(unitpres.una );
                                plc.setText(unitpres.upl);
                                mob.setText( unitpres.umo);
                                user.setText( unitpres.uus);
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
        btnUpd.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                war=wa.getSelectedItem().toString().trim();
                untno=no.getSelectedItem().toString().trim();
                reference= FirebaseDatabase.getInstance().getReference().child(war).child(untno);
                Query query=reference.orderByChild("status").equalTo(true);


            }
        } );
    }
}
