package com.example.sharedelementtransition;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.sharedelementtransition.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

       /* binding.sharedImageView.setOnClickListener(v->{
            Intent intent=new Intent(this, MainActivity2.class);
            //ActivityOptionsCompat options= ActivityOptionsCompat.makeScaleUpAnimation(binding.sharedImageView,100,100,400,400);//"image_transition");
            ActivityOptionsCompat options= ActivityOptionsCompat.makeSceneTransitionAnimation(this,binding.sharedImageView,"image_transition");
            //ActivityOptionsCompat options= ActivityOptionsCompat.makeClipRevealAnimation(binding.sharedImageView,100,100,400,400);
            startActivity(intent,options.toBundle());
        });*/

        binding.scaleUp.setOnClickListener(v->{
            Intent intent=new Intent(this, MainActivity2.class);
            ActivityOptionsCompat options= ActivityOptionsCompat.makeScaleUpAnimation(binding.sharedImageView,200,200,0,0);//"image_transition");
            startActivity(intent,options.toBundle());
        });

        binding.clipReveal.setOnClickListener(v->{
            Intent intent=new Intent(this, MainActivity2.class);
            ActivityOptions options = ActivityOptions.makeClipRevealAnimation(binding.sharedImageView, 0, 0, 0,0);
            startActivity(intent,options.toBundle());
        });

        binding.sharedElement.setOnClickListener(v->{
            Intent intent=new Intent(this, MainActivity2.class);
            ActivityOptionsCompat options= ActivityOptionsCompat.makeSceneTransitionAnimation(this,binding.sharedImageView,"image_transition");
            startActivity(intent,options.toBundle());
        });

    }
}