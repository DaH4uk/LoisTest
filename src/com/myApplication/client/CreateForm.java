package com.myApplication.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.user.client.ui.*;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.core.client.util.Rectangle;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.Dialog;
import com.sencha.gxt.widget.core.client.Window;
import com.sencha.gxt.widget.core.client.button.CellButtonBase;
import com.sencha.gxt.widget.core.client.button.IconButton;
import com.sencha.gxt.widget.core.client.button.SplitButton;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.HorizontalLayoutContainer.HorizontalLayoutData;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.event.SelectEvent.SelectHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.sencha.gxt.core.client.Style;
import com.sencha.gxt.core.client.util.DateWrapper;
import com.sencha.gxt.widget.core.client.FramedPanel;
import com.sencha.gxt.widget.core.client.container.BoxLayoutContainer.BoxLayoutPack;
import com.sencha.gxt.widget.core.client.container.CssFloatLayoutContainer;
import com.sencha.gxt.widget.core.client.event.FocusEvent;
import com.sencha.gxt.widget.core.client.form.*;
import com.sencha.gxt.widget.core.client.form.FormPanel;
import com.sencha.gxt.widget.core.client.form.TextArea;
import com.sencha.gxt.widget.core.client.form.validator.EmptyValidator;
import com.sencha.gxt.widget.core.client.form.validator.MaxNumberValidator;
import com.sencha.gxt.widget.core.client.form.validator.MinNumberValidator;
import com.sencha.gxt.widget.core.client.info.Info;

import java.util.Date;
import java.util.List;

import static com.sencha.gxt.widget.core.client.container.CssFloatLayoutContainer.*;
import static com.sencha.gxt.widget.core.client.form.FormPanelHelper.getFieldLabels;
import static com.sencha.gxt.widget.core.client.form.NumberPropertyEditor.*;


public class CreateForm implements IsWidget, EntryPoint {

    private FramedPanel framedPanel;


