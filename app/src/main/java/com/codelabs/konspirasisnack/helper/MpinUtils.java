package com.codelabs.konspirasisnack.helper;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import java.util.List;

public class MpinUtils {

    public static View.OnClickListener getOnClickText(List<EditText> listET, String txt) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (EditText et : listET)
                    if (TextUtils.isEmpty(et.getText().toString())) {
                        et.setText(txt);
                        break;
                    }

            }
        };
    }

    public static View.OnClickListener getClearAllText(List<EditText> listET) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (EditText et : listET)
                    et.setText(null);
            }
        };
    }

    public static View.OnClickListener getClearText(List<EditText> listET) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for (int i = listET.size(); i > 0; i--) {
                    EditText et = listET.get(i-1);
                    if (!TextUtils.isEmpty(et.getText().toString())) {
                        et.setText(null);
                        break;
                    }
                }
            }
        };
    }
}
