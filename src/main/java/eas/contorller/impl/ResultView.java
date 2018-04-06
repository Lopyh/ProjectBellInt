package eas.contorller.impl;




public class ResultView {
    public String result;
    Object object;

    public ResultView(){
        result = "success";
    }

    public ResultView(String result)
    {
        this.result = result;
    }


    @Override
    public String toString() {
        return "ResultView{" +
                "object=" + object +
                '}';
    }
}
