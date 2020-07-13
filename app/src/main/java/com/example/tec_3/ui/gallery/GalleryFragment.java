package com.example.tec_3.ui.gallery;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.tec_3.Adaptador_Ruta;
import com.example.tec_3.Mapa;
import com.example.tec_3.Preferencia;
import com.example.tec_3.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class GalleryFragment extends Fragment {
    private DatabaseReference Preferidas;
    ListView list_preferidas;
    ArrayList<Preferencia> arrayList=new ArrayList<>();
    Button pasar;
    private GalleryViewModel galleryViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(GalleryViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        pasar=(Button)root.findViewById(R.id.button4);
        list_preferidas=(ListView)root.findViewById(R.id.lista_preferidas);
        Preferidas= FirebaseDatabase.getInstance().getReference("Preferencia");
        Preferidas.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    for(DataSnapshot ds:dataSnapshot.getChildren()){
                        String id=ds.child("id").getValue().toString();
                        String origen=ds.child("origen").getValue().toString();
                        String destino=ds.child("destino").getValue().toString();
                        Preferencia prefer=new Preferencia(id,origen,destino);
                        arrayList.add(prefer);
                    }
                    list_preferidas.setAdapter((ListAdapter) new Adaptador_Ruta(root.getContext(),arrayList));
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        pasar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                startActivity(new Intent(getActivity(), Mapa.class));
            }
        });
        return root;
    }
}