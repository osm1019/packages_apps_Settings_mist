/*
 * Copyright (C) 2021 The Android Open Source Project
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

package com.android.settings.widget;

import android.content.Context;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Looper;
import android.telephony.TelephonyManager;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import com.android.settings.R;
import com.android.settings.network.MobileNetworkPreferenceController;

import androidx.preference.Preference;
import androidx.preference.PreferenceViewHolder;
import java.util.Set;

/** A customized layout for homepage preference. */
public class HomepagePreference extends Preference implements
        HomepagePreferenceLayoutHelper.HomepagePreferenceLayout {
        

    private final HomepagePreferenceLayoutHelper mHelper;

    public HomepagePreference(Context context, AttributeSet attrs, int defStyleAttr,
                              int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        mHelper = new HomepagePreferenceLayoutHelper(this);
    }

    public HomepagePreference(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mHelper = new HomepagePreferenceLayoutHelper(this);
    }

    public HomepagePreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        mHelper = new HomepagePreferenceLayoutHelper(this);
    }

    public HomepagePreference(Context context) {
        super(context);
        mHelper = new HomepagePreferenceLayoutHelper(this);
    }

    @Override
    public void onBindViewHolder(PreferenceViewHolder holder) {
        super.onBindViewHolder(holder);
        mHelper.onBindViewHolder(holder);
    }

    @Override
    public HomepagePreferenceLayoutHelper getHelper() {
        return mHelper;
    }

}
