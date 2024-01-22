package nxu.it.model;

import nxu.it.api.common.param.PageQueryParam;

public class ShipperPageQueryParam extends PageQueryParam {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
