package org.telegram.messenger;

//import org.telegram.messenger.regular.BuildConfig;

public class ApplicationLoaderImpl extends ApplicationLoader {
    @Override
    protected String onGetApplicationId() {
//        return BuildConfig.APPLICATION_ID;
//        return BuildVars.BUILD_GRAHER;
        return BuildVars.BUILD_DUROV_TG;
    }
}
