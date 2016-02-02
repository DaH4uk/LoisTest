package com.myApplication.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.myApplication.shared.ContractsDataSet;

import java.util.List;

@RemoteServiceRelativePath("MainFormService")
public interface MainFormService extends RemoteService {

    String getMessage(String msg);


    public static class App {
        private static MainFormServiceAsync ourInstance = GWT.create(MainFormService.class);

        public static synchronized MainFormServiceAsync getInstance() {
            return ourInstance;
        }
    }

//    List<ContractsDataSet> getAllContracts();
//    ContractsDataSet saveContract(ContractsDataSet contractsDataSet);


}
