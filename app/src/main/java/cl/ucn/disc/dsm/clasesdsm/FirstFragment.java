package cl.ucn.disc.dsm.clasesdsm;

import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import cl.ucn.disc.dsm.clasesdsm.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    private EditText txt_number_1, txt_number_2, txt_resp;

    private RadioButton radioButton1, radioButton2, radioButton3, radioButton4;

    private RadioGroup radioGroup;

    private Layout LayoutCheck;

    private CheckBox check1, check2, check3, check4;

    private String txtTempText, selected;

    private Spinner spinner;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);

        txt_number_1 = (EditText) binding.textNumber1;
        txt_number_2 = (EditText) binding.textNumber2;
        txt_resp = (EditText) binding.txtResp;
        radioButton1 = (RadioButton) binding.radioButton1;
        radioButton2 = (RadioButton) binding.radioButton2;
        radioButton3 = (RadioButton) binding.radioButton3;
        radioButton4 = (RadioButton) binding.radioButton4;
        spinner = (Spinner) binding.spOperations;

        String[] operations = {
                "Sumar",
                "Restar",
                "Multiplicar",
                "Dividir",
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this.getContext(), androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, operations);

        spinner.setAdapter(adapter);
        return binding.getRoot();


    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*
                if (radioButton1.isChecked()) {
                    sum();
                } else if (radioButton2.isChecked()) {
                    res();
                } else if (radioButton3.isChecked()) {
                    mult();
                } else if (radioButton4.isChecked()) {
                    div();
                } else {
                    showMessage();
                }
                */ //If else
                /*
                if (check1.isChecked()) {
                    txtTempText += sum();
                }
                if (check2.isChecked()) {
                    res();
                    txtTempText += sum();
                }
                if (check3.isChecked()) {
                    mult();
                    txtTempText += sum();
                }
                if (check4.isChecked()) {
                    div();
                    txtTempText += sum();
                }
                */ //If

                //TODO: Hay que darle el valor selected desde el spinner

                selected = spinner.getTransitionName();

                switch (selected) {
                    case "Sumar": {
                        sum();
                    }
                    case "Restar": {
                        res();
                    }
                    case "Multiplicar": {
                        mult();
                    }
                    case "Dividir": {
                        div();
                    }
                }
            }
        });

    }

    public void showMessage() {
        Toast.makeText(this.getContext(), "No se ha seleccionado ninguna operación", Toast.LENGTH_SHORT).show();
    }

    public void showMessageEmpty() {
        Toast.makeText(this.getContext(), "No se ha seleccionado ninguna opcion", Toast.LENGTH_SHORT).show();
    }

    public String sum() {
        double val_1 = Integer.parseInt(txt_number_1.getText().toString());
        double val_2 = Integer.parseInt(txt_number_2.getText().toString());
        double sum = val_1 + val_2;
        String res = String.valueOf(sum);
        txt_resp.setText(res); //puede haber un error, tal vez sea necesario cambiar el txt_number_1 por txt-resp
        return res;
    }

    public String res() {
        double val_1 = Integer.parseInt(txt_number_1.getText().toString());
        double val_2 = Integer.parseInt(txt_number_2.getText().toString());
        double sum = val_1 - val_2;
        String res = String.valueOf(sum);
        txt_number_1.setText(res);
        return res;
    }

    public String mult() {
        double val_1 = Integer.parseInt(txt_number_1.getText().toString());
        double val_2 = Integer.parseInt(txt_number_2.getText().toString());
        double sum = val_1 * val_2;
        String res = String.valueOf(sum);
        txt_number_1.setText(res);
        return res;
    }

    public String div() {
        double val_1 = Integer.parseInt(txt_number_1.getText().toString());
        double val_2 = Integer.parseInt(txt_number_2.getText().toString());
        if (val_2 == 0) {
            Toast.makeText(this.getContext(), "ERROR: División entre cero", Toast.LENGTH_SHORT).show();
            return "Error";
        }
        double sum = val_1 / val_2;
        String res = String.valueOf(sum);
        txt_number_1.setText(res);
        return res;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}