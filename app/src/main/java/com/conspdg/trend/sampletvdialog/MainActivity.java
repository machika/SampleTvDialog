/*
 * Copyright (C) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.conspdg.trend.sampletvdialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {
    public static final int DIALOG_SAMPLE = 9999;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showDialog(DIALOG_SAMPLE);
    }

    @Override
    public Dialog onCreateDialog(int id) {
        if (id == DIALOG_SAMPLE) {
            LayoutInflater inflater = getLayoutInflater();
            View dialogContent = inflater.inflate(R.layout.layout_dialog_content, null);
            TextView link = dialogContent.findViewById(R.id.dialog_text);
            link.setMovementMethod(LinkMovementMethod.getInstance());
            return new AlertDialog.Builder(this)
                    .setTitle(R.string.dialog_title)
                    .setView(dialogContent)
                    .setPositiveButton(R.string.button_ok, new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    })
                    .setCancelable(false)
                    .create();
        }
        return null;
    }
}
