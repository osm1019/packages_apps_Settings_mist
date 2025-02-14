/*
 * Copyright (C) 2024 MistOS
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

package com.android.settings.deviceinfo.aboutphone

import android.content.Context
import android.widget.TextView
import androidx.preference.PreferenceScreen
import com.android.settings.R
import com.android.settings.utils.MistSpecUtils
import com.android.settingslib.core.AbstractPreferenceController
import com.android.settingslib.widget.LayoutPreference

class MistInfoPreferenceController(context: Context) : AbstractPreferenceController(context) {

    companion object {
        private const val KEY_MIST_INFO = "mist_info"
        private const val KEY_STORAGE = "storage"
        private const val KEY_CHIPSET = "chipset"
        private const val KEY_BATTERY = "battery"
        private const val KEY_DISPLAY = "display"
    }

    override fun displayPreference(screen: PreferenceScreen) {
        super.displayPreference(screen)
        val mistInfoPreference = screen.findPreference<LayoutPreference>(KEY_MIST_INFO)

        mistInfoPreference?.let {
            val processor = it.findViewById<TextView>(R.id.chipset_summary)
            val storageAndRAM = it.findViewById<TextView>(R.id.cust_storage_summary)
            val battery = it.findViewById<TextView>(R.id.cust_battery_summary)
            val infoScreen = it.findViewById<TextView>(R.id.cust_display_summary)

            if (processor != null && storageAndRAM != null && battery != null && infoScreen != null) {
                val context = it.context

                processor.text = MistSpecUtils.getProcessorModel(context)
                storageAndRAM.text = MistSpecUtils.getStorageAndRAMInfo(context)
                battery.text = MistSpecUtils.getBatteryCapacity(context)
                infoScreen.text = MistSpecUtils.getScreenRes(context)
            }
        }
    }

    override fun isAvailable(): Boolean {
        return true
    }

    override fun getPreferenceKey(): String {
        return KEY_MIST_INFO
    }
}
