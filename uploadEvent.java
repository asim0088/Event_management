package com.example.eventmanagementprojectformygroup;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.eventmanagementprojectformygroup.databinding.ActivityUploadEventBinding;
import com.example.eventmanagementprojectformygroup.databinding.ActivityEventBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class uploadEvent extends AppCompatActivity {

    ActivityUploadEventBinding binding;

    String userName,email,EventName,timeduration,Date;
    FirebaseDatabase db;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUploadEventBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());


        binding.registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userName = binding.etusername.getText().toString();
                email = binding.etemail.getText().toString();
                EventName = binding.etMedicineName.getText().toString();
                timeduration= binding.etquantity.getText().toString();
                Date = binding.editTextNumber.getText().toString();

                if (!userName.isEmpty() && !email.isEmpty() && !EventName.isEmpty() && !timeduration.isEmpty() && !Date.isEmpty()){
                    Users users = new Users(userName,email,EventName,timeduration,Date);

                    db =FirebaseDatabase.getInstance();
                    reference = db.getReference("Users");
                    reference.child(userName).setValue(users).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            binding.etusername.setText("");
                            binding.etemail.setText("");
                            binding.etMedicineName.setText("");
                            binding.etquantity.setText("");
                            binding.editTextNumber.setText("");
                        }
                    });
                }
            }
        });
    }
}