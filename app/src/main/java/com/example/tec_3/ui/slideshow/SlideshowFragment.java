package com.example.tec_3.ui.slideshow;
//AUTOR : CCUNO CARLOS PAUL ARNALDO //
// REDIRECCION A LA DESCARGA DEL JUEGO//
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.tec_3.R;

public class SlideshowFragment extends Fragment {

    private SlideshowViewModel slideshowViewModel;
    private WebView juego;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                ViewModelProviders.of(this).get(SlideshowViewModel.class);
        final View root = inflater.inflate(R.layout.fragment_slideshow, container, false);
        juego=(WebView)root.findViewById(R.id.webview);
        juego.getSettings().setJavaScriptEnabled(true);
        juego.loadUrl("https://drive.google.com/drive/folders/1Dh__o_wXDLqapL7b2WG09InU1XiYk0oW?usp=sharing");
        return root;
    }
}