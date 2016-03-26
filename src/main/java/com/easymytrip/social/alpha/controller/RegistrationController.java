package com.easymytrip.social.alpha.controller;

import java.text.ParseException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.easymytrip.social.alpha.constants.Constants;
import com.easymytrip.social.alpha.constants.VerificationStatus;
import com.easymytrip.social.alpha.model.Registration;
import com.easymytrip.social.alpha.service.RegistrationService;
import com.easymytrip.social.alpha.to.ErrorResponse;
import com.easymytrip.social.alpha.to.RegistrationTo;
import com.easymytrip.social.alpha.to.Response;
import com.easymytrip.social.alpha.util.RegistrationUtils;
import com.easymytrip.social.comman.exception.ApplicationException;


@Controller
public class RegistrationController {

	
	private static final Logger LOG = Logger
			.getLogger(RegistrationController.class);

	@Autowired
	RegistrationService registrationService;

	

	@Autowired
	RegistrationUtils registrationUtils;

	@Transactional
	@RequestMapping(value = "/registration", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	@ResponseBody
	public Response registrer(@RequestBody RegistrationTo registrationTo) {
		boolean success = false;
		Object data = null;
		LOG.debug("Getting request for new registraction [ "+registrationTo+"]");
		// This will be useful if more than one condition can leads to
		// INVALID_USER
		String invalidUserMsg = null;
		String optCode = "";

		Registration registration = null;

		try {
			try {
				// Checking if a registration with user already exists for this
				// fbUserId
				registration = registrationService
						.findRegistrationWithUsersByFbUserId(registrationTo
								.getFbUserId());
				
				LOG.info("Checking if a registration ["+registrationTo
						.getFbUserId()+" with user already exists for this fbUserId ");

				// Populating registrationTo for sending to client
				try {
					registrationUtils.setRegistrationToFromRegistration(
							registrationTo, registration);
				} catch (ParseException e1) {
					LOG.error("Unable to convert Date to String [" + registrationTo +" ]",e1);
					throw new ApplicationException(
							Constants.ERROR_MSG_UNABLE_TO_CONVERT_DATE_TO_STRING);
				}

				data = registrationTo;
				success = true;
			} catch (ApplicationException e) {
				// Create new registration if registration does not exist
				LOG.info("Create new registration if registration does not exist...");
				registration = new Registration();
				// Populating registration from registrationTo
				try {
					registrationUtils.setRegistrationFromRegistrationTo(
							registration, registrationTo);
				} catch (ParseException e1) {
					LOG.error(Constants.ERROR_MSG_DOB_PARSE_EXCEPTION,e1);
					throw new ApplicationException(
							Constants.ERROR_MSG_DOB_PARSE_EXCEPTION);
				}

				// Checking if Minimum number of friends criteria is satisfied
				// or not
				//if (registration.getNoOfFriends() < Constants.MINIMUM_FRIENDS_REQUIRED) {
				if (!(registration.getNoOfFriends() != Constants.MINIMUM_FRIENDS_REQUIRED)) {
					registration
							.setVerificationStatus(VerificationStatus.INVALID_USER);
					invalidUserMsg = Constants.ERROR_MSG_INVALID_USER;
				} else {
					// TODO: No verification in V1 :'(
					// Generating the verification code:
					
					// As of now OPT will disable for android as well as for IOS 10-01-16
					
					// Need to uncomment 108 to 115 line to enable OTP 
//					if(registration.getDeviceType().toString().equalsIgnoreCase("ANDROID") || registration.getDeviceType().toString().equalsIgnoreCase("1")){
//					optCode = CommonUtils
//							 .generateRandomString(Constants.VERIFICATION_CODE_LENGTH);
//					 registration.setVerificationCode(optCode);
//					 registration.setVerificationCodeTime(new Date());
//					registration.setVerificationStatus(VerificationStatus.PENDING);
//					}
//					else{
					registration
							.setVerificationStatus(VerificationStatus.NOT_APPLICABLE);
//					}
				}

				// Persisting in DB
				registration = registrationService.register(registration);
				LOG.info("Persisting registration in to DB ["+registration+"]");

				// Throwing exception if INVALID_USER
				if (registration.getVerificationStatus().equals(
						VerificationStatus.INVALID_USER)) {
					LOG.error("INVALID_USER User ["+registration+"]");
					throw new ApplicationException(invalidUserMsg);
				}

				// Populating registrationTo for sending to client
				try {
					registrationUtils.setRegistrationToFromRegistration(
							registrationTo, registration);
				} catch (ParseException e1) {
					LOG.info(Constants.ERROR_MSG_UNABLE_TO_CONVERT_DATE_TO_STRING,e1);
					throw new ApplicationException(
							Constants.ERROR_MSG_UNABLE_TO_CONVERT_DATE_TO_STRING);
				}
				data = registrationTo;

				// TODO: Put code to send SMS instead of Push Notification
				// Sending the registration code as a push notification to the
				// user
				// pushRegistrationService.send(
				// registration.getPushId(),
				// Constants.VERIFICATION_PUSH_MESSAGE
				// + registration.getVerificationCode());

				success = true;
				/* This code need to comment
				 	to stop sending OPT 
				 */
					//	Thread t1 = new Thread(new SmsSenderThread(registrationTo.getMobileNo(),optCode));
					//	t1.start();
				
			}
		} catch (ApplicationException e) {
			LOG.error("Error while processing user registration request ",e);
			data = new ErrorResponse(e.getErrorCode(), e.getMessage());
		}
		return new Response(success, data);
	}

	
	@Transactional
	@RequestMapping(value = "/hello",method = RequestMethod.GET)
	public String getHello()
	{
		return "Hello Rest";
	}
	// TODO: No resendVerification in V1 :'(
	// @Transactional
	// @RequestMapping(value = "/resendVerification", method =
	// RequestMethod.POST, consumes = "application/json", produces =
	// "application/json")
	// @ResponseBody
	// public Response resendVerification(@RequestBody int registrationId) {
	// boolean success = false;
	// Object data = null;
	// try {
	// // Fetching the registration object from DB
	// // (Throws exception if null is returned)
	// Registration registration = registrationService.get(registrationId);
	//
	// // Re-generating the verification code
	// registration.setVerificationCode(CommonUtils
	// .generateRandomString(Constants.VERIFICATION_CODE_LENGTH));
	// registration.setVerificationCodeTime(new Date());
	// registration.setVerificationStatus(VerificationStatus.RESENT);
	//
	// // Updating registration in DB
	// registration = registrationService.update(registration);
	//
	// // Sending the re-generated verification code as a push notification
	// // to the user
	// pushRegistrationService.send(
	// registration.getPushId(),
	// Constants.VERIFICATION_PUSH_MESSAGE
	// + registration.getVerificationCode());
	//
	// // Returning the verification code to the mobile client
	// data = registration.getVerificationCode();
	// success = true;
	// } catch (ApplicationException e) {
	// data = new ErrorResponse(e.getErrorCode(), e.getMessage());
	// }
	// return new Response(success, data);
	// }
	
	private String getRandonNumber()
	{
		int randomPIN = (int)(Math.random()*9000)+1000;

        return String.valueOf(randomPIN);
	}
}
