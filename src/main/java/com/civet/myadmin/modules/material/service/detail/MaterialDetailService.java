/**
 * Copyright &copy; 2012-2016 civet All rights reserved.
 */
package com.civet.myadmin.modules.material.service.detail;

import java.util.List;

import com.civet.myadmin.modules.material.entity.road.MaterialRoad;
import com.civet.myadmin.modules.material.web.restful.req.CoordinateReq;
import com.civet.myadmin.modules.material.web.restful.req.CoordinatesPerRoadReq;
import com.civet.myadmin.modules.material.web.restful.res.BaseRes;
import com.civet.myadmin.modules.material.web.restful.res.CoordinateRes;
import com.civet.myadmin.modules.material.web.restful.res.CoordinatesPerRoadRes;
import com.civet.myadmin.modules.material.web.restful.res.RoadListRes;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.civet.myadmin.common.persistence.Page;
import com.civet.myadmin.common.service.CrudService;
import com.civet.myadmin.modules.material.entity.detail.MaterialDetail;
import com.civet.myadmin.modules.material.dao.detail.MaterialDetailDao;

/**
 * 物料类型Service
 * @author likai
 * @version 2018-08-08
 */
@Service
@Transactional(readOnly = true)
public class MaterialDetailService extends CrudService<MaterialDetailDao, MaterialDetail> {

	public MaterialDetail get(Integer id) {
		return super.get(id);
	}
	
	public List<MaterialDetail> findList(MaterialDetail materialDetail) {
		return super.findList(materialDetail);
	}
	
	public Page<MaterialDetail> findPage(Page<MaterialDetail> page, MaterialDetail materialDetail) {
		return super.findPage(page, materialDetail);
	}
	
	@Transactional(readOnly = false)
	public void save(MaterialDetail materialDetail) {
		super.save(materialDetail);
	}
	
	@Transactional(readOnly = false)
	public void delete(MaterialDetail materialDetail) {
		super.delete(materialDetail);
	}

    public int getNextId() {
		return dao.getNextId() + 1;
    }

    public BaseRes CoordinatesPerRoad(int roadId) {
        List<MaterialDetail> list = dao.CoordinatesPerRoad(roadId);
        CoordinatesPerRoadRes coordinatesPerRoadRes = new CoordinatesPerRoadRes();
        coordinatesPerRoadRes.setList(list);
        coordinatesPerRoadRes.setRetCode(0);
        return coordinatesPerRoadRes;
    }

    public BaseRes saveCoordinate(CoordinateReq coordinateReq) {
	    MaterialDetail materialDetail = coordinateReq.getMaterialDetail();
	    if(materialDetail.getId() != null){
            /**
             * 更新操作
             */
            this.save(materialDetail);
        }else{
            /**
             * 新增操作
             */
            materialDetail.setName("H" + getNextId());
            this.save(materialDetail);
        }
        CoordinateRes coordinateRes = new CoordinateRes();
	    coordinateRes.setRetCode(0);
	    coordinateRes.setMaterialDetail(materialDetail);
	    return coordinateRes;
    }
}