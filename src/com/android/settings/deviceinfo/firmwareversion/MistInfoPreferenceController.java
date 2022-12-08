/*
 * Copyright (C) 2020 Wave-OS
 * Copyright (C) 2022 Project Arcana
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

package com.android.settings.deviceinfo.firmwareversion;

import android.content.Context;
import android.os.Build;
import android.os.SystemProperties;
import android.widget.TextView;

import androidx.preference.PreferenceScreen;

import com.android.settings.R;
import com.android.settingslib.core.AbstractPreferenceController;
import com.android.settingslib.widget.LayoutPreference;

public class MistInfoPreferenceController extends AbstractPreferenceController {

    private static final String KEY_MIST_INFO = "mist_info";

    private static final String PROP_MIST_VERSION = "ro.mist.version";
    private static final String PROP_MIST_RELEASETYPE = "ro.mist.build_type";
    private static final String PROP_MIST_MAINTAINER = "ro.mist.maintainer";
    private static final String PROP_MIST_DEVICE = "ro.mist.device";

    public MistInfoPreferenceController(Context context) {
        super(context);
    }

    private String getDeviceName() {
        String device = SystemProperties.get(PROP_MIST_DEVICE, "");
        if (device.equals("")) {
            device = Build.MANUFACTURER + " " + Build.MODEL;
        }
        return device;
    }

    private String getMistVersion() {
        final String version = SystemProperties.get(PROP_MIST_VERSION,
                this.mContext.getString(R.string.device_info_default));

        return version + " ";
    }

    private String getMistReleaseType() {
        final String releaseType = SystemProperties.get(PROP_MIST_RELEASETYPE,
                this.mContext.getString(R.string.device_info_default));

        return releaseType.substring(0, 1).toUpperCase() +
                 releaseType.substring(1).toLowerCase();
    }

    @Override
    public void displayPreference(PreferenceScreen screen) {
        super.displayPreference(screen);
        final LayoutPreference MistInfoPreference = screen.findPreference(KEY_MIST_INFO);
        final TextView version = (TextView) MistInfoPreference.findViewById(R.id.version_message);
        final TextView device = (TextView) MistInfoPreference.findViewById(R.id.device_message);
        final TextView releaseType = (TextView) MistInfoPreference.findViewById(R.id.release_type_message);
        final TextView maintainer = (TextView) MistInfoPreference.findViewById(R.id.maintainer_message);
        final String MistVersion = getMistVersion();
        final String MistDevice = getDeviceName();
        final String MistReleaseType = getMistReleaseType();
        final String MistMaintainer = SystemProperties.get(PROP_MIST_MAINTAINER,
                this.mContext.getString(R.string.device_info_default));
        version.setText(MistVersion);
        device.setText(MistDevice);
        releaseType.setText(MistReleaseType);
        maintainer.setText(MistMaintainer);
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
