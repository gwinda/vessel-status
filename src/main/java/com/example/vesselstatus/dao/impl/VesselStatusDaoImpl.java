package com.example.vesselstatus.dao.impl;


import com.example.vesselstatus.dao.VesselStatusDao;
import com.example.vesselstatus.entity.VesselStatus;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VesselStatusDaoImpl implements VesselStatusDao {

  @Autowired
  private MongoTemplate mongoTemplate;

  @Override
  public VesselStatus save(VesselStatus vesselStatus) {
    VesselStatus newVesselStatus = mongoTemplate.save(vesselStatus);
    if(vesselStatus != null){
      return vesselStatus;
    }
    return null;
  }

  @Override
  public boolean remove(VesselStatus vesselStatus) {
    DeleteResult result = mongoTemplate.remove(vesselStatus);
    if (result.getDeletedCount() != 0) {
      return true;
    }
    return false;
  }

  @Override
  public boolean update(VesselStatus vesselStatus) {
    Query query = new Query(Criteria.where("vesselGid").is(vesselStatus.getVesselGid()));

    Update update = new Update();
    update.set("runningState",vesselStatus.getRunningState());

    UpdateResult result = mongoTemplate.updateFirst(query,update,VesselStatus.class);

    if(result.getModifiedCount() != 0){
      return true;
    }
    return false;
  }

  @Override
  public VesselStatus findByVesselGid(String vesselGid) {
    Query query = new Query(Criteria.where("vesselGid").is(vesselGid));
    return mongoTemplate.findOne(query,VesselStatus.class);
  }

  @Override
  public List<VesselStatus> getAll() {
    return mongoTemplate.findAll(VesselStatus.class);
  }
}
