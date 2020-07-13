package com.example.tec_3.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.tec_3.Login;
import com.example.tec_3.R;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.auth.FirebaseAuth;
import com.squareup.picasso.Picasso;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView name = root.findViewById(R.id.name);
        final Button button2=root.findViewById(R.id.button2);
        final ImageView profile_image=root.findViewById(R.id.profile_image);
        GoogleSignInAccount signInAccount= GoogleSignIn.getLastSignedInAccount(root.getContext());
        if(signInAccount!=null){
            name.setText(signInAccount.getDisplayName());
            Picasso.get().load(signInAccount.getPhotoUrl()).placeholder(R.mipmap.ic_launcher).into(profile_image);
        }
        button2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                FirebaseAuth.getInstance().signOut();
                Intent intent= new Intent(root.getContext(), Login.class);
                startActivity(intent);
            }
        });
        VideoView videoView1=(VideoView)root.findViewById(R.id.videoView);
        Uri path1=Uri.parse("https://firebasestorage.googleapis.com/v0/b/tec-3-281117.appspot.com/o/app-transporte-publico-segunda-parte%20(1).mp4?alt=media&token=5ecedc4d-33bd-447e-9d6e-31c8c5aa052f");
        videoView1.setVideoURI(path1);
        videoView1.start();
        MediaController mediaController=new MediaController(root.getContext());
        videoView1.setMediaController(mediaController);
        mediaController.setAnchorView(videoView1);
        return root;
    }
}