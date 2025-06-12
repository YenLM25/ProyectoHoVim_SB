package ac.cr.ucr.hoVim.repository;

import ac.cr.ucr.hoVim.model.Area;

import java.util.List;

public interface IAreaRegister {

    public Area addArea (Area area);
    public List<Area> getAllAreas();
    public Area getArea (Integer areaId);
    public Area deleteArea (Integer areaId);
    public Area editArea(Integer areaId, Area areaEdit);

    public Boolean existId(Integer areaId);
}
