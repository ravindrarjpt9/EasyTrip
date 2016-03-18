package com.easymytrip.social.alpha.service;

import com.easymytrip.social.alpha.model.Registration;
import com.easymytrip.social.comman.exception.ApplicationException;

public interface RegistrationService {

	Registration register(Registration registration)
			throws ApplicationException;

	Registration get(int registrationId) throws ApplicationException;

	Registration update(Registration registration) throws ApplicationException;

	Registration findRegistrationWithUsersByFbUserId(String fbUserId)
			throws ApplicationException;
}
