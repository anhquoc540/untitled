package Filter;

import model.Request;
import utils.Function;

import java.text.ParseException;
import java.util.Date;

public class FilterOfRequest {
    float rate = 90.0f/100.0f ;

    public FilterOfRequest() {

    }

    public boolean filterTime(Request rq1, Request rq2) {
        try {
            Date dateStartTime1 = Function.convertTime(rq1.getStart_time());
            Date dateStartTime2 = Function.convertTime(rq2.getStart_time());
            Date dateEndTime1 = Function.convertTime(rq1.getEnd_time());
            Date dateEndTime2 = Function.convertTime(rq2.getEnd_time());


            if (dateStartTime1.before(dateStartTime2) & dateEndTime1.after(dateEndTime2)) {
                return true;
            }
            if (dateStartTime1.after(dateStartTime2) & dateEndTime1.before(dateEndTime2)) {
                return true;
            }
            if (dateStartTime1.after(dateStartTime2) & dateEndTime1.before(dateEndTime2)) {
                return true;
            }
            if (dateStartTime1.before(dateStartTime2) & ( dateEndTime1.before(dateEndTime2)
                    &  dateEndTime1.after(dateStartTime2))) {
                if(Function.differenceInTime(dateEndTime1,dateStartTime2) > 60) {
                    return true;
                }
            }

            if ((dateStartTime1.after(dateStartTime2) &  dateStartTime1.before(dateEndTime2))
                    &  dateEndTime1.after(dateEndTime2)) {
               if(Function.differenceInTime(dateStartTime1,dateEndTime2) > 60) {
                    return true;
                }

            }
            if (dateStartTime1.equals(dateStartTime2) & ( dateEndTime1.before(dateEndTime2)
                    &  dateEndTime1.after(dateStartTime2))) {
                if(Function.differenceInTime(dateEndTime1,dateStartTime2) > 60) {
                    return true;
                }
            }
            if ((dateStartTime1.after(dateStartTime2) &  dateStartTime1.before(dateEndTime2))
                    &  dateEndTime1.equals(dateEndTime2)) {
                if(Function.differenceInTime(dateStartTime1,dateEndTime2) > 60) {
                    return true;
                }

            }


        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }

        return false;
    }

    public boolean filterRegion (Request rq1, Request rq2){
        double distance = Function.minDistanceOf2Objects(rq1,rq2);
        if(rq1.getRegions().size() == rq2.getRegions().size()){
            if(distance >= rq1.getRegions().size()*0.5f){
                return false;
            }
        }
        if(rq1.getRegions().size() > rq2.getRegions().size()){
            if(distance > (rq2.getRegions().size()) * rate){
                return false;
            }
        }
        if(rq1.getRegions().size() <  rq2.getRegions().size()){
            if(distance > (rq1.getRegions().size()) * rate){
                return false;
            }
        }
        return  true;
    }

    public double getDistance (Request rq1, Request rq2){
        return Function.minDistanceOf2Objects(rq1,rq2);
    }



}
