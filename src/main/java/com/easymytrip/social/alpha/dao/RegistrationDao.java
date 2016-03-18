package com.easymytrip.social.alpha.dao;

import com.easymytrip.social.alpha.model.Registration;
import com.easymytrip.social.comman.dao.BaseDao;

public interface RegistrationDao extends BaseDao<Registration> {

	Registration findRegistrationWithUsersByFbUserId(String fbUserId);
}
