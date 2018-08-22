/**
 * Copyright &copy; 2012-2016 civet All rights reserved.
 */
package com.civet.myadmin.modules.material.service.road;

import java.util.List;

import com.civet.myadmin.modules.material.web.restful.req.RoadAddReq;
import com.civet.myadmin.modules.material.web.restful.req.RoadFindidReq;
import com.civet.myadmin.modules.material.web.restful.req.TypeInfoReq;
import com.civet.myadmin.modules.material.web.restful.res.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.civet.myadmin.common.persistence.Page;
import com.civet.myadmin.common.service.CrudService;
import com.civet.myadmin.modules.material.entity.road.MaterialRoad;
import com.civet.myadmin.modules.material.dao.road.MaterialRoadDao;

/**
 * 路线Service
 * @author likai
 * @version 2018-08-14
 */
@Service
@Transactional(readOnly = true)
public class MaterialRoadService extends CrudService<MaterialRoadDao, MaterialRoad> {

	public MaterialRoad get(Integer id) {
		return super.get(id);
	}
	
	public List<MaterialRoad> findList(MaterialRoad materialRoad) {
		return super.findList(materialRoad);
	}
	
	public Page<MaterialRoad> findPage(Page<MaterialRoad> page, MaterialRoad materialRoad) {
		return super.findPage(page, materialRoad);
	}
	
	@Transactional(readOnly = false)
	public void save(MaterialRoad materialRoad) {
		super.save(materialRoad);
	}
	
	@Transactional(readOnly = false)
	public void delete(MaterialRoad materialRoad) {
		super.delete(materialRoad);
	}

    public RoadListRes roadList() {

        List<MaterialRoad> list = this.findList(new MaterialRoad());
        RoadListRes roadListRes = new RoadListRes();
        roadListRes.setRetCode(0);
        roadListRes.setRetMsg("");
        roadListRes.setRoad(list);
        return roadListRes;
    }

    @Transactional(readOnly = false)
    public BaseRes roadSave(RoadAddReq roadAddReq) {
        MaterialRoad materialRoad = roadAddReq.getMaterialRoad();
        RoadAddRes roadAddRes = new RoadAddRes();

        try{
            this.save(materialRoad);
            roadAddRes.setMaterialRoad(materialRoad);
            roadAddRes.setRetCode(0);
            roadAddRes.setRetMsg("");
        }catch (Exception e){
            roadAddRes.setRetCode(999);
            roadAddRes.setRetMsg(e.getMessage());
        }
        return roadAddRes;
    }

    /**、
     * 根据id获得路线
     * @param roadFindidReq
     * @return
     */
    public BaseRes Findid(RoadFindidReq roadFindidReq) {
        int id = roadFindidReq.getRoId();
        MaterialRoad materialRoad=this.get(id);
        RoadFindidRes roadFindidRes = new RoadFindidRes();
        roadFindidRes.setRetCode(0);
        roadFindidRes.setRetMsg("");
        roadFindidRes.setMaterialRoad(materialRoad);
        return roadFindidRes;
    }
}