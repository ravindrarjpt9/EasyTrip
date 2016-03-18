package com.easymytrip.social.alpha.constants;

import java.util.HashMap;
import java.util.Map;

public final class Constants {

	private Constants() {
		throw new RuntimeException(
				"Cannot instantiate object of Constants class");
	}

	public static final String PTOTOCOL = "http";
	
	public static  String HOST = "app.neargroup.in";
	
	//public static final String HOST = "119.9.107.53:8080";

	public static final String APPLICATION_NAME = "alphaserver";
	
	public static final String SERVICE_NAME = "alpha/getImage";
	
	public static final int VERIFICATION_CODE_LENGTH = 4;

	public static final String VERIFICATION_PUSH_MESSAGE = "NearGroup verification code is: ";

	public static final int VERIFICATION_MINUTES_RANGE = 30;

	public static  int MINIMUM_FRIENDS_REQUIRED = 50;
	
	public static String ADMIN_USER_FB_ID = "935276429872137";

	public static final String ERROR_MSG_INVALID_USER = "Sorry. Minimum "
			+ MINIMUM_FRIENDS_REQUIRED
			+ " friends on facebook are needed. Please try again later.";

	public static final String ERROR_MSG_USER_ALREADY_EXITS = "User with this FB user account already exists. "
			+ "Please login with the existing account.";

	public static final String ERROR_MSG_VERIFICATION_CODE_EXPIRED = "Verification code has expired for the REGISTRATION_ID: ";

	public static final String ERROR_MSG_INVALID_VERIFICATION_CODE = "Invalid verification code entered for the REGISTRATION_ID: ";

	public static final String ERROR_MSG_DOB_PARSE_EXCEPTION = "Unable to parse DOB";
	
	public static final String ERROR_MSG_FILE_DATA_BYTE = "Unable to convert file data to byte";

	public static final String ERROR_MSG_UNABLE_TO_CONVERT_DATE_TO_STRING = "Unable to convert Date to String";

	public static final String GROUP_NAME_SEPARATOR = "-";

	public static final String IN = " in ";

		

		
	public static final String SPACE = " ";

	
	public static final String COUNTRY_CODE_INDIA = "+91";

	
	public static final Map<String, String> COLLEGE_CODE_MAP = new HashMap<String, String>();

	public static final Map<String, String> CORPORATE_CODE_MAP = new HashMap<String, String>();
	
	public static final Map<String, String> SCHOOL_CODE_MAP = new HashMap<String, String>();

	
	// SMS Service Details 
	public static String SMS_SERVICES_URL = "http://smsbox.in/SecureApi.aspx";
	public static String SMS_USER = "prashant";
	public static String SMS_KEY = "8547025F-652D-4B5F-9ED6-C5408E707CDB";
	public static String SMS_TYPE = "TextSMS";
	public static String SMS_MSG = "use 000 as nearGroup account security code";
	public static String SMS_ROUT = "Transactional";
	public static String SMS_FROM = "nGroup";
	public static String SMS_USER_NAME = "prashant";
	public static String SMS_PASSWORD = "123456";
	
	
	// EMAIL Server Details
	public static String EMAIL_USER_NAME = "";
	public static String EMAIL_USER_PASSWORD = "";
	public static String EMAIL_IS_AUTH = "";
	public static String EMAIL_STARTTLS_ENABLE = "";
	public static String EMAIL_SMTP_HOST = "";
	public static String EMAIL_SMTP_PORT = "";
		
	
}
