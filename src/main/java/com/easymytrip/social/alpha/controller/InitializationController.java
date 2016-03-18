package com.easymytrip.social.alpha.controller;

import org.apache.log4j.Logger;

import com.easymytrip.social.alpha.constants.Constants;
import com.easymytrip.social.alpha.constants.XmppConstants;

public class InitializationController {

	private static final Logger LOG = Logger.getLogger(InitializationController.class);
	String host;
	String xmppServerIpAddress;
	String androidAppCurrentVersion;
	String iosAppCurrentVersion;
	String androidFourceUpdate;
	String iosFourceUpdate;
	String xmppClientPort;
	String xmppServerPortUnsecure;
	String xmppAdminUserName;
	String xmppAdminPassword;
	String groupWelcomeMessage;
	String groupAutoMessage;

	// SMS Details

	String smsServiceUrl;
	String smsUser;
	String smsKey;
	String smsType;
	String smsMsg;
	String smsRout;
	String smsFrom;
	String smsUserName;
	String smsPassword;

	// email
	String emailUserName;
	String emailPassword;
	String isEmailAuth;
	String isEmailStarttlsEnable;
	String emailSmtpHost;
	String emailSmtpPort;

	public void initIt() throws Exception {
		Constants.HOST = host;
		XmppConstants.XMPP_SERVER_IP_ADDRESS = xmppServerIpAddress;
		XmppConstants.ANDROID_APP_CURRENT_VERSION = androidAppCurrentVersion;
		XmppConstants.IOS_APP_CURRENT_VERSION = iosAppCurrentVersion;
		XmppConstants.ANRDOID_FOURCE_UPDATE = Boolean.parseBoolean(androidFourceUpdate);
		XmppConstants.IOS_FOURCE_UPDATE = Boolean.parseBoolean(iosFourceUpdate);
		XmppConstants.XMPP_CLIENT_PORT = xmppClientPort;
		XmppConstants.XMPP_SERVER_PORT_UNSECURE = xmppServerPortUnsecure;
		XmppConstants.XMPP_ADMIN_USER_NAME = xmppAdminUserName;
		XmppConstants.XMPP_ADMIN_PASSWORD = xmppAdminPassword;
		XmppConstants.GROUP_WELCOME_MESSAGE = groupWelcomeMessage;
		XmppConstants.GROUP_AUTO_MESSAGE = groupAutoMessage;

		Constants.SMS_SERVICES_URL = smsServiceUrl;
		Constants.SMS_FROM = smsFrom;
		Constants.SMS_KEY = smsKey;
		Constants.SMS_MSG = smsMsg;
		Constants.SMS_ROUT = smsRout;
		Constants.SMS_TYPE = smsType;
		Constants.SMS_USER = smsUser;
		Constants.SMS_USER = smsUserName;
		Constants.SMS_PASSWORD = smsPassword;

		Constants.EMAIL_USER_NAME = emailUserName;
		Constants.EMAIL_USER_PASSWORD = emailPassword;
		Constants.EMAIL_SMTP_PORT = emailSmtpPort;
		Constants.EMAIL_IS_AUTH = isEmailAuth;
		Constants.EMAIL_SMTP_HOST = emailSmtpHost;
		Constants.EMAIL_STARTTLS_ENABLE = isEmailStarttlsEnable;
		

	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public void cleanUp() throws Exception {

		System.out.println("Spring Container is destroy! Customer clean up");
	}

	public String getXmppServerIpAddress() {
		return xmppServerIpAddress;
	}

	public void setXmppServerIpAddress(String xmppServerIpAddress) {
		this.xmppServerIpAddress = xmppServerIpAddress;
	}

	public String getAndroidAppCurrentVersion() {
		return androidAppCurrentVersion;
	}

	public void setAndroidAppCurrentVersion(String androidAppCurrentVersion) {
		this.androidAppCurrentVersion = androidAppCurrentVersion;
	}

	public String getIosAppCurrentVersion() {
		return iosAppCurrentVersion;
	}

	public void setIosAppCurrentVersion(String iosAppCurrentVersion) {
		this.iosAppCurrentVersion = iosAppCurrentVersion;
	}

	public String getAndroidFourceUpdate() {
		return androidFourceUpdate;
	}

	public void setAndroidFourceUpdate(String androidFourceUpdate) {
		this.androidFourceUpdate = androidFourceUpdate;
	}

	public String getIosFourceUpdate() {
		return iosFourceUpdate;
	}

	public void setIosFourceUpdate(String iosFourceUpdate) {
		this.iosFourceUpdate = iosFourceUpdate;
	}

	public String getXmppClientPort() {
		return xmppClientPort;
	}

	public void setXmppClientPort(String xmppClientPort) {
		this.xmppClientPort = xmppClientPort;
	}

	public String getXmppServerPortUnsecure() {
		return xmppServerPortUnsecure;
	}

	public void setXmppServerPortUnsecure(String xmppServerPortUnsecure) {
		this.xmppServerPortUnsecure = xmppServerPortUnsecure;
	}

	public String getXmppAdminUserName() {
		return xmppAdminUserName;
	}

	public void setXmppAdminUserName(String xmppAdminUserName) {
		this.xmppAdminUserName = xmppAdminUserName;
	}

	public String getXmppAdminPassword() {
		return xmppAdminPassword;
	}

	public void setXmppAdminPassword(String xmppAdminPassword) {
		this.xmppAdminPassword = xmppAdminPassword;
	}

	public String getGroupWelcomeMessage() {
		return groupWelcomeMessage;
	}

	public void setGroupWelcomeMessage(String groupWelcomeMessage) {
		this.groupWelcomeMessage = groupWelcomeMessage;
	}

	public String getGroupAutoMessage() {
		return groupAutoMessage;
	}

	public void setGroupAutoMessage(String groupAutoMessage) {
		this.groupAutoMessage = groupAutoMessage;
	}

	public String getSmsServiceUrl() {
		return smsServiceUrl;
	}

	public void setSmsServiceUrl(String smsServiceUrl) {
		this.smsServiceUrl = smsServiceUrl;
	}

	public String getSmsUser() {
		return smsUser;
	}

	public void setSmsUser(String smsUser) {
		this.smsUser = smsUser;
	}

	public String getSmsKey() {
		return smsKey;
	}

	public void setSmsKey(String smsKey) {
		this.smsKey = smsKey;
	}

	public String getSmsType() {
		return smsType;
	}

	public void setSmsType(String smsType) {
		this.smsType = smsType;
	}

	public String getSmsMsg() {
		return smsMsg;
	}

	public void setSmsMsg(String smsMsg) {
		this.smsMsg = smsMsg;
	}

	public String getSmsRout() {
		return smsRout;
	}

	public void setSmsRout(String smsRout) {
		this.smsRout = smsRout;
	}

	public String getSmsFrom() {
		return smsFrom;
	}

	public void setSmsFrom(String smsFrom) {
		this.smsFrom = smsFrom;
	}

	public String getSmsUserName() {
		return smsUserName;
	}

	public void setSmsUserName(String smsUserName) {
		this.smsUserName = smsUserName;
	}

	public String getSmsPassword() {
		return smsPassword;
	}

	public void setSmsPassword(String smsPassword) {
		this.smsPassword = smsPassword;
	}

	public String getEmailUserName() {
		return emailUserName;
	}

	public void setEmailUserName(String emailUserName) {
		this.emailUserName = emailUserName;
	}

	public String getEmailPassword() {
		return emailPassword;
	}

	public void setEmailPassword(String emailPassword) {
		this.emailPassword = emailPassword;
	}

	public String getIsEmailAuth() {
		return isEmailAuth;
	}

	public void setIsEmailAuth(String isEmailAuth) {
		this.isEmailAuth = isEmailAuth;
	}

	public String getIsEmailStarttlsEnable() {
		return isEmailStarttlsEnable;
	}

	public void setIsEmailStarttlsEnable(String isEmailStarttlsEnable) {
		this.isEmailStarttlsEnable = isEmailStarttlsEnable;
	}

	public String getEmailSmtpHost() {
		return emailSmtpHost;
	}

	public void setEmailSmtpHost(String emailSmtpHost) {
		this.emailSmtpHost = emailSmtpHost;
	}

	public String getEmailSmtpPort() {
		return emailSmtpPort;
	}

	public void setEmailSmtpPort(String emailSmtpPort) {
		this.emailSmtpPort = emailSmtpPort;
	}

	public static Logger getLog() {
		return LOG;
	}

}
