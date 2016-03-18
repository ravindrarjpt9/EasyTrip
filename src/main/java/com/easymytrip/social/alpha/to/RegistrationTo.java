package com.easymytrip.social.alpha.to;

import java.util.Date;
import java.util.List;

import com.easymytrip.social.alpha.constants.DeviceType;
import com.easymytrip.social.alpha.constants.Gender;
import com.easymytrip.social.alpha.constants.MaritalStatus;
import com.easymytrip.social.alpha.constants.VerificationStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RegistrationTo {

	// To disable getter and setter
	@JsonIgnore
	private int id;


	private String imeiNo;

	private String pushId;

	private String deviceModel;

	// Setting default value of deviceType
	private int deviceType = DeviceType.ANDROID.ordinal();

	private String manufacturer;

	private int osVersion;

	private String locale;

	private String countryCode;

	private long mobileNo;

	private String firstName;

	private String lastName;

	private String fullName;

	private String dob;

	private String aboutMe;

	// Setting default value of gender
	private Gender gender = Gender.MALE;

	private String eMail;
	// Setting default value of gender
	//private List<FbPost> fbPosts;

	private int noOfFriends;

	private String coverPhotoUrl;

	private String fbUserId;

	private String fbTimelineUrl;
	
	@JsonProperty("relationship_status")
	private String fbRelationshipStatus;
	
	@JsonProperty("dateCreated")
	private String fbCreatedDate;

	// Comment on 11 -Jul -2015 discusstion with Team.
	//private List<FbLike> fbLikes;


	private MaritalStatus maritalStatus;
	
	@JsonProperty("location")
	private String fbCurrentLocation;

	private String verificationCode;

	private Date verificationCodeTime;

	private Date userVerificationTime;

	private VerificationStatus verificationStatus;

	private String invitationCode;
	
	private String currentCity;
	
	private String cityVisited;

	// To enable getting the id in JSON (serialization)
	@JsonProperty
	public int getId() {
		return id;
	}

	// To keep setter disabled (de-serialization) so as to use @GeneratedValue
	@JsonIgnore
	public void setId(int id) {
		this.id = id;
	}


	public String getImeiNo() {
		return imeiNo;
	}

	public void setImeiNo(String imeiNo) {
		this.imeiNo = imeiNo;
	}

	public String getPushId() {
		return pushId;
	}

	public void setPushId(String pushId) {
		this.pushId = pushId;
	}

	public String getDeviceModel() {
		return deviceModel;
	}

	public void setDeviceModel(String deviceModel) {
		this.deviceModel = deviceModel;
	}

	public int getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(int deviceType) {
		this.deviceType = deviceType;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public int getOsVersion() {
		return osVersion;
	}

	public void setOsVersion(int osVersion) {
		this.osVersion = osVersion;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getAboutMe() {
		return aboutMe;
	}

	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

//	public List<FbPost> getFbPosts() {
//		return fbPosts;
//	}
//
//	public void setFbPosts(List<FbPost> fbPosts) {
//		this.fbPosts = fbPosts;
//	}

	public int getNoOfFriends() {
		return noOfFriends;
	}

	public void setNoOfFriends(int noOfFriends) {
		this.noOfFriends = noOfFriends;
	}

	public String getCoverPhotoUrl() {
		return coverPhotoUrl;
	}

	public void setCoverPhotoUrl(String coverPhotoUrl) {
		this.coverPhotoUrl = coverPhotoUrl;
	}

	public String getFbUserId() {
		return fbUserId;
	}

	public void setFbUserId(String fbUserId) {
		this.fbUserId = fbUserId;
	}

	public String getFbTimelineUrl() {
		return fbTimelineUrl;
	}

	public void setFbTimelineUrl(String fbTimelineUrl) {
		this.fbTimelineUrl = fbTimelineUrl;
	}

//	public List<FbLike> getFbLikes() {
//		return fbLikes;
//	}
//
//	public void setFbLikes(List<FbLike> fbLikes) {
//		this.fbLikes = fbLikes;
//	}


	public MaritalStatus getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(MaritalStatus maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getVerificationCode() {
		return verificationCode;
	}

	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}

	public Date getVerificationCodeTime() {
		return verificationCodeTime;
	}

	public void setVerificationCodeTime(Date verificationCodeTime) {
		this.verificationCodeTime = verificationCodeTime;
	}

	public Date getUserVerificationTime() {
		return userVerificationTime;
	}

	public void setUserVerificationTime(Date userVerificationTime) {
		this.userVerificationTime = userVerificationTime;
	}

	public VerificationStatus getVerificationStatus() {
		return verificationStatus;
	}

	public void setVerificationStatus(VerificationStatus verificationStatus) {
		this.verificationStatus = verificationStatus;
	}

	public String getInvitationCode() {
		return invitationCode;
	}

	public void setInvitationCode(String invitationCode) {
		this.invitationCode = invitationCode;
	}

	public String getFbRelationshipStatus() {
		return fbRelationshipStatus;
	}

	public void setFbRFbRelationshipStatus(String fbRelationshipStatus) {
		this.fbRelationshipStatus = fbRelationshipStatus;
	}

	public String getFbCreatedDate() {
		return fbCreatedDate;
	}

	public void setFbCreatedDate(String fbCreatedDate) {
		this.fbCreatedDate = fbCreatedDate;
	}


	public String getFbCurrentLocation() {
		return fbCurrentLocation;
	}

	public void setFbCurrentLocation(String fbCurrentLocation) {
		this.fbCurrentLocation = fbCurrentLocation;
	}

	public void setFbRelationshipStatus(String fbRelationshipStatus) {
		this.fbRelationshipStatus = fbRelationshipStatus;
	}

	public String getCurrentCity() {
		return currentCity;
	}

	public void setCurrentCity(String currentCity) {
		this.currentCity = currentCity;
	}

	public String getCityVisited() {
		return cityVisited;
	}

	public void setCityVisited(String cityVisited) {
		this.cityVisited = cityVisited;
	}

	@Override
	public String toString() {
		return "RegistrationTo [id=" + id + ", imeiNo=" + imeiNo + ", pushId="
				+ pushId + ", deviceModel=" + deviceModel + ", deviceType="
				+ deviceType + ", manufacturer=" + manufacturer
				+ ", osVersion=" + osVersion + ", locale=" + locale
				+ ", countryCode=" + countryCode + ", mobileNo=" + mobileNo
				+ ", firstName=" + firstName + ", lastName=" + lastName
				+ ", fullName=" + fullName + ", dob=" + dob + ", aboutMe="
				+ aboutMe + ", gender=" + gender + ", eMail=" + eMail
				+ ", noOfFriends=" + noOfFriends + ", coverPhotoUrl="
				+ coverPhotoUrl + ", fbUserId=" + fbUserId + ", fbTimelineUrl="
				+ fbTimelineUrl + ", fbRelationshipStatus="
				+ fbRelationshipStatus + ", fbCreatedDate=" + fbCreatedDate
				+ ", maritalStatus=" + maritalStatus + ", fbCurrentLocation="
				+ fbCurrentLocation + ", verificationCode=" + verificationCode
				+ ", verificationCodeTime=" + verificationCodeTime
				+ ", userVerificationTime=" + userVerificationTime
				+ ", verificationStatus=" + verificationStatus
				+ ", invitationCode=" + invitationCode + "]";
	}


	
}
