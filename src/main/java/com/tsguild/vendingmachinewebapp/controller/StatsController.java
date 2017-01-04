package com.tsguild.vendingmachinewebapp.controller;

import com.google.visualization.datasource.datatable.ColumnDescription;
import com.google.visualization.datasource.datatable.DataTable;
import com.google.visualization.datasource.datatable.TableRow;
import com.google.visualization.datasource.datatable.value.ValueType;
import com.google.visualization.datasource.render.JsonRenderer;
import com.tsguild.vendingmachinewebapp.dao.VendingDao;
import com.tsguild.vendingmachinewebapp.model.ItemCount;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StatsController {

    private VendingDao dao;

    @Inject
    public StatsController(VendingDao dao) {
        this.dao = dao;
    }

    @RequestMapping(value = "/stats", method = RequestMethod.GET)
    public String displayStats() {
        return "stats";
    }

    @RequestMapping(value = "/stats/chart", method = RequestMethod.GET)
    @ResponseBody
    public String getDataTable() {
        try {
            List<ItemCount> counts = dao.getItemCounts();

            DataTable t = new DataTable();
            t.addColumn(new ColumnDescription("Item_Name",
                    ValueType.TEXT,
                    "Item"));
            t.addColumn(new ColumnDescription("Number_Items",
                    ValueType.NUMBER,
                    "# Items"));
            
            for (ItemCount currentCount : counts) {
                TableRow tr = new TableRow();
                tr.addCell(currentCount.getItemName());
                tr.addCell(currentCount.getNumItems());
                t.addRow(tr);
            }
            return JsonRenderer.renderDataTable(t, true, false, false).toString();
            
        } catch(Exception e) {
            return "Invalid Data";
        }
    }
}
