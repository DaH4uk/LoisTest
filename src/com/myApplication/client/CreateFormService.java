package com.myApplication.client;

import com.google.gwt.core.client.GWT;

/**
 * Created by DaH4uk on 01.02.2016.
 */
public interface CreateFormService {
    String getMessage(String msg);

    public static class App {
        private static MainFormServiceAsync ourInstance = GWT.create(CreateFormService.class);

        public static synchronized MainFormServiceAsync getInstance() {
            return ourInstance;
        }
    }
}
