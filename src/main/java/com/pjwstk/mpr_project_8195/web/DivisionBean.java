package com.pjwstk.mpr_project_8195.web;

import com.pjwstk.mpr_project_8195.domain.Division;
import com.pjwstk.mpr_project_8195.service.DivisionService;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

@SessionScoped
@Named
public class DivisionBean implements Serializable {
    
    private ListDataModel<Division> divisionModel = new ListDataModel<Division>();
    private Division division;
    
    @Inject
    private DivisionService ds;

    public ListDataModel<Division> getDivisionModel() {
        divisionModel.setWrappedData(ds.getDivisions());
        return divisionModel;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }
    
    public String edit() {
        division = divisionModel.getRowData();
        return "edit";
    }
    
    public String delete() {
        ds.remove(divisionModel.getRowData());
        return "list";
    }
    
    public String show() {
        division = divisionModel.getRowData();
        return "show";
    }
    
    public String add() {
        division = new Division();
        return "add";
    }
    
    public String merge() {
        ds.merge(division);
        return "list";
    }
}
