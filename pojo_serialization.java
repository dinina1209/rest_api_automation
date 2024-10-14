
/*
< Serialization & Deserialization of Request/Responses with POJO Classes >

Serialization in Rest Assured context is a process of converting a Java Object into Request body (Payload)

Rest Assured also supports deserialization by converting Response body back to Java Object

Advantages: 
Easy to parse and extract response (Json/XML) values if they are wrapped as Java object.
User friendly Methods can be created wich make scode more readable

Design Approach:
Java object is constructed with the support of POJO classes
POJO classes are created based on the request/Response payload.

*/

//POJO Class
{
    "message": "",
    "greet" : ""
}

public class Message {
    private String message;
    private String greet;

    public String getMessage(){
        return message;
    }
    public void setMessage(String message){
        this.message = message;
    }
    public String getGreet(){
        return greet;
    }
    public void setGreet(String greet){
        this.greet = greet;
    }
}

//Create java Object
Message m = new Message();
m.setMessage("Hello");
m.setGreet("Hi");

//Rest Assured
Message message = new Message();
message.setMessage("My new message");

given().
body(m).
when().post("/message");
