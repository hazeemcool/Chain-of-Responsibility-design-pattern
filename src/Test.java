public class Test {

    public static void main(String[] args) {
        LoginValidation stepone=new Stepone();
       LoginValidation steptwo=new Steptwo();
        LoginValidation stepthree=new Stepthree();

        Request request=new Request("www.access.tk/login.php","www.access.tk/login.php?username=amal& password=1234");


        stepone.nextStep(steptwo);
        steptwo.nextStep(stepthree);
        stepone.steps(request);





    }


}

abstract class LoginValidation{

    protected LoginValidation steps;

    public void nextStep(LoginValidation steps){

        this.steps=steps;
    }
    public abstract void steps(Request request);



}
class Request{

    String url;

    String parameter;
    public  Request(String url,String parameter){
        this.url=url;
        this.parameter=parameter;

    }


}

class Stepone extends LoginValidation{


    @Override
    public void steps(Request request) {
        String text=request.url;
        if(text.contains(".php")){
            System.out.println("Valid URL");

            this.steps.steps(request);
        }else {
            System.out.println("invalid URL");

        }


    }
}
class Steptwo extends LoginValidation{

    @Override
    public void steps(Request request) {
        String text = request.parameter;

        if(text.contains("username")&& text.contains("password")){
            System.out.println("Valid parameters");

            this.steps.steps(request);

        }else{

            System.out.println("text are invalid");
        }


    }
}
class Stepthree extends LoginValidation{

    @Override
    public void steps(Request request) {
        String text=  request.parameter;

        if(text.contains("username=amal")&&text.contains("password=1234")){

            System.out.println("Login successfully");

        }else {

            System.out.println("invalid username and password");
        }


    }
}