    public Widget asWidget() {
        if (framedPanel == null) {

            final IntegerField insuranceSum = new IntegerField();
            insuranceSum.setAllowBlank(false);

            insuranceSum.addValueChangeHandler(new ValueChangeHandler<Integer>() {
                @Override
                public void onValueChange(ValueChangeEvent<Integer> event) {
                    try {
                        Integer.parseInt(insuranceSum.getText());
                    } catch (Exception e) {
                        Info.display("Внимание!", "Введите коррекное значение в поле страховая сумма!");

                    }

                }
            });

            final DateField validFrom = new DateField();
            final DateField validUntil = new DateField();

            final DateTimeFormat format = DateTimeFormat.getFormat("dd.MM.yyyy");


            validFrom.setPropertyEditor(new DateTimePropertyEditor(format));
            validFrom.getDatePicker().setMinDate(new DateWrapper().addDays(0).asDate());
            validUntil.getDatePicker().setMinDate(new DateWrapper().addDays(0).asDate());
            validFrom.setAllowBlank(false);


            validFrom.addValueChangeHandler(new ValueChangeHandler<Date>() {
                @Override
                public void onValueChange(ValueChangeEvent<Date> event) {
                    Date selectedValidDate = event.getValue();

                    long difference = (selectedValidDate.getTime() - (new Date()).getTime()) / (24 * 60 * 60 * 1000) + 1;
                    validUntil.getDatePicker().setMinDate(new DateWrapper().addDays((int) difference).asDate());
                    validUntil.getDatePicker().setMaxDate(new DateWrapper().addDays((int) difference + 365).asDate());
                    validUntil.setValue(selectedValidDate);
                }
            });


            validUntil.setAllowBlank(false);
            validUntil.setPropertyEditor(new DateTimePropertyEditor(format));


            final StringComboBox propertyType = new StringComboBox();
            propertyType.add("Квартира");
            propertyType.add("Дом");
            propertyType.add("Комната");
            propertyType.setAllowBlank(false);


            final StringComboBox yearOfConstruction = new StringComboBox();
            yearOfConstruction.setAllowBlank(false);
            yearOfConstruction.setHideTrigger(true);
            for (int i = 2016; i >= 1900; i--) {
                yearOfConstruction.add("" + i);
            }


            yearOfConstruction.addFocusHandler(new FocusEvent.FocusHandler() {
                @Override
                public void onFocus(FocusEvent event) {
                    yearOfConstruction.getCell();
                }
            });


            yearOfConstruction.addValueChangeHandler(new ValueChangeHandler<String>() {
                @Override
                public void onValueChange(ValueChangeEvent<String> event) {
                    try {
                        if (Integer.parseInt(yearOfConstruction.getValue()) > 2016) {
                            Info.display("Внимание!", "Год постройки должен быть не больше текущего года!");

                        }
                        if (yearOfConstruction.getValue().length() != 4) {
                            Info.display("Внимание!", "Введите год постройки корректной длины!");
                        }
                    } catch (Exception e) {
                        Info.display("Внимание!", "Введите корректный год постройки!");

                    }
                }
            });


            final NumberField<Float> areaValue = new NumberField<Float>(new FloatPropertyEditor());
            areaValue.setAllowBlank(false);
            areaValue.addValidator(new EmptyValidator<Float>());
            areaValue.setFormat(NumberFormat.getFormat("0.0"));

            final DateField calculationDate = new DateField();
            calculationDate.setPropertyEditor(new DateTimePropertyEditor(format));
            calculationDate.setEditable(false);
            calculationDate.setEnabled(false);


            final NumberField<Float> premiumValue = new NumberField<Float>(new FloatPropertyEditor());
            premiumValue.setAllowBlank(false);
            premiumValue.addValidator(new EmptyValidator<Float>());
            premiumValue.addValidator(new MinNumberValidator<Float>((float) 0));
            premiumValue.setFormat(NumberFormat.getFormat("0.00"));


            SelectHandler selectHandler = new SelectHandler() {
                @Override
                public void onSelect(SelectEvent event) {
                    int countDays = validUntil.getValue().getDate() - validFrom.getValue().getDate();

                    float coefficientPropertyType = 0;
                    switch (propertyType.getValue()) {
                        case "Квартира":
                            coefficientPropertyType = (float) 1.7;
                            break;
                        case "Дом":
                            coefficientPropertyType = (float) 1.5;
                            break;
                        case "Комната":
                            coefficientPropertyType = (float) 1.3;
                            break;
                    }

                    float coefficientYearOfConstruction = 0;

                    if (Integer.parseInt(yearOfConstruction.getValue()) < 2000) {
                        coefficientYearOfConstruction = (float) 1.3;
                    } else if (Integer.parseInt(yearOfConstruction.getValue()) >= 2000 && Integer.parseInt(yearOfConstruction.getValue()) < 2015) {
                        coefficientYearOfConstruction = (float) 1.6;
                    } else if (Integer.parseInt(yearOfConstruction.getValue()) >= 2015) {
                        coefficientYearOfConstruction = (float) 2;
                    }

                    float coefficientArea = 0;

                    if (areaValue.getValue() < 50) {
                        coefficientArea = (float) 1.2;
                    } else if (areaValue.getValue() >= 50 && areaValue.getValue() <= 100) {
                        coefficientArea = (float) 1.5;
                    } else if (areaValue.getValue() > 100) {
                        coefficientArea = (float) 2;
                    }

                    float premium = (insuranceSum.getValue() / countDays) * coefficientPropertyType * coefficientYearOfConstruction * coefficientArea;
                    premiumValue.setValue(premium);
                    calculationDate.setValue(new Date());

                }
            };
            TextButton calculateButton = new TextButton("Рассчитать", selectHandler);


            CssFloatLayoutContainer calculationContainer = new CssFloatLayoutContainer();
            Label insuranceSumLabel = new Label("Страховая сумма");
            calculationContainer.add(insuranceSumLabel, new CssFloatData(0.15, new Margins(0, 0, 10, 25)));
            calculationContainer.add(insuranceSum, new CssFloatData(0.3, new Margins(0, 10, 10, 25)));
            Label validFromLabel = new Label("Срок действия с");
            calculationContainer.add(validFromLabel, new CssFloatData(0.15, new Margins(0, 0, 10, 25)));
            calculationContainer.add(validFrom, new CssFloatData(0.15, new Margins(0, 10, 10, 0)));
            Label validUntilLabel = new Label("до");
            calculationContainer.add(validUntilLabel, new CssFloatData(0.05, new Margins(0, 0, 10, 25)));
            calculationContainer.add(validUntil, new CssFloatData(0.15, new Margins(0, 25, 10, 0)));

            Label propertyTypeLabel = new Label("Тип недвижимости");
            calculationContainer.add(propertyTypeLabel, new CssFloatData(0.15, new Margins(0, 0, 10, 25)));
            calculationContainer.add(propertyType, new CssFloatData(0.85, new Margins(0, 634, 10, 25)));

            Label yearOfConstructionLabel = new Label("Год постройки");
            calculationContainer.add(yearOfConstructionLabel, new CssFloatData(0.15, new Margins(0, 0, 0, 25)));
            calculationContainer.add(yearOfConstruction, new CssFloatData(0.85, new Margins(0, 634, 10, 25)));

            Label areaValueLabel = new Label("Площадь, кв.м.");
            calculationContainer.add(areaValueLabel, new CssFloatData(0.15, new Margins(0, 0, 0, 25)));
            calculationContainer.add(areaValue, new CssFloatData(0.85, new Margins(0, 634, 10, 25)));


            calculationContainer.add(calculateButton, new CssFloatData(1, new Margins(15, 510, 25, 510)));

            Label calculationDateLabel = new Label("Дата расчета");
            calculationContainer.add(calculationDateLabel, new CssFloatData(0.15, new Margins(0, 0, 0, 25)));
            calculationContainer.add(calculationDate, new CssFloatData(0.3, new Margins(0, 10, 10, 25)));

            Label premiumValueLabel = new Label("Премия");
            calculationContainer.add(premiumValueLabel, new CssFloatData(0.1, new Margins(0, 0, 10, 25)));
            calculationContainer.add(premiumValue, new CssFloatData(0.45, new Margins(0, 85, 10, 57)));


            FieldSet fieldSet = new FieldSet();
            fieldSet.setHeading("Расчет");
            fieldSet.setCollapsible(true);
            fieldSet.add(calculationContainer);

            //TODO: Не должны повторяться
            IntegerField contractNumber = new IntegerField();
            contractNumber.setAllowBlank(false);
            contractNumber.addValidator(new EmptyValidator<Integer>());
            contractNumber.addValidator(new MinNumberValidator<Integer>(000001));
            contractNumber.addValidator(new MaxNumberValidator<Integer>(999999));
            contractNumber.setAutoValidate(true);


            final DateField conclusionDate = new DateField();
            conclusionDate.setPropertyEditor(new DateTimePropertyEditor(format));
            conclusionDate.setEditable(false);
            calculationDate.setHideTrigger(true);
            conclusionDate.setEnabled(false);
            conclusionDate.setValue(new Date());

            //TODO: Добавить обработчик для кнопки

            TextButton selectButton = new TextButton("Выбрать", new SelectHandler() {
                @Override
                public void onSelect(SelectEvent event) {
                    SelectWindow selectWindow = new SelectWindow();
                    selectWindow.asWidget();
                    selectWindow.selectWindow.show();


                    // constrain the window to the viewport (for small mobile screen sizes)
                    Rectangle bounds = selectWindow.selectWindow.getElement().getBounds();
                    Rectangle adjusted = selectWindow.selectWindow.getElement().adjustForConstraints(bounds);
                    if (adjusted.getWidth() != bounds.getWidth() || adjusted.getHeight() != bounds.getHeight()) {
                        selectWindow.selectWindow.setPixelSize(adjusted.getWidth(), adjusted.getHeight());
                    }
                }
            });
            selectButton.setWidth(10);

            TextField fioTextField = new TextField();
            fioTextField.setAllowBlank(false);
            fioTextField.setEnabled(false);

            //TODO: Добавить слушателя для кнопки
            TextButton changeButton = new TextButton("Изменить");

            DateField birthDate = new DateField();
            birthDate.setPropertyEditor(new DateTimePropertyEditor(format));
            birthDate.setAllowBlank(false);

            IntegerField passportSeriesField = new IntegerField();
            passportSeriesField.setAllowBlank(false);
            passportSeriesField.addValidator(new MaxNumberValidator<Integer>(9999));
            passportSeriesField.addValidator(new MinNumberValidator<Integer>(1000));
            passportSeriesField.setAutoValidate(true);

            IntegerField passportNumberField = new IntegerField();
            passportNumberField.setAllowBlank(false);
            passportNumberField.addValidator(new MaxNumberValidator<Integer>(999999));
            passportNumberField.addValidator(new MinNumberValidator<Integer>(100000));
            passportNumberField.setAutoValidate(true);

            StringComboBox countryCombobox = new StringComboBox();
            countryCombobox.setAllowBlank(false);

            TextField indexField = new TextField();

            TextField republicField = new TextField();
            republicField.setAllowBlank(false);

            TextField districtField = new TextField();

            TextField localityField = new TextField();
            localityField.setAllowBlank(false);

            TextField streetField = new TextField();
            streetField.setAllowBlank(false);

            IntegerField houseField = new IntegerField();

            TextField housingField = new TextField();

            TextField buildingField = new TextField();

            IntegerField apartmentField = new IntegerField();
            apartmentField.setAllowBlank(false);

            TextArea commentArea = new TextArea();
            commentArea.setHeight(75);


            CssFloatLayoutContainer contractRegistration = new CssFloatLayoutContainer();

            Label contractNumberLabel = new Label("№ договора");
            contractRegistration.add(contractNumberLabel, new CssFloatData(0.15, new Margins(25, 0, 10, 40)));
            contractRegistration.add(contractNumber, new CssFloatData(0.3, new Margins(25, 10, 10, 25)));

            Label conclusionDateLabel = new Label("Дата заключения");
            contractRegistration.add(conclusionDateLabel, new CssFloatData(0.15, new Margins(25, 0, 10, 25)));
            contractRegistration.add(conclusionDate, new CssFloatData(0.4, new Margins(25, 100, 10, 0)));

            Label policyholderLabel = new Label("СТРАХОВАТЕЛЬ");
            policyholderLabel.setStyleName("mainLabel");
            contractRegistration.add(policyholderLabel, new CssFloatData(1, new Margins(0, 10, 10, 37)));

            contractRegistration.add(selectButton, new CssFloatData(0.15, new Margins(10, 10, 10, 37)));
            contractRegistration.add(new Label("ФИО"), new CssFloatData(0.07, new Margins(15, 10, 0, 25)));
            contractRegistration.add(fioTextField, new CssFloatData(0.63, new Margins(10, 10, 10, 0)));
            contractRegistration.add(changeButton, new CssFloatData(0.15, new Margins(10, 10, 10, 25)));

            contractRegistration.add(new Label("Дата рождения"), new CssFloatData(0.15, new Margins(15, 10, 10, 37)));
            contractRegistration.add(birthDate, new CssFloatData(0.22, new Margins(10, 10, 10, 25)));
            contractRegistration.add(new Label("Паспорт   серия"), new CssFloatData(0.23, new Margins(15, 10, 10, 140)));
            contractRegistration.add(passportSeriesField, new CssFloatData(0.15, new Margins(10, 10, 10, 0)));
            contractRegistration.add(new Label("№"), new CssFloatData(0.1, new Margins(15, 10, 10, 90)));
            contractRegistration.add(passportNumberField, new CssFloatData(0.15, new Margins(10, 10, 10, 25)));


            Label addressOfBuildingLabel = new Label("АДРЕС НЕДВИЖИМОСТИ");
            addressOfBuildingLabel.setStyleName("mainLabel");
            contractRegistration.add(addressOfBuildingLabel, new CssFloatData(1, new Margins(10, 10, 10, 37)));

            contractRegistration.add(countryCombobox, new CssFloatData(0.15, new Margins(10, 10, 0, 37)));
            contractRegistration.add(indexField, new CssFloatData(0.15, new Margins(10, 10, 0, 25)));
            contractRegistration.add(republicField, new CssFloatData(0.35, new Margins(10, 10, 0, 25)));
            contractRegistration.add(districtField, new CssFloatData(0.35, new Margins(10, 10, 0, 25)));

            Label countryLabel = new Label("государство");
            countryLabel.setStyleName("underFieldLabel");
            contractRegistration.add(countryLabel, new CssFloatData(0.15, new Margins(0, 10, 10, 25)));
            Label indexLabel = new Label("индекс");
            indexLabel.setStyleName("underFieldLabel");
            contractRegistration.add(indexLabel, new CssFloatData(0.15, new Margins(0, 10, 10, 25)));
            Label republicLabel = new Label("республика, край, область");
            republicLabel.setStyleName("underFieldLabel");
            contractRegistration.add(republicLabel, new CssFloatData(0.35, new Margins(0, 10, 10, 25)));
            Label districtLabel = new Label("район");
            districtLabel.setStyleName("underFieldLabel");
            contractRegistration.add(districtLabel, new CssFloatData(0.35, new Margins(0, 10, 10, 25)));


            contractRegistration.add(localityField, new CssFloatData(0.15, new Margins(10, 10, 0, 37)));
            contractRegistration.add(streetField, new CssFloatData(0.5, new Margins(10, 10, 0, 25)));
            contractRegistration.add(houseField, new CssFloatData(0.0875, new Margins(10, 10, 0, 25)));
            contractRegistration.add(housingField, new CssFloatData(0.0875, new Margins(10, 10, 0, 10)));
            contractRegistration.add(buildingField, new CssFloatData(0.0875, new Margins(10, 10, 0, 10)));
            contractRegistration.add(apartmentField, new CssFloatData(0.0875, new Margins(10, 10, 0, 10)));


            Label localityLabel = new Label("населенный пункт");
            localityLabel.setStyleName("underFieldLabel");
            contractRegistration.add(localityLabel, new CssFloatData(0.15, new Margins(0, 10, 0, 25)));
            Label streetLabel = new Label("улица");
            streetLabel.setStyleName("underFieldLabel");
            contractRegistration.add(streetLabel, new CssFloatData(0.5, new Margins(0, 10, 0, 25)));
            Label houseLabel = new Label("дом");
            houseLabel.setStyleName("underFieldLabel");
            contractRegistration.add(houseLabel, new CssFloatData(0.0875, new Margins(0, 10, 0, 25)));
            Label housingLabel = new Label("корпус");
            housingLabel.setStyleName("underFieldLabel");
            contractRegistration.add(housingLabel, new CssFloatData(0.0875, new Margins(0, 10, 0, 10)));
            Label buildingLabel = new Label("строение");
            buildingLabel.setStyleName("underFieldLabel");
            contractRegistration.add(buildingLabel, new CssFloatData(0.0875, new Margins(0, 10, 0, 10)));
            Label apartmentLabel = new Label("квартира");
            apartmentLabel.setStyleName("underFieldLabel");
            contractRegistration.add(apartmentLabel, new CssFloatData(0.0875, new Margins(0, 10, 0, 10)));

            Label commentLabel = new Label("КОММЕНТАРИЙ");
            commentLabel.setStyleName("mainLabel");
            contractRegistration.add(commentLabel, new CssFloatData(1, new Margins(20, 10, 10, 37)));
            contractRegistration.add(new Label("Комментарий к договору (не печатается на полисе)"), new CssFloatData(0.15, new Margins(15, 10, 50, 37)));
            contractRegistration.add(commentArea, new CssFloatData(0.85, new Margins(10, 10, 50, 25)));


            VerticalLayoutContainer container = new VerticalLayoutContainer();
            container.add(fieldSet, new VerticalLayoutData(1, -1, new Margins(15, 15, 0, 15)));
            container.add(contractRegistration, new VerticalLayoutData(1, -1, new Margins(15, 15, 50, 15)));


            framedPanel = new FramedPanel();
            framedPanel.setHeading("Создание договора");
            framedPanel.add(container);
            framedPanel.addButton(new TextButton("Сохранить"));
            framedPanel.addButton(new TextButton("К списку договоров"));
            this.framedPanel.setStyleName("main");

            List<FieldLabel> fieldLabels = getFieldLabels(framedPanel);
            for (FieldLabel fieldLabel : fieldLabels) {
                fieldLabel.setLabelAlign(FormPanel.LabelAlign.TOP);
            }
        }

        return framedPanel;
    }


    public void onModuleLoad() {
        this.framedPanel = (FramedPanel) asWidget();
        RootPanel.get().add(framedPanel);
    }
}
