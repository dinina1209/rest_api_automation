package pojo;
import java.util.List;
/*
"courses" :{
        "webAutomation": [
            {
                "courseTitle" : "Selenium",
                "price" : "50"
            },
            {
                "courseTitle" : "Cypress",
                "price" : "40"
            },
            {
                "courseTitle" : "Protractor",
                "price" : "40"
            }
        ],
        "api": [
            {
                "courseTitle" : "Rest assured automation using Java",
                "price" : "50"
            },
            {
                "courseTitle" : "SOAP API Webservices testing",
                "price" : "40"
            },
            {
                "courseTitle" : "Protractor",
                "price" : "40"
            }
        ],
        "mobileAutomation": [
            {
                "courseTitle" : "Appium",
                "price" : "40"
            }  
        ]
*/
public class Courses {
	private List<WebAutomation> webAutomation; //make it as a List of Object Array
	private List<API> api;
	private List<Mobile> mobileAutomation;
	
	public List<WebAutomation> getWebAutomation() {
		return webAutomation;
	}
	public void setWebAutomation(List<WebAutomation> webAutomation) {
		this.webAutomation = webAutomation;
	}
	public List<API> getApi() {
		return api;
	}
	public void setApi(List<API> api) {
		this.api = api;
	}
	public List<Mobile> getMobileAutomation() {
		return mobileAutomation;
	}
	public void setMobileAutomation(List<Mobile> mobileAutomation) {
		this.mobileAutomation = mobileAutomation;
	}
	
}
