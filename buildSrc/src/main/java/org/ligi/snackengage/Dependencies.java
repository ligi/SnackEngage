package org.ligi.snackengage;

public class Dependencies {

    public static class Android {

        public static final String APPLICATION_ID = "org.ligi.snackengage";
        public static final int MIN_SDK_VERSION = 14;
        public static final int COMPILE_SDK_VERSION = 33;
        public static final int TARGET_SDK_VERSION = 33;
        public static final int VERSION_CODE = 33;
        public static final String VERSION_NAME = "0.33";

    }

    public static class GradlePlugins {

        public static final String ANDROID = "com.android.tools.build:gradle:8.0.2";
        public static final String VERSIONS = "com.github.ben-manes:gradle-versions-plugin:0.54.0";

    }

    public static class Maven {

        public static final String GROUP_ID = "com.github.ligi.snackengage";

    }

    public static class Libs {

        public static final String ANNOTATION = "androidx.annotation:annotation:1.10.0";
        public static final String APPCOMPAT = "androidx.appcompat:appcompat:1.6.1"; // compileSdk 34 & minSdk 21 are required as of 1.7.0
        public static final String ASSERTJ = "org.assertj:assertj-core:3.27.7";
        public static final String COORDINATOR_LAYOUT = "androidx.coordinatorlayout:coordinatorlayout:1.2.0"; // compileSdk 34 is required as of 1.3.0
        public static final String JUNIT = "junit:junit:4.13.2";
        public static final String MATERIAL = "com.google.android.material:material:1.9.0"; // compileSdk 34 is required as of 1.10.0
        public static final String MOCKITO = "org.mockito:mockito-core:5.23.0";

    }

}
