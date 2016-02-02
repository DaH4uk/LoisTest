package com.myApplication.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;
import com.myApplication.shared.ContractsDataSet;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.button.TextButton;
import com.sencha.gxt.widget.core.client.container.BoxLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.event.SelectEvent;

import java.util.List;

import static com.google.gwt.user.client.Window.*;


public class MainForm implements EntryPoint, IsWidget {


    private VerticalLayoutContainer panel;
    private CreateForm createForm;
    final DateTimeFormat format = DateTimeFormat.getFormat("dd.MM.yyyy");


    public Widget asWidget() {

        ContentPanel mainPanel = new ContentPanel();
        mainPanel.setButtonAlign(BoxLayoutContainer.BoxLayoutPack.START);
        mainPanel.setHeading("Основная форма");
        mainPanel.addButton(new TextButton("Создать договор", new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent event) {
                if (createForm == null) {

                    panel.removeFromParent();
                    createForm = new CreateForm();
                    createForm.onModuleLoad();
                }

            }
        }));
        mainPanel.addButton(new TextButton("Открыть договор", new SelectEvent.SelectHandler() {
            @Override
            public void onSelect(SelectEvent event) {

            }
        }));

        panel = new VerticalLayoutContainer();
        panel.add(mainPanel, new VerticalLayoutContainer.VerticalLayoutData(1, -1, new Margins(0, 0, 0, 0)));
        panel.add(new HTML(), new VerticalLayoutContainer.VerticalLayoutData(1, -1, new Margins(20, 0, 0, 0)));


//        MainFormServiceAsync rpcService = GWT.create(MainFormService.class);
//
//        rpcService.getAllContracts(new AsyncCallback<List<ContractsDataSet>>() {
//            @Override
//            public void onFailure(Throwable caught) {
//                alert("Fail get all contracts"
//                 + caught);
//            }
//
//            @Override
//            public void onSuccess(List<ContractsDataSet> result) {
//                ContractsDataSet contracts = result.get(0);

//                ListStore<ContractsDataSet> listStore = new ListStore<>(new ModelKeyProvider<ContractsDataSet>() {
//                    @Override
//                    public String getKey(ContractsDataSet item) {
//                        return "" + item.getId();
//                    }
//
//                });
//
//                ContractProperties properties = GWT.create(ContractProperties.class);
//
//                ColumnConfig<ContractsDataSet, String> idCol = new ColumnConfig<>(properties.contractNumber(), 150, "Серия-Номер");
//                ColumnConfig<ContractsDataSet, Date> dateCol = new ColumnConfig<>(properties.date(), 150, "Дата заключения");
//                ColumnConfig<ContractsDataSet, String> nameCol = new ColumnConfig<>(properties.name(), 400, "Страхователь");
//                ColumnConfig<ContractsDataSet, String> premiumCol = new ColumnConfig<>(properties.premium(), 150, "Премия");
//                ColumnConfig<ContractsDataSet, Date> validUntilCol = new ColumnConfig<>(properties.dateValidUntil(), 150, "Срок действия");
//
//                List<ColumnConfig<ContractsDataSet, ?>> columns = new ArrayList<>();
//                columns.add(idCol);
//                columns.add(dateCol);
//                columns.add(nameCol);
//                columns.add(premiumCol);
//                columns.add(validUntilCol);
//                ColumnModel<ContractsDataSet> columnModel = new ColumnModel<>(columns);
//
//                GridView<ContractsDataSet> gridView = new GridView<>();
//                gridView.setAutoExpandColumn(nameCol);
//
//                Grid<ContractsDataSet> grid = new Grid<>(listStore, columnModel, gridView);
////
//                Cell c = new DateCell(format);
//                grid.getColumnModel().getColumn(1).setCell(c);
//                grid.getColumnModel().getColumn(4).setCell(c);
//
//                panel.add(grid, new VerticalLayoutContainer.VerticalLayoutData(1, -1, new Margins(10, 0, 0, 0)));
//            }
//        });


        return panel;
    }

    public void onModuleLoad() {
        this.panel = (VerticalLayoutContainer) asWidget();
        this.panel.setStyleName("main");
        RootPanel.get().add(panel);

    }
}
