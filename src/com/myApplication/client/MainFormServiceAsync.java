package com.myApplication.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.myApplication.shared.ContractsDataSet;

import java.util.List;

public interface MainFormServiceAsync {
    void getMessage(String msg, AsyncCallback<String> async);

//    void getAllContracts(AsyncCallback<List<ContractsDataSet>> async);
//
//    void saveContract(ContractsDataSet contractsDataSet, AsyncCallback<ContractsDataSet> async);



}
