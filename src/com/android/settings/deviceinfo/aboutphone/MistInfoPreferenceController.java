/*
 * Copyright (C) 2020 Wave-OS
 * Copyright (C) 2021 ShapeShiftOS
 * Copyright (C) 2024 SuperiorExtended-OS
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.settings.deviceinfo.aboutphone;

import android.content.Context;
import android.os.SystemProperties;
import android.widget.TextView;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceScreen;

import com.android.settings.R;
import com.android.settings.utils.MistSpecUtils;
import com.android.settingslib.core.AbstractPreferenceController;
import com.android.settingslib.widget.LayoutPreference;

public class MistInfoPreferenceController extends AbstractPreferenceController {

    private static final String KEY_MIST_INFO = "mist_info";

    public MistInfoPreferenceController(Context context) {
        super(context);
    }

    @Override
    public void displayPreference(PreferenceScreen screen) {
        super.displayPreference(screen);
        final LayoutPreference mistInfoPreference = screen.findPreference(KEY_MIST_INFO);

        if (mistInfoPreference != null) {
            final TextView processor = mistInfoPreference.findViewById(R.id.processor_message);
            final TextView storageAndRAM = mistInfoPreference.findViewById(R.id.storage_code_message);
            final TextView battery = mistInfoPreference.findViewById(R.id.battery_type_message);
            final TextView infoScreen = mistInfoPreference.findViewById(R.id.screen_message);

            Context context = mistInfoPreference.getContext();

            processor.setText(MistSpecUtils.getProcessorModel(context));
            storageAndRAM.setText(MistSpecUtils.getStorageAndRAMInfo(context));
            battery.setText(MistSpecUtils.getBatteryInfo(context));
            infoScreen.setText(MistSpecUtils.getScreenRes(context));
        }
    }

    @Override
    public boolean isAvailable() {
        return true;
    }

    @Override
    public String getPreferenceKey() {
        return KEY_MIST_INFO;
    }
}
