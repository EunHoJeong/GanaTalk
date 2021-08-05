package com.polared.ganatalk.common.dialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.polared.ganatalk.R;

public class OneButtonDialog extends DialogFragment {
    private TextView content;
    private Button button;

    String contentText;
    String buttonText;
    View.OnClickListener buttonListener;

    public static OneButtonDialog newInstance(String contentText, String buttonText, View.OnClickListener buttonListener) {
        OneButtonDialog dialog = new OneButtonDialog();
        dialog.contentText = contentText;
        dialog.buttonText = buttonText;
        dialog.buttonListener = buttonListener;

        return dialog;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_one_button, container, false);

        widgetFindId(view);

        initWidget();

        initClickEvent();

        setCancelable(false);

        return view;
    }

    private void initWidget() {
        content.setText(contentText);
        button.setText(buttonText);
    }

    private void initClickEvent() {
        button.setOnClickListener(v -> {
            dismiss();
            if (buttonListener != null) {
                buttonListener.onClick(v);
            }
        });
    }

    private void widgetFindId(View view) {
        content = view.findViewById(R.id.dialog_content);
        button = view.findViewById(R.id.dialog_button);
    }
}
