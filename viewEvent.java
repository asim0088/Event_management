package com.example.eventmanagementprojectformygroup;



import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.eventmanagementprojectformygroup.databinding.ActivityViewEventBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class viewEvent extends AppCompatActivity {


    ActivityViewEventBinding binding;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityViewEventBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.readdataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = binding.etusername.getText().toString();
                if (!userName.isEmpty()){
                    readData(userName);
                }else {
                    Toast.makeText(viewEvent.this, "Plese enter user name", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void readData(String userName) {
        reference = FirebaseDatabase.getInstance().getReference("Users");
        reference.child(userName).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {

                if (task.isSuccessful()){

                    if (task.getResult().exists()){
                        Toast.makeText(viewEvent.this, "Successfully fetch data", Toast.LENGTH_SHORT).show();
                        DataSnapshot dataSnapshot = task.getResult();
                        String  EventName = String.valueOf(dataSnapshot.child("EventName").getValue());
                        String timeduration=  String.valueOf(dataSnapshot.child("timeduration").getValue());
                        String Date =  String.valueOf(dataSnapshot.child("Date").getValue());

                        binding.tvFirstName.setText(EventName);
                        binding.tvLastName.setText(timeduration);
                        binding.tvAge.setText(Date);


                    }else {
                        Toast.makeText(viewEvent.this, "User does not exit", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(viewEvent.this, "Failed to fetch data", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}