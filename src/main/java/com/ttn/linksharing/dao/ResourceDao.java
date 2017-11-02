package com.ttn.linksharing.dao;

import com.ttn.linksharing.model.DocumentResource;
import com.ttn.linksharing.model.LinkResource;

public interface ResourceDao {

    boolean addLinkResourceDao (LinkResource linkResource);

    boolean addDocResourceDao (DocumentResource documentResource);
}
