package com.myApplication.shared;

import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;

import java.util.Date;

/**
 * Created by DaH4uk on 06.02.2016.
 */
public interface PolicyholdersProperties extends PropertyAccess<Policyholders> {


    ModelKeyProvider<Policyholders> id();

    ValueProvider<Policyholders, String> first_name();

    ValueProvider<Policyholders, String> last_name();

    ValueProvider<Policyholders, String> middle_name();

    ValueProvider<Policyholders, Date> birth_date();

    ValueProvider<Policyholders, Integer> passport_serial();

    ValueProvider<Policyholders, Integer> passport_number();

}

