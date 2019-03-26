package com.example.vesselstatus.dao;



import com.example.vesselstatus.entity.VesselStatus;

import java.util.List;

public interface VesselStatusDao {
  VesselStatus save(VesselStatus vesselStatus);

  boolean remove(VesselStatus vesselStatus);

  boolean update(VesselStatus vesselStatus);

  VesselStatus findByVesselGid(String vesselGid);

  List<VesselStatus> getAll();
}
