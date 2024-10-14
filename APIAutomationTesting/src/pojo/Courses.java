package pojo;

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
	private String webAutomation;
	private String api;
	private String mobileAutomation;
	
	public String getWebAutomation() {
		return webAutomation;
	}
	public void setWebAutomation(String webAutomation) {
		this.webAutomation = webAutomation;
	}
	public String getApi() {
		return api;
	}
	public void setApi(String api) {
		this.api = api;
	}
	public String getMobileAutomation() {
		return mobileAutomation;
	}
	public void setMobileAutomation(String mobileAutomation) {
		this.mobileAutomation = mobileAutomation;
	}
	
}
