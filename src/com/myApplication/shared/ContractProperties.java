package com.myApplication.shared;

import com.google.gwt.editor.client.Editor.Path;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.LabelProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;

import java.util.Date;

/**
 * Created by DaH4uk on 02.02.2016.
 */
public interface ContractProperties extends PropertyAccess<ContractsDataSet> {

    @Path("id")
    ModelKeyProvider<ContractsDataSet> id();

    @Path("name")
    LabelProvider<ContractsDataSet> nameLabel();

    ValueProvider<ContractsDataSet, String> contractNumber();

    ValueProvider<ContractsDataSet, Date> date();

    ValueProvider<ContractsDataSet, String> name();

    ValueProvider<ContractsDataSet, String> premium();

    ValueProvider<ContractsDataSet, Date> dateValidUntil();

}
