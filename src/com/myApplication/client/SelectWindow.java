package com.myApplication.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.user.client.ui.*;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.Window;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.CssFloatLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.event.SelectEvent;
import com.sencha.gxt.widget.core.client.form.TextField;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.GridView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;

/**
 * Created by DaH4uk on 29.01.2016.
 */
public class SelectWindow implements IsWidget{


//    public static class ClientsExchange {
//
//        private List<ClientsDao> clients = new ArrayList<>();
//
//
//        public List<ClientsDao> getClients() {
//            return clients;
//        }
//
//        public void setClients(List<ClientsDao> stocks) {
//            this.clients = stocks;
//        }
//    }
//
//    interface ListDriver extends SimpleBeanEditorDriver<ClientsExchange, SelectWindow> {
//    }


    public Window selectWindow;
    private VerticalLayoutContainer container;
    private ContentPanel panel;
//    com.sencha.gxt.widget.core.client.grid.Grid<ClientsDao> clientListGrid;
//    public static ClientProperties gridProperties = GWT.create(ClientProperties.class);

    @Override
    public Widget asWidget() {
        if (container == null){



            selectWindow = new Window();
            selectWindow.setPixelSize(640, 480);
            selectWindow.setResizable(false);
            selectWindow.setModal(true);
            selectWindow.setBlinkModal(true);
            selectWindow.setHeading("Выбор клиентов");
            selectWindow.addButton(new TextButton("Закрыть", new SelectEvent.SelectHandler() {
                @Override
                public void onSelect(SelectEvent event) {
                    selectWindow.hide();
                }
            }));

            CssFloatLayoutContainer selectWindowForm = new CssFloatLayoutContainer();

            selectWindowForm.add(new Label("ФИО"), new CssFloatLayoutContainer.CssFloatData(0.1, new Margins(25, 0, 0, 15)));
            TextField surnameField = new TextField();
            selectWindowForm.add(surnameField, new CssFloatLayoutContainer.CssFloatData(0.25, new Margins(20, 0, 0, 10)));
            TextField nameField = new TextField();
            selectWindowForm.add(nameField, new CssFloatLayoutContainer.CssFloatData(0.25, new Margins(20, 0, 0, 10)));
            TextField middleNameField = new TextField();
            selectWindowForm.add(middleNameField, new CssFloatLayoutContainer.CssFloatData(0.25, new Margins(20, 0, 0, 10)));
            PushButton searchButton = new PushButton(new Image("images/search.png"));
            selectWindowForm.add(searchButton, new CssFloatLayoutContainer.CssFloatData(0.15, new Margins(20, 0, 0, 10)));

//todo: Доделать форму
            selectWindowForm.add(new Label(""), new CssFloatLayoutContainer.CssFloatData(0.1, new Margins(0, 0, 10, 15)));
            Label surnameFieldLabel = new Label("фамилия");
            surnameFieldLabel.setStyleName("underFieldLabel");
            selectWindowForm.add(surnameFieldLabel, new CssFloatLayoutContainer.CssFloatData(0.25, new Margins(0, 0, 10, 10)));
            Label nameFieldLabel = new Label("имя");
            nameFieldLabel.setStyleName("underFieldLabel");
            selectWindowForm.add(nameFieldLabel, new CssFloatLayoutContainer.CssFloatData(0.25, new Margins(0, 0, 10, 10)));
            Label middleNameFieldLabel = new Label("отчество");
            middleNameFieldLabel.setStyleName("underFieldLabel");
            selectWindowForm.add(middleNameFieldLabel, new CssFloatLayoutContainer.CssFloatData(0.25, new Margins(0, 0, 10, 10)));

//todo: реализовать рабочий грид
//            ListStore<ClientsDao> listStore = new ListStore<>(gridProperties.id());
//
//
//            listStore.add(1,new ClientsDao("Дмитриевич", "Данил", "Туров", new Date(1993,8,8)));
//
//            ColumnConfig<ClientsDao, String> surnameColumn = new ColumnConfig<>(gridProperties.surname(), 10, "Фамилия");
//            ColumnConfig<ClientsDao, String> nameColumn = new ColumnConfig<>(gridProperties.name(), 100, "Имя");
//            ColumnConfig<ClientsDao, String> middleNameColumn = new ColumnConfig<>(gridProperties.middleName(), 100, "Отчество");
//
//            List<ColumnConfig<ClientsDao, ?>> columns = new ArrayList<>();
//            columns.add(surnameColumn);
//            columns.add(nameColumn);
//            columns.add(middleNameColumn);

//            ColumnModel<ClientsDao> columnModel = new ColumnModel<ContractDao>(columns);
//
//
//            GridView<ClientsDao> gridView = new GridView<>();
//            gridView.setAutoExpandColumn(nameColumn);

//            com.sencha.gxt.widget.core.client.grid.Grid<ContractDao> grid = new com.sencha.gxt.widget.core.client.grid.Grid<ContractDao>(listStore, columnModel, gridView);
//            Grid<ClientsDao> stockListGrid = new Grid<>(listStore, new ColumnModel<>(columns));
//            stockListGrid.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
//            stockListGrid.getView().setAutoExpandColumn(nameColumn);


            VerticalLayoutContainer selectWindowContainer = new VerticalLayoutContainer();
            selectWindowContainer.add(selectWindowForm, new VerticalLayoutData(1, -1, new Margins(15, 15, 0, 15)));
//            selectWindowContainer.add(stockListGrid, new VerticalLayoutData(1, 1));


            selectWindow.add(selectWindowContainer);
        }
        return container;
    }


}
