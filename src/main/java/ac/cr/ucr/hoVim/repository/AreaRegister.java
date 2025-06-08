package ac.cr.ucr.hoVim.repository;

import ac.cr.ucr.hoVim.model.Area;

import java.util.ArrayList;
import java.util.List;

public class AreaRegister implements IAreaRegister{

    private ArrayList<Area> listArea;

    public AreaRegister() {

        this.listArea = new ArrayList<>();

    }

    @Override
    public Area addArea(Area area) {

        this.listArea.add(area);
        return area;

    }

    @Override
    public List<Area> getAllAreas() {

        return this.listArea;

    }

    @Override
    public Area getArea(Integer areaId) {

        for (int i = 0; i < this.listArea.size(); i++) {

            if (this.listArea.get(i).getAreaId() == areaId) {

                return this.listArea.get(i);

            }

        }

        return new Area();

    }

    @Override
    public Area deleteArea(Integer areaId) {

        for (int i = 0; i < this.listArea.size(); i++) {

            if (this.listArea.get(i).getAreaId() == areaId) {

                Area u = this.listArea.get(i);
                this.listArea.remove(i);
                return u;

            }

        }

        return new Area();

    }

    @Override
    public Area editArea(Integer areaId, Area areaEdit) {

        for (int i = 0; i < this.listArea.size(); i++) {

            if (this.listArea.get(i).getAreaId() == areaId) {

                this.listArea.set(i, areaEdit);
                return this.listArea.get(i);

            }

        }

        return new Area();

    }

    @Override
    public Boolean existId(Integer areaId) {

        for (int i = 0; i<this.listArea.size(); i++) {

            if (this.listArea.get(i).getAreaId() == areaId) {

                return true;
            }

        }

        return false;

    }
}
