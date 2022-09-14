package cl.ucn.disc.dsm.clasesdsm;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import cl.ucn.disc.dsm.clasesdsm.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;
    private EditText txt_search;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        }
        );
        binding.thirthbutton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view1) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.toThirth);
            }
        }
        );
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void navegate() {
        Intent i = new Intent(this.getContext(), ActivityWeb.class);
        i.putExtra("url", txt_search.getText().toString());
        startActivity(i);
    }

}