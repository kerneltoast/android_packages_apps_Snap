/*
 * Copyright (C) 2013 The Android Open Source Project
 *               2015 The CyanogenMod Project
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

package com.android.camera.app;

import android.app.Application;
import android.content.Context;
import android.os.SystemProperties;

import com.android.camera.util.CameraUtil;
import com.android.camera.util.UsageStatistics;

public class CameraApp extends Application {

    private static Application mApp = null;
    private static String mModel = SystemProperties.get("ro.boot.project_name", null);

    @Override
    public void onCreate() {
        super.onCreate();
        mApp = this;
        UsageStatistics.initialize(this);
        CameraUtil.initialize(this);
    }

    public static Context getContext()
    {
        return mApp.getApplicationContext();
    }

    public static boolean isOnePlus3T() {
        if (mModel != null && mModel.equals("15811")) {
            return true;
        }
        return false;
    }
}
